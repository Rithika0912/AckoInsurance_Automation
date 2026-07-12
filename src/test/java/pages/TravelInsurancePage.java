package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
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

    @FindBy(xpath="(//div[@class='Hero_heroCard__Etq_R '])[2]")
    private WebElement clickTravel;

    @FindBy(xpath="//p[contains(text(),'Get international travel insurance')]")
    private WebElement clickInternational;

    @FindBy(xpath="(//div[@class='styles_inputContainer__ryWDY'])[1]")
    private WebElement searchCountry;

    @FindBy(xpath="//input")
    private WebElement searchBox;

    @FindBy(xpath="//div[@class='sc-cbkKFq dLULXL']")
    private WebElement enterCountry;

    @FindBy(xpath="//p[text()='July 2026']/following-sibling::div//div[text()='17']")
    private WebElement startDate;

    @FindBy(xpath="//p[text()='July 2026']/following-sibling::div//div[text()='23']")
    private WebElement endDate;

    @FindBy(xpath="//button[text()='Next']")
    private WebElement next;

    @FindBy(xpath="//div[text()='1']/following-sibling::div[@class='sc-kXeGPI gGpwrP']")
    private WebElement addAdultCount;

    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueBtn;

    @FindBy(xpath="//div[@class='sc-gNJABI bKVCgl']")
    private WebElement divVis;

    @FindBy(xpath="//div[@class='sc-jGxEUC cXfUzD']")
    private List<WebElement> insurancePackages;

    @FindBy(xpath="//div[@class='sc-jRuhRL dSPYdl']")
    private List<WebElement> cost;

    public void selectTravelInsurance() {

        wait.until(
                ExpectedConditions.elementToBeClickable(clickTravel));
        clickTravel.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(clickInternational));
        clickInternational.click();
    }

    public void selectCountry(String country) {

        wait.until(
                ExpectedConditions.elementToBeClickable(searchCountry));
        searchCountry.click();

        wait.until(
                ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(country);

        wait.until(
                ExpectedConditions.visibilityOf(enterCountry));
        enterCountry.click();
        wait.until(
                ExpectedConditions.elementToBeClickable(next));

        js.executeScript(
                "arguments[0].click();",
                next);
    }

    public void selectTravelDates() {

        wait.until(
                ExpectedConditions.elementToBeClickable(startDate));

        startDate.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(endDate));

        endDate.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(next));

        js.executeScript(
                "arguments[0].click();",
                next);
    }

    public void selectTravellers() {
        addAdultCount.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(continueBtn));

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


        wait.until(
                ExpectedConditions.visibilityOf(divVis));
        js.executeScript("arguments[0].scrollIntoView(true);", divVis);
        ArrayList<String> planName=new ArrayList<>();
        System.out.println("Number of Plans Available "+insurancePackages.size());
        for(WebElement w: insurancePackages) {
            planName.add(w.getText());
        }
        for(int i=0;i<planName.size();i++){
            System.out.println("Plan "+(i+1)+" is "+planName.get(i));
        }
        System.out.println("Cost of Each Plan is "+cost.size());
        for(WebElement w: cost) {
            System.out.println(w.getText());
        }
    }

}