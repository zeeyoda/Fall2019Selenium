package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By. tagName("h4")).getText();
        if(expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        //let's click on Logout button. It looks like a button, but it id actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkTest instead of linkText
        //linkText = equals()
        //partialLinkText = contains() - complete match is not required
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");
        System.out.println(href);
        System.out.println(className);

        logout.click();
        Thread.sleep(2000);
        // Enter invalid credentials
        driver.quit();
    }
}
