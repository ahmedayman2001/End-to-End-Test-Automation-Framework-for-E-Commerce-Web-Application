package Pages;

import Utils.Framework;
import org.openqa.selenium.By;

/**
 * Represents the Account Deleted page and provides methods
 * to verify the account deletion confirmation and continue navigation.
 */
public class AccountDeleted extends BasePage {

    private final String DeletedMessageLocator = "//b";
    private final String ContinueButtonLocator = "//div[@class=\"pull-right\"]/a";

    /**
     * Initializes the Account Deleted page with the specified framework.
     *
     * @param framework the framework instance used to interact with web elements
     */
    public AccountDeleted(Framework framework) {
        super(framework);
    }

    /**
     * Checks whether the account deletion success message is visible.
     *
     * @return true if the deletion message is visible; otherwise, false
     */
    public boolean CheckDeletedMessageVisible() {
        return framework.ElementIsVisible(By.xpath(DeletedMessageLocator));
    }

    /**
     * Clicks the Continue button to proceed from the Account Deleted page.
     *
     * @return a BasePage instance for subsequent page interactions
     */
    public BasePage ClickOnContinueButton() {
        framework.ClickOnButton(By.xpath(ContinueButtonLocator));
        return new BasePage(super.framework);
    }
}