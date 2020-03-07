package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        //below checks if black button is visible and clickable
        if(blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("Clicked on black button");
            blackButton.click();
        }else {
            System.out.println("Failed to click on black button");
            BrowserUtils.wait(5);
        }
            if (blackButton.isSelected()) {
                System.out.println("Passed");
                BrowserUtils.wait(3);
            } else {
                System.out.println("Failed");

        }
            driver.close();
    }
}
