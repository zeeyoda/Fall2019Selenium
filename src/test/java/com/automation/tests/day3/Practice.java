package com.automation.tests.day3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if(expected.equals(actual)) {
            System.out.println("Test passed");
        } else{
            System.out.println("Test failed");
        }
        //Let's click on logout button. Although it looks like a button, it is actually a link
        //every element with <a> is a link
        //if you have couple spaces in the test, use partialLinkText instead of link text
        //link text is the same as equals()
        //partialLinkText is the same as contains()

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));

        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);

        //let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("wrong");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        WebElement logOutMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(logOutMessage.getText());

        driver.close();

    }
}
