package com.automation.tests.day8;

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

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearch(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By. tagName("h3"));
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        for (WebElement searchItem:searchItems) {
            String var = searchItem.getText();
            if(!var.isEmpty()){
                System.out.println(var);
                //verify each search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }

        }
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void teardown(){
        //close driver and destroy WebDriver object
        driver.quit();
    }
}