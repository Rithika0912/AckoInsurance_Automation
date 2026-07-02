package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HealthInsurancePage {
    WebDriver driver;

    public HealthInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    By Products =
            By.xpath("//div/span[text()='Products']");
    By Health= By.xpath("//div/span[text()='Health']");

    By healthItems =
            By.xpath("//div[contains(text(),'Health')]/following-sibling::div//a");

    public void clickProducts() {
        driver.findElement(Products).click();
    }


    public List<String> getHealthInsuranceItems() {

        List<WebElement> elements =
                driver.findElements(healthItems);

        List<String> items = new ArrayList<>();

        for(WebElement ele : elements) {
            items.add(ele.getText());
            System.out.println(ele.getText());
        }


        return items;
    }

    public void navigateBackToHome() {
        driver.navigate().back();
    }
}
