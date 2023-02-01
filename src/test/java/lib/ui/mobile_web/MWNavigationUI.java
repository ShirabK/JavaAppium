package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        MY_LISTS_LINK = "css:a[data-event-name='menu.unStar']";
        CLOSE_AUTH_IN_SAVED_PAGE = "xpath://XCUIElementTypeButton[@name='Close']";
        OPEN_NAVIGATION = "css:label#mw-mf-main-menu-button";
        BACK_LINK_AFTER_AUTH = "css:#centralauth-backlink-section";
        HOME_LINK = "css:a[class='menu__item--home']";
    }
}
