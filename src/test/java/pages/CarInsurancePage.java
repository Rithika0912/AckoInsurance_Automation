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

    public void clickCarInsurance() {

        WebElement insurance = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h4[contains(text(),'Car insurance')]")));

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
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//h3[contains(text(),'Insure your brand')]")));

        insureBrand.click();
    }

    public void selectTata() {

        WebElement brand = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='Tata']")));

        brand.click();
    }

    public void selectPunch() {

        WebElement model = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='Punch']")));

        model.click();
    }

    public void selectPetrol() {

        WebElement fuelType = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='Petrol']")));

        fuelType.click();
    }

    public void selectManual() {

        WebElement transmission = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='manual']")));

        transmission.click();
    }

    public void selectPureMT() {

        WebElement variant = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='Pure MT']")));

        variant.click();
    }

    public void selectCommercialNo() {

        WebElement commercial = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='No']")));

        commercial.click();
    }

    public void selectBookedCar() {

        WebElement booked = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(normalize-space(),'Have you booked the car?')]/following-sibling::div[1]//button")));

        booked.click();
    }

    public void clickContinue() {

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[.//span[text()='Continue']]")));

        continueButton.click();
    }

    public void enterPhone(String phoneNumber) {

        WebElement phone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("phone")));

        phone.sendKeys(phoneNumber);

        driver.findElement(By.tagName("body")).click();
    }

    public void enterPincode(String pinCode) {

        WebElement pincode = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("pincode")));

        pincode.sendKeys(pinCode);

        driver.findElement(By.tagName("body")).click();
    }

    public String getPhoneError() {

        WebElement phoneAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'valid Phone')]")));

        return phoneAlert.getText();
    }

    public String getPincodeError() {

        WebElement pincodeAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'valid Pincode')]")));

        return pincodeAlert.getText();
    }
}