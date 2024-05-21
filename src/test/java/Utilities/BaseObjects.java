package Utilities;

import TestBase.AppDriver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.testng.Assert;

public class BaseObjects {

    protected static AppiumDriver driver;

    public BaseObjects() {
        driver = AppDriver.getCurrentDriver();
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
}

