import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioBuutonCheck extends SetupDriver {

    protected By radioButtons = By.xpath("//ul[@id='treemenu']//a[text()='Radio Buttons Demo']");
    protected By sexOnGroupRadioButtonDemoField = By.xpath("//*[@class='col-md-6 text-left']//*[@class= 'panel panel-default'][2]//*[text()='Male']");
    protected By AgeGroupOnGroupRadioButtonDemoField = By.xpath("//*[@class='panel panel-default']//*[@class='radio-inline'][3]");
    protected By getValueButton = By.xpath("//*[text()='Get values']");
    protected By displayWithText = By.xpath("//*[@class='groupradiobutton']");

    @Test

    public void fourthTest() {


        find(inputFormMenuItem).click();
        find(radioButtons).click();
        find(sexOnGroupRadioButtonDemoField).click();
        find(AgeGroupOnGroupRadioButtonDemoField).click();
        find(getValueButton).click();
        String actualText = find(displayWithText).getText();
        Assert.assertEquals(actualText, "Sex : Male\n" + "Age group: 15 - 50");


    }


}
