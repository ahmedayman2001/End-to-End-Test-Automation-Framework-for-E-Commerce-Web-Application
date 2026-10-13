package DataTypes;


/**
 * Represents test data used to verify login behavior
 * when invalid credentials are provided.
 */
public class InvalidLoginCredentials {

    private String EmailAddress ;
    private String Password ;
    private String ExpectedLoginErrorMessage ;


    /**
     * Initializes the test data for an invalid login scenario.
     *
     * @param emailAddress               the email address used for login
     * @param password                  the password used for login
     * @param expectedLoginErrorMessage the expected error message displayed
     *                                  when login fails
     */
    public InvalidLoginCredentials(String emailAddress, String password, String expectedLoginErrorMessage) {
        EmailAddress = emailAddress;
        Password = password;
        ExpectedLoginErrorMessage = expectedLoginErrorMessage;
    }


    /**
     * Returns the email address used for login.
     *
     * @return the login email address
     */
    public String getEmailAddress() {
        return EmailAddress;
    }


    /**
     * Updates the email address used for login.
     *
     * @param emailAddress the new login email address
     */
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }


    /**
     * Returns the password used for login.
     *
     * @return the login password
     */
    public String getPassword() {
        return Password;
    }


    /**
     * Updates the password used for login.
     *
     * @param password the new login password
     */
    public void setPassword(String password) {
        Password = password;
    }


    /**
     * Returns the expected error message for an invalid login attempt.
     *
     * @return the expected login error message
     */
    public String getExpectedLoginErrorMessage() {
        return ExpectedLoginErrorMessage;
    }


    /**
     * Updates the expected login error message.
     *
     * @param expectedLoginErrorMessage the new expected error message
     */
    public void setExpectedLoginErrorMessage(String expectedLoginErrorMessage) {
        ExpectedLoginErrorMessage = expectedLoginErrorMessage;
    }


    /**
     * Returns a string representation of the login test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "InvalidLoginCredentials{" +
                "EmailAddress='" + EmailAddress + '\'' +
                ", Password='" + Password + '\'' +
                ", ExpectedLoginErrorMessage='" + ExpectedLoginErrorMessage + '\'' +
                '}';
    }

}
