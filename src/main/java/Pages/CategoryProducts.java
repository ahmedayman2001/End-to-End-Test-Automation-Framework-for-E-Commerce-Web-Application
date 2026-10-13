package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page object for the category products page.
 * Provides methods to verify page navigation and element visibility.
 */
public class CategoryProducts extends BasePage {

    /*
     * Locators
     */

    /** XPath locator for the category products page heading. */
    private final String WomenDressProductsElement = "//h2[@class=\"title text-center\"]";

    /**
     * Initializes the category products page using the shared framework.
     *
     * @param framework the framework instance providing browser interaction utilities
     */
    public CategoryProducts(Framework framework) {
        super(framework);
    }

    /*
     * Functionalities
     */

    /**
     * Waits until the browser reaches the specified category page URL.
     *
     * @param URL the expected category page URL
     */
    public void WaitURLEqualCategoryPage(String URL) {
        framework.WaitTillReachURL(URL);
    }

    /**
     * Retrieves the current browser URL.
     *
     * @return the current page URL
     */
    public String GetCategoryPageURL() {
        return framework.GetCurrentURL();
    }

    /**
     * Checks whether the category products page heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckWomenDressProductsElementVisible() {
        return framework.ElementIsVisible(By.xpath(WomenDressProductsElement));
    }
}