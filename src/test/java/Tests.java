import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tests extends SetupDriver {


    @Test
    public void firstTest() {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("at-cv-lightbox-close")));
            WebElement openWindow = driver.findElement(By.id("at-cv-lightbox-close"));
            openWindow.click();
        } catch (Exception a) {
            System.out.println("window not open");
        }
        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement simpleForm = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']"));
        simpleForm.click();
        WebElement enterMessage = driver.findElement(By.id("user-message"));
        enterMessage.sendKeys("Hello, my name is");


    }


}



    
    

