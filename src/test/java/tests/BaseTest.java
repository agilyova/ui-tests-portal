package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.AssertionMode.SOFT;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        Configuration.baseUrl = "https://dportal-proxy.ak-dev.adc.vpn/";
        Configuration.browserSize = "1920x1024";
        Configuration.assertionMode = SOFT;

    }

    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
