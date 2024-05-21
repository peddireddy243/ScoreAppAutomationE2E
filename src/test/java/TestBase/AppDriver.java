package TestBase;

import Utilities.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppDriver {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final AppDriver instance = new AppDriver();
    private static final Logger logger = Logger.getLogger(AppDriver.class.getName());

    private AppDriver() {
        // Private constructor to enforce singleton pattern
    }

    public static AppDriver getInstance() {
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public static AppiumDriver getCurrentDriver() {
        return getInstance().getDriver();
    }

    public static void setDriver(AppiumDriver driverInstance) {
        driver.set(driverInstance);
        logger.info("Driver is set");
    }


    public static void launchApp(String platformName, String remoteHost) throws IOException {
        DesiredCapabilities capabilities = getCapabilities(platformName);
        AppiumDriver driver;

        try {
            if (platformName.equalsIgnoreCase("android")) {
                driver = new AndroidDriver(new URL(remoteHost), capabilities);
            } else if (platformName.equalsIgnoreCase("iOS")) {
                driver = new IOSDriver(new URL(remoteHost), capabilities);
            } else {
                throw new RuntimeException("Unsupported platform: " + platformName);
            }

            setDriver(driver);
            getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("App launched on " + platformName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to launch app on " + platformName, e);
            throw e;
        }
    }


    private static DesiredCapabilities getCapabilities(String platformName) {
        JsonNode platformNode = JSONFileReader.getPlatformNode(Constants.CAP_PATH, platformName);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", platformNode.path("platformName").asText());
        capabilities.setCapability("deviceName", platformNode.path("deviceName").asText());
        capabilities.setCapability("automationName", platformNode.path("automationName").asText());
        capabilities.setCapability("platformVersion", platformNode.path("platformVersion").asText());
        capabilities.setCapability("noReset", platformNode.path("noReset").asText());

        // Set capabilities based on platform
        if (platformName.equalsIgnoreCase("android")) {
            if (!platformNode.path("appActivity").asText().isEmpty()) {
                capabilities.setCapability("appActivity", platformNode.path("appActivity").asText());
                capabilities.setCapability("appPackage", platformNode.path("appPackage").asText());
            } else {
                capabilities.setCapability("app", Constants.RESOURCES_PATH + "theScoreApp.apk");
            }
        } else if (platformName.equalsIgnoreCase("ios")) {
            capabilities.setCapability("bundleId", platformNode.path("bundleId").asText());
            capabilities.setCapability("udid", platformNode.path("udid").asText());
        }

        return capabilities;
    }


    public static void quitDriver() {
        if (getCurrentDriver() != null) {
            getCurrentDriver().quit();
            driver.remove();
            logger.info("Driver quit and removed from ThreadLocal");
        }
    }
}
