package stepdefinitions;

import Base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HealthInsurancePage;
import utils.ExcelUtil;

import java.util.List;

public class HealthInsuranceSteps extends BaseClass {

    WebDriver driver;
    HealthInsurancePage homePage;
    List<String> healthItems;

    @Given("User launches Acko website for health insurance")
    public void launchWebsite() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.acko.com/");

        homePage = new HealthInsurancePage(driver);
    }

    @When("User clicks on Products")
    public void clickProducts() {

        homePage.clickProducts();
    }

    @When("User retrieves Health Insurance menu items")
    public void retrieveHealthItems() {

        healthItems = homePage.getHealthInsuranceItems();
    }

    @Then("Display menu items")
    public void displayItems() {

        for(String item : healthItems)
        {
            System.out.println(item);
        }
    }

    @Then("Save menu items to Excel")
    public void saveExcel() {

        ExcelUtil.writeData(healthItems);
    }

    @Then("Navigate back to home page")
    public void navigateBack() {

        homePage.navigateBackToHome();

        driver.quit();
    }
}