package TestData;

/**
 * Utility class for generating test data used in automated tests.
 */
public class TestDataGenerator {

    /**
     * Generates a unique email address using the current system timestamp.
     *
     * @return a generated email address with a timestamp to reduce duplication
     */
    public static String generateUniqueEmail() {
        return "testuser_"
                + System.currentTimeMillis()
                + "@gmail.com";
    }

}