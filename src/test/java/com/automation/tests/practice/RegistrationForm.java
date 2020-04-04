package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    //p tag name of success message
    // one locator for all inputs: //label[text()='Label name']/..//input
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By dobBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitle = By.name("job_title");
    //languages
    private By CPlusPLusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By JavaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By JavaScript = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    //sign up button
    private By signUpBy = By.id("wooden_spoon");

        @Test
        public void test1(){
            driver.findElement(firstNameBy).sendKeys("Ziyoda");
            driver.findElement(lastNameBy).sendKeys("Mahsut");
            driver.findElement(userNameBy).sendKeys("testuser");
            driver.findElement(emailBy).sendKeys("test@gmail.com");
            BrowserUtils.wait(3);
            driver.findElement(passwordBy).sendKeys("12345678");
            BrowserUtils.wait(3);
            driver.findElement(phoneBy).sendKeys("330-234-4898");
            BrowserUtils.wait(2);
            driver.findElement(femaleBy).click();
            driver.findElement(dobBy).sendKeys("01/01/1980");
            BrowserUtils.wait(2);

            Select departmentSelect = new Select(driver.findElement(departmentBy));
            departmentSelect.selectByVisibleText("Department of Agriculture");
            BrowserUtils.wait(2);

            Select jobTitleSelect = new Select(driver.findElement(jobTitle));
            jobTitleSelect.selectByVisibleText("SDET");
            BrowserUtils.wait(2);

            driver.findElement(JavaBy).click();
            driver.findElement(signUpBy).click();
            BrowserUtils.wait(5);

            String expected  = "You've successfully completed registration!";
            String actual = driver.findElement(By.tagName("p")).getText();
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void verifyFirstNameLengthTest(){
            driver.findElement(firstNameBy).sendKeys("Z");
            BrowserUtils.wait(3);

            WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

            Assert.assertTrue(warningMessage.isDisplayed());
        }
        @Test
        public void VerifyOnlyLettersPassed(){
            driver.findElement(firstNameBy).sendKeys("123");
            BrowserUtils.wait(3);

            WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
            Assert.assertTrue(warningMessage.isDisplayed());
        }


    @BeforeMethod
    private void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


        @AfterMethod
         public void teardown(){
            driver.quit();
        }


}
