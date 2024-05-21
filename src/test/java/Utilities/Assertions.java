package Utilities;

import StepDefinitions.BaseStepDef;
import org.testng.Assert;

import java.util.logging.Logger;

public class Assertions {

    private static final Logger logger = Logger.getLogger(BaseStepDef.class.getName());


    public static void assertEquals(String actualText, String expectedText) {
        try {
            Assert.assertEquals(actualText, expectedText);
            logger.info("Verification Success : '" + actualText + "' Vs '" + expectedText + "'");
        } catch (AssertionError e) {
            logger.info( "Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
            throw e;
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (condition) {
            logger.info( "Success : " + message);
        } else {
            logger.info("Failed to Validate : " + message);
            Assert.fail("Failed to validate: " + message);
        }
    }


    public static void assertFalse(boolean condition, String message) {
        if (!condition) {
            logger.info( "Success: " + message);
        } else {
            logger.info( "Failed to validate: " + message);
            Assert.fail("Failed to validate: " + message);
        }
    }

    public static void assertContains(String actualText, String expectedText) {
        if (actualText.contains(expectedText)) {
            logger.info("Verification Success : '" + actualText + "' Vs '" + expectedText + "'");
        } else {
            logger.info("Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
            Assert.fail("Verification failed : '" + actualText + "' Vs '" + expectedText + "'");
        }
    }
}
