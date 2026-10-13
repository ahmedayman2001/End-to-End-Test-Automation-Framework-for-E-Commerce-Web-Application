package Tests;

import DataTypes.InvalidLoginCredentials;
import DataTypes.SignupCredentials;
import DataTypes.ValidPayment;
import Pages.*;
import TestData.TestDataGenerator;
import Utils.HelperClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

          ////================== Cart and Product Placement Tests: TC13–TC20================================///

@Listeners(MyListeners.CustomListener.class)

public class CartAndProductPlacement_Tests {

    // Stores the credentials of the user created for the current test.
    SignupCredentials createdUser;
    private String targetUrl;
    private String browserType;


    // Reads browser and application configuration from the TestNG XML file.
    @Parameters({"TargetUrl", "BrowserType"})

    @BeforeClass
    public void readParams(String targetUrl, String browserType) {
        this.targetUrl = targetUrl;
        this.browserType = browserType;
    }





    ///======================================================================================================================///






    // TC13: Verify that the selected product quantity is reflected correctly in the cart.
    @Description("This Test To verify that increasing the product quantity on the product detail page reflects accuratdy\n" +
            "with the exact quantity in the shopping cart.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("CartAndProductPlacement_Tests")
    @Feature("Verify Product quantity in Cart")
    @Story("As a user, I want to increase the product quantity and verify it in the cart")

    @Test
    public void TC13_VerifyProductQuantityInCart() {

        // Initialize the browser and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Open the product details page and set the requested quantity.
        ProductDetails PD = base.ClickOnViewProduct_2Link();
        PD.IncreaseProductQuantity("4");

        // Add the product to the cart and open the cart page.
        PD.ClickOnAddToCartButton();
        ViewCart VC = PD.ClickOnViewCartLink();

        // Verify that the cart displays the expected product quantity.
        VC.HoverOnProduct_2();
        String ExpectedQuantity = "4";
        Assert.assertEquals(VC.ReadProduct_2_Quantity(), ExpectedQuantity);

        // Close the browser after completing the test.
        VC.CloseDriver();
    }

    // Prepares a unique user account for tests that require registration during checkout.
    @BeforeMethod(onlyForGroups = "AccountNeed")
    public void CreateTestAccount() {

        // Load the signup test data and generate a unique email address.
        SignupCredentials[] test = HelperClass.readJson
                ("src/main/java/TestData/SignupCredentialsData.JSON", SignupCredentials[].class);

        test[0].setEmailAddress(TestDataGenerator.generateUniqueEmail());

        // Store the generated credentials for use in the test.
        createdUser = test[0];
    }

    // Supplies payment data from the JSON test data file.
    @DataProvider(name = "ValidPayment")
    public ValidPayment[] DataDrivenValidPayment() {

        ValidPayment[] Test = HelperClass.readJson
                ("src/main/java/TestData/ValidPaymentData.JSON", ValidPayment[].class);
        return Test;
    }





    ///======================================================================================================================///





    // TC14: Verify that a guest user can register during checkout and place an order.
    @Description("This Test To verify that an unauthenticated user can add products to cart, register a new account\n" +
            "during the checkout now, complete the payment process, and successfully place")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("CartAndProductPlacement_Tests")
    @Feature("Place Order Register While Checkout")
    @Story("As an unauthenticated user, I want to register during checkout and successfully place an order")
    @Test(dataProvider = "ValidPayment", groups = "AccountNeed")

    public void TC14_PlaceOrderRegisterWhileCheckout(ValidPayment test) {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Add two products to the cart and proceed to checkout as a guest.
        base.ClickOnAddToCartProduct_1_Home();
        base.HoverOnProduct_1_Home();
        base.ClickOnContinueShoppingButton_Home();
        base.ClickOnAddToCartProduct_2_Home();
        base.HoverOnProduct_2_Home();

        ViewCart VC = base.ClickOnViewCartLink_Home();
        VC.ClickOnProceedToCheckoutButton_1();

        // Register a new account from the checkout flow.
        LoginPage lg = VC.ClickOnRegisterLoginLink();
        SignUPPage SG = lg.PerformSignUP(createdUser);
        AccountCreated AC = SG.PerformCreateAccount(createdUser);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Continue to the home page and verify that the user is logged in.
        BasePage B = AC.ClickOnContinueButton();
        Assert.assertTrue(B.CheckLoggedInVisible());

        // Return to the cart and proceed to checkout.
        ViewCart v_cart = B.ClickOnCart();
        Checkout CK = v_cart.ClickOnProceedToCheckoutButton_2();

        // Verify that the delivery and billing address details are displayed and match.
        Assert.assertTrue(CK.CheckAddressDetailsVisible());
        String c1 = CK.ReadFirstElementInDeliveryAddress();
        String c2 = CK.ReadFirstElementInBillingAddress();
        Assert.assertEquals(c1, c2);

        // Verify the individual product prices and the total order amount.
        CK.MakeCheckOutScroll();
        String Product1ExpectedPrice = "Rs. 500";
        String Product2ExpectedPrice = "Rs. 400";
        String TotalPriceExpected = "Rs. 900";
        String Product1ActualPrice = CK.ReadProduct_1_PriceCheckout();
        String Product2ActualPrice = CK.ReadProduct_2_PriceCheckout();
        String ActualTotalPrice = CK.ReadTotalPriceCheckout();

        Assert.assertEquals(Product1ActualPrice, Product1ExpectedPrice);
        Assert.assertEquals(Product2ActualPrice, Product2ExpectedPrice);
        Assert.assertEquals(ActualTotalPrice, TotalPriceExpected);

        // Add an order comment and complete the payment process.
        CK.SendMessageTextBox("Please deliver the order carefully.");
        Payment PY = CK.ClickOnPlaceOrderButton();
        PaymentDone PD = PY.PerformPayment(test);
        Assert.assertTrue(PD.CheckSuccessPaymentMessageVisible());

        // Delete the account and close the browser after verifying the confirmation.
        AccountDeleted AD = PD.ClickOnDeleteAccount();
        Assert.assertTrue(AD.CheckDeletedMessageVisible());
        AD.ClickOnContinueButton();
        AD.CloseDriver();
    }




    ///======================================================================================================================///




    // TC15: Verify that a registered user can place an order after registering before checkout.
    @Description("This Test To verify that a registered user can add products to the cart, proceed to checkout, complete the payment process, and successfully place an order.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("CartAndProductPlacement_Tests")
    @Feature("TC15_PlaceOrderRegisterBeforeCheckout")
    @Story("As a registered user, I want to place an order successfully")
    @Test(dataProvider = "ValidPayment", groups = "AccountNeed")

    public void TC15_PlaceOrderRegisterBeforeCheckout(ValidPayment test) {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Register a new account before adding products to the cart.
        LoginPage lg = base.ClickOnSignUPLoginLink();
        SignUPPage sg = lg.PerformSignUP(createdUser);
        AccountCreated AC = sg.PerformCreateAccount(createdUser);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Continue to the home page and verify the logged-in state.
        BasePage BS = AC.ClickOnContinueButton();
        Assert.assertTrue(BS.CheckLoggedInVisible());

        // Add two products to the cart and open the cart page.
        BS.ClickOnAddToCartProduct_1_Home();
        BS.HoverOnProduct_1_Home();
        BS.ClickOnContinueShoppingButton_Home();
        BS.ClickOnAddToCartProduct_2_Home();
        BS.HoverOnProduct_2_Home();

        ViewCart VC = BS.ClickOnViewCartLink_Home();
        Checkout CK = VC.ClickOnProceedToCheckoutButton_2();

        // Verify the address details and confirm that delivery and billing addresses match.
        Assert.assertTrue(CK.CheckAddressDetailsVisible());
        String c1 = CK.ReadFirstElementInDeliveryAddress();
        String c2 = CK.ReadFirstElementInBillingAddress();
        Assert.assertEquals(c1, c2);

        // Verify the prices of both products and the total order amount.
        CK.MakeCheckOutScroll();
        String Product1ExpectedPrice = "Rs. 500";
        String Product2ExpectedPrice = "Rs. 400";
        String TotalPriceExpected = "Rs. 900";
        String Product1ActualPrice = CK.ReadProduct_1_PriceCheckout();
        String Product2ActualPrice = CK.ReadProduct_2_PriceCheckout();
        String ActualTotalPrice = CK.ReadTotalPriceCheckout();

        Assert.assertEquals(Product1ActualPrice, Product1ExpectedPrice);
        Assert.assertEquals(Product2ActualPrice, Product2ExpectedPrice);
        Assert.assertEquals(ActualTotalPrice, TotalPriceExpected);

        // Submit an order comment and complete the payment.
        CK.SendMessageTextBox("Please deliver the order carefully.");
        Payment PY = CK.ClickOnPlaceOrderButton();
        PaymentDone PD = PY.PerformPayment(test);
        Assert.assertTrue(PD.CheckSuccessPaymentMessageVisible());

        // Delete the account and close the browser.
        AccountDeleted AD = PD.ClickOnDeleteAccount();
        Assert.assertTrue(AD.CheckDeletedMessageVisible());
        BasePage b_s = AD.ClickOnContinueButton();
        b_s.CloseDriver();
    }







    ///======================================================================================================================///






    // Creates a registered account, then logs out so it can be used for login-based tests.
    @BeforeMethod(onlyForGroups = "neededAccount")
    public void CreateTestAccountBeforeLogin() {

        // Load signup data and generate a unique email address for the account.
        SignupCredentials[] test = HelperClass.readJson
                ("src/main/java/TestData/SignupCredentialsData.JSON", SignupCredentials[].class);

        test[0].setEmailAddress(TestDataGenerator.generateUniqueEmail());

        // Store the credentials for subsequent login steps.
        createdUser = test[0];

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Register the account and verify each major registration step.
        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckNewUserSignUPElementVisible());
        SignUPPage Sign = login.PerformSignUP(createdUser);
        Assert.assertTrue(Sign.CheckAccountInfoElementVisible());

        AccountCreated AC = Sign.PerformCreateAccount(createdUser);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Confirm the logged-in state, then log out and close the browser.
        BasePage BP = AC.ClickOnContinueButton();
        Assert.assertTrue(BP.CheckLoggedInVisible());
        BP.ClickOnLogout();
        BP.CloseDriver();
    }

    // TC16: Verify that a user can log in before checkout and successfully place an order.
    @Description("This Test To verify that a registered user can log in before checkout, add products to the cart, complete the checkout process, and successfully place an order.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Cart And Product PlacementTests")
    @Feature("PlaceOrderLoginBeforeCheckout")
    @Story("As a registered user, I want to log in before checkout and successfully place an order")
    @Test(dataProvider = "ValidPayment", groups = "neededAccount")

    public void TC16_PlaceOrderLoginBeforeCheckout(ValidPayment test) {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Log in using the credentials created by the setup method.
        LoginPage lg = base.ClickOnSignUPLoginLink();
        BasePage BS = lg.PerformLogin(createdUser);
        Assert.assertTrue(BS.CheckLoggedInVisible());

        // Add two products to the cart and proceed to checkout.
        BS.ClickOnAddToCartProduct_1_Home();
        BS.HoverOnProduct_1_Home();
        BS.ClickOnContinueShoppingButton_Home();
        BS.ClickOnAddToCartProduct_2_Home();
        BS.HoverOnProduct_2_Home();

        ViewCart VC = BS.ClickOnViewCartLink_Home();
        Checkout CK = VC.ClickOnProceedToCheckoutButton_2();

        // Verify that the address details are visible and that the addresses match.
        Assert.assertTrue(CK.CheckAddressDetailsVisible());
        String c1 = CK.ReadFirstElementInDeliveryAddress();
        String c2 = CK.ReadFirstElementInBillingAddress();
        Assert.assertEquals(c1, c2);

        // Validate both product prices and the total order amount.
        CK.MakeCheckOutScroll();
        String Product1ExpectedPrice = "Rs. 500";
        String Product2ExpectedPrice = "Rs. 400";
        String TotalPriceExpected = "Rs. 900";
        String Product1ActualPrice = CK.ReadProduct_1_PriceCheckout();
        String Product2ActualPrice = CK.ReadProduct_2_PriceCheckout();
        String ActualTotalPrice = CK.ReadTotalPriceCheckout();

        Assert.assertEquals(Product1ActualPrice, Product1ExpectedPrice);
        Assert.assertEquals(Product2ActualPrice, Product2ExpectedPrice);
        Assert.assertEquals(ActualTotalPrice, TotalPriceExpected);

        // Submit the order comment and complete payment.
        CK.SendMessageTextBox("Please deliver the order carefully.");
        Payment PY = CK.ClickOnPlaceOrderButton();
        PaymentDone PD = PY.PerformPayment(test);
        Assert.assertTrue(PD.CheckSuccessPaymentMessageVisible());

        // Delete the account and close the browser after confirming deletion.
        AccountDeleted AD = PD.ClickOnDeleteAccount();
        Assert.assertTrue(AD.CheckDeletedMessageVisible());
        BasePage b_s = AD.ClickOnContinueButton();
        b_s.CloseDriver();
    }






    ///======================================================================================================================///






    // TC17: Verify that products can be removed from the shopping cart.
    @Description("This Test To verify that a user can successfully remove a product from the shopping cart.")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Cart And Product PlacementTests")
    @Feature("RemoveProductsFromCart")
    @Story("As a user, I want to remove a product from the cart successfully")
    @Test

    public void TC17_RemoveProductsFromCart() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Add two products to the cart.
        base.ClickOnAddToCartProduct_1_Home();
        base.HoverOnProduct_1_Home();
        base.ClickOnContinueShoppingButton_Home();
        base.ClickOnAddToCartProduct_2_Home();
        base.HoverOnProduct_2_Home();

        // Open the cart and remove both products.
        ViewCart VC = base.ClickOnViewCartLink_Home();
        VC.ClickOnDeleteButtonProduct_1();
        VC.ClickOnDeleteButtonProduct_2();

        // Verify that the cart displays its empty state.
        Assert.assertTrue(VC.CheckCartISEmptyVisible());

        // Close the browser after completing the test.
        VC.CloseDriver();
    }





