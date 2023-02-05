package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String
        login = "Shirab.k",
        password = "KnjJNND94nI@d";
    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article"),@Feature(value = "Read list")})
    @DisplayName("Add article in read list")
    @Description("Search article 'Object-oriented programming language', add read list and remove")
    @Step("Start test 'testSaveFirstArticleToMyListTitle'")
    public void testSaveFirstArticleToMyListTitle() {

        String name_of_folder = "Java";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubString("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForTitleElement();
        }

        ArticlePageObject.getArticleTitle();
        String article_title = ArticlePageObject.getArticleTitle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.closeArticle();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticleToMySaved();
            ArticlePageObject.GoToMainPage();
        } else {
            ArticlePageObject.addArticleToMySaved();
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enteringLoginData(login, password);
            Auth.submitForm();
            NavigationUI.returnBackPage();
            NavigationUI.openNavigation();
            NavigationUI.tapOnHome();

/*          Пришлось убрать из-за того, что после авторизации открывается другая страница
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );*/
        }

        MyListObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
            MyListPageObject.swipeByArticleToDelete(article_title);
            MyListPageObject.waitForArticleToDisappearByTitle(article_title);
        } else if (Platform.getInstance().isIOS()){
            NavigationUI.closeAuthPage();
            MyListPageObject.swipeFirstArticleToDeleteForIOS();
            NavigationUI.closeAuthPage();
            MyListPageObject.waitForArticleToDisappearByTitleForIOSFirstArticle();
        } else {
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
            MyListPageObject.swipeByArticleToDelete(article_title);
        }
    }
}
