package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the product details page.
 * Provides methods to verify product information, update product quantity,
 * add products to the cart, and navigate to the cart page.
 */
public class ProductDetails extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the product name. */
    private final String ProductNameLocator = "//div[@class=\"product-information\"]//h2";

    /** XPath locator for the product category information. */
    private final String ProductCategoryLocator = "//div[@class=\"product-information\"]/p[1]";

    /** XPath locator for the product price. */
    private final String ProductPriceLocator = "//div[@class=\"product-information\"]/span/span";

    /** XPath locator for the product availability label. */
    private final String ProductAvailabilityLocator = "//div[@class=\"product-information\"]/p[2]/b";

    /** XPath locator for the product condition label. */
    private final String ProductConditionLocator = "//div[@class=\"product-information\"]/p[3]/b";

    /** XPath locator for the product brand label. */
    private final String ProductBrandLocator = "//div[@class=\"product-information\"]/p[4]/b";

    /** XPath locator for the product quantity input field. */
    private final String ProductQuantityLocator = "//div[@class=\"product-information\"]/span/input[@id=\"quantity\"]";

    /** XPath locator for the Add to Cart button. */
    private final String AddToCartButtonLocator = "//div[@class=\"product-information\"]//button";

    /** XPath locator for the View Cart link in the confirmation modal. */
    private final String ViewCartLinkLocator = "//div[@class=\"modal-body\"]//a";

    /*
     * Functionalities
     */

    /**
     * Initializes the product details page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public ProductDetails(Framework framework) {
        super(framework);
    }

    /**
     * Checks whether the product name is visible.
     *
     * @return true if the product name is visible; otherwise, false
     */
    public boolean CheckProductNameVisible() {
        return framework.ElementIsVisible(By.xpath(ProductNameLocator));
    }

    /**
     * Checks whether the product category information is visible.
     *
     * @return true if the product category is visible; otherwise, false
     */
    public boolean CheckProductCategoryVisible() {
        return framework.ElementIsVisible(By.xpath(ProductCategoryLocator));
    }

    /**
     * Checks whether the product price is visible.
     *
     * @return true if the product price is visible; otherwise, false
     */
    public boolean CheckProductPriceVisible() {
        return framework.ElementIsVisible(By.xpath(ProductPriceLocator));
    }

    /**
     * Checks whether the product availability information is visible.
     *
     * @return true if the availability information is visible; otherwise, false
     */
    public boolean CheckProductAvailabilityVisible() {
        return framework.ElementIsVisible(By.xpath(ProductAvailabilityLocator));
    }

    /**
     * Checks whether the product condition information is visible.
     *
     * @return true if the condition information is visible; otherwise, false
     */
    public boolean CheckProductConditionVisible() {
        return framework.ElementIsVisible(By.xpath(ProductConditionLocator));
    }

    /**
     * Checks whether the product brand information is visible.
     *
     * @return true if the brand information is visible; otherwise, false
     */
    public boolean CheckProductBrandVisible() {
        return framework.ElementIsVisible(By.xpath(ProductBrandLocator));
    }

    /**
     * Sets the desired quantity for the product.
     *
     * @param quantityNum the quantity to enter
     */
    public void IncreaseProductQuantity(String quantityNum) {
        framework.SendText(By.xpath(ProductQuantityLocator), quantityNum);
    }

    /**
     * Clicks the Add to Cart button for the current product.
     */
    public void ClickOnAddToCartButton() {
        framework.ClickOnButton(By.xpath(AddToCartButtonLocator));
    }

    /**
     * Clicks the View Cart link in the confirmation modal.
     *
     * @return a ViewCart page object for interacting with the cart page
     */
    public ViewCart ClickOnViewCartLink() {
        framework.ClickOnElement(By.xpath(ViewCartLinkLocator));
        return new ViewCart(super.framework);
    }
}