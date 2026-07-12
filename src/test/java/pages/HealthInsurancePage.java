package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HealthInsurancePage {
    WebDriver driver;

    public HealthInsurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div/span[text()='Products']")
    private WebElement Products;

    @FindBy(xpath="//div[text()='Health insurance' and @class='dhk7580 dhk7581 niwet11s']")
    private WebElement Health;

    @FindBy(xpath="//a[contains(@href,'health-insurance')]/div[@class='_3n34710 _3n34711 _3n34710 _1a4b2178 zkw9eg8']")
    private List<WebElement> healthItems;


    public void clickProducts() {
        Products.click();
    }

    public List<String> getHealthInsuranceItems() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Health));
        Health.click();
        wait.until(
                ExpectedConditions.visibilityOfAllElements(healthItems));

        List<WebElement> elements = healthItems;

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
