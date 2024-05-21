package Utilities;

import StepDefinitions.BaseStepDef;
import org.testng.Assert;

import java.util.logging.Logger;

import static Utilities.BaseObjects.logMessage;

public class Assertions extends BaseObjects{

    public Assertions() {
        super();
    }

    public static void assertEquals(String actualText, String expectedText) {
        try {
            Assert.assertEquals(actualText, expectedText);
            logMessage("info", "Verification Success : '" + actualText + "' Vs '" + expectedText + "'");
        } catch (AssertionError e) {
            logMessage("fail", "Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
            throw e;
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (condition) {
            logMessage("pass", "Success : " + message);
        } else {
            logMessage("fail", "Failed to Validate : " + message);
            Assert.fail("Failed to validate: " + message);
        }
    }


    public static void assertFalse(boolean condition, String message) {
        if (!condition) {
            logMessage("pass", "Success: " + message);
        } else {
            logMessage("fail", "Failed to validate: " + message);
            Assert.fail("Failed to validate: " + message);
        }
    }

    public static void assertContains(String actualText, String expectedText) {
        if (actualText.contains(expectedText)) {
            logMessage("pass", "Verification Success : '" + actualText + "' Vs '" + expectedText + "'");
        } else {
            logMessage("fail", "Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
            Assert.fail("Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
        }
    }
}
