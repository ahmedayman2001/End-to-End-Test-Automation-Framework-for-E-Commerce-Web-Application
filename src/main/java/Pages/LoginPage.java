package Pages;

import DataTypes.ExistingSignUPEmail;
import DataTypes.InvalidLoginCredentials;
import DataTypes.SignupCredentials;
import DataTypes.ValidLogoutUser;
import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the login and signup page.
 * Provides methods to register new users, validate signup and login errors,
 * authenticate users, and navigate to the appropriate page objects.
 */
public class LoginPage extends BasePage {

    /* Locators */

    /** XPath locator for the new user's name input field. */
    private final String NewUserNameLocator = "//form[@action=\"/signup\"]/input[2]";

    /** XPath locator for the new user's email input field. */
    private final String NewEmailLocator = "//form[@action=\"/signup\"]/input[3]";

    /** XPath locator for the signup form submit button. */
    private final String SignUPButtonLocator = "//form[@action=\"/signup\"]/button";

    /** XPath locator for the New User Signup section heading. */
    private final String NewUserSignupLocator = "//div[@class=\"signup-form\"]//h2";

    /** XPath locator for the Login to Your Account section heading. */
    private final String LoginToYourAccountLocator = "//div[@class=\"login-form\"]/h2";

    /** XPath locator for the login email input field. */
    private final String EmailAddressLocator = "//form[@action=\"/login\"]/input[2]";

    /** XPath locator for the login password input field. */
    private final String PasswordLocator = "//form[@action=\"/login\"]/input[3]";

    /** XPath locator for the login form submit button. */
    private final String LoginButtonLocator = "//form[@action=\"/login\"]/button";

    /** XPath locator for the login error message. */
    private final String LoginErrorMessageLocator = "//form[@action=\"/login\"]/p";

    /** XPath locator for the signup error message. */
    private final String SignUPErrorMessageLocator = "//form[@action=\"/signup\"]/p";

    /*
     * Functionalities
     */

    /**
     * Initializes the login page using the specified browser and target URL.
     *
     * @param BrowserName the name of the browser to launch
     * @param TargetURL the URL to open
     */
    public LoginPage(String BrowserName, String TargetURL) {
        super(BrowserName, TargetURL);
    }

    /**
     * Initializes the login page using an existing framework instance.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public LoginPage(Framework framework) {
        super(framework);
    }

    /**
     * Enters the new user's name in the signup form.
     *
     * @param Name the name to enter
     */
    public void EnterNewUserName(String Name) {
        framework.SendText(By.xpath(NewUserNameLocator), Name);
    }

    /**
     * Enters the new user's email address in the signup form.
     *
     * @param Email the email address to enter
     */
    public void EnterNewEmail(String Email) {
        framework.SendText(By.xpath(NewEmailLocator), Email);
    }

    /**
     * Clicks the signup form submit button.
     */
    public void ClickOnSignUPButton() {
        framework.ClickOnButton(By.xpath(SignUPButtonLocator));
    }

    /**
     * Checks whether the New User Signup heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckNewUserSignUPElementVisible() {
        return framework.ElementIsVisible(By.xpath(NewUserSignupLocator));
    }

    /**
     * Submits the signup form using the supplied user credentials.
     *
     * @param user the signup credentials
     * @return a SignUPPage object for the next registration step
     */
    public SignUPPage PerformSignUP(SignupCredentials user) {
        EnterNewUserName(user.getName());
        EnterNewEmail(user.getEmailAddress());
        ClickOnSignUPButton();
        return new SignUPPage(super.framework);
    }

    /**
     * Attempts to register a user with an email address that already exists.
     *
     * @param user the existing user's signup data
     * @return a SignUPPage object for validating the signup result
     */
    public SignUPPage PerformNegativeSignUP(ExistingSignUPEmail user) {
        EnterNewUserName(user.getName());
        EnterNewEmail(user.getEmailAddress());
        ClickOnSignUPButton();
        return new SignUPPage(super.framework);
    }

    /**
     * Checks whether the Login to Your Account heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckLoginToYourAccountVisible() {
        return framework.ElementIsVisible(By.xpath(LoginToYourAccountLocator));
    }

    /**
     * Enters an email address in the login form.
     *
     * @param Email the email address to enter
     */
    public void EnterEmailAddress(String Email) {
        framework.SendText(By.xpath(EmailAddressLocator), Email);
    }

    /**
     * Enters a password in the login form.
     *
     * @param Password the password to enter
     */
    public void EnterPassword(String Password) {
        framework.SendText(By.xpath(PasswordLocator), Password);
    }

    /**
     * Clicks the login form submit button.
     */
    public void ClickOnLoginButton() {
        framework.ClickOnButton(By.xpath(LoginButtonLocator));
    }

    /**
     * Checks whether the login error message is visible.
     *
     * @return true if the error message is visible; otherwise, false
     */
    public boolean CheckLoginErrorMessageVisible() {
        return framework.ElementIsVisible(By.xpath(LoginErrorMessageLocator));
    }

    /**
     * Retrieves the displayed login error message.
     *
     * @return the login error message text
     */
    public String ReadLoginErrorMessage() {
        return framework.GetTextFromElement(By.xpath(LoginErrorMessageLocator));
    }

    /**
     * Checks whether the signup error message is visible.
     *
     * @return true if the error message is visible; otherwise, false
     */
    public boolean CheckSignUPErrorMessageVisible() {
        return framework.ElementIsVisible(By.xpath(SignUPErrorMessageLocator));
    }

    /**
     * Logs in using the supplied signup credentials.
     *
     * @param test the user credentials used for login
     * @return a BasePage object representing the post-login page
     */
    public BasePage PerformLogin(SignupCredentials test) {
        EnterEmailAddress(test.getEmailAddress());
        EnterPassword(test.getPassword());
        ClickOnLoginButton();
        return new BasePage(super.framework);
    }

    /**
     * Attempts to log in using the supplied invalid credentials.
     *
     * @param user the invalid login credentials
     * @return the current LoginPage object for further validation
     */
    public LoginPage PerformNegativeLogin(InvalidLoginCredentials user) {
        EnterEmailAddress(user.getEmailAddress());
        EnterPassword(user.getPassword());
        ClickOnLoginButton();
        return this;
    }

    /**
     * Logs in using the supplied credentials for a logout test scenario.
     *
     * @param user the credentials of the user being tested
     * @return a BasePage object representing the post-login page
     */
    public BasePage PerformLoginLogout(ValidLogoutUser user) {
        EnterEmailAddress(user.getEmailAddress());
        EnterPassword(user.getPassword());
        ClickOnLoginButton();
        return new BasePage(super.framework);
    }


//    public LoginPage PerformNegative(UserCredentials user){
//        EnterUserName(user.getUserName());
//        EnterEmail(user.getEmail());
//        ClickOnLoginButton();
//        return this;
//    }

}