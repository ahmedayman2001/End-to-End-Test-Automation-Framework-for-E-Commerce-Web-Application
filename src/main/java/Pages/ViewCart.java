package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

import javax.print.DocFlavor;

/**
 * Page Object Model class for the Shopping Cart page.
 * Provides methods to inspect cart contents and interact with cart elements.
 */
public class ViewCart extends BasePage {

    // Locators

    /** Locator for the message displayed when the cart is empty. */
    final String CartIsEmptyElementLocator = "//p[@class=\"text-center\"]/b";

    /** Locators for the first and second product images in the cart. */
    private final String ImageOfFirstProductLocator = "//img[@src=\"get_product_picture/1\"]";
    private final String ImageOfSecondProductLocator = "//img[@src=\"get_product_picture/2\"]";

    /** Locators for the prices of the first and second products. */
    private final String PriceOfProduct_1_Locator = "//tr[@id=\"product-1\"]/td[3]/p";
    private final String PriceOfProduct_2_Locator = "//tr[@id=\"product-2\"]/td[3]/p";

    /** Locators for the quantities of the first and second products. */
    private final String QuantityOfProduct_1_Locator = "//tr[@id=\"product-1\"]/td[4]/button";
    private final String QuantityOfProduct_2_Locator = "//tr[@id=\"product-2\"]//td[4]/button";

    /** Locator for the total price of the first product. */
    private final String TotalPriceOfProduct_1_Locator = "//tr[@id=\"product-1\"]/td[5]/p";

    /** Locator for the Proceed to Checkout button. */
    private final String ProceedToCheckOutButtonLocator = "//a[@class=\"btn btn-default check_out\"]";

    /** Locator for the Register/Login link displayed in the modal. */
    private final String RegisterLoginLinkLocator = "//div[@class=\"modal-body\"]//a";

    /** Locator for the Continue Shopping button in the modal footer. */
    private final String ContinueOnCartButtonLocator = "//div[@class=\"modal-footer\"]/button";

    /** Locators for removing the first and second products from the cart. */
    private final String DeleteButtonProduct_1Locator = "//a[@data-product-id=\"1\"]";
    private final String DeleteButtonProduct_2Locator = "//a[@data-product-id=\"2\"]";

    /** Locators for the prices of the selected jeans products. */
    private final String Jeans_1_PriceLocator = "//tr[@id=\"product-33\"]/td[5]/p";
    private final String Jeans_2_PriceLocator = "//tr[@id=\"product-35\"]/td[5]/p";
    private final String Jeans_3_PriceLocator = "//tr[@id=\"product-37\"]/td[5]/p";


    // Functionalities

    /**
     * Initializes the Shopping Cart page with the provided framework instance.
     *
     * @param framework the framework instance used to manage browser interactions
     */
    public ViewCart(Framework framework) {

        super(framework);

    }

    /**
     * Checks whether the empty-cart message is visible.
     *
     * @return true if the empty-cart message is visible; otherwise, false
     */
    public boolean CheckCartISEmptyVisible() {

        return framework.ElementIsVisible(By.xpath(CartIsEmptyElementLocator));
    }

    /**
     * Moves the mouse pointer over the first product image.
     */
    public void HoverOnProduct_1() {

        framework.HoverOnElement(By.xpath(ImageOfFirstProductLocator));
    }

    /**
     * Moves the mouse pointer over the second product image.
     */
    public void HoverOnProduct_2() {

        framework.HoverOnElement(By.xpath(ImageOfSecondProductLocator));
    }

    /**
     * Retrieves the price of the first product in the cart.
     *
     * @return the displayed price of the first product
     */
    public String ReadProduct_1_Price() {

        return framework.GetTextFromElement(By.xpath(PriceOfProduct_1_Locator));
    }

    /**
     * Retrieves the quantity of the first product in the cart.
     *
     * @return the displayed quantity of the first product
     */
    public String ReadProduct_1_Quantity() {

        return framework.GetTextFromElement(By.xpath(QuantityOfProduct_1_Locator));
    }

    /**
     * Retrieves the total price of the first product in the cart.
     *
     * @return the displayed total price of the first product
     */
    public String ReadProduct_1_TotalPrice() {

        return framework.GetTextFromElement(By.xpath(TotalPriceOfProduct_1_Locator));
    }

    /**
     * Retrieves the quantity of the second product in the cart.
     *
     * @return the displayed quantity of the second product
     */
    public String ReadProduct_2_Quantity() {

        return framework.GetTextFromElement(By.xpath(QuantityOfProduct_2_Locator));
    }

    /**
     * Clicks the Proceed to Checkout button.
     */
    public void ClickOnProceedToCheckoutButton_1() {

        framework.ClickOnButton(By.xpath(ProceedToCheckOutButtonLocator));
    }

    /**
     * Clicks the Register/Login link in the modal.
     *
     * @return a LoginPage instance
     */
    public LoginPage ClickOnRegisterLoginLink() {

        framework.ClickOnElement(By.xpath(RegisterLoginLinkLocator));
        return new LoginPage(super.framework);
    }

    /**
     * Clicks the Proceed to Checkout button and navigates to the checkout page.
     *
     * @return a Checkout page instance
     */
    public Checkout ClickOnProceedToCheckoutButton_2() {

        framework.ClickOnButton(By.xpath(ProceedToCheckOutButtonLocator));
        return new Checkout(super.framework);
    }

    /**
     * Removes the first product from the cart.
     */
    public void ClickOnDeleteButtonProduct_1() {

        framework.ClickOnButton(By.xpath(DeleteButtonProduct_1Locator));
    }

    /**
     * Removes the second product from the cart.
     */
    public void ClickOnDeleteButtonProduct_2() {

        framework.ClickOnButton(By.xpath(DeleteButtonProduct_2Locator));
    }

    /**
     * Checks whether the empty-cart message is visible.
     *
     * @return true if the empty-cart message is visible; otherwise, false
     */
    public boolean CheckCartIsEmptyVisible() {

        return framework.ElementIsVisible(By.xpath(CartIsEmptyElementLocator));
    }

    /**
     * Retrieves the price of the first selected jeans product.
     *
     * @return the displayed price of the first jeans product
     */
    public String ReadJeans_1_Price() {

        return framework.GetTextFromElement(By.xpath(Jeans_1_PriceLocator));
    }

    /**
     * Retrieves the price of the second selected jeans product.
     *
     * @return the displayed price of the second jeans product
     */
    public String ReadJeans_2_Price() {

        return framework.GetTextFromElement(By.xpath(Jeans_2_PriceLocator));
    }

    /**
     * Retrieves the price of the third selected jeans product.
     *
     * @return the displayed price of the third jeans product
     */
    public String ReadJeans_3_Price() {

        return framework.GetTextFromElement(By.xpath(Jeans_3_PriceLocator));
    }

}