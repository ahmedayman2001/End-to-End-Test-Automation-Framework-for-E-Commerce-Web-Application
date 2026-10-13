package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the product search results page.
 * Provides methods to verify search results, scroll to page elements,
 * hover over products, and add products to the cart.
 */
public class ProductsSearch extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the Searched Products section heading. */
    private final String SearchedProductsElement = "//h2[@class=\"title text-center\"]";

    /** XPath locator for the first product image in the search results. */
    private final String Product_1_Locator = "//img[@src=\"/get_product_picture/33\"]";

    /** XPath locator for the second product image in the search results. */
    private final String Product_2_Locator = "//img[@src=\"/get_product_picture/35\"]";

    /** XPath locator for the third product image in the search results. */
    private final String Product_3_Locator = "//img[@src=\"/get_product_picture/37\"]";

    /** XPath locator for the Subscription section heading. */
    private final String SubscriptionElementLocator = "//div[@class=\"single-widget\"]/h2";

    /** XPath locator for the Add to Cart button of the first search result. */
    private final String AddToCartProduct_1_ButtonLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][1]/div/div[1]/div[1]/a";

    /** XPath locator for the Add to Cart button of the second search result. */
    private final String AddToCartProduct_2_ButtonLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][2]/div/div[1]/div[1]/a";

    /** XPath locator for the Add to Cart button of the third search result. */
    private final String AddToCartProduct_3_ButtonLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][3]/div/div[1]/div[1]/a";

    /** XPath locator for the View Cart link in the confirmation modal. */
    private final String ViewCartLinkLocator = "//div[@class=\"modal-body\"]//a";

    /** XPath locator for the Continue Shopping button in the confirmation modal. */
    private final String ContinueShoppingButtonLocator = "//div[@class=\"modal-footer\"]/button";

    /*
     * Functionalities
     */

    /**
     * Initializes the product search results page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public ProductsSearch(Framework framework) {
        super(framework);
    }

    /**
     * Checks whether the Searched Products section heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckSearchedProductsVisible() {
        return framework.ElementIsVisible(By.xpath(SearchedProductsElement));
    }

    /**
     * Checks whether the first product in the search results is visible.
     *
     * @return true if the first product is visible; otherwise, false
     */
    public boolean CheckProduct_1_Visible() {
        return framework.ElementIsVisible(By.xpath(Product_1_Locator));
    }

    /**
     * Checks whether the second product in the search results is visible.
     *
     * @return true if the second product is visible; otherwise, false
     */
    public boolean CheckProduct_2_Visible() {
        return framework.ElementIsVisible(By.xpath(Product_2_Locator));
    }

    /**
     * Checks whether the third product in the search results is visible.
     *
     * @return true if the third product is visible; otherwise, false
     */
    public boolean CheckProduct_3_Visible() {
        return framework.ElementIsVisible(By.xpath(Product_3_Locator));
    }

    /**
     * Scrolls the page until the Subscription section is reached.
     */
    public void MakeScroll() {
        framework.ScrollToElement(By.xpath(SubscriptionElementLocator));
    }

    /**
     * Moves the mouse pointer over each of the first three search result images.
     */
    public void HoverOnSearchedProducts() {
        framework.HoverOnElement(By.xpath(Product_1_Locator));
        framework.HoverOnElement(By.xpath(Product_2_Locator));
        framework.HoverOnElement(By.xpath(Product_3_Locator));
    }

    /**
     * Clicks the Add to Cart button for the first search result.
     */
    public void ClickOnAddToCartP_1() {
        framework.ClickOnButton(By.xpath(AddToCartProduct_1_ButtonLocator));
    }

    /**
     * Clicks the Add to Cart button for the second search result.
     */
    public void ClickOnAddToCartP_2() {
        framework.ClickOnButton(By.xpath(AddToCartProduct_2_ButtonLocator));
    }

    /**
     * Clicks the Add to Cart button for the third search result.
     */
    public void ClickOnAddToCartP_3() {
        framework.ClickOnButton(By.xpath(AddToCartProduct_3_ButtonLocator));
    }

    /**
     * Clicks the Continue Shopping button in the confirmation modal.
     */
    public void ClickOnContinueShopping() {
        framework.ClickOnButton(By.xpath(ContinueShoppingButtonLocator));
    }
}