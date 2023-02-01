package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
public class MWSearchPageObject  extends SearchPageObject {
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "css:div.header-action>button.mw-ui-icon.mw-ui-icon-element.mw-ui-icon-mf-close-base20.cancel.mw-ui-button.mw-ui-quiet";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list.thumbs.actionable>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
    }
}
