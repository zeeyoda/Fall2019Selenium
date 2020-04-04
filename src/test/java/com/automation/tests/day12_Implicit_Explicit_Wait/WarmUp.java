package com.automation.tests.day12_Implicit_Explicit_Wait;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarmUp {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // driver = DriverFactory.createDriver("chrome");
        //instead of using the above we can run the browser without interface as follows
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes the execution twice as fast
        //it does everything except file uploading
        //set it to true to make it work
        chromeOptions.setHeadless(false);//this will run browser without GUI(graphical user interface), makes browser invisible
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void verifyLastNameSorted() {
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
    }
    @Test
    public void verifyFirstNameSorted(){
        driver.findElement(By.xpath("//table[1]//*[text()='First Name']"));
        List<WebElement> names = driver.findElements(By.xpath("//table[1]//tbody//td[2]"));
        for (int i = 0; i < names.size() - 1; i++) {
            String namesFirst = names.get(i).getText();
            String namesSecond = names.get(i+1).getText();
            Assert.assertTrue(namesFirst.compareTo(namesSecond) >= 0);
        }
    }
    @Test
    public void table_test_compare() {
        List<WebElement> first_names1 = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody//td[2]"));
        List<String> first_names = new ArrayList<>();
        for (WebElement first_name_w :
                first_names1) {
            first_names.add(first_name_w.getText());
        }
        List<String> first_names_actual = new ArrayList<>(first_names);
        Collections.sort(first_names);
        System.out.println(first_names);
        System.out.println(first_names_actual);
        Assert.assertTrue(first_names_actual.equals(first_names));
    }
}
