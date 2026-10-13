package Pages;

import DataTypes.SignupCredentials;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Page object for the signup page.
 * Provides methods to enter account details, select preferences,
 * fill in personal and address information, and complete account registration.
 */
public class SignUPPage extends BasePage {

    /* Locators */

    /** XPath locator for the Mr. title radio button. */
    private String MrLocator = "//input[@value=\"Mr\"]";

    /** XPath locator for the Mrs. title radio button. */
    private String MrsLocator = "//input[@value=\"Mrs\"]";

    /** XPath locator for the account name input field. */
    private String NameLocator = "//div[@class=\"required form-group\"][1]//input";

    /** XPath locator for the newsletter subscription checkbox. */
    private String CheckBox1Locator = "//input[@type=\"checkbox\"][@name=\"newsletter\"]";

    /** XPath locator for the special offers subscription checkbox. */
    private String CheckBox2Locator = "//div[@id=\"uniform-optin\"]//input";

    /** XPath locator for the day of birth dropdown. */
    private String DayLocator = "//select[@id=\"days\"]";

    /** XPath locator for the month of birth dropdown. */
    private String MonthLocator = "//select[@id=\"months\"]";

    /** XPath locator for the year of birth dropdown. */
    private String YearLocator = "//select[@id=\"years\"]";

    /** XPath locator for the first name input field. */
    private String FirstNameLocator = "//input[@data-qa=\"first_name\"]";

    /** XPath locator for the country dropdown. */
    private String CountryLocator = "//select[@id=\"country\"]";

    /** XPath locator for the state input field. */
    private String StateLocator = "//input[@data-qa=\"state\"]";

    /** XPath locator for the Account Information section heading. */
    private final String AccountInfoElementLocator = "//b";

    /*
     * Functionalities
     */

    /**
     * Initializes the signup page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public SignUPPage(Framework framework) {
        super(framework);
    }

    /**
     * Selects the account title based on the supplied value.
     * Selects Mr. when the title is "Mr."; otherwise, selects Mrs.
     *
     * @param title the title to select
     */
    public void ChooseTitle(String title) {
        if (title.equals("Mr.")) {
            framework.SelectRadioButton(By.xpath(MrLocator));
        } else {
            framework.SelectRadioButton(By.xpath(MrsLocator));
        }
    }

    /**
     * Enters the account password and scrolls to the first name field.
     *
     * @param Password the password to enter
     */
    public void EnterAccountInfo(String Password) {
        framework.ClickOnElement(By.xpath(NameLocator));
        framework.SendStringViaActions(Keys.TAB + Password);
        framework.ScrollToElement(By.xpath(FirstNameLocator));
    }

    /**
     * Selects the user's date of birth from the day, month, and year dropdowns.
     *
     * @param Day the day of birth value
     * @param Month the month of birth value
     * @param Year the year of birth value
     */
    public void EnterDateOfBirth(String Day, String Month, String Year) {
        framework.ClickOnElement(By.xpath(DayLocator));
        framework.DropDownMenuSelectByValue(By.xpath(DayLocator), Day);
        framework.DropDownMenuSelectByValue(By.xpath(MonthLocator), Month);
        framework.DropDownMenuSelectByValue(By.xpath(YearLocator), Year);
        framework.SendStringViaActions(Keys.TAB);
        framework.SendStringViaActions(Keys.TAB);
    }

    /**
     * Selects both newsletter and special offers subscription checkboxes.
     */
    public void SelectCheckBoxes() {
        framework.CheckBox(By.xpath(CheckBox1Locator));
        framework.CheckBox(By.xpath(CheckBox2Locator));
    }

    /**
     * Enters the user's name and initial address details.
     *
     * @param Firstname the user's first name
     * @param LastName the user's last name
     * @param Company the company name
     * @param Address the primary address
     * @param Address2 the secondary address
     */
    public void EnterAddressInfo_1(String Firstname, String LastName, String Company, String Address, String Address2) {
        framework.ClickOnElement(By.xpath(FirstNameLocator));
        framework.SendStringViaActions(Firstname + Keys.TAB + LastName + Keys.TAB + Company + Keys.TAB + Address + Keys.TAB + Address2);
    }

    /**
     * Selects the user's country from the country dropdown.
     *
     * @param Country the country value to select
     */
    public void SelectCountry(String Country) {
        framework.DropDownMenuSelectByValue(By.xpath(CountryLocator), Country);
    }

    /**
     * Enters the remaining address and contact details.
     *
     * @param State the user's state
     * @param City the user's city
     * @param Zipcode the postal or ZIP code
     * @param MobileNumber the user's mobile phone number
     */
    public void EnterAddressInfo_2(String State, String City, String Zipcode, String MobileNumber) {
        framework.ClickOnElement(By.xpath(StateLocator));
        framework.SendStringViaActions(State + Keys.TAB + City + Keys.TAB + Zipcode + Keys.TAB + MobileNumber + Keys.TAB + Keys.ENTER);
    }

    /**
     * Checks whether the Account Information section heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckAccountInfoElementVisible() {
        return framework.ElementIsVisible(By.xpath(AccountInfoElementLocator));
    }

    /**
     * Completes the signup form using the supplied user data.
     * Enters account information, date of birth, subscription preferences,
     * personal details, and address information.
     *
     * @param user the signup credentials and account details
     * @return an AccountCreated page object for the next registration step
     */
    public AccountCreated PerformCreateAccount(SignupCredentials user) {
        ChooseTitle(user.getTitle());
        EnterAccountInfo(user.getPassword());
        EnterDateOfBirth(user.getDay(), user.getMonth(), user.getYear());
        SelectCheckBoxes();
        EnterAddressInfo_1(user.getFirstName(), user.getLastName(), user.getCompany(), user.getAddress(), user.getAddress2());
        SelectCountry(user.getCountry());
        EnterAddressInfo_2(user.getState(), user.getCity(), user.getZipcode(), user.getMobileNumber());

        return new AccountCreated(super.framework);
    }
}