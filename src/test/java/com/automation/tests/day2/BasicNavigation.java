package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
//        RemoteWebDriver driver1 = new FirefoxDriver();
//        RemoteWebDriver driver2 = new SafariDriver();
        //in selenium, everything starts from webdriver interface
        //ChromeDriver extends RemoteWebDriver --- implements WebDriver
        driver.get("http://google.com");// is used to open website.

        Thread.sleep(3000);//for demo wait 3 seconds

        //method that return page title
        //you can also see it as teb name, in the browser
        String title = driver.getTitle();// returns <title>Some title</title> test
        String expectedTitle = "Google";

        System.out.println("Title is ..."+title);
        if(expectedTitle.equals(title)) {
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }
        driver.close();//to close browser
        //browser cannot close itself
    }
}
