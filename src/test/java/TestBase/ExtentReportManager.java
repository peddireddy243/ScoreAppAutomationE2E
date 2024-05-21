package TestBase;

import Utilities.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }



    private static ExtentReports createInstance() {
        String timestamp = new SimpleDateFormat("MMddHHmm").format(new Date());

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Constants.REPORT_DIR +"AutomatonReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        return extent;
    }

    public static synchronized void createTest(String name, String description) {
        ExtentTest extentTest = getInstance().createTest(name, description);
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
