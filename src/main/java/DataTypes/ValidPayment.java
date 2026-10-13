package DataTypes;

/**
 * Represents test data used to verify the payment process
 * with valid card details.
 */
public class ValidPayment {

    private String nameOnCard;
    private String cardNumber;
    private String cvc;
    private String expirationMonth;
    private String expirationYear;

    /**
     * Initializes the payment test data with the provided card details.
     *
     * @param nameOnCard     the name printed on the payment card
     * @param cardNumber     the payment card number
     * @param cvc            the card verification code
     * @param expirationMonth the card expiration month
     * @param expirationYear  the card expiration year
     */
    public ValidPayment(String nameOnCard, String cardNumber, String cvc,
                        String expirationMonth, String expirationYear) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    /**
     * Returns the name printed on the payment card.
     *
     * @return the cardholder's name
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * Updates the name printed on the payment card.
     *
     * @param nameOnCard the new cardholder's name
     */
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    /**
     * Returns the payment card number.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Updates the payment card number.
     *
     * @param cardNumber the new card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Returns the card verification code.
     *
     * @return the CVC
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Updates the card verification code.
     *
     * @param cvc the new CVC
     */
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    /**
     * Returns the card expiration month.
     *
     * @return the expiration month
     */
    public String getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Updates the card expiration month.
     *
     * @param expirationMonth the new expiration month
     */
    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * Returns the card expiration year.
     *
     * @return the expiration year
     */
    public String getExpirationYear() {
        return expirationYear;
    }

    /**
     * Updates the card expiration year.
     *
     * @param expirationYear the new expiration year
     */
    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * Returns a string representation of the payment test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "ValidPayment{" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvc='" + cvc + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                '}';
    }
}