package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ImageNavigatorPage {

    public ElementsCollection previews() {
        return $$(".previewWrapper");
    }

    public SelenideElement toolBarTitle() {
        return $("#menu span");
    }

    public SelenideElement firstImage() {
        return $("#pdfPage>img");
    }

    public ImageNavigatorPage shouldHavePreviewsSize(int i) {
        $$(".previewWrapper").shouldHave(size(i));
        return this;
    }

    public ImageNavigatorPage shouldHaveTitle(String title) {
        $("#menu span").shouldHave(exactText(title));
        return this;
    }

    public ImageNavigatorPage shouldHaveFirstImageResolution(String width, String height) {
        $("#pdfPage>img").shouldHave(attribute("naturalWidth", width),
                attribute("naturalHeight", height));
        return this;
    }
}
