package com.automation.tests.day06_DropDowns;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select languages = new Select(driver.findElement(By.name("Languages")));
       boolean isMultiple = languages.isMultiple();
        System.out.println(isMultiple);

        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        //verify above options are selected
        //let's get all selected options
        List<WebElement>  selectedlanguages = languages.getAllSelectedOptions();

        for(WebElement eachLanguage : selectedlanguages){
            System.out.println(eachLanguage.getText());
        }
        BrowserUtils.wait(2);

        languages.deselectByVisibleText("Java");//to unselect one selection
        BrowserUtils.wait(2);
        languages.deselectAll();

        BrowserUtils.wait(2);
        driver.quit();
    }
}
