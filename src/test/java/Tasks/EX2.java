package Tasks;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class EX2 extends CoreTestCase {

    @Test
    public void testElementHasText () {
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

        assertElementHasTex(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Search field not contain 'Java' text",
                5
        );*/
        String locator = "//*[@resource-id='org.wikipedia:id/search_src_text']";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        MainPageObject MainPageObject = new MainPageObject(driver);
        MainPageObject.assertElementHasTex(locator,
                "Java",
                "Search field not contain 'Java' text",
                5);

    }
}
