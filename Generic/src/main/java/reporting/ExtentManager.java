package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;
    ExtentTest logger;


    @BeforeTest
    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(), "html");

            extent = new ExtentReports(System.getProperty("user.dir") + "/Extent-Report/ExtentReport.html", true);

            Reporter.log("Extent Report Directory" + resultDirectory, true);
            extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment", "QA").addSystemInfo("User Name", "Denys Myronenko");
            extent.loadConfig(new File(System.getProperty("user.dir") + "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context) {
        ExtentManager.context = context;

    }
}