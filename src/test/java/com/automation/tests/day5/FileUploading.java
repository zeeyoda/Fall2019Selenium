package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        System.out.println(filePath);

        String scoobie = "C:\\Users\\ziyod\\OneDrive\\Desktop\\59721be09d0918319c32a058.jfif";
        System.out.println(scoobie);

        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(5);

        driver.quit();
    }
}
