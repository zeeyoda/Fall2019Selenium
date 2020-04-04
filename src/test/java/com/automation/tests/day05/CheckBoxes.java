package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click();
        BrowserUtils.wait(2);
        if(checkBoxes.get(1).isDisplayed() && checkBoxes.get(1).isEnabled() && (!checkBoxes.get(1).isSelected())) {
            //if checkbox is not selected then click on it
            checkBoxes.get(1).click();
        }
        BrowserUtils.wait(2);



        driver.close();
    }
}
