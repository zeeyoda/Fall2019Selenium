package com.automation.tests.day08;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
//        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
//        //ChromeOptions - use to customize browser for tests
//        ChromeOptions chromeOptions = new ChromeOptions();
//        //to ignore "Your connection is not private issue"
//        chromeOptions.setAcceptInsecureCerts(true);
//        //provide chromeOptions object into chromedriver constructor
//        driver = new ChromeDriver(chromeOptions);
//        driver.get("http://practice.cybertekschool.com/");
//        driver.manage().window().maximize();
    }
    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails it will throw exception and message will be printed
        //3 parameters: (expected, actual, message in case of error)
        Assert.assertEquals(expected, actual, "Sub-header message doesn't match");
    }

    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("ziyoda2000@yahoo.com", Keys.ENTER);
        String expected = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();
        BrowserUtils.wait(3);
        Assert.assertEquals(expected, actualMessage, "Messages didn't match");
    }
    @Test
    public void checkBoxes(){
        driver.findElement(By.linkText("Checkboxes")).click();

        //locator for specific checkbox, xpath: //input[1]
        //cssSelector: input:nth-of-type(1)
        BrowserUtils.wait(3);
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
    }
    @AfterMethod
    public void teardown(){
        //driver.close();
    }
}
