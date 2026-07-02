package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TravelInsurancePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public TravelInsurancePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(20));

        js = (JavascriptExecutor) driver;
    }

    public void selectTravelInsurance() {

        WebElement clickTravel = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//div[@class='Hero_heroCard__Etq_R '])[2]")
                )
        );

        clickTravel.click();

        WebElement clickInternational = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[contains(text(),'Get international travel insurance')]")
                )
        );

        clickInternational.click();
    }

    public void selectCountry(String country) {

        WebElement searchCountry = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//div[@class='styles_inputContainer__ryWDY'])[1]")
                )
        );

        searchCountry.click();

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input")
                )
        );

        searchBox.sendKeys(country);

        WebElement enterCountry = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='sc-cbkKFq dLULXL']")
                )
        );

        enterCountry.click();
    }

    public void selectTravelDates() {

        driver.findElement(
                        By.xpath("//*[@id=\"__next\"]/main/div/div[3]/div[2]/div/div[2]"))
                .click();

        WebElement startDate = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//div[normalize-space()='17'])")
                )
        );

        startDate.click();

        WebElement endDate = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//div[normalize-space()='29'])[3]")
                )
        );

        endDate.click();

        WebElement next = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Next']")
                )
        );

        js.executeScript(
                "arguments[0].click();",
                next);
    }

    public void selectTravellers() {

        driver.findElement(
                        By.xpath("//*[@id=\"__next\"]/main/div/div[3]/div[3]/div/div[1]"))
                .click();

        driver.findElement(
                        By.xpath("//*[@id=\"__next\"]/main/div/div[3]/div[3]/div[2]/div[2]/div/div[2]/div[3]"))
                .click();

        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Continue']")
                )
        );

        js.executeScript(
                "arguments[0].click();",
                continueBtn);

    }

    public boolean verifyPlansDisplayed() {

        return driver.getPageSource()
                .contains("plans")
                || driver.getCurrentUrl().contains("travel");
    }
    public void printPlanNamesAndCosts() {


        WebElement divVis=wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-gNJABI bKVCgl']")));
        js.executeScript("arguments[0].scrollIntoView(true);", divVis);
        List<WebElement> insurancePackages=driver.findElements(By.xpath("//div[@class='sc-jGxEUC cXfUzD']"));

        System.out.println(insurancePackages.size());
        for(WebElement w: insurancePackages) {
            System.out.println(w.getText());
        }

        List<WebElement> cost=driver.findElements(By.xpath("//div[@class=\"sc-jRuhRL dSPYdl\"]"));

        System.out.println(cost.size());
        for(WebElement w: cost) {
            System.out.println(w.getText());
        }
    }

}