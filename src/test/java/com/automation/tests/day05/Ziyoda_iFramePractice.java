package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ziyoda_iFramePractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);
       driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.id("tinymce"));
        BrowserUtils.wait(1);
        text.clear();
        BrowserUtils.wait(1);

        text.sendKeys("Wassup:)");
        //to go back to original html document/layer

        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());



        BrowserUtils.wait(2);
        driver.close();
    }
}
