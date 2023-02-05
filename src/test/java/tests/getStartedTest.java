package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

@Epic("Welcome screens on iOS")
public class getStartedTest extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @Feature(value = "Welcome screen")
    @DisplayName("Check all welcome screens on iOS")
    @Description("Check all welcome screens on iOS")
    @Step("Start test 'testPassThroughWelcome'")
    public void testPassThroughWelcome () {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMw())) {
            return;
        }

        WelcomePageObject WelcomePageObject = new WelcomePageObject (driver);

        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForNewWayToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferredLangText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();
    }
}
