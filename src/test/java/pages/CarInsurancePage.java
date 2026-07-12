package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarInsurancePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public CarInsurancePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//h4[contains(text(),'Car insurance')]")
    private WebElement carInsurance;

    @FindBy(xpath = "//h3[contains(text(),'Insure your brand')]")
    private WebElement insuranceBrand;

    @FindBy(xpath = "//div[text()='Tata']")
    private WebElement carBrand;

    @FindBy(xpath = "//div[text()='Punch']")
    private WebElement carModel;

    @FindBy(xpath = "//div[text()='Petrol']")
    private WebElement fuel;

    @FindBy(xpath = "//div[text()='manual']")
    private WebElement manual;

    @FindBy(xpath = "//div[text()='Pure MT']")
    private WebElement pureMT;

    @FindBy(xpath = "//span[text()='No']")
    private WebElement no;

    @FindBy(xpath = "//div[contains(normalize-space(),'Have you booked the car?')]/following-sibling::div[1]//button")
    private WebElement bookedBtn;

    @FindBy(xpath = "//button[.//span[text()='Continue']]")
    private WebElement continueBtn;

    @FindBy(id = "phone")
    private WebElement phoneNo;

    @FindBy(tagName = "body")
    private WebElement body;

    @FindBy(id = "pincode")
    private WebElement pincodeNo;

    @FindBy(xpath = "//p[contains(text(),'valid Phone')]")
    private WebElement phoneError;

    @FindBy(xpath = "//p[text()='Enter a valid Pincode']")
    private WebElement pinError;

    public void clickCarInsurance() {

        wait.until(ExpectedConditions.visibilityOf(carInsurance));
        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                carInsurance);

        js.executeScript(
                "arguments[0].click();",
                carInsurance);
    }

    public void clickInsureBrand() {

        wait.until(ExpectedConditions.elementToBeClickable(insuranceBrand));

        insuranceBrand.click();
    }

    public void selectTata() {

        wait.until(ExpectedConditions.elementToBeClickable(carBrand));

        carBrand.click();
    }

    public void selectPunch() {

        wait.until(ExpectedConditions.elementToBeClickable(carModel));

        carModel.click();
    }

    public void selectPetrol() {

        wait.until(ExpectedConditions.elementToBeClickable(fuel));

        fuel.click();
    }

    public void selectManual() {

        wait.until(ExpectedConditions.elementToBeClickable(manual));

        manual.click();
    }

    public void selectPureMT() {

        wait.until(ExpectedConditions.elementToBeClickable(pureMT));

        pureMT.click();
    }

    public void selectCommercialNo() {

        wait.until(ExpectedConditions.elementToBeClickable(no));

        no.click();
    }

    public void selectBookedCar() {

        wait.until(ExpectedConditions.elementToBeClickable(bookedBtn));

        bookedBtn.click();
    }

    public void clickContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));

        continueBtn.click();
    }

    public void enterPhone(String phoneNumber) {

        wait.until(ExpectedConditions.visibilityOf(phoneNo));

        phoneNo.sendKeys(phoneNumber);

        body.click();
    }

    public void enterPincode(String pinCode) {

        wait.until(ExpectedConditions.visibilityOf(pincodeNo));

        pincodeNo.sendKeys(pinCode);

        body.click();
    }

    public String getPhoneError() {

        wait.until(ExpectedConditions.visibilityOf(phoneError));

        return phoneError.getText();
    }

    public String getPincodeError() {

        wait.until(ExpectedConditions.visibilityOf(pinError));

        return pinError.getText();
    }
}