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
public class EX2 extends CoreTestCase {

    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @Feature(value = "Search")
    @DisplayName("Search field has entered text")
    @Description("Input in search field text 'Java' and check")
    @Step("Start test 'testElementHasText'")
    public void testElementHasText () {
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
