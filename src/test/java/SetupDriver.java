import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class SetupDriver {
    WebDriver driver;

    public void waitDriver() {
        new WebDriverWait(driver, 5);
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static String yesterdayDate(WebElement element) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String correctDate = yesterday.format(formatter);
        element.sendKeys(correctDate);
        element.sendKeys(Keys.ENTER);
        return correctDate;
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("at-cv-lightbox-close")));
            WebElement openWindow = driver.findElement(By.id("at-cv-lightbox-close"));
            openWindow.click();
        } catch (Exception a) {
            System.out.println("window not open");
        }
    }


    @AfterMethod(alwaysRun = true)

    public void afterMethod() {

        driver.quit();


    }

    protected By inputFormMenuItem = By.xpath("//a[text()='Input Forms']");
    protected By simpleFormDemoMenuItem = By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']");

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public String getPartOfString(String originalString, String regex, int index) {
        String[] strings = originalString.split(regex);
        return strings[index];

    }

    public void pickDaysWeek(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);

    }

    public void selectElements (By firstSelectionElement, By secondSelectionElement){
        Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL);
        a.pause(500);
        a.moveToElement(find((By) firstSelectionElement)).click();
        a.pause(500);
        a.moveToElement(find((By) secondSelectionElement)).click();
        a.pause(500);
        a.build().perform();


    }



}


