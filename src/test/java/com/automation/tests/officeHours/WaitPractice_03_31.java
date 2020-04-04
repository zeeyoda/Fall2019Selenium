package com.automation.tests.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice_03_31 {

    /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123

    Implcit wait - set it 1 time and it will work for every findElement method
                   - NoSuchElementException

   Explicit Wait - we have to declare every time before the interaction with element
                    Expected Condition we are looking for
     */
    private WebDriver driver;

    @Test
    public void testWait(){
       driver = DriverFactory.createDriver("chrome");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("http://qa3.vytrack.com");

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.titleIs("Login"));

        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();

        WebElement accounts = driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::span/following-sibling::a"));

        accounts.click();
    }
}
