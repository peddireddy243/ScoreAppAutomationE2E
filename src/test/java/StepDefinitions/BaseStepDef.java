package StepDefinitions;

import TestBase.AppDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.logging.Logger;

public class BaseStepDef {

    private static final Logger logger = Logger.getLogger(BaseStepDef.class.getName());

    @Before
    @Parameters({"platformName", "remoteHost"})
    public void setUp(String platformName, @Optional String remoteHost, Scenario scenario) {
        logger.info("Initiated setup for scenario: " + scenario.getName());

        try {
            AppDriver.launchApp(platformName, remoteHost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("Scenario: " + scenario.getName() + " completed. Tearing down...");
        AppDriver.quitDriver();
    }

}