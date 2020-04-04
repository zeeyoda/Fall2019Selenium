package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ziyoda_CheckBoxTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        checkBoxes.get(0).click();
        BrowserUtils.wait(2);
        if(checkBoxes.get(0).isSelected()){
            System.out.println("Test passed, checkbox #1 is selected");
        }else{
            System.out.println("Test failed. checkbox #1 is NOT selected");
        }

        driver.close();
    }
}
