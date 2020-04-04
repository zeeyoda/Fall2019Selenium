package com.automation.tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //set up chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriverobject
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");
    }
}
