package Runners;

import io.cucumber.tagexpressions.TagExpressionParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
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
                "html:target/TestOutput/cucumber-reports.html",
                "json:target/TestOutput/CucumberTestReport.json",
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

        @Parameters({"tags"})
        @BeforeClass
        public void runCucumberTests(String tags) {
                System.setProperty("cucumber.filter.tags", tags);
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