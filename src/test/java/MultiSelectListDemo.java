import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelectListDemo extends SetupDriver {


    protected By selectDropDownList = By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']");
    protected By firstSelectionElement = By.xpath("//*[@id='multi-select']//*[text()='Florida']");
    protected By secondSelectionElement = By.xpath("//*[@id='multi-select']//*[text()='New York']");
    protected By getAllButton = By.xpath("//*[@id='printAll']");
    protected By display = By.xpath("//*[@class='getall-selected']");

    @Test
    public void sixthTest() {
        String expectedText = "Florida,New York";

        find(inputFormMenuItem).click();
        find(selectDropDownList).click();
        selectElements(firstSelectionElement, secondSelectionElement);
        find(getAllButton).click();
        String displayWithText = find(display).getText();
        String actualText = getPartOfString(displayWithText,": ", 1);
        Assert.assertEquals(actualText, expectedText);
    }
}
