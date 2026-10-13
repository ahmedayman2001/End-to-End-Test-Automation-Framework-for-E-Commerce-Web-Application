package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Represents the Brand Products page and provides methods
 * to verify page navigation and interact with products
 * belonging to the Polo and H&M brands.
 */
public class BrandProducts extends BasePage {

    /*
     * Locators
     */

    private final String Product_1_PoloImageLocator = "//img[@src=\"/get_product_picture/1\"]";
    private final String Product_2_PoloImageLocator = "//img[@src=\"/get_product_picture/8\"]";
    private final String Product_3_PoloImageLocator = "//img[@src=\"/get_product_picture/29\"]";

    private final String Product_1_HM_ImageLocator = "//img[@src=\"/get_product_picture/2\"]";
    private final String Product_2_HM_ImageLocator = "//img[@src=\"/get_product_picture/6\"]";
    private final String Product_3_HM_ImageLocator = "//img[@src=\"/get_product_picture/28\"]";

    // Brand products pages:
    // https://www.automationexercise.com/brand_products/Polo
    // https://www.automationexercise.com/brand_products/H&M

    /**
     * Initializes the Brand Products page with the specified framework.
     *
     * @param framework the framework instance used for browser interactions
     */
    public BrandProducts(Framework framework) {
        super(framework);
    }

    /*
     * Functionalities
     */

    /**
     * Waits until the browser reaches the specified brand products URL.
     *
     * @param URL the expected brand products URL
     */
    public void WaitTillLinkEqualBrandProducts(String URL) {
        framework.WaitTillReachURL(URL);
    }

    /**
     * Retrieves the current browser URL.
     *
     * @return the current page URL
     */
    public String GetBrandProductsURL() {
        return framework.GetCurrentURL();
    }

    /**
     * Hovers over the first Polo product image.
     */
    public void HoverOnProduct_1_Polo() {
        framework.HoverOnElement(By.xpath(Product_1_PoloImageLocator));
    }

    /**
     * Hovers over the second Polo product image.
     */
    public void HoverOnProduct_2_Polo() {
        framework.HoverOnElement(By.xpath(Product_2_PoloImageLocator));
    }

    /**
     * Hovers over the third Polo product image.
     */
    public void HoverOnProduct_3_Polo() {
        framework.HoverOnElement(By.xpath(Product_3_PoloImageLocator));
    }

    /**
     * Hovers over the first H&M product image.
     */
    public void HoverOnProduct_1_HM() {
        framework.HoverOnElement(By.xpath(Product_1_HM_ImageLocator));
    }

    /**
     * Hovers over the second H&M product image.
     */
    public void HoverOnProduct_2_HM() {
        framework.HoverOnElement(By.xpath(Product_2_HM_ImageLocator));
    }

    /**
     * Hovers over the third H&M product image.
     */
    public void HoverOnProduct_3_HM() {
        framework.HoverOnElement(By.xpath(Product_3_HM_ImageLocator));
    }
}