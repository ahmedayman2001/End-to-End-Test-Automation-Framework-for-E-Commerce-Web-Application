package DataTypes;

/**
 * Represents test data used to verify the sign-up process
 * when an email address is already registered.
 */

public class ExistingSignUPEmail {

    private String Name;
    private String EmailAddress ;
    private String SignUPErrorMessage ;


    /**
     * Initializes the test data for an existing email address.
     *
     * @param name               the name used during sign-up
     * @param emailAddress       the email address already registered
     * @param signUPErrorMessage the expected sign-up error message
     */

    public ExistingSignUPEmail(String name, String emailAddress, String signUPErrorMessage) {
        Name = name;
        EmailAddress = emailAddress;
        SignUPErrorMessage = signUPErrorMessage;
    }


    /**
     * Returns the name used during sign-up.
     *
     * @return the sign-up name
     */
    public String getName() {
        return Name;
    }



    /**
     * Updates the name used during sign-up.
     *
     * @param name the new sign-up name
     */
    public void setName(String name) {
        Name = name;
    }


    /**
     * Returns the registered email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return EmailAddress;
    }


    /**
     * Updates the email address used in the test.
     *
     * @param emailAddress the new email address
     */
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }


    /**
     * Returns the expected error message for an existing email.
     *
     * @return the expected sign-up error message
     */
    public String getSignUPErrorMessage() {
        return SignUPErrorMessage;
    }


    /**
     * Updates the expected sign-up error message.
     *
     * @param signUPErrorMessage the new expected error message
     */
    public void setSignUPErrorMessage(String signUPErrorMessage) {
        SignUPErrorMessage = signUPErrorMessage;
    }


    /**
     * Returns a string representation of the test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "ExistingSignUPEmail{" +
                "Name='" + Name + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", SignUPErrorMessage='" + SignUPErrorMessage + '\'' +
                '}';
    }
}
