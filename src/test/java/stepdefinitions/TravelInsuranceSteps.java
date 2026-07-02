package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.TravelInsurancePage;
import utils.BaseClass;

public class TravelInsuranceSteps extends BaseClass {

    TravelInsurancePage travelPage;

    @Given("User launches Acko application")
    public void launchApp() {

        launchBrowser();

        driver.get("https://www.acko.com");

        travelPage = new TravelInsurancePage(driver);
    }

    @When("User selects travel insurance")
    public void selectTravelInsurance() {

        travelPage.selectTravelInsurance();
    }

    @When("User enters travel country")
    public void userEntersCountry() {

        travelPage.selectCountry("United Kingdom");

        travelPage.selectTravelDates();

        travelPage.selectTravellers();
    }

    @Then("Travel plans should be displayed")
    public void verifyPlans() {

        Assert.assertTrue(
                "Travel plans are not displayed",
                travelPage.verifyPlansDisplayed());

        System.out.println(
                "Plans displayed successfully");

        closeBrowser();
    }
}