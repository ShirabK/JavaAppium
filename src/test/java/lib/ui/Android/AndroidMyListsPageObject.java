package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListObject {
    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL= "xpath://*[@text='{TITLE}']";
    }
}
