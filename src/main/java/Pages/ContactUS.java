package Pages;

import DataTypes.VaildContactUS;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Page object for the Contact Us page.
 * Provides methods to fill out and submit the contact form,
 * upload a file, handle JavaScript alerts, and navigate back home.
 */
public class ContactUS extends BasePage {

    /* Locators */

    /** XPath locator for the Get In Touch section heading. */
    private final String GetInTouchElementLocator = "//div[@class=\"contact-form\"]//h2";

    /** XPath locator for the name input field. */
    private final String NameElementLocator = "//div[@class=\"contact-form\"]//input[@name=\"name\"]";

    /** XPath locator for the file upload input. */
    private final String InputFileLocator = "//input[@type=\"file\"]";

    /** XPath locator for the contact form submit button. */
    private final String SubmitButtonLocator = "//input[@type=\"submit\"]";

    /** XPath locator for the successful submission message. */
    private final String SuccessMessageLocator = "//div[@class=\"status alert alert-success\"]";

    /** XPath locator for the Home button displayed after form submission. */
    private final String HomeButtonLocator = "//a[@class=\"btn btn-success\"]";

    /*
     * Functionalities
     */

    /**
     * Initializes the Contact Us page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public ContactUS(Framework framework) {
        super(framework);
    }

    /**
     * Checks whether the Get In Touch section heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean ChickGetInTouchVisible() {
        return framework.ElementIsVisible(By.xpath(GetInTouchElementLocator));
    }

    /**
     * Enters the contact name and moves focus to the next form field.
     *
     * @param Name the name to enter
     */
    public void EnterName(String Name) {
        framework.ClickOnElement(By.xpath(NameElementLocator));
        framework.SendText(By.xpath(NameElementLocator), Name);
        framework.SendStringViaActions(Keys.TAB);
    }

    /**
     * Enters the contact email and moves focus to the next form field.
     *
     * @param Email the email address to enter
     */
    public void EnterEmail(String Email) {
        framework.SendStringViaActions(Email + Keys.TAB);
    }

    /**
     * Enters the contact subject and moves focus to the next form field.
     *
     * @param Subject the subject to enter
     */
    public void EnterSubject(String Subject) {
        framework.SendStringViaActions(Subject + Keys.TAB);
    }

    /**
     * Enters the contact message into the currently focused form field.
     *
     * @param Message the message to enter
     */
    public void EnterMessage(String Message) {
        framework.SendStringViaActions(Message);
    }

    /**
     * Uploads a file through the contact form's file input.
     *
     * @param FileBath the path of the file to upload
     */
    public void UploadFile(String FileBath) {
        framework.UploadFile(By.xpath(InputFileLocator), FileBath);
    }

    /**
     * Clicks the contact form submit button.
     */
    public void ClickOnSubmitButton() {
        framework.ClickOnButton(By.xpath(SubmitButtonLocator));
    }

    /**
     * Clicks the Home button and returns a BasePage object.
     *
     * @return a BasePage object representing the home page
     */
    public BasePage ClickOnHomeButton() {
        framework.ClickOnButton(By.xpath(HomeButtonLocator));
        return new BasePage(super.framework);
    }

    /**
     * Checks whether the successful form submission message is visible.
     *
     * @return true if the success message is visible; otherwise, false
     */
    public boolean CheckSuccessMessageVisible() {
        return framework.ElementIsVisible(By.xpath(SuccessMessageLocator));
    }

    /**
     * Accepts the currently displayed JavaScript alert.
     *
     * @return the current ContactUS page object for method chaining
     */
    public ContactUS AcceptJavaScriptAlert() {
        framework.AcceptAlert();
        return this;
    }

    /**
     * Completes and submits the contact form using the supplied user data.
     * Enters the form details, uploads the specified file, submits the form,
     * and accepts the resulting JavaScript alert.
     *
     * @param user the contact form data
     * @return the current ContactUS page object for method chaining
     */
    public ContactUS PerformSubmit(VaildContactUS user) {
        EnterName(user.getName());
        EnterEmail(user.getEmail());
        EnterSubject(user.getSubject());
        EnterMessage(user.getMessage());
        UploadFile(user.getFilePath());
        ClickOnSubmitButton();
        AcceptJavaScriptAlert();
        return this;
    }
}