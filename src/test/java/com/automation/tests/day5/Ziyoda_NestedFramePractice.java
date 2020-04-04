package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ziyoda_NestedFramePractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.id("content"));
        System.out.println(middleFrame.getText());
        BrowserUtils.wait(2);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");

        WebElement leftFrame = driver.findElement(By.tagName("body"));
        System.out.println(leftFrame.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        WebElement bottom = driver.findElement(By.tagName("body"));
        System.out.println(bottom.getText());




        BrowserUtils.wait(2);
        driver.close();
    }
}
