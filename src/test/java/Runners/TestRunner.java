package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "html:target/TestOutput/cucumber-reports.html",
                "json:target/TestOutput/CucumberTestReport.json",
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

        @BeforeMethod
        @Parameters({"capabilitiesPath", "platformName", "remoteHost"})
        public void setParameters(String capabilitiesPath, String platformName, String remoteHost) {
                System.setProperty("capabilitiesPath", capabilitiesPath);
                System.setProperty("platformName", platformName);
                System.setProperty("remoteHost", remoteHost);
        }

}