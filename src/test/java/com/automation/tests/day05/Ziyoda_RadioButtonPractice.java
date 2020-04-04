package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Ziyoda_RadioButtonPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("input"));

        for(WebElement button: buttons){
            boolean isSelected = button.isSelected();
            System.out.println(button.getAttribute("id")+" is selected --->> "+isSelected);

            if(button.isEnabled()) {
                button.click();
                System.out.println("Clicked on: "+button.getAttribute("id")+" button");
                System.out.println();
                BrowserUtils.wait(1);
            }else{
                System.out.println(button.getAttribute("id")+" button is not clickable.");
            }
        }
        driver.close();


    }
}
