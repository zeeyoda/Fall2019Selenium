package com.automation.tests.day12_Implicit_Explicit_Wait;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
//    @AfterMethod
//    public void teardown(){
//        driver.quit();
//    }
    @Test
    public void checkboxTest() {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //cssSelector path is below
        //  List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        BrowserUtils.wait(2);
        for (WebElement eachbox : checkboxes) {
            BrowserUtils.wait(2);
            Assert.assertTrue(eachbox.isSelected());

        }
    }
    @Test
    public void updateZipCode(){
        WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        String actual = driver.findElement(By.xpath("//tbody//tr[4]//td[9]")).getText();
        String expected = "21233";
        Assert.assertEquals(actual, expected);

        //Vasyl's xpath for finding edit button and click is below
        driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td/input")).click();

        driver.findElement(By.xpath("//tbody//tr[4]//td[13]")).click();
        WebElement zipcodeBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcodeBox.clear();
        zipcodeBox.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "20002");




    }
}
