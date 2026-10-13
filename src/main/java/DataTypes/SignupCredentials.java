package DataTypes;


/**
 * Represents the test data required to execute user registration scenarios.
 * Includes account credentials, personal information, and address details.
 */
public class SignupCredentials {

    private String Name ;
    private String EmailAddress ;
    private String Title ;
    private String Password ;
    private String Day  ;
    private String Month ;
    private String Year ;
    private String FirstName ;
    private String LastName;
    private String Company ;
    private String Address ;
    private String Address2 ;
    private String Country  ;
    private String State ;
    private String City ;
    private String Zipcode ;
    private String MobileNumber ;



    /**
     * Initializes the registration test data with the provided values.
     *
     * @param name         the name used to register the account
     * @param emailAddress the email address associated with the account
     * @param title        the user's title, such as Mr. or Mrs.
     * @param password     the password for the new account
     * @param day          the day of birth
     * @param month        the month of birth
     * @param year         the year of birth
     * @param firstName    the user's first name
     * @param lastName     the user's last name
     * @param company      the user's company name
     * @param address      the primary address
     * @param address2     the secondary address, if applicable
     * @param country      the user's country
     * @param state        the user's state or region
     * @param city         the user's city
     * @param zipcode      the postal or ZIP code
     * @param mobileNumber the user's mobile phone number
     */
    public SignupCredentials(String name, String emailAddress, String title, String password, String day, String month, String year, String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        Name = name;
        EmailAddress = emailAddress;
        Title = title;
        Password = password;
        Day = day;
        Month = month;
        Year = year;
        FirstName = firstName;
        LastName = lastName;
        Company = company;
        Address = address;
        Address2 = address2;
        Country = country;
        State = state;
        City = city;
        Zipcode = zipcode;
        MobileNumber = mobileNumber;
    }


    /**
     * Returns the name used during registration.
     *
     * @return the registration name
     */
    public String getName() {
        return Name;
    }


    /**
     * Updates the registration name.
     *
     * @param name the new registration name
     */
    public void setName(String name) {
        Name = name;
    }


    /**
     * Returns the account email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return EmailAddress;
    }


    /**
     * Updates the account email address.
     *
     * @param emailAddress the new email address
     */
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }


    /**
     * Returns the user's title.
     *
     * @return the user's title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Updates the user's title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        Title = title;
    }


    /**
     * Returns the account password.
     *
     * @return the account password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Updates the account password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        Password = password;
    }


    /**
     * Returns the day of birth.
     *
     * @return the birth day
     */
    public String getDay() {
        return Day;
    }


    /**
     * Updates the day of birth.
     *
     * @param day the new birth day
     */
    public void setDay(String day) {
        Day = day;
    }


    /**
     * Returns the month of birth.
     *
     * @return the birth month
     */
    public String getMonth() {
        return Month;
    }


    /**
     * Updates the month of birth.
     *
     * @param month the new birth month
     */
    public void setMonth(String month) {
        Month = month;
    }


    /**
     * Returns the year of birth.
     *
     * @return the birth year
     */
    public String getYear() {
        return Year;
    }


    /**
     * Updates the year of birth.
     *
     * @param year the new birth year
     */
    public void setYear(String year) {
        Year = year;
    }


    /**
     * Returns the user's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Updates the user's first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * Updates the user's last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * Returns the company name.
     *
     * @return the company name
     */
    public String getCompany() {
        return Company;
    }

    /**
     * Updates the company name.
     *
     * @param company the new company name
     */
    public void setCompany(String company) {
        Company = company;
    }

    /**
     * Returns the primary address.
     *
     * @return the primary address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Updates the primary address.
     *
     * @param address the new primary address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * Returns the secondary address.
     *
     * @return the secondary address
     */
    public String getAddress2() {
        return Address2;
    }

    /**
     * Updates the secondary address.
     *
     * @param address2 the new secondary address
     */
    public void setAddress2(String address2) {
        Address2 = address2;
    }

    /**
     * Returns the user's country.
     *
     * @return the country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Updates the user's country.
     *
     * @param country the new country
     */
    public void setCountry(String country) {
        Country = country;
    }

    /**
     * Returns the user's state or region.
     *
     * @return the state or region
     */
    public String getState() {
        return State;
    }

    /**
     * Updates the user's state or region.
     *
     * @param state the new state or region
     */
    public void setState(String state) {
        State = state;
    }

    /**
     * Returns the user's city.
     *
     * @return the city
     */
    public String getCity() {
        return City;
    }

    /**
     * Updates the user's city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        City = city;
    }

    /**
     * Returns the postal or ZIP code.
     *
     * @return the postal code
     */
    public String getZipcode() {
        return Zipcode;
    }

    /**
     * Updates the postal or ZIP code.
     *
     * @param zipcode the new postal code
     */
    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    /**
     * Returns the user's mobile phone number.
     *
     * @return the mobile phone number
     */
    public String getMobileNumber() {
        return MobileNumber;
    }

    /**
     * Updates the user's mobile phone number.
     *
     * @param mobileNumber the new mobile phone number
     */
    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    /**
     * Returns a string representation of the registration test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "SignupCredentials{" +
                "Name='" + Name + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", Title='" + Title + '\'' +
                ", Password='" + Password + '\'' +
                ", Day='" + Day + '\'' +
                ", Month='" + Month + '\'' +
                ", Year='" + Year + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Company='" + Company + '\'' +
                ", Address='" + Address + '\'' +
                ", Address2='" + Address2 + '\'' +
                ", Country='" + Country + '\'' +
                ", State='" + State + '\'' +
                ", City='" + City + '\'' +
                ", Zipcode='" + Zipcode + '\'' +
                ", MobileNumber='" + MobileNumber + '\'' +
                '}';
    }


}
