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
            System.out.println(link.getAttribute("href"));
            System.out.println();
        }
        for (int i = 1; i <links.size(); i++) {
            links.get(i).click();
           // Thread.sleep(500);
            driver.navigate().back();
           // Thread.sleep(500);
            //we need to refresh list as when we navigate back list becomes old, therefore refresh is needed
            links = driver.findElements(By.tagName("a"));

        }

       // Thread.sleep(1000);
        driver.quit();
    }
}
