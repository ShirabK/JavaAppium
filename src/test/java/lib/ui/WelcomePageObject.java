package lib.ui;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {
    public WelcomePageObject (RemoteWebDriver driver) {
        super(driver);
    }

    private static final String
    LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    NEXT_BUTTON = "id:Next",
    NEW_WAYS_TO_EXPLORE = "id:New ways to explore",
    ADD_OR_EDIT_PREFERRED_LANG_TEXT = "id:Add or edit preferred languages",

    LEARN_MORE_ABOUT_DATA_COLLECT_TEXT= "id:Learn more about data collected",
    GET_STARTED = "id:Get started",
    SKIP = "id:Skip"; //XCUIElementTypeButton[@name="Skip"]


    public void waitForLearnMoreLink () {
        this.waitForElementPresent(LEARN_MORE_LINK,
                "Cannot find 'learn More' link",
                10);
    }

    public void clickNextButton () {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Cannot find 'NEXT' button and click",
                10);
    }

    public void waitForNewWayToExploreText () {
        this.waitForElementPresent(NEW_WAYS_TO_EXPLORE,
                "Cannot find 'learn More' link",
                10);
    }

    public void waitForAddOrEditPreferredLangText () {
        this.waitForElementPresent(ADD_OR_EDIT_PREFERRED_LANG_TEXT,
                "Cannot find 'Add or edit preferred languages' link",
                10);
    }

    public void waitForLearnMoreAboutDataCollectedText () {
        this.waitForElementPresent(LEARN_MORE_ABOUT_DATA_COLLECT_TEXT,
                "Cannot find 'Learn more about data collected' link",
                10);
    }

    public void clickGetStartedButton () {
        this.waitForElementAndClick(GET_STARTED,
                "Cannot find 'Get started' button and click",
                10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP,
                "Cannot find and click skip button",
                5);
    }
}
