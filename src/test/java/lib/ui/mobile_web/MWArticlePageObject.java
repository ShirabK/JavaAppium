package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:mw-footer minerva-footer";
        OPTIONS_BUTTON = "css:";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#page-actions-watch #ca-watch.mw-ui-icon-wikimedia-star-base20";//#page-actions #ca-watch
        ADD_TO_MY_LIST_OVERLAY = "css:#page-actions #ca-watch.mw-ui-icon.mw-watchlink.menu__item--page-actions-watch.mw-ui-icon-wikimedia-star-base20";
        MY_LIST_NAME_INPUT = "css:";
        MY_LIST_OKAY_BUTTON = "css:";
        CLOSE_ARTICLE_BUTTON = "css:";
        CREATED_FOLDER_IN_MY_LIST = "css:";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions #ca-watch.mw-ui-icon.mw-watchlink.menu__item--page-actions-watch.watched.mw-ui-icon-wikimedia-unStar-progressive";
    }
}
