package MyListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Custom TestNG listener for logging test execution events.
 * Reports test starts, successes, failures, and skipped tests.
 */
public class CustomListener implements ITestListener {

    /**
     * Executes when a test method starts.
     * Logs the test method name and its parameters.
     *
     * @param result the result object containing test execution details
     */
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test Started" + result.getMethod().getMethodName());
        System.out.println("Test Parameters" + result.getParameters());
    }

    /**
     * Executes when a test method completes successfully.
     * Logs the test's success status.
     *
     * @param result the result object containing test execution details
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success" + result.isSuccess());
    }

    /**
     * Executes when a test method fails.
     * Logs the test failure event.
     *
     * @param result the result object containing test execution details
     */
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failure");
    }

    /**
     * Executes when a test method is skipped.
     * Logs the skipped test event.
     *
     * @param result the result object containing test execution details
     */
    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test Skipped");
    }

}