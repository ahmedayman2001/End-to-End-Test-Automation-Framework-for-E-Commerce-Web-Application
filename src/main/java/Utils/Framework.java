package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.webextension.ExtensionPath;
import org.openqa.selenium.bidi.webextension.InstallExtensionParameters;
import org.openqa.selenium.bidi.webextension.WebExtension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;


/**
 * Provides reusable Selenium WebDriver utilities for UI test automation.
 *
 * <p>This class is responsible for common browser and web-element
 * interactions such as:</p>
 *
 * <ul>
 *     <li>Browser initialization and configuration</li>
 *     <li>Navigation and window management</li>
 *     <li>Element interactions</li>
 *     <li>Dropdowns, checkboxes, and radio buttons</li>
 *     <li>Mouse and keyboard actions</li>
 *     <li>Windows, tabs, alerts, and frames</li>
 *     <li>Explicit and implicit waiting</li>
 *     <li>Full-page and element screenshots</li>
 * </ul>
 *
 * <p>The class is intended to reduce duplicated Selenium code
 * throughout the automation framework.</p>
 */


public class Framework {


    /** WebDriver instance used to control the browser. */
    WebDriver driver ;

    /** Selenium Actions instance used for advanced mouse and keyboard interactions. */
    Actions action ;


    /** Directory used to store screenshots generated during test execution. */
    private static final String ScreenShotPath = "src\\main\\resources\\ScreenShots" ;

    /** Path to the ad-block browser extension used to prevent ads during test execution. */
    private static final String AdBlockExtensionPath = "C:\\Users\\Asus\\Downloads\\ads\\ADS\\2026.723.1724_0";




    /**
     * Initializes the framework using the specified browser.
     *
     * <p>Supported browsers are Chrome, Firefox, Edge, and Safari.</p>
     *
     * @param BrowserName name of the browser to initialize
     */
    public Framework( String BrowserName ) {

        if (BrowserName.equalsIgnoreCase("chrome")){

            /*
             * Configure Chrome preferences to disable
             * password-manager related popups during automation.
             */
            ChromeOptions options = new ChromeOptions();
            options.setCapability("unhandledPromptBehavior", "ignore");


            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

            // Enable extension installation via BiDi so the ad-block extension can be loaded.
            options.addArguments("--enable-unsafe-extension-debugging");
            options.addArguments("--remote-debugging-pipe");
            options.enableBiDi();

            driver = new ChromeDriver(options);

            // Install the ad-block extension to prevent ads from interfering with test execution.
            InstallAdBlockExtension();



        } else if (BrowserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver() ;

        } else if (BrowserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver() ;

        } else if (BrowserName.equalsIgnoreCase("safari")) {

            driver = new SafariDriver() ;

        } else  {

            System.out.println("BrowserName not found");
        }


        // Configure common WebDriver settings after browser initialization.
        SetImplicitWait( ) ;

        // Maximize the browser window by default.
        MaxWindow();

        // Initialize Selenium Actions for mouse and keyboard operations.
        action = new Actions( driver ) ;


    }




    /**
     * Initializes the framework with Chrome as the default browser.
     */
    public Framework ( ){

        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "ignore");

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        // Enable extension installation via BiDi so the ad-block extension can be loaded.
        options.addArguments("--enable-unsafe-extension-debugging");
        options.addArguments("--remote-debugging-pipe");
        options.enableBiDi();

        driver = new ChromeDriver(options);

        // Install the ad-block extension to prevent ads from interfering with test execution.
        InstallAdBlockExtension();

        SetImplicitWait( ) ;

        MaxWindow();

