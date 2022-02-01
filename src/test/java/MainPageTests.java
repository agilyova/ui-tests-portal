import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class MainPageTests extends BaseTest {
    @Test
    @DisplayName("Главная страница содержит заголовок")
    @Severity(NORMAL)
    void openMainPage() {

        step("Открыть главную страницу", () -> {
            open("http://portal.portal-uat.k8s.ak-dev.adc.vpn/");
        });

        step("Страница должна содержать заголовок Архивы Санкт-Петербурга", () -> {
            $(".site-title").shouldHave(text("Архивы Санкт-Петербурга"));
        });
    }
}
