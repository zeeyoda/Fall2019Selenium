package com.automation.tests.day05;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);
        //before looking for that element, we need to jump to that frame
        //it is like an outer layer
        driver.switchTo().frame("mce_0_ifr");
        //then we go to the inner layer
        WebElement textInput = driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());
        BrowserUtils.wait(4);
        //deleting the text
        textInput.clear();
        textInput.sendKeys("Hello, World!");
        BrowserUtils.wait(4);


        //exit from the frame
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        driver.close();

    }
}
