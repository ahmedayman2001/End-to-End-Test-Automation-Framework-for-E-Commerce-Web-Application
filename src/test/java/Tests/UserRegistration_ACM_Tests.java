package Tests;

import DataTypes.*;
import Pages.*;
import Utils.HelperClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import TestData.TestDataGenerator;

import java.util.Optional;

/**
 * Test suite for user registration and account management.
 * Covers registration, login, logout, account deletion, invalid login,
 * duplicate email registration, and Contact Us form submission.
 */

@Listeners(MyListeners.CustomListener.class)

public class UserRegistration_ACM_Tests {

    // Stores the credentials of the account created for the login test.
    private SignupCredentials createdUser;

    // Configuration parameters supplied through TestNG XML.
    private String targetUrl;
    private String browserType;



    /**
     * Reads the target URL and browser configuration before the test class executes.
     *
     * @param targetUrl the base URL of the application under test
     * @param browserType the browser used for test execution
     */
    @Parameters({"TargetUrl", "BrowserType"})

    @BeforeClass
    public void readParams(String targetUrl, String browserType) {
        this.targetUrl = targetUrl;
        this.browserType = browserType;
    }





    ///===================================================================================================================///




    // Data Providers

    /**
     * Loads valid signup credentials from the JSON test data file.
     *
     * @return an array of signup credentials for data-driven testing
     */
    @DataProvider(name = "NewUserSignupProvider")
    public SignupCredentials[] DataDrivenTest() {

        SignupCredentials[] test = HelperClass.readJson
                ("src/main/java/TestData/SignupCredentialsData.JSON", SignupCredentials[].class);
        return test;
    }

    // TC01: Register a new user and verify account deletion.

    @Description("This_Test_To_verify_that_a_new_user_can_successfully_create_an_account_using_valid_registration\n" +
            "information")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("RegisterUser")
    @Story("RegisterNewUserWithValidData")
    @Test(dataProvider = "NewUserSignupProvider")

    public void TC01_RegisterUser(SignupCredentials test) {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the signup/login page and verify the new-user signup section.
        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckNewUserSignUPElementVisible());

        // Enter the signup details and verify that the account information form is displayed.
        SignUPPage Sign = login.PerformSignUP(test);
        Assert.assertTrue(Sign.CheckAccountInfoElementVisible());

        // Complete registration and verify the account creation confirmation.
        AccountCreated AC = Sign.PerformCreateAccount(test);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Continue to the home page and verify the logged-in state.
        BasePage BP = AC.ClickOnContinueButton();
        Assert.assertTrue(BP.CheckLoggedInVisible());

        // Delete the newly created account and verify the confirmation message.
        AccountDeleted AD = BP.ClickOnDeleteAccount();
        Assert.assertTrue(AD.CheckDeletedMessageVisible());

