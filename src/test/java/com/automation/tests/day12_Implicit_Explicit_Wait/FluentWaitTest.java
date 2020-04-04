package com.automation.tests.day12_Implicit_Explicit_Wait;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait = new FluentWait<>(driver).
                                withTimeout(Duration.ofSeconds(10)).
                                pollingEvery(Duration.ofSeconds(3)).
                                ignoring(NoSuchElementException.class);

        //we added explicit wait below as without the below 2 lines our test fails. FluentWait didn't work
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        //Anonymous - class without name one shot with lambda expression
        WebElement submitBtn = wait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));

        //Anonymous - class without name ---> longer way
//        WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>(){
//            @Override
//            public WebElement apply(WebDriver webDriver){
//                return driver.findElement(By.xpath("//button[text()='Submit']"));
//            }
//        });
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        submitBtn.click();

    }
}
