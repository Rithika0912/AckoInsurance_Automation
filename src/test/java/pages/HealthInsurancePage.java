package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HealthInsurancePage {
    WebDriver driver;

    public HealthInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    By Products =
            By.xpath("//div/span[text()='Products']");
    By Health= By.xpath("//div[text()='Health insurance' and @class='dhk7580 dhk7581 niwet11s']");

    By healthItems =
            By.xpath("//a[contains(@href,'health-insurance')]/div[@class='_3n34710 _3n34711 _3n34710 _1a4b2178 zkw9eg8']");
    public void clickProducts() {
        driver.findElement(Products).click();
    }


    public List<String> getHealthInsuranceItems() {



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Health));
        driver.findElement(Health).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(healthItems));

        List<WebElement> elements = driver.findElements(healthItems);

        System.out.println("Items found : " + elements.size());

        List<String> items = new ArrayList<>();

        for (WebElement element : elements) {

            String text = element.getText().trim();

            if (!text.isEmpty()) {
                items.add(text);
                System.out.println(text);
            }
        }

        return items;
    }

    public void navigateBackToHome() {
        driver.navigate().back();
    }
}
