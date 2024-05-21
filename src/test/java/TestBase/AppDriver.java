package TestBase;

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
    
}
