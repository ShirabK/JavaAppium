package Tasks;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
public class EX5 extends CoreTestCase {

    @Test
    public void testSavingTwoArticle () {

        String name_of_folder = "Japanese animation article";
        String search_text = "Anime";
        String first_article = "Japanese animation";
        String second_article = "Western animation inspired by anime (Japanese animation)";

        //Add first article
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_text);
        SearchPageObject.clickByArticleWithSubString(first_article);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.getArticleTitle();
        String article_first_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        //Add second article
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_text);
        SearchPageObject.clickByArticleWithSubString(second_article);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.getArticleTitle();
        String article_second_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addiArticleToCreatedFolderInMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        //Go to My list to remove one of article
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(second_article);
        MyListPageObject.waitForArticleToDisappearByTitle(second_article);

        MyListPageObject.waitForArticleToAppearByTitle(first_article);
    }
}
