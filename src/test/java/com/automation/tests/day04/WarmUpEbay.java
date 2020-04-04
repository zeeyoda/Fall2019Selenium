package com.automation.tests.day04;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUpEbay {
    static WebDriver driver;
    public static void main(String[] args) throws Exception{

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        //ebayTest();
        //amazonTest();
        wikiTest();

    }
    public static void ebayTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("watch");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult = driver.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText().split(" ")[0]);
        driver.quit();
    }
    public static void amazonTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("dog leash", Keys.ENTER);
        Thread.sleep(3000);
        String title = driver.getTitle();
        if(title.contains("dog")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        driver.quit();
    }

    public static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(4000);
        String link = driver.getCurrentUrl(); // to get link as a String
        //verify url ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();

    }
}
