package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Condition")})
    @DisplayName("Check change screen orientation")
    @Description("Check change screen orientation")
    @Step("Start test 'testChangeScreenOrientationOnSearchResults'")
    public void testChangeScreenOrientationOnSearchResults () {

        if (Platform.getInstance().isMw()) {
            return;
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();

        this.rotateScreenPortrait();

        String title_after_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been change after rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenLandscape();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been change after rotation",
                title_before_rotation,
                title_after_second_rotation);
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @DisplayName("Checking an article where collapse the application")
    @Description("Checking an article stays open after collapse the application")
    @Step("Start test 'testChangeScreenOrientationOnSearchResults'")
    public void testCheckSearchArticleInBackGround () {
        String result_title = "Object-oriented programming language";

        if (Platform.getInstance().isMw()) {
            return;
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult(result_title);

        this.backgroundApp(3);

        SearchPageObject.waitForSearchResult(result_title);
    }
}
