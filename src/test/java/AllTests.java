import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllTests extends SetupDriver {











    @Test(enabled = false)

    public void seventhTest() {

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement ajaxForm = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Ajax Form Submit']"));
        ajaxForm.click();
        waitDriver();
        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='btn-submit']"));
        waitDriver();
        clickWithJS(buttonSubmit);
        WebElement fieldName = driver.findElement(By.xpath("//*[@id='title']"));
        String actualResult = "rgb(255, 0, 0);";
        String style = fieldName.getAttribute("style");
        String[] s = style.split("solid ");
        Assert.assertEquals(s[1], actualResult);


    }

    @Test(enabled = false)

    public void eighthTest() {

        WebElement datePickers = driver.findElement(By.xpath("//*[text()='Date pickers']"));
        datePickers.click();
        WebElement bootsStrap = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Bootstrap Date Picker']"));
        bootsStrap.click();
        WebElement calendarClick = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
        String expectedDate = yesterdayDate(calendarClick);
        String actualResult = calendarClick.getAttribute("value");
        Assert.assertEquals(actualResult, expectedDate);

    }

    @Test(enabled = false)
    public void ninthTest() {

        WebElement table = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table']"));
        table.click();
        WebElement tableDataSearch = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table Data Search']"));
        tableDataSearch.click();
        WebElement inputForm = driver.findElement(By.xpath("//*[@id='task-table-filter']"));
        waitDriver();
        inputForm.sendKeys("Emily John");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='task-table']//tbody//tr[not(contains(@style,'display: none;'))]"));
        Assert.assertEquals(elements.size(), 1);
        String expectedResult = "4 Bootstrap 3 Emily John in progress";
        Assert.assertEquals(expectedResult, elements.get(0).getText());
    }

    @Test(enabled = false)
    public void tenthTest() {
        WebElement table = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table']"));
        table.click();
        WebElement tableFilter = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table Filter ']"));
        tableFilter.click();
        WebElement orangeButton = driver.findElement(By.xpath("//button[contains(text(), 'Orange')]"));
        orangeButton.click();
        List<WebElement> elementsOrange = driver.findElements(By.xpath("//tbody//i[contains(@style,'color:orange;')]"));
        for (WebElement element : elementsOrange) {
            Assert.assertTrue(element.getAttribute("style").contains("orange"));
        }

    }

    @Test(enabled = false)
    public void eleventhTest() {

        WebElement alertModuls = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Alerts & Modals']"));
        alertModuls.click();
        WebElement jsAlest = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Javascript Alerts']"));
        jsAlest.click();
        WebElement buttonClick = driver.findElement(By.xpath("//*[@id='confirm-demo']/parent::div/button"));
        buttonClick.click();
        driver.switchTo().alert().dismiss();
        String display = driver.findElement(By.xpath("//*[@id='confirm-demo']")).getText();
        Assert.assertEquals(display, "You pressed Cancel!");
    }

    @Test(enabled = false)
    public void twelfthTest() {
        WebElement listBox = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='List Box']"));
        listBox.click();
        WebElement bootstrap = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Bootstrap List Box']"));
        bootstrap.click();
        WebElement morbiLeoRisus = driver.findElement(By.xpath("//ul[@class='list-group']//li[3]"));
        morbiLeoRisus.click();
        WebElement rightButton = driver.findElement(By.xpath("//button[contains(@class,'right')]"));
        rightButton.click();
        List<WebElement> elementMorbi = driver.findElements(By.xpath("//div[@class='well']//ul//li[6]"));
        String expectedResult = "Morbi leo risus";
        Assert.assertEquals(expectedResult, elementMorbi.get(0).getText());
    }

    @Test(enabled = false)
    public void thirteenthTest() {
        WebElement listBox = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='List Box']"));
        listBox.click();
        WebElement jQueryListBox = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='JQuery List Box']"));
        jQueryListBox.click();
        Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL);
        WebElement alisa = driver.findElement(By.xpath("//*[text()='Alice']"));
        alisa.click();
        WebElement laura = driver.findElement(By.xpath("//*[text()='Laura']"));
        laura.click();
        WebElement giovanna = driver.findElement(By.xpath("//*[text()='Giovanna']"));
        giovanna.click();
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();
        String alisaResult = driver.findElement(By.xpath("//select[contains(@class, 'pickListResult')]//*[text()='Alice']")).getText();
        String lauraResult = driver.findElement(By.xpath("//select[contains(@class, 'pickListResult')]//*[text()='Laura']")).getText();
        String giovannaResult = driver.findElement(By.xpath("//select[contains(@class, 'pickListResult')]//*[text()='Giovanna']")).getText();
        String alisaExpectResult = "Alice";
        String lauraExpectResult = "Laura";
        String giovannaExpectResult = "Giovanna";
        Assert.assertEquals(alisaResult, alisaExpectResult);
        Assert.assertEquals(lauraResult, lauraExpectResult);
        Assert.assertEquals(giovannaResult, giovannaExpectResult);
    }

    @Test(enabled = false)

    public void fourteenthTest() throws InterruptedException {
        WebElement other = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Others']"));
        other.click();
        WebElement dynamicDataLoading = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Dynamic Data Loading']"));
        dynamicDataLoading.click();
        WebElement getButton = driver.findElement(By.xpath("//button[@id='save']"));
        getButton.click();
        Thread.sleep(5000);
        WebElement foto = driver.findElement(By.xpath("//div[@id='loading']/img"));
        WebElement firstName = driver.findElement(By.xpath("//div[@id='loading']/br[2]"));
        WebElement lastName = driver.findElement(By.xpath("//div[@id='loading']/br[4]"));
        Assert.assertTrue(foto.isDisplayed());
        Assert.assertTrue(firstName.isDisplayed());
        Assert.assertTrue(lastName.isDisplayed());
    }
}



    
    

