package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ziyoda_FileUpload {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));

        String file = "C:\\Users\\ziyod\\OneDrive\\Desktop\\59721be09d0918319c32a058.jfif";

        fileUpload.sendKeys(file);
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(2);

        driver.close();

    }
}
