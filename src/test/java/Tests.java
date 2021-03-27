import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static java.sql.DriverManager.getDriver;

public class Tests extends SetupDriver {


    @Test
    public void firstTest() {

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement simpleForm = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']"));
        simpleForm.click();
        WebElement enterMessage = driver.findElement(By.id("user-message"));
        enterMessage.sendKeys("Hello, my name is");
        WebElement showMessage = driver.findElement(By.xpath("//*[text()='Show Message']"));
        showMessage.click();
        String display = driver.findElement(By.xpath("//span[@id='display']")).getText();
        Assert.assertEquals("Hello, my name is", display);

    }

    @Test

    public void secondTest() {


        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement simpleForm = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']"));
        simpleForm.click();
        WebElement enterFirstMessage = driver.findElement(By.xpath("//*[@id='sum1']"));
        enterFirstMessage.sendKeys("5");
        WebElement enterSecondMessage = driver.findElement(By.xpath("//*[@id='sum2']"));
        enterSecondMessage.sendKeys("2");
        WebElement getTotal = driver.findElement(By.xpath("//*[text()='Get Total']"));
        getTotal.click();
        String displayValue = driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
        Assert.assertEquals(Integer.parseInt(displayValue), 7);
    }

    @Test

    public void treeTest() {

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement checkboxDemo = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Checkbox Demo']"));
        checkboxDemo.click();
        WebElement optionOne = driver.findElement(By.xpath("//*[@class='cb1-element'][1]"));
        optionOne.click();
        WebElement optionTree = driver.findElement(By.xpath("//input[@class='cb1-element']/following::div[2]//input"));
        optionTree.click();
        Assert.assertTrue(optionOne.isSelected());
        Assert.assertTrue(optionTree.isSelected());

    }

    @Test

    public void fourthTest() {


        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement radioButtons = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Radio Buttons Demo']"));
        radioButtons.click();
        WebElement sex = driver.findElement(By.xpath("//*[@class='col-md-6 text-left']//*[@class= 'panel panel-default'][2]//*[text()='Male']"));
        sex.click();
        WebElement ageGroup = driver.findElement(By.xpath("//*[@class='panel panel-default']//*[@class='radio-inline'][3]"));
        ageGroup.click();
        WebElement getValues = driver.findElement(By.xpath("//*[text()='Get values']"));
        getValues.click();
        String display = driver.findElement(By.xpath("//*[@class='groupradiobutton']")).getText();
        Assert.assertEquals(display, "Sex : Male\n" + "Age group: 15 - 50");


    }

    @Test
    public void fifthTest() {

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement dropDownList = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']"));
        dropDownList.click();
        Select dayList = new Select(driver.findElement(By.xpath("//*[@id='select-demo']")));
        dayList.selectByVisibleText("Friday");
        String daySelection = driver.findElement(By.xpath("//*[@class='selected-value']")).getText();
        Assert.assertEquals(daySelection, "Day selected :- Friday");

    }

    @Test
    public void sixthTest() {

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement dropDownList = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']"));
        dropDownList.click();
        Actions a = new Actions(driver);
        a.keyDown(Keys.SHIFT);
        a.keyDown(Keys.CONTROL);
        a.moveToElement(driver.findElement(By.xpath("//*[@id='multi-select']//*[text()='New York']"))).click();
        a.moveToElement(driver.findElement(By.xpath("//*[@id='multi-select']//*[text()='Florida']"))).click();
        a.build().perform();
        WebElement getAll = driver.findElement(By.xpath("//*[@id='printAll']"));
        getAll.click();
        String getallSelected = driver.findElement(By.xpath("//*[@class='getall-selected']")).getText();
        Assert.assertEquals(getallSelected, "Options selected are : Florida,New York");
    }

    @Test

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

    @Test

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

    @Test
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

    @Test
    public void tenthTest() {
        WebElement table = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table']"));
        table.click();
        WebElement tableFilter = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Table Filter ']"));
        tableFilter.click();
        WebElement orangeButton = driver.findElement(By.xpath("//button[contains(text(), 'Orange')]"));
        orangeButton.click();
        List<WebElement> elementsOrange = driver.findElements(By.xpath("//tbody//i[contains(@style,'color:orange;')]"));
        String color = "orange;";

    }

    @Test
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

    @Test
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

    @Test
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

    @Test

    public void fourteenthTest(){
        WebElement other = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Others']"));
        other.click();
        WebElement dynamicDataLoading = driver.findElement(By.xpath("//ul[@id='treemenu']//*[text()='Dynamic Data Loading']"));
        dynamicDataLoading.click();
        WebElement getButton = driver.findElement(By.xpath("//button[@id='save']"));
        getButton.click();
        WebElement loading = driver.findElement(By.xpath("//div[@id='loading']"));

    }
}



    
    

