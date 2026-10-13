package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Page Object Model class for the Test Cases page.
 * Provides locators and methods to interact with and validate the page.
 */
public class TestCases extends BasePage {

    // Locators

    /** XPath locator for the Test Cases page heading. */
    private final String TestCasesMessageLocator = "//h2[@class=\"title text-center\"]";


    // Functionalities

    /**
     * Initializes the Test Cases page using the provided framework instance.
     *
     * @param framework the framework instance used to manage browser interactions
     */
    public TestCases(Framework framework) {

        super(framework);

    }

    /**
     * Checks whether the Test Cases page heading is visible.
     *
     * @return true if the heading is visible; otherwise, false
     */
    public boolean CheckTestCasesMessageVisible() {

        return framework.ElementIsVisible(By.xpath(TestCasesMessageLocator));

    }

}