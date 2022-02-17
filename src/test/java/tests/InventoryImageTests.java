package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ImageNavigatorPage;
import pages.InventoryPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@ExtendWith({SoftAssertsExtension.class})
public class InventoryImageTests extends BaseTest {

    public SelenideElement button(String buttonName){
        return $$("button").findBy(exactText(buttonName));
    }

    @Test
    @DisplayName("1. Просмотр образов описи под пользователем без авторизации")
    void guestCanSeeInventoryImages1() {

        open("/infres/-/archive/cga/R-2455/6");
        $$(".button").findBy(text("Просмотреть образы")).click();

        $(byText("ф.Р-2455 оп.6")).should(exist);
        $$(".previewWrapper").shouldHave(size(34));
        $("#pdfPage>img").shouldHave(attribute("naturalWidth", "1163"),
                                              attribute("naturalHeight", "1600"));
    }

    @Test
    @DisplayName("2. Просмотр образов описи под пользователем без авторизации")
    void guestCanSeeInventoryImages2() {
        step("Открыть страницу описи ЦГА СПб ф.Р-2455 оп.6", () -> {
            open("/infres/-/archive/cga/R-2455/6");
        });
        step("Нажать кнопку Просмотреть образы", () -> {
            $$(".button").findBy(text("Просмотреть образы")).click();
        });

        step("Страница должна содержать надпись ф.Р-2455 оп.6", () -> {
            $(byText("ф.Р-2455 оп.6")).should(exist);
        });
        step("Страница должна содержать 34 превью", () -> {
            $$(".previewWrapper").shouldHave(size(34));
        });
        step("Размеры первого образа должны быть 1163 на 1600", () -> {
            $("#pdfPage>img").shouldHave(attribute("naturalWidth", "1163"),
                    attribute("naturalHeight", "1600"));
        });
    }

    @Test
    @DisplayName("3. Просмотр образов описи под пользователем без авторизации")
    void guestCanSeeInventoryImages3() {

        InventoryPage inventoryPage = new InventoryPage();
        ImageNavigatorPage imageNavigatorPage = new ImageNavigatorPage();

        inventoryPage.open("cga", "R-2455", "6");
        inventoryPage.button("Просмотреть образы").click();

        imageNavigatorPage.toolBarTitle().shouldHave(exactText("ф.Р-2455 оп.6"));
        imageNavigatorPage.previews().shouldHave(size(34));
        imageNavigatorPage.firstImage().shouldHave(attribute("naturalWidth", "1163"),
                attribute("naturalHeight", "1600"));

    }

    @Test
    @DisplayName("4. Просмотр образов описи под пользователем без авторизации")
    void guestCanSeeInventoryImages4() {

        InventoryPage inventoryPage = new InventoryPage();
        ImageNavigatorPage imageNavigatorPage = new ImageNavigatorPage();

        inventoryPage.open("cga", "R-2455", "6")
                .openImgNavigatorByClickOnButton();

        imageNavigatorPage.shouldHaveTitle("ф.Р-2455 оп.6")
                .shouldHavePreviewsSize(34)
                .shouldHaveFirstImageResolution("1163", "1600");

    }
}
