package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(3000);

        //every window has some id, this id calls window handle
        //based on window handle,  we can switch between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        //getWindowHandles() - returns id's of all currently open windows
        //Set - doesn't allow duplicates

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("Before switch = "+driver.getCurrentUrl());

        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equal to old window id
        for (String windowID:windowHandles     ) {
            if(!windowID.equals(windowHandle)){
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("After switch = " +driver.getCurrentUrl() );

        driver.close();
    }
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
