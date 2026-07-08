package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarInsurancePage {

    WebDriver driver;
    WebDriverWait wait;

    public CarInsurancePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(50));
    }
    By CarInsurance=By.xpath("//h4[contains(text(),'Car insurance')]");
    By InsuranceBrand=By.xpath("//h3[contains(text(),'Insure your brand')]");
    By CarBrand=By.xpath("//div[text()='Tata']");
    By CarModel=By.xpath("//div[text()='Punch']");
    By fuel =By.xpath("//div[text()='Petrol']");
    By manual=By.xpath("//div[text()='manual']");
    By PureMT=By.xpath("//div[text()='Pure MT']");
    By No=By.xpath("//span[text()='No']");
    By BookedBtn=By.xpath("//div[contains(normalize-space(),'Have you booked the car?')]/following-sibling::div[1]//button");
    By continueBtn=By.xpath("//button[.//span[text()='Continue']]");
    By phoneNo=By.id("phone");
    By Body=By.tagName("body");
    By pincodeNo=By.id("pincode");
    By phoneError=By.xpath("//p[contains(text(),'valid Phone')]");
    By pinError=By.xpath("//p[text()='Enter a valid Pincode']");
    public void clickCarInsurance() {

        WebElement insurance = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                      CarInsurance));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                insurance);

        js.executeScript(
                "arguments[0].click();",
                insurance);
    }

    public void clickInsureBrand() {

        WebElement insureBrand = wait.until(
                ExpectedConditions.elementToBeClickable(InsuranceBrand));

        insureBrand.click();
    }

    public void selectTata() {

        WebElement brand = wait.until(
                ExpectedConditions.elementToBeClickable(CarBrand));

        brand.click();
    }

    public void selectPunch() {

        WebElement model = wait.until(
                ExpectedConditions.elementToBeClickable(
                       CarModel));

        model.click();
    }

    public void selectPetrol() {

        WebElement fuelType = wait.until(
                ExpectedConditions.elementToBeClickable(
                      fuel));

        fuelType.click();
    }

    public void selectManual() {

        WebElement transmission = wait.until(
                ExpectedConditions.elementToBeClickable(
                       manual));

        transmission.click();
    }

    public void selectPureMT() {

        WebElement variant = wait.until(
                ExpectedConditions.elementToBeClickable(
                        PureMT));

        variant.click();
    }

    public void selectCommercialNo() {

        WebElement commercial = wait.until(
                ExpectedConditions.elementToBeClickable(
                        No));

        commercial.click();
    }

    public void selectBookedCar() {

        WebElement booked = wait.until(
                ExpectedConditions.elementToBeClickable(
                        BookedBtn));

        booked.click();
    }

    public void clickContinue() {

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueBtn));

        continueButton.click();
    }

    public void enterPhone(String phoneNumber) {

        WebElement phone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        phoneNo));

        phone.sendKeys(phoneNumber);

        driver.findElement(Body).click();
    }

    public void enterPincode(String pinCode) {

        WebElement pincode = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        pincodeNo));

        pincode.sendKeys(pinCode);

        driver.findElement(Body).click();
    }

    public String getPhoneError() {

        WebElement phoneAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        phoneError));

        return phoneAlert.getText();
    }

    public String getPincodeError() {

        WebElement pincodeAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        pinError));

        return pincodeAlert.getText();
    }
}