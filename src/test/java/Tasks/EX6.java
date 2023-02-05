package Tasks;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

@Epic("Home work")
public class EX6 extends CoreTestCase {

    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @Feature(value = "Search")
    @DisplayName("Search field has entered text")
    @Description("Input in search field text 'Java' and check")
    @Step("Start test 'testSearchTitleArticle'")
    public void testSearchTitleArticle () {
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
