package StepDefinitions;

import Runners.TestRunner;
import TestBase.AppDriver;
import TestBase.AppiumServerManager;
import TestBase.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BaseStepDef  {

    private static final Logger logger = LogManager.getLogger(BaseStepDef.class);

    protected static ExtentTest test = ExtentReportManager.getTest();
    @Before
    public void setUp(Scenario scenario) {

        String platformName = TestRunner.platformName;
        String localHost = TestRunner.localHost;
        try {
            AppiumServerManager.start();
            AppDriver.launchApp(platformName, localHost);
            logger.info("Initiated setup for scenario: " + scenario.getName());
            ExtentReportManager.createTest(scenario.getName(), scenario.getId());
            test = ExtentReportManager.getTest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("Scenario: " + scenario.getName() + " completed. Tearing down...");
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario passed: " + scenario.getName());
        }
        ExtentReportManager.removeTest();
        ExtentReportManager.getInstance().flush();
        AppDriver.quitDriver();
        AppiumServerManager.stop();
    }
}