    ///======================================================================================================================///






    // TC18: Verify that products can be viewed by category.
    @Description("Verify that the user can view products by selecting a product category")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Cart And Product PlacementTests")
    @Feature("ViewCategoryProducts")
    @Story("View Products by Category")
    @Test

    public void TC18_ViewCategoryProducts() {

        // Open the application and verify that the home page and category section are visible.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());
        Assert.assertTrue(base.CheckCategoryElementVisible());

        // Select the Women's category and open the Dress subcategory.
        base.ClickOnWomenLink();
        CategoryProducts CP = base.ClickOnDressLink();

        // Verify the category page URL and the visibility of women's dress products.
        CP.WaitURLEqualCategoryPage("https://www.automationexercise.com/category_products/1");
        String ExpectedURL = "https://www.automationexercise.com/category_products/1";
        String ActualURL = CP.GetCategoryPageURL();
        Assert.assertEquals(ActualURL, ExpectedURL);
        Assert.assertTrue(CP.CheckWomenDressProductsElementVisible());

        // Select the Men's category and its T-shirts subcategory.
        CP.ClickOnMenLink();
        CP.ClickOnTShirtsLink();

        // Close the browser after completing the test.
        Assert.assertEquals(ActualURL, ExpectedURL);
        CP.CloseDriver();
    }






