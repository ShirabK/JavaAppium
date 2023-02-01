package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class AuthorizationPageObject extends MainPageObject{

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static final String
        LOGIN_BUTTON = "xpath://body/div/div/a[text()='Log in']",
        LOGIN_INPUT = "css:input[name='wpName']",
        PASSWORD_INPUT = "css:input[name='wpPassword']",
        SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public void clickAuthButton () {
/*          driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
        this.waitForElementPresent(
                LOGIN_BUTTON,
                "Cannot find Auth button",
                5
        );
        this.waitForElementAndClick(
                LOGIN_BUTTON,
                "Cannot find and click Auth button",
                5
        );*/
       this.tryClickElementWithFewAttempts(
                LOGIN_BUTTON,
                "Cannot find Auth button",
                10
        );
    }

    public void enteringLoginData (String login, String password) {
        this.waitForElementAndSendKeys(
                LOGIN_INPUT,
                login,
                "Cannot find and put a login to the login input",
                5
        );
        this.waitForElementAndSendKeys(
                PASSWORD_INPUT,
                password,
                "Cannot find and put a password to the password input",
                5
        );
    }

    public void submitForm () {
        this.waitForElementAndClick(
                SUBMIT_BUTTON,
                "Cannot find and click submit button",
                5
        );
    }
}
