package Pages;

import Utils.Framework;
import org.openqa.selenium.By;


/**
 * Represents the Account Created page and provides methods
 * to verify the account creation confirmation and continue navigation.
 */
public class AccountCreated extends BasePage {


    private final String SuccessMessageLocator ="//b" ;
    private final String ContinueButtonLocator ="//div[@class=\"pull-right\"]/a" ;


    /**
     * Initializes the Account Created page with the specified framework.
     *
     * @param framework the framework instance used to interact with web elements
     */
    public AccountCreated(Framework framework){

        super(framework) ;

    }


    /**
     * Checks whether the account creation success message is visible.
     *
     * @return true if the success message is visible; otherwise, false
     */
    public boolean CheckSuccessMessageVisible(){

        return framework.ElementIsVisible(By.xpath(SuccessMessageLocator));

    }


    /**
     * Clicks the Continue button to proceed from the Account Created page.
     *
     * @return a BasePage instance for subsequent page interactions
     */
    public BasePage ClickOnContinueButton(){

       framework.ClickOnButton(By.xpath( ContinueButtonLocator ));

        return new BasePage(super.framework) ;

    }


}
