package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
//        RemoteWebDriver driver1 = new FirefoxDriver();
//        RemoteWebDriver driver2 = new SafariDriver();
        //in selenium, everything starts from webdriver interface
        driver.get("http://google.com");// is used to open website
    }
}
