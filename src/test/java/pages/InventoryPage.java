package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    public InventoryPage open(String archiveNameEng, String fundCipherEng, String inventoryCipherEng) {
        Selenide.open("/infres/-/archive/" + archiveNameEng + "/" + fundCipherEng + "/" + inventoryCipherEng);
        return this;
    }

    public SelenideElement button(String buttonText) {
        return  $$(".button").findBy(exactText(buttonText));
    }

    public ImageNavigatorPage openImgNavigatorByClickOnButton() {
        $$(".button").findBy(exactText("Просмотреть образы")).click();
        return new ImageNavigatorPage();
    }
}

