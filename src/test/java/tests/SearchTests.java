package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testFirstTest() {
        System.out.println("First test run");
    }

    @Test
    public void testFirstSearchLocator() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");

    }

    @Test
    public void testSearchJava() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    @Test
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
