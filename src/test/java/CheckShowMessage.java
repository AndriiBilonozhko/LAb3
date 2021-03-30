import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckShowMessage extends SetupDriver {
    protected By enterMessageField = By.id("user-message");
    protected By showMessageButton = By.xpath("//*[text()='Show Message']");
    protected By displayText = By.xpath("//span[@id='display']");

    @Test


    public void CheckShowMessage() {

        String expectedText = "Hello my name is";

        find(inputFormMenuItem).click();
        find(simpleFormDemoMenuItem).click();
        find(enterMessageField).sendKeys(expectedText);
        find(showMessageButton).click();
        String display = find(displayText).getText();
        assertEquals(expectedText, display);


    }


}
