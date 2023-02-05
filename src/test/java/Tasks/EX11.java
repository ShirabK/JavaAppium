package Tasks;

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

@Epic("Home work")
public class EX11 extends CoreTestCase {
    private static final String
            login = "Shirab.k",
            password = "KnjJNND94nI@d";

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article"),@Feature(value = "Read list")})
    @DisplayName("Add two article in read list and remove one")
    @Description("Adding two articles about anime, removing one from the list and checking the rest")
    @Step("Start test 'testSavingTwoArticle'")
    public void testSavingTwoArticle () {

        String name_of_folder = "Java language";
        String search_text = "Java";
        String first_article = "Java (programming language)";
        String second_article = "Java version history";
        String first_article_subtitle = "Object-oriented programming language";
        String second_article_subtitle = "List of versions of the Java programming language";

        //Add first article
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_text);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);

        if ((Platform.getInstance().isAndroid()) || Platform.getInstance().isIOS()) {
            SearchPageObject.clickByArticleWithSubString(first_article);
        }

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.closeArticle();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticleToMySaved();
            ArticlePageObject.GoToMainPage();
        } else {
            SearchPageObject.clickByArticleWithSubString(first_article_subtitle);
            ArticlePageObject.addArticleToMySaved();
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enteringLoginData(login, password);
            Auth.submitForm();
            NavigationUI.returnBackPage();
            NavigationUI.openNavigation();
            NavigationUI.tapOnHome();
        }

        //Add second article
        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine(search_text);
            SearchPageObject.clickByArticleWithSubString(second_article);
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.getArticleTitle();
            ArticlePageObject.addiArticleToCreatedFolderInMyList(name_of_folder);
            ArticlePageObject.closeArticle();
        } else if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickByArticleWithSubString(second_article);
            ArticlePageObject.addArticleToMySaved();
            ArticlePageObject.GoToMainPage();
        } else {
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine(search_text);
            SearchPageObject.clickByArticleWithSubString(second_article_subtitle);
            ArticlePageObject.addArticleToMySaved();
            NavigationUI.openNavigation();
        }

        NavigationUI.clickMyLists();

        MyListObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
            MyListPageObject.swipeByArticleToDelete(second_article);
            MyListPageObject.waitForArticleToDisappearByTitle(second_article);
        } else if (Platform.getInstance().isIOS()) {
            NavigationUI.closeAuthPage();
            MyListPageObject.swipeSecondArticleToDeleteForIOS();
            MyListPageObject.waitForArticleToDisappearByTitleForIOSSecondArticle();
        } else {
            MyListPageObject.swipeByArticleToDelete(second_article);
        }
    }
}
