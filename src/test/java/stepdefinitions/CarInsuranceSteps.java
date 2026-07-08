package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CarInsurancePage;
import Base.BaseClass;
import utils.ScreenshotUtil;

public class CarInsuranceSteps extends BaseClass {

    CarInsurancePage carPage;

    @Given("User launches Acko website for car insurance")
    public void user_launches_acko_website() {

        launchBrowser();

        driver.get("https://www.acko.com");

        carPage = new CarInsurancePage(driver);
    }

    @When("User selects Car Insurance")
    public void user_selects_car_insurance() {

        carPage.clickCarInsurance();
        carPage.clickInsureBrand();
    }

    @When("User selects Tata Punch Petrol Manual Pure MT vehicle")
    public void user_select_vehicle() {

        carPage.selectTata();
        carPage.selectPunch();
        carPage.selectPetrol();
        carPage.selectManual();
        carPage.selectPureMT();

        carPage.selectCommercialNo();
        carPage.selectBookedCar();
        carPage.clickContinue();
    }

    @When("User enters invalid phone number and pincode")
    public void user_enters_invalid_data() {

        carPage.enterPhone("12345");
        carPage.enterPincode("123");
    }

    @Then("Proper validation messages should be displayed")
    public void verify_validation_messages() {

        String phoneError =
                carPage.getPhoneError();

        String pincodeError =
                carPage.getPincodeError();

        System.out.println(
                "Phone Error : " + phoneError);

        System.out.println(
                "Pincode Error : " + pincodeError);

        try {
            ScreenshotUtil.captureScreenshot(
                    driver,
                    "CarInsuranceValidation");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(
                "Enter a valid Phone number",
                phoneError);

        Assert.assertEquals(
                "Enter a valid Pincode",
                pincodeError);

       
    }
    @And("close the Browser")
    public void close(){
            
        closeBrowser();
    }
}
