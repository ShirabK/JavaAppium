package lib.ui.iOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        TITLE = "xpath://XCUIElementTypeStaticText[contains(@name,'Java (programming language)')]";
        FOOTER_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_external_link']";
        OPTIONS_BUTTON = "xpath://*[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        ADD_TO_MY_LIST_OVERLAY = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        MY_LIST_NAME_INPUT = "xpath://XCUIElementTypeTextField[contains(@value,'reading list title')]";
        MY_LIST_OKAY_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Search']";
        CLOSE_SEARCH_TOOL = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        CREATED_FOLDER_IN_MY_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='{FOLDER_NAME}']";
        BUTTON_CREATED_READ_LIST = "xpath://XCUIElementTypeButton[@name='Create a new list']";
        BUTTON_ADD_FOLDER = "xpath://XCUIElementTypeStaticText[@name='Java language']";
        GO_TO_MAIN_PAGE = "xpath://XCUIElementTypeButton[@name='W']";
    }
}
