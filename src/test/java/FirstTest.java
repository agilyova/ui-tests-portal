import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest extends BaseTest {
    @Test
    void openMainPage() {
        open("http://portal.portal-uat.k8s.ak-dev.adc.vpn/");

        $(".site-title").innerText().equals("Архивы Санкт-Петербурга");
    }
}
