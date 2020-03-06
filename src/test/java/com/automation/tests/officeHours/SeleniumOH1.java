package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
    /*
    -Iterator
        -List, Set, Map and other types of collections can use Iterator class to iterate over that collection
        -List has indexes (for i, for each, while, Iterator)
        -Map (for each, Iterator - to loop through keys)
    -Basic Selenium Navigations
         */
    public static void main(String[] args) throws Exception {

        //Create ArrayList and iterate over them

        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruit");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator list = keysToSearch.iterator();
        //iterator() - return Iterator type which we can use with all iterator methods
        while(list.hasNext()){
            System.out.println("* "+list.next());
        }
        System.out.println("----------------------------------------------------------------");
        //Create map with <String, String>
        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Brian");
        personalInfo.put("studentID", "123456");
        personalInfo.put("major", "computer science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while(mapIterator.hasNext()){
            //I would like to print each key with its value

            String key = mapIterator.next();
            System.out.println(key+":"+personalInfo.get(key));
        }
        //Selenium
        /*
        In Selenium we use 8 types of locators
        -id - is always unique
        -class -classname
        -name
        -tag - every element will have a tag

         below will only work with the link
        -linktext
        -partial linktext

        locator that is using html (syntax)
        -css
        -xpath
         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://etsy.com");

        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        searchBar.sendKeys("handbag");
       driver.findElement(By.xpath("//button[@value='Search']")).click();
        Thread.sleep(2000);

        driver.close();

    }
}
