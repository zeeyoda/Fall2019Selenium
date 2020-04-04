package com.automation.tests.day07_Xpath_cssSelector;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZIyoda_XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);
        //tagName[@attribute='value']
        //<button class="btn btn-primary" onclick="button1()">Button 1</button>

        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
    }
}
