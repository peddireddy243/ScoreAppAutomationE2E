package StepDefinations;

import TestBase.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;


public class BaseStepDef {

    private static final Logger logger = Logger.getLogger(BaseStepDef.class.getName());
    private static AppiumDriver driver;
    static String platformName = System.getProperty("platformName");
    static String remoteHost = System.getProperty("remoteHost");

    @Before
    public void setUp(Scenario scenario) {
        logger.info("Initiated setup for scenario: " + scenario.getName());
        try {
            launchApp();
            logger.info("app launched");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void launchApp() throws IOException {

        // Set capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "src/test/resources/theScoreApp.apk");
        capabilities.setCapability("automationName", "UiAutomator2");

        if (platformName.equalsIgnoreCase("android")) {
            driver = new AndroidDriver(new URL(remoteHost), capabilities);
        } else if (platformName.equalsIgnoreCase("iOS")) {
            driver = new IOSDriver(new URL(remoteHost), capabilities);
        } else {
            throw new RuntimeException("Unsupported platform: " + capabilities.getCapability("platformName"));
        }
        AppDriver.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}