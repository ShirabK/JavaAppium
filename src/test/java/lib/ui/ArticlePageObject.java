package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OKAY_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    CREATED_FOLDER_IN_MY_LIST,
    BUTTON_CREATED_READ_LIST,
    BUTTON_ADD_FOLDER,
    CLOSE_SEARCH_TOOL,
    GO_TO_MAIN_PAGE,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;

    private static String getXpathFolderName (String folder_name) {
        return CREATED_FOLDER_IN_MY_LIST.replace("{FOLDER_NAME}", folder_name);
    }
    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement () {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 5);
    }

    public String getArticleTitle () {
        WebElement title_element = waitForTitleElement();
        return title_element.getText();
    }

    public void swipeToFooter () {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the and of article",
                    40
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTitleElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the and of article",
                    40
            );
        } else {
            this.scrollWebPageTitleElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the and of article",
                    40
            );
        }
    }

    public void addArticleToMyList (String name_of_folder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to add article to reading options",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button to 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot clear input element to set name of article folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OKAY_BUTTON,
                "Cannot find or press 'OK' button to create folder",
                5
        );
    }

    public void addArticleToMySaved () {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to add article to reading list",
                5
        );
    }

    public void removeArticleFromSavedIfItAdded () {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
            5);
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }

    public void addiArticleToCreatedFolderInMyList (String name_of_folder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to add article to reading options",
                5
        );

        String name_xpath = getXpathFolderName(name_of_folder);
        this.waitForElementAndClick(
                name_xpath,
                "Cannot find folder by name " + name_xpath,
                5
        );
    }

    public void closeArticle () {
        if ((Platform.getInstance().isIOS()) || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot find close article, cannot find 'x' click",
                    5
            );
        } else {
            System.out.println("Method closeArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }
    public void GoToMainPage () {
        this.waitForElementAndClick(
                GO_TO_MAIN_PAGE,
                "Cannot find close article, cannot find 'x' click",
                5
        );
    }
}
