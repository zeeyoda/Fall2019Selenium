package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ziyoda_RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(4);


        WebElement blackButton = driver.findElement(By.id("black"));

        if(blackButton.isEnabled() && blackButton.isDisplayed()){
            System.out.println("Click on black button -  test passed");
            blackButton.click();
            BrowserUtils.wait(5);
        }else{
            System.out.println("Test failed");
        }

        if(blackButton.isSelected()){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }



        BrowserUtils.wait(5);
        driver.close();
    }
}
