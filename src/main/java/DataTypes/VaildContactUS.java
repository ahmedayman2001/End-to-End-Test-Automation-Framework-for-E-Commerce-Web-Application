package DataTypes;

/**
 * Represents test data used to verify the Contact Us form
 * with valid input values.
 */
public class VaildContactUS {

    private String Name;
    private String Email;
    private String Subject;
    private String Message;
    private String FilePath;

    /**
     * Initializes the test data for a valid Contact Us submission.
     *
     * @param name     the name of the user submitting the form
     * @param email    the user's email address
     * @param subject  the subject of the inquiry
     * @param message  the message submitted through the form
     * @param filePath the path of the file to be uploaded
     */
    public VaildContactUS(String name, String email, String subject, String message, String filePath) {
        Name = name;
        Email = email;
        Subject = subject;
        Message = message;
        FilePath = filePath;
    }

    /**
     * Returns the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return Name;
    }

    /**
     * Updates the user's name.
     *
     * @param name the new user name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Returns the user's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Updates the user's email address.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Returns the inquiry subject.
     *
     * @return the subject of the inquiry
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * Updates the inquiry subject.
     *
     * @param subject the new inquiry subject
     */
    public void setSubject(String subject) {
        Subject = subject;
    }

    /**
     * Returns the submitted message.
     *
     * @return the contact message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Updates the submitted message.
     *
     * @param message the new contact message
     */
    public void setMessage(String message) {
        Message = message;
    }

    /**
     * Returns the path of the file to be uploaded.
     *
     * @return the file path
     */
    public String getFilePath() {
        return FilePath;
    }

    /**
     * Updates the path of the file to be uploaded.
     *
     * @param filePath the new file path
     */
    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    /**
     * Returns a string representation of the Contact Us test data.
     *
     * @return a formatted string containing the object's fields
     */
    @Override
    public String toString() {
        return "VaildContactUS{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Message='" + Message + '\'' +
                ", FilePath='" + FilePath + '\'' +
                '}';
    }
}