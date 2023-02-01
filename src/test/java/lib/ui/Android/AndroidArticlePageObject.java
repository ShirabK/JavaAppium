package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        TITLE = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']";
        FOOTER_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_external_link']";
        OPTIONS_BUTTON = "xpath://*[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
        ADD_TO_MY_LIST_OVERLAY = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        MY_LIST_NAME_INPUT = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        MY_LIST_OKAY_BUTTON = "xpath://*[@resource-id='android:id/button1']";
        CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Navigate up']";
        CREATED_FOLDER_IN_MY_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='{FOLDER_NAME}']";
    }
}