        action = new Actions( driver ) ;


    }




    /**
     * Configures the implicit wait used by WebDriver.
     *
     * <p>The implicit wait tells WebDriver to wait for a specified
     * amount of time when locating elements before throwing an
     * element-not-found exception.</p>
     */
    private void SetImplicitWait ( ) {

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10)) ;

    }





    /**
     * Navigates the browser to the specified URL.
     *
     * @param TargetUrl destination URL
     */
    public void NavigateToURL(String TargetUrl ){

        driver.navigate().to(TargetUrl);

    }






    /**
     * Navigates forward in the browser history.
     */
    public void NavigateForward( ){

        driver.navigate().forward() ;

    }





    /**
     * Navigates backward in the browser history.
     */
    public void NavigateBack( ){

        driver.navigate().back() ;

    }




    /**
     * Refreshes the current browser page.
     */
    public void RefreshPage( ){

        driver.navigate().refresh() ;

    }





    /**
     * Maximizes the browser window.
     */
    public void MaxWindow( ){

        driver.manage().window().maximize() ;

    }





    /**
     * Minimizes the browser window.
     */
    public void MinWindow( ){

        driver.manage().window().minimize() ;

    }





    /**
     * Sets the browser window to the specified dimensions.
     *
     * @param w window width in pixels
     * @param h window height in pixels
     */
    public void SetWindowSize(int w , int h ){

        driver.manage().window().setSize ( new Dimension( w , h ) )  ;

    }






    /**
     * Closes the currently active browser tab or window.
     *
     * <p>If multiple tabs are open, only the current tab is closed.</p>
     */
    public void CloseCurrentTab( ){

        driver.close();
    }






    /**
     * Closes all browser windows and terminates the WebDriver session.
     */
    public void CloseAllTabs( ){

        driver.quit() ;
    }







    /**
     * Clicks an element after waiting until it becomes visible.
     *
     * @param Locator locator used to identify the target element
     */
    public void ClickOnButton(By Locator){

        new WebDriverWait(driver , Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(Locator));

        driver.findElement(Locator).click() ;

    }





    /**
     * Opens a new browser tab and switches the driver focus to it.
     */
    public void AddNewTab( ){


        driver.switchTo().newWindow(WindowType.TAB ) ;

    }






    /**
     * Retrieves the visible text of an element.
     *
     * @param Locator locator used to identify the target element
     * @return visible text of the element
     */
    public String GetTextFromElement(By Locator ) {

        new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(Locator)) ;

        return driver.findElement(Locator).getText();

    }







    /**
     * Selects an option from a standard HTML select element by its value.
     *
     * @param Locator locator of the select element
     * @param val value attribute of the option to select
     */
    public void DropDownMenuSelectByValue(By Locator , String val ){


        Select dropdown = new Select(driver.findElement(Locator));
        dropdown.selectByValue(val) ;

    }








    /**
     * Selects multiple options from a multi-select dropdown by index.
     *
     * @param locator locator of the select element
     * @param indexes indexes of the options to select
     */
    public void DropDownMenuSelectMultipleByIndex (By locator, int... indexes ) {

        Select dropdown = new Select(driver.findElement(locator));

        for (int index : indexes) {
            dropdown.selectByIndex(index);
        }

    }






    /**
     * Selects a checkbox if it is not already selected.
     *
     * @param locator locator of the checkbox
     */
    public void CheckBox(By locator ) {

        if ( !driver.findElement(locator).isSelected() ) {

            driver.findElement(locator).click() ;

        }
    }






    /**
     * Deselects a checkbox if it is currently selected.
     *
     * @param locator locator of the checkbox
     */
    public void UnCheckBox(By locator ) {

        if ( driver.findElement(locator).isSelected() ) {

            driver.findElement(locator).click();
        }
    }




    /**
     * Selects a radio button if it is not already selected.
     *
     * @param locator locator of the radio button
     */
    public void SelectRadioButton (By locator ) {

        if (!driver.findElement(locator).isSelected( ) ) {

            driver.findElement(locator).click( ) ;

        }

    }




    /**
     * Clears the existing value from an input field.
     *
     * @param locator locator of the input field
     */
    public void ClearField(By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.findElement(locator).clear();
    }



    /**
     * Clears an input field and enters the specified text.
     *
     * @param locator locator of the input field
     * @param text text to enter
     */
    public void SendText(By locator, String text) {


        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).clear() ;
        driver.findElement(locator).sendKeys(text) ;

    }





    /**
     * Moves the mouse pointer over the specified element.
     *
     * @param Locator locator of the target element
     */
    public void HoverOnElement (By Locator ){

        new WebDriverWait(driver , Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Locator)) ;

        action.moveToElement(driver.findElement(Locator)).perform() ;

    }





    /**
     * Performs a drag-and-drop operation from one element to another.
     *
     * @param SourceLocator locator of the source element
     * @param DestLocator locator of the destination element
     */
    public void DragAndDrop (By SourceLocator , By DestLocator ){


        new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.and(

                ExpectedConditions.elementToBeClickable(SourceLocator) ,
                ExpectedConditions.visibilityOfElementLocated(DestLocator)
        )) ;

        action.dragAndDrop(

                driver.findElement(SourceLocator )
                , driver.findElement(DestLocator)
        ).perform();


    }





    /**
     * Clicks an element using Selenium Actions.
     *
     * @param Locator locator of the target element
     */
    public void ClickOnElement (By Locator) {

        new WebDriverWait(driver , Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Locator) ) ;

        action.moveToElement(driver.findElement(Locator)).perform();

        action.click().perform() ;
    }



    /**
     * Sends keyboard input using the currently focused element.
     *
     * <p>This method sends one or more keyboard inputs to the
     * currently focused element.</p>
     *
     * <p>It can be used to send both normal text and special
     * keyboard keys such as {@link org.openqa.selenium.Keys#TAB}.</p>
     *
     * <p>For direct text entry into a specific element,
     * {@link #SendText(By, String)} is generally preferred.</p>
     *
     * @param keys keyboard inputs or text to send
     */
    public void SendStringViaActions(CharSequence... keys) {

        action.sendKeys(keys).perform();
    }



    /**
     * Performs a double-click on the specified element.
     *
     * @param Locator locator of the target element
     */
    public void DoubleClick ( By Locator ){

        action.doubleClick(driver.findElement(Locator)).perform();

    }




    /**
     * Performs a right-click on the specified element.
     *
     * @param Locator locator of the target element
     */
    public void RightClick ( By Locator ){

        action.contextClick(driver.findElement(Locator)).perform();

    }




    /**
     * Scrolls the page until the specified element is visible.
     *
     * @param Locator locator of the target element
     */
    public void ScrollToElement ( By Locator ) {


        action.scrollToElement(driver.findElement(Locator)).perform(); ;

    }




    /**
     * Retrieves all currently available browser window handles.
     *
     * @return set containing all window handles
     */
    public Set<String> GetAllWindowHandles () {

        return driver.getWindowHandles();

    }




    /**
     * Switches WebDriver focus to the specified browser window.
     *
     * @param Handle window handle of the target window
     */
    public void SwitchToWindow(String Handle ) {


        driver.switchTo().window( Handle ) ;

    }





    /**
     * Retrieves the handle of the currently active browser window.
     *
     * @return current window handle
     */
    public String GetCurrentWindowHandle ( ) {

        return driver.getWindowHandle() ;

    }






    /**
     * Finds the newly opened browser window by comparing
     * window handles before and after opening it.
     *
     * @param Before window handles captured before opening the new window
     * @param After window handles captured after opening the new window
     * @return handle of the newly opened window, or null if none is found
     */
    public String GetAddedNewHandle(Set<String> Before , Set<String> After) {

        for (String Handle : After ){

            if (Before.contains(Handle)){

                /// Do Nothing ///

            }else {

                return Handle ;
            }
        } return null ;

    }





    /**
     * Accepts the currently displayed JavaScript alert.
     */
    public void AcceptAlert(){


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }






    /**
     * Dismisses the currently displayed JavaScript alert.
     */
    public void ClosAlert ( )
    {
        driver.switchTo().alert().dismiss();

    }







    /**
     * Enters text into the currently displayed JavaScript prompt.
     *
     * @param text text to enter into the alert
     */
    public void SendStringToAlert ( String text ) {


        driver.switchTo().alert().sendKeys( text ) ;

    }






    /**
     * Retrieves the text displayed by the current JavaScript alert.
     *
     * @return alert text
     */
    public String GetAlertText ( ) {

        return driver.switchTo().alert().getText() ;

    }





    /**
     * Retrieves the current browser URL.
     *
     * @return current page URL
     */
    public String GetURL(){

        return driver.getCurrentUrl();

    }





    /**
     * Switches WebDriver focus to an iframe.
     *
     * @param Locator locator of the iframe element
     */
    public void SwitchToFrame (By Locator) {


        driver.switchTo().frame(driver.findElement( Locator )) ;

    }






    /**
     * Switches from the current frame to its parent frame.
     */
    public void SwitchToParentFrame ( ) {

        driver.switchTo().parentFrame() ;

    }





    /**
     * Switches WebDriver focus back to the main document.
     */
    public void SwitchToDefaultContent ( ){

        driver.switchTo().defaultContent() ;
    }








    /**
     * Captures a screenshot of the current browser viewport.
     *
     * <p>The screenshot is saved using a timestamp-based filename
     * to reduce the possibility of filename conflicts.</p>
     */
    public void DriverTakeScreenShot() {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timstamp =new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date()) ;

        try {

            FileHandler.copy(src,  new File(ScreenShotPath +"screenshot_" + timstamp +".png" ));

        } catch (Exception e ) {

            System.out.println("Failed To Save Screen Shot");
            System.out.println(e.getMessage() ) ;

        }

    }




    /**
     * Captures a screenshot of a specific web element.
     *
     * @param Locator locator of the element to capture
     */
    public void TakeScreenShotForElement (By Locator ){

        File src = driver.findElement(Locator).getScreenshotAs(OutputType.FILE);

        String timstamp =new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date()) ;

        try {

            FileHandler.copy(src,  new File(ScreenShotPath +"screenshot_" + timstamp +".png" ));

        } catch (Exception e ) {

            System.out.println("Failed To Save Screen Shot");
            System.out.println(e.getMessage() ) ;

        }

    }



    /**
     * Waits until the browser reaches the specified URL.
     *
     * @param URL expected URL
     */
    public void WaitTillReachURL(String URL ){

        new WebDriverWait(driver , Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(URL)) ;
    }


    public String GetCurrentURL(){

        return driver.getCurrentUrl();
    }


    /**
     * Checks whether an element is visible on the page.
     *
     * @param Locator locator of the element
     * @return true if the element exists and is visible; false otherwise
     */
    public boolean ElementIsVisible(By Locator) {

        try {


            new WebDriverWait(driver , Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(Locator) ) ;

            return driver.findElement(Locator).isDisplayed();

        } catch ( Exception e) {

            return false;
        }
    }


    /**
     * Uploads a file by sending its absolute path directly to a
     * file input element.
     *
     * <p>This works only with HTML {@code <input type="file">}
     * elements, since Selenium sends the file path as text instead
     * of interacting with the native OS file dialog.</p>
     *
     * @param locator locator of the file input element
     * @param filePath absolute path of the file to upload
     */
    public void UploadFile(By locator, String filePath) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

        driver.findElement(locator).sendKeys(filePath);
    }







    /**
     * Installs the ad-block browser extension into the currently
     * running Chrome driver instance to prevent ads from interfering
     * with test execution.
     *
     * <p>If installation fails for any reason (e.g. missing extension
     * folder, unsupported browser), the failure is logged and test
     * execution continues normally.</p>
     */
    private void InstallAdBlockExtension() {

        try {
            new WebExtension(driver).install(
                    new InstallExtensionParameters(new ExtensionPath(AdBlockExtensionPath))
            );
        } catch (Exception e) {
            System.out.println("Failed to install ad-block extension: " + e.getMessage());
        }
    }




}