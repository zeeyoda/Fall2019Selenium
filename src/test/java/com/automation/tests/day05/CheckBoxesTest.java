package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Task
        //lets verify 1st checkBox is not selected and 2nd one is selected

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
//        for (int i = 0; i <checkBoxes.size() ; i++) {
//
//         if(checkBoxes.get(i).isSelected()){
//             System.out.println(checkBoxes.get(i)+" is selected");
//         }else{
//             System.out.println(checkBoxes.get(i)+ "checkbox is not selected");
//         }
    if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
        System.out.println("Test Passed");
        }else{
        System.out.println("Test failed");
    }

    WebElement checkBox1 = checkBoxes.get(0);
    checkBox1.click();
    BrowserUtils.wait(2);

    checkBoxes.get(1).click();
    BrowserUtils.wait(2);

    if(checkBox1.isSelected()){
        System.out.println("Test Passed");
        System.out.println("checkbox #1 is selected");
    }else{
        System.out.println("Test failed");
        System.out.println("Checkbox #1 is not selected");
    }
    driver.close();
    }
}
