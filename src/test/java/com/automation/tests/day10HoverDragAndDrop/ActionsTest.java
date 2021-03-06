package com.automation.tests.day10HoverDragAndDrop;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //build is needed when we have couple of actions
        //actions must end with .perform()
        actions.moveToElement(img1).pause(1000).
                moveToElement(img2).pause(1000).
                moveToElement(img3).pause(1000).
                build().perform();
        BrowserUtils.wait(3);

        //hover on the first image
        //verify that "name: user1" is displayed
        actions.moveToElement(img1).perform();
        WebElement img1Txt = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(img1Txt.isDisplayed());
    }
    @Test
    public void jQueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");

        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).pause(1000)
                .moveToElement(downloads).pause(1000)
                .click(pdf).build().perform();
    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(expected, actual);

    }
}
