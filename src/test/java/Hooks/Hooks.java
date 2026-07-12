package Hooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;


public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {

        extent = ExtentManager.getExtentReport();
        test = extent.createTest(scenario.getName());
    }


}