    ///======================================================================================================================///




    // TC19: Verify that products can be viewed by brand.
    @Description("This Test To Verify that the user can view products by brand and add a product to the cart")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Cart And Product PlacementTests")
    @Feature("ViewAndCartBrandProducts")
    @Story("View Brand Products and Add Product to Cart")
    @Test
    public void TC19_ViewAndCartBrandProducts() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Open the products page and verify that the brands section is visible.
        Products P = base.ClickOnProducts();
        Assert.assertTrue(P.CheckBradsElementVisible());

        // Open the Polo brand page and verify its URL.
        BrandProducts BP = P.ClickOnPoloLink();
        BP.WaitTillLinkEqualBrandProducts("https://www.automationexercise.com/brand_products/Polo");
        String ExpectedLink = "https://www.automationexercise.com/brand_products/Polo";
        String ActualLink = BP.GetBrandProductsURL();
        Assert.assertEquals(ActualLink, ExpectedLink);

        // Hover over the first three Polo products.
        BP.HoverOnProduct_1_Polo();
        BP.HoverOnProduct_2_Polo();
        BP.HoverOnProduct_3_Polo();

        // Open the H&M brand page and verify its URL.
        BrandProducts B_P = BP.ClickOnHMLink();
        String ExpectedLink1 = "https://www.automationexercise.com/brand_products/H&M";
        String ActualLink1 = BP.GetBrandProductsURL();
        Assert.assertEquals(ActualLink1, ExpectedLink1);

