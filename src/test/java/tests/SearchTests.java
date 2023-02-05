package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

@Epic("Test for search line")
public class SearchTests extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Search")
    @DisplayName("First test")
    @Description("First test run")
    @Step("Start test 'testFirstTest'")
    public void testFirstTest() {
        System.out.println("First test run");
    }

    @Test
    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Search")
    @DisplayName("Init search line")
    @Description("Search article 'Appium'")
    @Step("Start test 'testFirstSearchLocator'")
    public void testFirstSearchLocator() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");

    }

    @Test
    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Search")
    @DisplayName("Search article 'Object-oriented programming language'")
    @Description("Search article about Java 'Object-oriented programming language'")
    @Step("Start test 'testSearchJava'")
    public void testSearchJava() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Search")
    @DisplayName("Cancel button in search line")
    @Description("Click cancel button after search article")
    @Step("Start test 'testCancelSearch'")
    public void  testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.clickCancelSearch();
            SearchPageObject.clickCancelSearch();
            SearchPageObject.waitForCancelButtonToDisappear();
        } else if (Platform.getInstance().isIOS()){
            SearchPageObject.clickSearchSearch();
            SearchPageObject.waitForCancelButtonToDisappearIOS();
        } else if (Platform.getInstance().isMw()) {
            SearchPageObject.clickCancelSearch();
            SearchPageObject.waitForCancelButtonToDisappear();
        }
    }
}
