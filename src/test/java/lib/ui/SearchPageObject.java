package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_RESULT_BY_SUBSTRING_TPL,
        SEARCH_CANCEL_BUTTON,
        SEARCH_CLEAR_FIELD_IOS,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    // Template methods
    @Step("Get search article with substring")
    private static String getResultSearchElement (String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    // Template methods

    @Step("Initializing the search field")
    public void initSearchInput () {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"Cannot find search and click search init element", 5);
    }

    @Step("Typing text to the search line")
    public void typeSearchLine (String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    @Step("Waiting for search result")
    public void waitForSearchResult (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    @Step("waiting for search result and select an article by substring in article title")
    public void clickByArticleWithSubString (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 5);
    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear () {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    @Step("Waiting for search cancel button to to disappear")
    public void waitForCancelButtonToDisappear () {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }
    @Step("Waiting for cancel button to disappear")
    public void waitForCancelButtonToDisappearIOS () {
        this.waitForElementNotPresent(SEARCH_CLEAR_FIELD_IOS, "Search cancel button is still present", 5);
    }

    @Step("Click button to cancel search result")
    public void clickCancelSearch () {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    @Step("Click button clear search line")
    public void clickSearchSearch () {
        this.waitForElementAndClick(SEARCH_CLEAR_FIELD_IOS, "Cannot find and click search cancel button", 5);
    }

    @Step("Getting amount of found article")
    public int getAmountOfFoundArticle () {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                5
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    @Step("Waiting for empty result label")
    public void waitForEmptyResultsLabel () {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Cannot find empty result element", 5);
    }

    @Step("Waiting for some one result search")
    public void waitForSomeOneResultSearch () {
        this.waitForElementNotPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Nothing was found for the specified query", 5);
    }

    @Step("Waiting for empty search line after clear")
    public void waitForEmptySearchContainerAfterClear() {
        this.waitForElementNotPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Search container has not been cleaned", 5);
    }

    @Step("Making sure there are no results for the search")
    public void assertThereIsNoResultOfSearch () {
        this.waitForElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results",5);
    }
}
