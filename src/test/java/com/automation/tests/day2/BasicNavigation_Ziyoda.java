package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation_Ziyoda{
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driverF = new ChromeDriver();
        driverF.get("htt://facebook.com");
        Thread.sleep(5000);
        String title = driverF.getTitle();
        String expectedResult = "Firefox";
        System.out.println("Expected result is "+title);
        if(expectedResult.equals(title)){
            System.out.println("Test has passed");
        }else{
            System.out.println("Test has failed");
        }
        driverF.close();
    }
}
