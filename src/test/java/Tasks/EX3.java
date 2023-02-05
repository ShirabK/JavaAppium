package Tasks;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

@Epic("Home work")
public class EX3 extends CoreTestCase {

    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @Feature(value = "Search")
    @DisplayName("Check the cleanliness of the search field")
    @Description("Input in search field text 'Java', click clear button and check result")
    @Step("Start test 'testClearSearchAfterRequest'")
    public void  testClearSearchAfterRequest() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSomeOneResultSearch();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForEmptySearchContainerAfterClear();
    }
}
