package lib.ui;


import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
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


    @Step("Waiting for learn link")
    public void waitForLearnMoreLink () {
        this.waitForElementPresent(LEARN_MORE_LINK,
                "Cannot find 'learn More' link",
                10);
    }

    @Step("Click 'next' button")
    public void clickNextButton () {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Cannot find 'NEXT' button and click",
                10);
    }

    @Step("Click Skip button")
    public void clickSkip() {
        this.waitForElementAndClick(SKIP,
                "Cannot find and click skip button",
                5);
    }

    @Step("Wait for new way to explore text")
    public void waitForNewWayToExploreText () {
        this.waitForElementPresent(NEW_WAYS_TO_EXPLORE,
                "Cannot find 'learn More' link",
                10);
    }

    @Step("Wait to add order edit Preferred lang text")
    public void waitForAddOrEditPreferredLangText () {
        this.waitForElementPresent(ADD_OR_EDIT_PREFERRED_LANG_TEXT,
                "Cannot find 'Add or edit preferred languages' link",
                10);
    }

    @Step("Wait for learn more about data collected text")
    public void waitForLearnMoreAboutDataCollectedText () {
        this.waitForElementPresent(LEARN_MORE_ABOUT_DATA_COLLECT_TEXT,
                "Cannot find 'Learn more about data collected' link",
                10);
    }

    @Step("Click get started button")
    public void clickGetStartedButton () {
        this.waitForElementAndClick(GET_STARTED,
                "Cannot find 'Get started' button and click",
                10);
    }
}
