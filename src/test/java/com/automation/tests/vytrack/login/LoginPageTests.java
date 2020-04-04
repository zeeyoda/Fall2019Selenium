package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//static import of all assertions
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    //https is a secure version of http protocol
    //http  - hyper text protocol that every single is using nowaways, this data is plain text and easy to hack
    //https - data encrypted, to change for hackers to retrieve information
    private String URL = "https://qa2.vytrack.com/user/login";
    //credentials for store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // > css selector means same thing as / in xpath - direct child
    private By getWarningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    @Test (description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName() {
        //By is a class--> when we find an element by using By.... methods
        //it returns By data type and we stored it in to By as below statement.
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        WebElement warningElement = driver.findElement(getWarningMessageBy);
        assertTrue(warningElement.isDisplayed());
        String expected = "Invalid user name or password";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }
    @Test
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual, expected, "Page title is not correct");



    }
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void teardown(){
        //if webdriver object is alive
        if(driver != null)
            //close browser, close session
        driver.quit();
        //destroy driver object for sure
        driver = null;
    }
}
