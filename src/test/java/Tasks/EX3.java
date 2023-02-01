package Tasks;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class EX3 extends CoreTestCase {

    @Test
    public void  testClearSearchAfterRequest() {
/*        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia input'",
                5);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_empty_text"),
                "No results found",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'X' to cancel button",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'X' to cancel button",
                5
        );

        waitForElementPresent(
          By.id("org.wikipedia:id/search_empty_message"),
                "Search result are present",
                5
        );*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSomeOneResultSearch();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForEmptySearchContainerAfterClear();
    }
}
