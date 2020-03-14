package com.automation.tests.day6DropDowns;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(44);
        BrowserUtils.wait(3);

        //select last option

        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);
        BrowserUtils.wait(3);
    }
}
