package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the products page.
 * Provides methods to verify product listings, search for products,
 * interact with product cards, and navigate to the cart.
 */
public class Products extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the All Products page heading. */
    private final String AllProductsElementLocator = "//h2[@class=\"title text-center\"]";

    /** XPath locator for the product search input field. */
    private final String InputSearchElementLocator = "//input[@name=\"search\"]";

    /** XPath locator for the product search button. */
    private final String ProductSearchButtonLocator = "//button[@id=\"submit_search\"]";

    /** XPath locator for the View Product link of the first product. */
    private final String ViewFirstProductLinkLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][1]//li/a";

    /** XPath locator for the View Product link of the second product. */
    private final String ViewSecondProductLinkLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][2]//li/a";

    /** XPath locator for the Add to Cart button of the first product. */
    private final String AddToCartButtonOfFirstProductLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][1]//a";

    /** XPath locator for the Add to Cart button of the second product. */
    private final String AddToCartButtonOfSecondProductLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][2]//a";

    /** XPath locator for the first product image. */
    private final String FirstProductImageLocator = "//img[@src=\"/get_product_picture/1\"]";

    /** XPath locator for the second product image. */
    private final String SecondProductImageLocator = "//img[@src=\"/get_product_picture/2\"]";

    /** XPath locator for the Continue Shopping button in the confirmation modal. */
    private final String ContinueShoppingButtonLocator = "//div[@class=\"modal-footer\"]/button";

    /** XPath locator for the View Cart link in the confirmation modal. */
    private final String ViewCartLinkLocator = "//div[@class=\"modal-body\"]//a";

    /*
     * Functionalities
     */

    /**
     * Initializes the products page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public Products(Framework framework) {
        super(framework);
    }

    /**
     * Checks whether the All Products page heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckAllProductsElementVisible() {
        return framework.ElementIsVisible(By.xpath(AllProductsElementLocator));
    }

    /**
     * Clicks the View Product link for the first product.
     *
     * @return a ProductDetails page object for the selected product
     */
    public ProductDetails ClickOnViewProduct() {
        framework.ClickOnElement(By.xpath(ViewFirstProductLinkLocator));
        return new ProductDetails(super.framework);
    }

    /**
     * Enters a product name into the search field.
     *
     * @param Product the product name to search for
     */
    public void EnterValidProduct(String Product) {
        framework.SendText(By.xpath(InputSearchElementLocator), Product);
    }

    /**
     * Clicks the product search button to submit the search query.
     */
    public void ClickOnProductSearchButton() {
        framework.ClickOnButton(By.xpath(ProductSearchButtonLocator));
    }

    /**
     * Searches for the predefined product "jeans".
     *
     * @return a ProductsSearch page object containing the search results
     */
    public ProductsSearch PerformSearchProduct() {
        EnterValidProduct("jeans");
        ClickOnProductSearchButton();
        return new ProductsSearch(super.framework);
    }

    /**
     * Moves the mouse pointer over the first product image.
     */
    public void HoverOnFirstProduct() {
        framework.HoverOnElement(By.xpath(FirstProductImageLocator));
    }

    /**
     * Clicks the Add to Cart button for the first product.
     */
    public void ClickOnAddToCartProduct_1() {
        framework.ClickOnButton(By.xpath(AddToCartButtonOfFirstProductLocator));
    }

    /**
     * Clicks the Continue Shopping button in the confirmation modal.
     */
    public void ClickOnContinueShoppingButton() {
        framework.ClickOnButton(By.xpath(ContinueShoppingButtonLocator));
    }

    /**
     * Moves the mouse pointer over the second product image.
     */
    public void HoverOnSecondProduct() {
        framework.HoverOnElement(By.xpath(SecondProductImageLocator));
    }

    /**
     * Clicks the Add to Cart button for the second product.
     */
    public void ClickOnAddToCartProduct_2() {
        framework.ClickOnButton(By.xpath(AddToCartButtonOfSecondProductLocator));
    }

    /**
     * Clicks the View Cart link in the confirmation modal.
     *
     * @return a ViewCart page object for interacting with the cart
     */
    public ViewCart ClickOnViewCartLink() {
        framework.ClickOnElement(By.xpath(ViewCartLinkLocator));
        return new ViewCart(super.framework);
    }
}