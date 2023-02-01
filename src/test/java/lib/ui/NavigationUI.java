package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{
    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            MY_LISTS_LINK,
            CLOSE_AUTH_IN_SAVED_PAGE,
            OPEN_NAVIGATION,
            BACK_LINK_AFTER_AUTH,
            HOME_LINK;

    public void openNavigation () {
        if (Platform.getInstance().isMw()) {
            this.waitForElementAndClick(
                    OPEN_NAVIGATION,
                    "Cannot find and click open navigation button",
                    5
            );
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void tapOnHome () {
        this.tryClickElementWithFewAttempts(
                HOME_LINK,
                "Cannot find 'Home' button to home page",
                5
        );
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find 'My lists' button and click",
                    5
            );
        }
    }

    public void returnBackPage() {
        if (Platform.getInstance().isMw()) {
            driver.navigate().back();
        }
    }

    public void closeAuthPage () {
        this.waitForElementAndClick(
                CLOSE_AUTH_IN_SAVED_PAGE,
                "Cannot find 'X' button and click on AuthPage",
                5
        );
    }
}
