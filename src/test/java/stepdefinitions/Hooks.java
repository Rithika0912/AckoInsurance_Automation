package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BaseClass;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {

        extent = ExtentManager.getExtentReport();

        test = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        WebDriver driver = BaseClass.driver;

        if(scenario.isFailed()) {

            try {

                String path =
                        ScreenshotUtil.captureScreenshot(
                                driver,
                                scenario.getName());

                test.fail("Scenario Failed")
                        .addScreenCaptureFromPath(path);

            }
            catch(IOException e) {

                e.printStackTrace();
            }
        }
        else {

            test.pass("Scenario Passed");
        }

        extent.flush();
    }
}