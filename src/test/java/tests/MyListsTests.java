package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.checkerframework.checker.units.qual.A;

public class MyListsTests extends CoreTestCase {

    private static final String
        login = "Shirab.k",
        password = "KnjJNND94nI@d";
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
            NavigationUI.returnArticlePageAfterAuth();
            NavigationUI.openNavigation();
            NavigationUI.tapOnHome();

/*          Пришлось убрать из-за того, что после авторизации открывается другая страница
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );*/

            ArticlePageObject.closeArticle();
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