        // Return to the application and close the browser.
        AD.ClickOnContinueButton().CloseDriver();
    }




    ///===================================================================================================================///





    // Test Setup: Create a fresh account for tests in the "needsAccount" group.

    /**
     * Creates a new account before each test belonging to the "needsAccount" group.
     * Generates a unique email address and stores the credentials for subsequent tests.
     */
    @BeforeMethod(onlyForGroups = "needsAccount")
    public void CreateTestAccount() {

        // Load the signup data and generate a unique email address.
        SignupCredentials[] test = HelperClass.readJson
                ("src/main/java/TestData/SignupCredentialsData.JSON", SignupCredentials[].class);

        test[0].setEmailAddress(TestDataGenerator.generateUniqueEmail());

        // Store the generated credentials for use by the login test.
        createdUser = test[0];

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to signup and complete account registration.
        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckNewUserSignUPElementVisible());

        SignUPPage Sign = login.PerformSignUP(createdUser);
        Assert.assertTrue(Sign.CheckAccountInfoElementVisible());

        AccountCreated AC = Sign.PerformCreateAccount(createdUser);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Verify the logged-in state, then log out and close the browser.
        BasePage BP = AC.ClickOnContinueButton();
        Assert.assertTrue(BP.CheckLoggedInVisible());

        BP.ClickOnLogout();
        BP.CloseDriver();
    }

    // TC02: Log in with valid credentials and delete the account.

    @Description("This Test To Verify that a registered user can successfully log in using valid credentials and delete their\n" +
            "account.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("LoginUserWithCorrectEmailAndPassword")
    @Story("LoginUserWithValidData")
    @Test(groups = "needsAccount")

    public void TC02_LoginUserWithCorrectEmailAndPassword() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Log in using the credentials generated during test setup.
        LoginPage login = base.ClickOnSignUPLoginLink();
        BasePage BP = login.PerformLogin(createdUser);

        // Verify successful login, then delete the account.
        Assert.assertTrue(BP.CheckLoggedInVisible());

        AccountDeleted AD = BP.ClickOnDeleteAccount();
        Assert.assertTrue(AD.CheckDeletedMessageVisible());

        // Return to the application and close the browser.
        AD.ClickOnContinueButton().CloseDriver();
    }






    ///======================================================================================================================///






    // Data Provider: Invalid login credentials.

    /**
     * Loads invalid login credentials from the JSON test data file.
     *
     * @return an array of invalid login credential sets
     */
    @DataProvider(name = "InValidLoginProvider")
    public InvalidLoginCredentials[] DataDrivenInvalidLogin() {

        InvalidLoginCredentials[] user = HelperClass.readJson
                ("src/main/java/TestData/InvalidLoginCredentialsData.JSON", InvalidLoginCredentials[].class);
        return user;
    }

    // TC03: Verify that login is rejected when invalid credentials are provided.

    @Description("This Test To Verify That The System Prevents Login With Invalid Credentials AndDisplays TheAppropriate Error Message.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("LoginUserWithIncorrectEmailAndPassword")
    @Story("LoginUserWithInValidData")
    @Test(dataProvider = "InValidLoginProvider")

    public void TC03_LoginUserWithIncorrectEmailAndPassword(InvalidLoginCredentials user) {

        // Open the application and navigate to the login page.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckLoginToYourAccountVisible());

        // Attempt login with invalid credentials and verify the error message.
        login.PerformNegativeLogin(user);
        Assert.assertTrue(login.CheckLoginErrorMessageVisible());

        String ActualMessage = login.ReadLoginErrorMessage();
        Assert.assertTrue(ActualMessage.contains(user.getExpectedLoginErrorMessage()));

        // Close the browser after completing the test.
        login.CloseDriver();
    }




    ///======================================================================================================================///





    // Data Provider: Valid credentials for login and logout.

    /**
     * Loads valid login credentials from the JSON test data file.
     *
     * @return an array of valid login/logout test data
     */
    @DataProvider(name = "ValidLoginLogoutUser")
    public ValidLogoutUser[] DataDrivenValidLoginLogout() {

        ValidLogoutUser[] user = HelperClass.readJson
                ("src/main/java/TestData/ValidLogoutData.JSON", ValidLogoutUser[].class);
        return user;
    }

    // TC04: Verify that a logged-in user can log out successfully.

    @Description("This Test To Verify that a logged-in user can successfully log out and be redirected to the login page.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("LogoutUser")
    @Story("LoginUserWithValidDataThenLogout")
    @Test(dataProvider = "ValidLoginLogoutUser")

    public void TC04_LogoutUser(ValidLogoutUser user) {

        // Open the application and navigate to the login page.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckLoginToYourAccountVisible());

        // Log in and verify that the logged-in state is displayed.
        BasePage BP = login.PerformLoginLogout(user);
        Assert.assertTrue(BP.CheckLoggedInVisible());

        // Log out and verify that the login section is displayed again.
        Assert.assertTrue(BP.ClickOnLogout().CheckLoginToYourAccountVisible());

        // Close the browser after completing the test.
        login.CloseDriver();
    }




    ///======================================================================================================================///





    // TC05: Verify that registration is rejected when the email already exists.

    @Description("This Test Verify that an error message is displayed when attempting to register with an already\n" +
            "existing email address.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("Register User with existing email")
    @Story("SignUP New User With Email already Exist")
    @Test

    public void TC05_RegisterUserWithExistingEmail() {

        // Load the existing email address from the test data file.
        ExistingSignUPEmail user = HelperClass.readJson
                ("src/main/java/TestData/ExistingSignUPEmail.JSON", ExistingSignUPEmail.class);

        // Open the application and navigate to the signup section.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckNewUserSignUPElementVisible());

        // Attempt registration with the existing email and verify the error message is visible.
        login.PerformNegativeSignUP(user);
        Assert.assertTrue(login.CheckSignUPErrorMessageVisible());

        // Close the browser after completing the test.
        login.CloseDriver();
    }





    ///======================================================================================================================///





    // Data Provider: Contact Us form test data.

    /**
     * Loads valid Contact Us form details from the JSON test data file.
     *
     * @return an array of Contact Us form test data
     */
    @DataProvider(name = "ContactUS")
    public VaildContactUS[] DataDrivenValidContactUS() {

        VaildContactUS[] user = HelperClass.readJson
                ("src/main/java/TestData/ContactUSData.JSON", VaildContactUS[].class);

        return user;
    }

    // TC06: Verify successful submission of the Contact Us form.

    @Description("This Test To verify that a user can successfully submit the 'Contact Us' form with all valid details\n" +
            "and an attached file.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("UserRegistration&AccountManagement")
    @Feature("Contact Us Form")
    @Story("UserSubmit Valid ContactUS Form")
    @Test(dataProvider = "ContactUS")

    public void TC06_ContactUsForm(VaildContactUS user) {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the Contact Us page and verify that the form is available.
        ContactUS CU = base.ClickOnContactUS();
        Assert.assertTrue(CU.ChickGetInTouchVisible());

        // Submit the form and verify the success confirmation.
        CU.PerformSubmit(user);
        Assert.assertTrue(CU.CheckSuccessMessageVisible());

        // Return to the home page, verify it is displayed, and close the browser.
        Assert.assertTrue(CU.ClickOnHomeButton().CheckHomePageImageVisible());
        base.CloseDriver();
    }

}




///======================================================================================================================///





