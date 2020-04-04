package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ziyoda_RegistrationForm {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.findElement(By.name("firstname")).sendKeys("Ziyoda");
        driver.findElement(By.name("lastname")).sendKeys("Mahsut");
        driver.findElement(By.name("username")).sendKeys("zmahsut");
        driver.findElement(By.name("email")).sendKeys("zmahsut@gmail.com");
        driver.findElement(By.name("password")).sendKeys("ziyodamahsut");
        driver.findElement(By.name("phone")).sendKeys("508-495-8956");

        List<WebElement> buttons = driver.findElements(By.name("gender"));
        buttons.get(1).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/1992");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(1);

        driver.close();
    }
}
