import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoInputFields extends SetupDriver {
    protected By enterFirstMessage = By.xpath("//*[@id='sum1']");
    protected By enterSecondMessage = By.xpath("//*[@id='sum2']");
    protected By getTotalButton = By.xpath("//*[text()='Get Total']");
    protected By displayValue = By.xpath("//span[@id='displayvalue']");

    @Test

    public void TwoInputFields() {
        int firstValue = 5;
        int secondValue = 2;
        int expectedResult = firstValue + secondValue;

        find(inputFormMenuItem).click();
        find(simpleFormDemoMenuItem).click();
        find(enterFirstMessage).sendKeys("5");
        find(enterSecondMessage).sendKeys("2");
        find(getTotalButton).click();

        String actualDisplayValue = find(displayValue).getText();
        assertEquals(Integer.parseInt(actualDisplayValue), expectedResult);
    }
}
