package Runners;

import io.cucumber.tagexpressions.TagExpressionParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.stream.Collectors;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "html:testOutput/cucumberReport/cucumber-reports.html",
                "json:TestOutput/cucumberReport/CucumberTestReport.json",
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

        public static String platformName;
        public static String localHost;
        @Parameters({"tags"})
        @BeforeClass
        public void runCucumberTests(String tags, ITestContext context) {
                System.setProperty("cucumber.filter.tags", tags);
                platformName = context.getCurrentXmlTest().getParameter("platformName");
                localHost = context.getCurrentXmlTest().getParameter("localHost");
        }

        @Override
        @DataProvider()
        public Object[][] scenarios() {
                Object[][] scenarios = super.scenarios();
                String dynamicTags = System.getProperty("cucumber.filter.tags");
                if(dynamicTags != null && !dynamicTags.isEmpty()){
                        return (Arrays.stream(scenarios).filter(scenario ->
                                TagExpressionParser.parse(dynamicTags).evaluate(((PickleWrapper) scenario[0])
                                        .getPickle().getTags())).collect(Collectors.toList())).toArray(new Object[0][0]);
                }else {
                        return scenarios;
                }
        }
}