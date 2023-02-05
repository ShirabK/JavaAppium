package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import lib.ui.WelcomePageObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.time.Duration;

public class CoreTestCase {
    protected RemoteWebDriver driver;

    @Before
    @Step("Run driver and session")
    public void setUp () throws Exception{
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.openPageWikiPageFromMobileWeb();
    }

    @After
    @Step("Remove driver and session")
    public  void tearDown() throws Exception{
        driver.quit();
    }

    @Step("Rotate scree to portrait mode")
    protected void rotateScreenPortrait () {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate scree to landscape mode")
    protected void rotateScreenLandscape () {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Send mobile app to background (this methode does nothing for Mobile Web)")
    protected void backgroundApp (int seconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Method backgroundApp() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Swipe article to up")
    protected void SwipeUp (int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width/2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);

            action
                    .press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();
        } else {
            System.out.println("Method SwipeUp() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Open Wikipedia URL for Mobile Web (this methode does nothing for Android and iOS)")
    protected void openPageWikiPageFromMobileWeb() {
        if (Platform.getInstance().isMw()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openPageWikiPageFromMobileWeb() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Step sckip welcome page screen for iOS")
    private  void skipWelcomePageForIOSApp () {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            if (Platform.getInstance().isIOS()) {
                WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
                WelcomePageObject.clickSkip();
            }
        } else {
            System.out.println("Method skipWelcomePageForIOSApp() does  nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
}
