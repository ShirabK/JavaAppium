package Tasks;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class EX11 extends CoreTestCase {

    @Test
    public void testSavingTwoArticle () {

        String name_of_folder = "Java language";
        String search_text = "Java";
        String first_article = "Java (programming language)";
        String second_article = "Java version history";

        //Add first article
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_text);
        SearchPageObject.clickByArticleWithSubString(first_article);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        //Add second article
        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine(search_text);
            SearchPageObject.clickByArticleWithSubString(second_article);
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.getArticleTitle();
            ArticlePageObject.addiArticleToCreatedFolderInMyList(name_of_folder);
            ArticlePageObject.closeArticle();
        } else {
            SearchPageObject.clickByArticleWithSubString(second_article);
            ArticlePageObject.addArticleToMySaved();
            ArticlePageObject.GoToMainPage();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
            MyListPageObject.swipeByArticleToDelete(second_article);
            MyListPageObject.waitForArticleToDisappearByTitle(second_article);
        } else {
            NavigationUI.closeAuthPage();
            MyListPageObject.swipeSecondArticleToDeleteForIOS();
            MyListPageObject.waitForArticleToDisappearByTitleForIOSSecondArticle();
        }
    }
}
