package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.manage().window().maximize();

        Thread.sleep(2000);//for demo wait 3 seconds

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
        //navigate to another page within same window
        //driver.navigate().to() is the sam as driver.navigate.get()
        driver.navigate().to("http:amazon.com");
        Thread.sleep(2000);
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        //comeback to google
        driver.navigate().back();
        Thread.sleep(2000);

        verifyEquals(driver.getTitle(), "Google");

        //move forward in the browser history

        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println("Title "+driver.getTitle());
        //returns the title of the page

        //getting current url
        System.out.println("URL: "+driver.getCurrentUrl());

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();//to close browser
        //browser cannot close itself
    }
    public static void verifyEquals(String str1, String str2){
        if(str1.equals(str2)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }
}
