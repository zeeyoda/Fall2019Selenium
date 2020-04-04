package com.automation.tests.day08;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    //runs only once before @beforemethod and before test
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }

    @Test (priority = 2)
    public void test1(){
        System.out.println("Test1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected, actual);
    }

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test2");
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1 < num2);
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }


}
