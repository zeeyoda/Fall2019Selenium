package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@gmail.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword");
        driver.findElement(By.name("phone")).sendKeys("571-343-2342");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(1).click();//select male
        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        BrowserUtils.wait(2);
        driver.findElement(By.id("inlineCheckbox2")).click();//checking java button
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);

        String result = driver.findElement(By.tagName("h4")).getText();
        System.out.println(result);
        String lastMessage = driver.findElement(By.tagName("p")).getText();
        System.out.println(lastMessage);
        String actual = result+" "+lastMessage;
        String expected = "Well done! You've successfully completed registration!";
        if(expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();

    }
}
