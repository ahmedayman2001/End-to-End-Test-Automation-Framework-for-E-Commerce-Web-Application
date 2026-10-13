package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the checkout page.
 * Provides methods to verify address details, retrieve product prices,
 * enter order comments, and proceed to payment.
 */
public class Checkout extends BasePage {

    /*
     * Locators
     */

    // Expected product prices:
    // Product 1: Rs. 500
    // Product 2: Rs. 400
    // Total: Rs. 900

    /** XPath locator for the address details section heading. */
    private final String AddressDetailLocator = "//section[@id=\"cart_items\"]/div[@class=\"container\"]//div[@class=\"step-one\"][1]/h2";

    /** XPath locator for the order message text area. */
    private final String TextAreaBoxLocator = "//textarea";

    /** XPath locator for the Place Order button. */
    private final String PlaceOrderButtonLocator = "//a[@href=\"/payment\"]";

    /** XPath locator for the first address detail in the delivery address section. */
    private final String FirstElementInDeliveryAddressLocator = "//ul[@id=\"address_delivery\"]/li[2]";

    /** XPath locator for the first address detail in the billing address section. */
    private final String FirstElementInBillingAddressLocator = "//ul[@id=\"address_invoice\"]/li[2]";

    /** XPath locator for the first product's price in the checkout table. */
    private final String Product_1_PriceCheckoutLocator = "//tr[@id=\"product-1\"]/td[3]/p";

    /** XPath locator for the second product's price in the checkout table. */
    private final String Product_2_PriceCheckoutLocator = "//tr[@id=\"product-2\"]/td[3]/p";

    /** XPath locator for the total order price. */
    private final String TotalPriceLocator = "//table[@class=\"table table-condensed\"]/tbody/tr[3]/td[4]/p";

    /**
     * Initializes the checkout page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public Checkout(Framework framework) {
        super(framework);
    }

    /*
     * Functionalities
     */

    /**
     * Checks whether the address details section heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckAddressDetailsVisible() {
        return framework.ElementIsVisible(By.xpath(AddressDetailLocator));
    }

    /**
     * Retrieves the first displayed detail from the delivery address section.
     *
     * @return the delivery address detail text
     */
    public String ReadFirstElementInDeliveryAddress() {
        return framework.GetTextFromElement(By.xpath(FirstElementInDeliveryAddressLocator));
    }

    /**
     * Retrieves the first displayed detail from the billing address section.
     *
     * @return the billing address detail text
     */
    public String ReadFirstElementInBillingAddress() {
        return framework.GetTextFromElement(By.xpath(FirstElementInBillingAddressLocator));
    }

    /**
     * Retrieves the price of the first product in the checkout table.
     *
     * @return the first product's displayed price
     */
    public String ReadProduct_1_PriceCheckout() {
        return framework.GetTextFromElement(By.xpath(Product_1_PriceCheckoutLocator));
    }

    /**
     * Retrieves the price of the second product in the checkout table.
     *
     * @return the second product's displayed price
     */
    public String ReadProduct_2_PriceCheckout() {
        return framework.GetTextFromElement(By.xpath(Product_2_PriceCheckoutLocator));
    }

    /**
     * Retrieves the total order price displayed at checkout.
     *
     * @return the total displayed price
     */
    public String ReadTotalPriceCheckout() {
        return framework.GetTextFromElement(By.xpath(TotalPriceLocator));
    }

    /**
     * Enters a message into the order comment text area.
     *
     * @param Message the message to enter
     */
    public void SendMessageTextBox(String Message) {
        framework.SendText(By.xpath(TextAreaBoxLocator), Message);
    }

    /**
     * Clicks the Place Order button and navigates to the payment page.
     *
     * @return a Payment page object
     */
    public Payment ClickOnPlaceOrderButton() {
        framework.ClickOnButton(By.xpath(PlaceOrderButtonLocator));
        return new Payment(super.framework);
    }

    /**
     * Scrolls the page until the Place Order button is in view.
     */
    public void MakeCheckOutScroll() {
        framework.ScrollToElement(By.xpath(PlaceOrderButtonLocator));
    }
}