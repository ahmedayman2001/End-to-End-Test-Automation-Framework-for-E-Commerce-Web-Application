package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Provides common web page interactions and navigation methods
 * shared across the application's page objects.
 */
public class BasePage {

    // String AccessAlertExpectedMessage = "You have been successfully subscribed!";

    private final String SignUpLoginLocator = "//body//div[@class=\"header-middle\"]//li[4]/a";
    private final String LoggedInAsLocator = "//div[@class=\"shop-menu pull-right\"]//li[10]//b";
    private final String DeleteAccountLocator = "//div[@class=\"shop-menu pull-right\"]//li[5]/a";
    private final String HomeElementLocator = "//body//div[@class=\"header-middle\"]//li[1]/a";
    private final String HomePageFeaturesItemsLocator = "//div[@class=\"features_items\"]/h2";
    private final String LogoutElementLocator = "//div[@class=\"row\"]//li[4]/a[@href=\"/logout\"]";
    private final String ContactUSLocator = "//div[@class=\"header-middle\"]//li[8]/a";
    private final String TestCasesElementLocator = "//body//div[@class=\"header-middle\"]//li[5]/a";
    private final String ProductsElementLocator = "//ul[@class=\"nav navbar-nav\"]/li[2]/a";
    private final String CartElementLocator = "//div[@class=\"header-middle\"]//li[3]/a";
    private final String SubscriptionElementLocator = "//div[@class=\"single-widget\"]/h2";
    private final String InputFieldEmailLocator = "//input[@id=\"susbscribe_email\"]";
    private final String SubscribeButtonLocator = "//button[@id='subscribe']";
    private final String AccessMessageAlertLocator = "//div[@class=\"alert-success alert\"]";
    private final String HomePageFooterLocator = "//p[@class=\"pull-left\"]";
    private final String ViewSecondProductLinkLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][2]//li/a";
    private final String AddToCartButtonOfFirstProductLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][1]//a";
    private final String AddToCartButtonOfSecondProductLocator = "//div[@class=\"features_items\"]//div[@class=\"col-sm-4\"][2]//a";
    private final String FirstProductImageLocator = "//img[@src=\"/get_product_picture/1\"]";
    private final String SecondProductImageLocator = "//img[@src=\"/get_product_picture/2\"]";
    private final String ContinueShoppingButtonLocator = "//div[@class=\"modal-footer\"]/button";
    private final String ViewCartLinkLocator = "//div[@class=\"modal-body\"]//a";
    private final String WomenLinkLocator = "//div[@id=\"accordian\"]//div[@class=\"panel panel-default\"][1]//h4/a";
    private final String DressLinkLocator = "//div[@id=\"Women\"]//ul/li[1]/a";
    private final String MenLinkLocator = "//div[@id=\"accordian\"]//div[@class=\"panel panel-default\"][2]//h4/a";
    private final String TShirtsLinkLocator = "//div[@id=\"Men\"]//li[1]/a";
    private final String CategoryElementLocator = "//div[@class=\"left-sidebar\"]/h2";
    private final String BrandsElementsLocator = "//div[@class=\"brands_products\"]/h2";
    private final String PoloLinkLocator = "//div[@class=\"brands_products\"]//li[1]/a";
    private final String HAndMLinkLocator = "//div[@class=\"brands_products\"]//li[2]/a";

    Framework framework;
    private String TargetURL;

    /**
     * Initializes the page object using an existing framework instance.
     *
     * @param framework the framework instance used for browser interactions
     */
    public BasePage(Framework framework) {
        this.framework = framework;
    }

    /**
     * Initializes the framework with the specified browser and navigates
     * to the target URL.
     *
     * @param BrowserName the browser to launch
     * @param TargetUrl   the URL to open
     */
    public BasePage(String BrowserName, String TargetUrl) {
        this.framework = new Framework(BrowserName);
        this.TargetURL = TargetUrl;
        framework.NavigateToURL(TargetURL);
    }

    /**
     * Creates a BasePage instance without initializing a framework.
     */
    public BasePage() {
    }

    /**
     * Opens the Sign Up / Login page.
     *
     * @return the LoginPage object
     */
    public LoginPage ClickOnSignUPLoginLink() {
        framework.ClickOnElement(By.xpath(SignUpLoginLocator));
        return new LoginPage(this.framework);
    }

    /**
     * Checks whether the logged-in user's name is displayed.
     *
     * @return true if the logged-in indicator is visible; otherwise, false
     */
    public boolean CheckLoggedInVisible() {
        return framework.ElementIsVisible(By.xpath(LoggedInAsLocator));
    }

    /**
     * Checks whether the home page's featured products section is visible.
     *
     * @return true if the featured products section is visible; otherwise, false
     */
    public boolean CheckHomePageImageVisible() {
        return framework.ElementIsVisible(By.xpath(HomePageFeaturesItemsLocator));
    }

    /**
     * Deletes the currently logged-in user's account.
     *
     * @return the AccountDeleted page object
     */
    public AccountDeleted ClickOnDeleteAccount() {
        framework.ClickOnElement(By.xpath(DeleteAccountLocator));
        return new AccountDeleted(this.framework);
    }

    /**
     * Checks whether the Logout link is visible.
     *
     * @return true if the Logout link is visible; otherwise, false
     */
    public boolean CheckedLogOutVisible() {
        return framework.ElementIsVisible(By.xpath(LogoutElementLocator));
    }

    /**
     * Logs out the currently authenticated user.
     *
     * @return the LoginPage object
     */
    public LoginPage ClickOnLogout() {
        framework.ClickOnElement(By.xpath(LogoutElementLocator));
        return new LoginPage(this.framework);
    }

    /**
     * Opens the Contact Us page.
     *
     * @return the ContactUS page object
     */
    public ContactUS ClickOnContactUS() {
        framework.ClickOnElement(By.xpath(ContactUSLocator));
        return new ContactUS(this.framework);
    }

    /**
     * Opens the Test Cases page.
     *
     * @return the TestCases page object
     */
    public TestCases ClickOnTestCases() {
        framework.ClickOnElement(By.xpath(TestCasesElementLocator));
        return new TestCases(this.framework);
    }

    /**
     * Opens the Products page.
     *
     * @return the Products page object
     */
    public Products ClickOnProducts() {
        framework.ClickOnElement(By.xpath(ProductsElementLocator));
        return new Products(this.framework);
    }

    /**
     * Scrolls the page to the footer.
     */
    public void MakePageScrollToFooter() {
        framework.ScrollToElement(By.xpath(HomePageFooterLocator));
    }

    /**
     * Checks whether the subscription section is visible.
     *
     * @return true if the subscription section is visible; otherwise, false
     */
    public boolean CheckSubscriptionElementVisible() {
        return framework.ElementIsVisible(By.xpath(SubscriptionElementLocator));
    }

    /**
     * Enters an email address into the subscription field.
     *
     * @param Email the email address to enter
     */
    public void EnterSubscriptionEmail(String Email) {
        framework.SendText(By.xpath(InputFieldEmailLocator), Email);
    }

    /**
     * Clicks the subscription button to submit the email address.
     */
    public void ClickOnSubscriptionButton() {
        framework.ClickOnButton(By.xpath(SubscribeButtonLocator));
    }

    /**
     * Checks whether the subscription confirmation alert is visible.
     *
     * @return true if the confirmation alert is visible; otherwise, false
     */
    public boolean CheckAccessMessageAlertVisible() {
        return framework.ElementIsVisible(By.xpath(AccessMessageAlertLocator));
    }

    /**
     * Opens the shopping cart page.
     *
     * @return the ViewCart page object
     */
    public ViewCart ClickOnCart() {
        framework.ClickOnElement(By.xpath(CartElementLocator));
        return new ViewCart(this.framework);
    }

    /**
     * Opens the details page for the second featured product.
     *
     * @return the ProductDetails page object
     */
    public ProductDetails ClickOnViewProduct_2Link() {
        framework.ClickOnElement(By.xpath(ViewSecondProductLinkLocator));
        return new ProductDetails(this.framework);
    }

    /**
     * Clicks the Add to Cart button for the first featured product
     * on the home page.
     */
    public void ClickOnAddToCartProduct_1_Home() {
        framework.ClickOnButton(By.xpath(AddToCartButtonOfFirstProductLocator));
    }

    /**
     * Hovers over the first featured product image on the home page.
     */
    public void HoverOnProduct_1_Home() {
        framework.HoverOnElement(By.xpath(FirstProductImageLocator));
    }

    /**
     * Clicks the Continue Shopping button in the cart confirmation modal.
     */
    public void ClickOnContinueShoppingButton_Home() {
        framework.ClickOnButton(By.xpath(ContinueShoppingButtonLocator));
    }

    /**
     * Clicks the Add to Cart button for the second featured product
     * on the home page.
     */
    public void ClickOnAddToCartProduct_2_Home() {
        framework.ClickOnButton(By.xpath(AddToCartButtonOfSecondProductLocator));
    }

    /**
     * Hovers over the second featured product image on the home page.
     */
    public void HoverOnProduct_2_Home() {
        framework.HoverOnElement(By.xpath(SecondProductImageLocator));
    }

    /**
     * Opens the shopping cart through the cart modal link.
     *
     * @return the ViewCart page object
     */
    public ViewCart ClickOnViewCartLink_Home() {
        framework.ClickOnElement(By.xpath(ViewCartLinkLocator));
        return new ViewCart(this.framework);
    }

    /**
     * Checks whether the product category section is visible.
     *
     * @return true if the category section is visible; otherwise, false
     */
    public boolean CheckCategoryElementVisible() {
        return framework.ElementIsVisible(By.xpath(CategoryElementLocator));
    }

    /**
     * Expands the Women category in the sidebar.
     */
    public void ClickOnWomenLink() {
        framework.ClickOnElement(By.xpath(WomenLinkLocator));
    }

    /**
     * Opens the Dresses category under Women.
     *
     * @return the CategoryProducts page object
     */
    public CategoryProducts ClickOnDressLink() {
        framework.ClickOnElement(By.xpath(DressLinkLocator));
        return new CategoryProducts(this.framework);
    }

    /**
     * Expands the Men category in the sidebar.
     */
    public void ClickOnMenLink() {
        framework.ClickOnElement(By.xpath(MenLinkLocator));
    }

    /**
     * Opens the T-shirts category under Men.
     *
     * @return the CategoryProducts page object
     */
    public CategoryProducts ClickOnTShirtsLink() {
        framework.ClickOnElement(By.xpath(TShirtsLinkLocator));
        return new CategoryProducts(this.framework);
    }

    /**
     * Checks whether the brands section is visible.
     *
     * @return true if the brands section is visible; otherwise, false
     */
    public boolean CheckBradsElementVisible() {
        return framework.ElementIsVisible(By.xpath(BrandsElementsLocator));
    }

    /**
     * Opens the Polo brand products page.
     *
     * @return the BrandProducts page object
     */
    public BrandProducts ClickOnPoloLink() {
        framework.ClickOnElement(By.xpath(PoloLinkLocator));
        return new BrandProducts(this.framework);
    }

    /**
     * Opens the H&M brand products page.
     *
     * @return the BrandProducts page object
     */
    public BrandProducts ClickOnHMLink() {
        framework.ClickOnElement(By.xpath(HAndMLinkLocator));
        return new BrandProducts(this.framework);
    }

    /**
     * Closes all browser tabs managed by the framework.
     */
    public void CloseDriver() {
        framework.CloseAllTabs();
    }
}