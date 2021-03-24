import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends SetupDriver {

    public void handlePopupWindow() {
        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("at-cv-lightbox-close")));
            WebElement openWindow = driver.findElement(By.id("at-cv-lightbox-close"));
            openWindow.click();
        } catch (Exception a) {
            System.out.println("window not open");
        }
    }

    @Test
    public void firstTest() {
        handlePopupWindow();
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
        handlePopupWindow();

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
        handlePopupWindow();
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

        handlePopupWindow();
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
        Assert.assertEquals(display, "Sex : Male\n" +
                "Age group: 15 - 50");


    }

    @Test
    public void fiveTest(){
        handlePopupWindow();
        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement dropDownList = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']"));
        dropDownList.click();
        WebElement dayList = driver.findElement(By.xpath("//*[@id='select-demo']"));
        dayList.click();
        WebElement friday = driver.findElement(By.xpath("//*[@id='select-demo']//*[text()='Friday']"));
        friday.click();
        String dayListText = dayList.getText();
        Assert.assertEquals(dayListText, "Friday");
    }
}



    
    

