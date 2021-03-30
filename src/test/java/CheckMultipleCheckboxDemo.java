import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckMultipleCheckboxDemo extends SetupDriver {
    protected By checkboxDemo = By.xpath("//ul[@id='treemenu']//a[text()='Checkbox Demo']");
    protected By optionOneClick = By.xpath("//*[@class='cb1-element'][1]");
    protected By optionTreeClick = By.xpath("//input[@class='cb1-element']/following::div[2]//input");

    @Test

    public void treeTest() {

        find(inputFormMenuItem).click();
        find(checkboxDemo).click();
        WebElement optionOne = find(optionOneClick);
        optionOne.click();
        WebElement optionTree = find(optionTreeClick);
        optionTree.click();
        assertTrue(optionOne.isSelected());
        assertTrue(optionTree.isSelected());

    }
}
