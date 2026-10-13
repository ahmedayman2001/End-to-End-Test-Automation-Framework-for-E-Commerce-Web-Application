package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the payment confirmation page.
 * Provides methods to verify successful payment completion.
 */
public class PaymentDone extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the payment success message. */
    private final String SuccessMessageLocator = "//div[@class=\"col-sm-9 col-sm-offset-1\"]//p";

    /**
     * Initializes the payment confirmation page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public PaymentDone(Framework framework) {
        super(framework);
    }

    /*
     * Functionalities
     */

    /**
     * Checks whether the payment success message is visible.
     *
     * @return true if the success message is visible; otherwise, false
     */
    public boolean CheckSuccessPaymentMessageVisible() {
        return framework.ElementIsVisible(By.xpath(SuccessMessageLocator));
    }
}