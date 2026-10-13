package Pages;

import DataTypes.ValidPayment;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Page object for the payment page.
 * Provides functionality to enter payment details and submit the payment form.
 */
public class Payment extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the cardholder name input field. */
    private final String NameOnCardLocator = "//input[@name=\"name_on_card\"]";

    /*
     * Functionalities
     */

    /**
     * Initializes the payment page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public Payment(Framework framework) {
        super(framework);
    }

    /**
     * Enters the payment details and submits the payment form.
     * Navigates to the payment confirmation page after submission.
     *
     * @param VP the payment data containing the cardholder name, card number,
     *           CVC, expiration month, and expiration year
     * @return a PaymentDone page object representing the payment confirmation page
     */
    public PaymentDone PerformPayment(ValidPayment VP) {

        framework.ClickOnElement(By.xpath(NameOnCardLocator));
        framework.SendStringViaActions(VP.getNameOnCard() + Keys.TAB
                + VP.getCardNumber() + Keys.TAB
                + VP.getCvc() + Keys.TAB
                + VP.getExpirationMonth() + Keys.TAB
                + VP.getExpirationYear() + Keys.TAB + Keys.ENTER);

        return new PaymentDone(super.framework);
    }
}