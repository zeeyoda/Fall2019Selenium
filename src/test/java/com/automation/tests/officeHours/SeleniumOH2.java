package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        //WebElement is an interface in selenium/java and it has many useful methods
        //sendKeys is one of the methods: .sendKeys("value that we want to send - input")
       WebElement search = driver.findElement(By.id("search_query_top"));
       search.sendKeys("tshirt", Keys.ENTER);
       Thread.sleep(2000);

       WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
       String errorText = error.getText();
       //.getText()  -> returns String text from the element
        System.out.println("Error text "+errorText);
        Thread.sleep(2000);
        //NoSuchElementException  - it means that we could not locate such element
        search = driver.findElement(By.id("search_query_top"));
        search.clear();
        //.clear() - (void) it will delete any values from input box
        search.sendKeys("t-shirt", Keys.ENTER);
        //StaleElementReferenceException - element is old/stale
        //we want to find this element again or sometimes refresh page

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement count  = driver.findElement(By.className("product-count"));
        String itemsFound = count.getText();

        System.out.println("items found: "+itemsFound);
    }
}