        // Hover over the first three H&M products.
        B_P.HoverOnProduct_1_HM();
        B_P.HoverOnProduct_2_HM();
        B_P.HoverOnProduct_3_HM();

        // Close the browser after completing the test.
        B_P.CloseDriver();
    }

    // Creates a registered account and logs out before cart verification tests.
    @BeforeMethod(onlyForGroups = "CartAccount")
    public void CreateLoginLogoutAccount() {

        // Load signup data and assign a unique email address.
        SignupCredentials[] test = HelperClass.readJson
                ("src/main/java/TestData/SignupCredentialsData.JSON", SignupCredentials[].class);

        test[0].setEmailAddress(TestDataGenerator.generateUniqueEmail());

        // Store the credentials for use in the test.
        createdUser = test[0];

        // Register the account and verify the registration steps.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());
        LoginPage login = base.ClickOnSignUPLoginLink();
        Assert.assertTrue(login.CheckNewUserSignUPElementVisible());

        SignUPPage Sign = login.PerformSignUP(createdUser);
        Assert.assertTrue(Sign.CheckAccountInfoElementVisible());

        AccountCreated AC = Sign.PerformCreateAccount(createdUser);
        Assert.assertTrue(AC.CheckSuccessMessageVisible());

        // Verify the logged-in state, then log out and close the browser.
        BasePage BP = AC.ClickOnContinueButton();
        Assert.assertTrue(BP.CheckLoggedInVisible());
        BP.ClickOnLogout();
        BP.CloseDriver();
    }





    ///======================================================================================================================///





    // TC20: Verify that searched products remain in the cart after login.
    @Description("This Test To Verify that the user can search for a product, add it to the cart, log in, and verify the cart contents")
    @Owner("Ahmed_Ayman")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test cases documentation", url = "https://www.automationexercise.com/test_cases")
    @TmsLink("https://www.automationexercise.com/test_cases")
    @Epic("Cart And Product PlacementTests")
    @Feature("Search Products and Verify Cart After Login")
    @Story("Verify Cart Products After Login")
    @Test(groups = "CartAccount")
    public void TC20_SearchProductsAndVerifyCartAfterLogin() {

        // Open the application and verify that the home page is displayed.
        BasePage base = new BasePage(browserType, targetUrl);
        Assert.assertTrue(base.CheckHomePageImageVisible());

        // Open the products page and verify that the products section is visible.
        Products P = base.ClickOnProducts();
        Assert.assertTrue(P.CheckAllProductsElementVisible());

        // Search for products and add the first three results to the cart.
        ProductsSearch PS = P.PerformSearchProduct();
        PS.ClickOnAddToCartP_1();
        PS.ClickOnContinueShopping();
        PS.ClickOnAddToCartP_2();
        PS.ClickOnContinueShopping();
        PS.ClickOnAddToCartP_3();
        PS.ClickOnContinueShopping();

        // Open the cart and verify the prices of the three selected products.
        PS.HoverOnSearchedProducts();
        ViewCart VC = PS.ClickOnCart();

        String Jeans_1_ExpectedPrice = "Rs. 799";
        String Jeans_2_ExpectedPrice = "Rs. 1200";
        String Jeans_3_ExpectedPrice = "Rs. 1400";
        String Jeans_1_ActualPrice = VC.ReadJeans_1_Price();
        String Jeans_2_ActualPrice = VC.ReadJeans_2_Price();
        String Jeans_3_ActualPrice = VC.ReadJeans_3_Price();

        Assert.assertEquals(Jeans_1_ActualPrice, Jeans_1_ExpectedPrice);
        Assert.assertEquals(Jeans_2_ActualPrice, Jeans_2_ExpectedPrice);
        Assert.assertEquals(Jeans_3_ActualPrice, Jeans_3_ExpectedPrice);

        // Log in and reopen the cart to verify the product prices again.
        LoginPage lg = VC.ClickOnSignUPLoginLink();
        BasePage BS = lg.PerformLogin(createdUser);
        ViewCart V_Cart = BS.ClickOnCart();

        Assert.assertEquals(Jeans_1_ActualPrice, Jeans_1_ExpectedPrice);
        Assert.assertEquals(Jeans_2_ActualPrice, Jeans_2_ExpectedPrice);
        Assert.assertEquals(Jeans_3_ActualPrice, Jeans_3_ExpectedPrice);

        // Close the browser after completing the test.
        V_Cart.CloseDriver();
    }






    ///======================================================================================================================///






}