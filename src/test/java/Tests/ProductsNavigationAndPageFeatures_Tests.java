package Tests;

import DataTypes.ValidLogoutUser;
import Pages.*;
import Utils.HelperClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Test suite for product navigation and page features.
 * Covers navigation to the Test Cases page, product details, product search,
 * newsletter subscriptions, and adding products to the shopping cart.
 */

@Listeners(MyListeners.CustomListener.class)

public class ProductsNavigationAndPageFeatures_Tests {


    // Application configuration parameters.
    private String targetUrl;
    private String browserType;


    /**
     * Reads the application URL and browser type from the TestNG configuration.
     *
     * @param targetUrl the base URL of the application under test
     * @param browserType the browser used for test execution
     */
    @Parameters({"TargetUrl", "BrowserType"})


    @BeforeClass
    public void readParams(String targetUrl, String browserType) {
        this.targetUrl = targetUrl;
        this.browserType = browserType;
    }






    ///======================================================================================================================///






    // TC07: Verify navigation to the Test Cases page.

    @Description("This Test To verify that the user can navigate to the 'Test Cases' page successfully from the main\n" +
            "header menu." +
            "information")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature("Verify Test Cases Page")
    @Story("verify that the user can navigate to the 'Test Cases' page")
    @Test

    public void TC07_VerifyTesTCasesPage() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the Test Cases page and verify its heading is visible.
        TestCases TC = base.ClickOnTestCases();
        Assert.assertTrue(TC.CheckTestCasesMessageVisible());

        // Close the browser after completing the test.
        TC.CloseDriver();
    }





    ///======================================================================================================================///





    // TC08: Verify the All Products page and product details.

    @Description("This Test To verify that all products are displayed on the 'All Products' page and that the product\n" +
            "detail page displays correct product attributes (Name. Category. price. Availability,\n" +
            "Condition, and Brand).")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature("Verify All Products and product detail page")
    @Story("verify that all products are displayed on the 'All Products' page")
    @Test

    public void TC08_VerifyAllProductsAndProductDetailPage() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the All Products page and verify that the products section is visible.
        Products P = base.ClickOnProducts();
        Assert.assertTrue(P.CheckAllProductsElementVisible());

        // Open a product's detail page and verify its key attributes.
        ProductDetails PD = P.ClickOnViewProduct();
        Assert.assertTrue(PD.CheckProductNameVisible());
        Assert.assertTrue(PD.CheckProductAvailabilityVisible());
        Assert.assertTrue(PD.CheckProductPriceVisible());
        Assert.assertTrue(PD.CheckProductCategoryVisible());
        Assert.assertTrue(PD.CheckProductConditionVisible());

        // Close the browser after completing the test.
        PD.CloseDriver();
    }





    ///======================================================================================================================///





    // TC09: Verify product search functionality.

    @Description("This Test To verify that the product search functionality returns relevant products based on the\n" +
            "search keyword.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature("Search Product")
    @Story("verify that the product search functionality returns relevant products")
    @Test

    public void TC09_SearchProduct() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the All Products page and verify that the products section is visible.
        Products P = base.ClickOnProducts();
        Assert.assertTrue(P.CheckAllProductsElementVisible());

        // Search for products and verify that the results section is displayed.
        ProductsSearch PS = P.PerformSearchProduct();
        Assert.assertTrue(PS.CheckSearchedProductsVisible());

        // Scroll to the results and verify that the first three products are visible.
        PS.MakeScroll();
        Assert.assertTrue(PS.CheckProduct_1_Visible());
        Assert.assertTrue(PS.CheckProduct_2_Visible());
        Assert.assertTrue(PS.CheckProduct_3_Visible());

        // Hover over the searched products and close the browser.
        PS.HoverOnSearchedProducts();
        PS.CloseDriver();
    }




    ///======================================================================================================================///





    // TC10: Verify newsletter subscription on the home page.

    @Description("This Test To verify that a user can successfully subscribe to the newsletter from the footer on the\n" +
            "Home page.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature("Verify Subscription In Home Page")
    @Story("As a user, I want to subscribe to the newsletter from the home page")
    @Test

    public void TC10_VerifySubscriptionInHomePage() {

        // Load subscription test data from the JSON file.
        ValidLogoutUser[] test = HelperClass.readJson
                ("src/main/java/TestData/ValidLogoutData.JSON", ValidLogoutUser[].class);

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Scroll to the footer and verify that the subscription section is visible.
        base.MakePageScrollToFooter();
        Assert.assertTrue(base.CheckSubscriptionElementVisible());

        // Submit the email address and verify the subscription confirmation.
        base.EnterSubscriptionEmail(test[0].getEmailAddress());
        base.ClickOnSubscriptionButton();
        Assert.assertTrue(base.CheckAccessMessageAlertVisible());

        // Close the browser after completing the test.
        base.CloseDriver();
    }




    ///======================================================================================================================///





    // TC11: Verify newsletter subscription on the Cart page.

    @Description("This Test To verify that a user can successfully subscribe to the newsletter from the footer on the\n" +
            "Cart page")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature(" Verify Subscription in Cart page")
    @Story("User successfully subscribes to the newsletter from the cart page")
    @Test

    public void TC11_VerifySubscriptionInCartPage() {

        // Load subscription test data from the JSON file.
        ValidLogoutUser[] test = HelperClass.readJson
                ("src/main/java/TestData/ValidLogoutData.JSON", ValidLogoutUser[].class);

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the Cart page and scroll to the footer.
        ViewCart VC = base.ClickOnCart();
        VC.MakePageScrollToFooter();

        // Verify the subscription section, submit the email, and check the confirmation.
        Assert.assertTrue(VC.CheckSubscriptionElementVisible());
        VC.EnterSubscriptionEmail(test[0].getEmailAddress());
        VC.ClickOnSubscriptionButton();
        Assert.assertTrue(VC.CheckAccessMessageAlertVisible());

        // Close the browser after completing the test.
        VC.CloseDriver();
    }




    ///======================================================================================================================///




    // TC12: Verify that multiple products can be added to the cart.

    @Description("This Test To Verify that the user can successfully add multiple products to the shopping cart from the\n" +
            "Products page, and ensure that product details (item presence, individual price, quantity, and\n" +
            "total price) are calculated and displayed correctly in the cart view.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Products Navigation & Page Features")
    @Feature("Add Products in Cart")
    @Story("User successfully adds multiple products to the shopping cart")
    @Test

    public void TC12_AddProductsInCart() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Navigate to the Products page and add the first product to the cart.
        Products P = base.ClickOnProducts();
        P.ClickOnAddToCartProduct_1();
        P.HoverOnFirstProduct();

        // Continue shopping and add the second product to the cart.
        P.ClickOnContinueShoppingButton();
        P.ClickOnAddToCartProduct_2();
        P.HoverOnSecondProduct();

        // Open the cart and hover over both products.
        ViewCart VC = P.ClickOnViewCartLink();
        VC.HoverOnProduct_1();
        VC.HoverOnProduct_2();

        // Define the expected details for the first product.
        String ExpectedPrice = "Rs. 500";
        String ExpectedQuantity = "1";
        String ExpectedTotalPrice = "Rs. 500";

        // Verify the first product's price, quantity, and total price.
        Assert.assertEquals(VC.ReadProduct_1_Price(), ExpectedPrice);
        Assert.assertEquals(VC.ReadProduct_1_Quantity(), ExpectedQuantity);
        Assert.assertEquals(VC.ReadProduct_1_TotalPrice(), ExpectedTotalPrice);

        // Close the browser after completing the test.
        VC.CloseDriver();
    }

}





///======================================================================================================================///



