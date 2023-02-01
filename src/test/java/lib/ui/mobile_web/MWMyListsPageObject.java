package lib.ui.mobile_web;

import lib.ui.MyListObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListObject {
    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        FOLDER_BY_NAME_TPL = "";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'content-unstyled page-list thumbs page-summary-list mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]";
        FIRST_ARTICLE_BY_JAVA = "";
        SECOND_ARTICLE_BY_JAVA = "";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]";
        REMOVE_FROM_SAVED_BUTTON_AFTER = "xpath://ul[contains(@class,'mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'mw-ui-icon mw-ui-icon-element mw-ui-icon-wikimedia-star-base20  watch-this-article mw-ui-button mw-ui-quiet')]";
    }
}
