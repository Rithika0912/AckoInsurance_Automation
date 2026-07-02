package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {

        if(extent == null) {

            String path = System.getProperty("user.dir")
                    + "/Reports/ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(path);

            spark.config().setDocumentTitle("Acko Automation Report");
            spark.config().setReportName("Cucumber Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Acko Insurance");
            extent.setSystemInfo("Tester", "Karthicka");
        }

        return extent;
    }
}