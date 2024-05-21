package Listeners;

import TestBase.AppDriver;
import TestBase.ExtentReportManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);
    public static String platformName;
    public static String localHost;
    public static AppiumDriver driver = AppDriver.getCurrentDriver();

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite started: " + context.getName());
        platformName = context.getCurrentXmlTest().getParameter("platformName");
        localHost = context.getCurrentXmlTest().getParameter("localHost");

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite finished: " + context.getName());
        // Flush the Extent Reports at the end of the suite
        ExtentReportManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
        // Log the test as passed in the Extent Report
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.PASS, "Test passed: " + result.getName());
            ExtentReportManager.removeTest();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getTestName());
        logger.error("Test failure cause: ", result.getThrowable());
        // Log the test as failed in the Extent Report
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getTestName());
            ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable().getCause());
            ExtentReportManager.removeTest();
            try {
                String errorXML = driver.getPageSource();
                ExtentReportManager.getTest().info(MarkupHelper.createCodeBlock(errorXML));
            } catch (Exception e) {
                // ignore
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getTestName());
        // Log the test as skipped in the Extent Report
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.SKIP, "Test skipped: " + result.getTestName());
            ExtentReportManager.getTest().log(Status.SKIP, result.getThrowable().getCause());
            ExtentReportManager.removeTest();
        }
    }
}
