package Tasks;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class EX6 extends CoreTestCase {

/*    private void assertElementPresent (By by, String error_message, long timeoutInSeconds) {
        int found_element = getAmountOfElements(by);

        if (found_element == 0) {
            String message = "An element " + by.toString() + " not present";
            throw new AssertionError(message + " " + error_message );
        }
    }*/

    @Test
    public void testSearchTitleArticle () {
/*        String search_element = "//*[@resource-id='org.wikipedia:id/view_page_header_container']" +
                "//*[@resource-id='org.wikipedia:id/view_page_title_text']";

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia input'",
                5);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                5
        );

        assertElementPresent(
            By.xpath(search_element),
                "We not found search element",
                10
        );*/
        String search_element = "//*[@resource-id='org.wikipedia:id/view_page_header_container']" +
                "//*[@resource-id='org.wikipedia:id/view_page_title_text']";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");

        MainPageObject MainPageObject = new MainPageObject (driver);

        MainPageObject.assertElementPresent(
                search_element,
                "We not found search element",
                10
        );
    }
}
