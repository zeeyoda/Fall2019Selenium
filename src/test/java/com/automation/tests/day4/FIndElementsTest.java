package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FIndElementsTest {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link:links) {
            System.out.println(link.getText());

        }

        Thread.sleep(3000);
        driver.quit();
    }
}
