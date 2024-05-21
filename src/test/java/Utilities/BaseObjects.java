package Utilities;

import TestBase.AppDriver;

import TestBase.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

public class BaseObjects {

    protected static AppiumDriver driver;
    protected static ExtentTest test;
    protected static Logger log;
    protected static WebDriverWait wait;

    public BaseObjects() {
        driver = AppDriver.getCurrentDriver();
        test = ExtentReportManager.getTest();
        log = LogManager.getLogger(this.getClass());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Initialize the WebDriverWait here
    }

    public void sleep(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            log.error("Thread sleep was interrupted!", e);
        }
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementDisplayed (WebElement element, String message){
        try {
            boolean displayed = element.isDisplayed();
            return displayed;
        } catch (WebDriverException e) {
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static boolean isElementEnabled (WebElement element, String message){
        try {
            boolean enabled = element.isEnabled();
            return enabled;
        } catch (WebDriverException e) {
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static boolean isElementSelected (WebElement element, String message){
        try {
            boolean selected = element.isSelected();
            return selected;
        } catch (WebDriverException e) {
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static void logMessage(String status, String message) {
        if (test != null) {
            String screenshotPath = captureScreenshot();
            try {
                switch (status.toLowerCase()) {
                    case "info":
                        test.log(Status.INFO, message);
                        log.info(message);
                        break;
                    case "warn":
                        test.log(Status.WARNING, message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                        log.warn(message);
                        getPageSource();
                        break;
                    case "fail":
                        test.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                        log.error(message);
                        getPageSource();
                        break;
                    case "pass":
                        test.log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                        log.info(message);
                        break;
                    default:
                        test.log(Status.INFO, "Invalid log level provided: " + status);
                        log.info("Invalid log level provided: " + status);
                        getPageSource();
                }
            } catch (Exception e) {
                log.error("Error while logging: " + e.getMessage());
                test.fail("Error while logging: " + e.getMessage());
                getPageSource();
            }
        } else {
            log.info("Test instance is null. Make sure it is properly initialized.");
        }
    }

    protected static String captureScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String uniqueID = UUID.randomUUID().toString(); // Generates a unique identifier
        String imgPath = "img/" + uniqueID + ".png"; // Appended the unique identifier to the filename
        File filePath = new File(Constants.SCREENSHOT_PATH + imgPath);

        try {
            // Ensure the directory exists
            FileUtils.forceMkdirParent(filePath);
            // Move the file to the desired location
            FileUtils.copyFile(screenshot, filePath);
        } catch (IOException e) {
            log.error("Screenshot service failed!!!", e); // Log the actual exception
        }
        return imgPath;
    }

    public static String getPageSource() {
        String pageSource = null;
        try {
            pageSource = driver.getPageSource();
            test.info(MarkupHelper.createCodeBlock(pageSource));
        } catch (Exception e) {
            log.warn("Failed to get page source: " + e.getMessage());
            if (test != null) {
                test.warning("Failed to get page source: " + e.getMessage());
            }
        }
        return pageSource;
    }
}

