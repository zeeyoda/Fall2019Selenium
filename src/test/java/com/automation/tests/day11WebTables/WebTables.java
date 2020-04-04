package com.automation.tests.day11WebTables;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // driver = DriverFactory.createDriver("chrome");
        //instead of using the above we can run the browser without interface as follows
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes the execution twice as fast
        //it does everything except file uploading
        //set it to true to make it work
        chromeOptions.setHeadless(false);//this will run browser without GUI(graphical user interface), makes browser invisible
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() {
        /* //tbody//tr---> to get all rows from table body, excluding table header */
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        for (WebElement eachRow : rows) {
            System.out.println(eachRow.getText());
            BrowserUtils.wait(3);

        }

        //if we get a size of this collection it automatically equals to number of elements
        //expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }

    @Test
    public void getSpecificColumn() {
        // td[5] - column with link
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @Test
    public void deleteRecordWithEmail() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);
        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);


        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());

        List<WebElement> numOfRows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(numOfRows.size(), 3);
    }
    //Write a function that will return column index based on column name
    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {

            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));
            if(actualColumnName.equals(columnName)){
                index = i+1;
                break;
            }
        }
        Assert.assertEquals(index, 3);

    }
    @Test
    public void getSpecificCell(){
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;

        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);
    }

}
