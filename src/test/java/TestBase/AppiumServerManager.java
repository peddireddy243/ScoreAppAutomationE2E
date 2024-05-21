package TestBase;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class AppiumServerManager {
    private static final Logger logger = LogManager.getLogger(AppiumServerManager.class);
    private static AppiumDriverLocalService server;

    private static void setInstance() {

        // Build the AppiumServiceBuilder
        server = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumServerPath()))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("testOutput/AppiumLog.txt"))
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")
                .build();
    }

    private static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    public static void start() {
        getInstance().start();
        logger.info("Server started at URL: " + server.getUrl());
        logger.info("is Server started = " + server.isRunning());
    }

    public static void stop() {
        if (server != null) {
            getInstance().stop();
            logger.info("Appium server stopped");
        }

    }

    private static String appiumServerPath() {
        String[] possiblePaths = {
                "/opt/homebrew/bin/appium", // Common path for appium on Apple Silicon
                "/usr/local/bin/appium" // Common path for appium on Intel Macs
        };

        for (String path : possiblePaths) {
            if (new File(path).exists()) {
                return path;
            }
        }
        throw new RuntimeException("Appium server executable not found in common paths. Please ensure Appium is installed.");
    }
}
