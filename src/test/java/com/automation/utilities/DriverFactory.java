package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    /**
     * This method return webdriver object based on browser type
     * if you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */
    public static WebDriver createDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();//version("79.00").
            return new ChromeDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
        }
    }
}
