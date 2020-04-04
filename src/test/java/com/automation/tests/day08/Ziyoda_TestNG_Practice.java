package com.automation.tests.day08;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ziyoda_TestNG_Practice {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void teardown() {
        //driver.close();
    }

    @Test
    public void addRemoveElement() {
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        BrowserUtils.wait(5);
        String actual = "Add/Remove Elements";
        String expected = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expected, actual, "Expected didn't match the actual");
    }
}