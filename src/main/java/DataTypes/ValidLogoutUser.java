//package DataTypes;
//
//public class ValidLogoutUser {
//
//    private String EmailAddress ;
//    private String Password ;
//
//    public ValidLogoutUser(String emailAddress, String password) {
//        EmailAddress = emailAddress;
//        Password = password;
//    }
//
//    public String getEmailAddress() {
//        return EmailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        EmailAddress = emailAddress;
//    }
//
//    public String getPassword() {
//        return Password;
//    }
//
//    public void setPassword(String password) {
//        Password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "ValidLogoutUser{" +
//                "EmailAddress='" + EmailAddress + '\'' +
//                ", Password='" + Password + '\'' +
//                '}';
//    }
//}

package DataTypes;

/**
 * Represents test data used to verify the logout functionality
 * for a user with valid login credentials.
 */
public class ValidLogoutUser {

    private String EmailAddress;
    private String Password;

    /**
     * Initializes the test data with valid user credentials.
     *
     * @param emailAddress the email address of the registered user
     * @param password     the password associated with the account
     */
    public ValidLogoutUser(String emailAddress, String password) {
        EmailAddress = emailAddress;
        Password = password;
    }

    /**
     * Returns the registered user's email address.
     *
     * @return the user's email address
     */
    public String getEmailAddress() {
        return EmailAddress;
    }

    /**
     * Updates the registered user's email address.
     *
     * @param emailAddress the new email address
     */
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    /**
     * Returns the user's password.
     *
     * @return the account password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Updates the user's password.
     *
     * @param password the new account password
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Returns a string representation of the logout test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "ValidLogoutUser{" +
                "EmailAddress='" + EmailAddress + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
