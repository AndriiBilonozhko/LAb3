import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDays extends SetupDriver {

    protected By selectDropDownList = By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']");
    protected By dayList = By.xpath("//*[@id='select-demo']");
    protected By displayedText = By.xpath("//*[@class='selected-value']");

    @Test
    public void fifthTest() {
        String expectedDay = "Friday";

        find(inputFormMenuItem).click();
        find(selectDropDownList).click();
        WebElement selector = find(dayList);
        pickDaysWeek(selector, "Friday");
        String daySelection = find(displayedText).getText();
        String actualDay = getPartOfString(daySelection, ":- ", 1);
        Assert.assertEquals(actualDay, expectedDay);

    }
}
