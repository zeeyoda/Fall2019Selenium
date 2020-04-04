package com.automation.tests.day08;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNG_Demo {
    @BeforeSuite
            public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public static void beforeclass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }
    @Test (priority = 2)
    public void test1(){
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word1, word2);
    }
    @Ignore
    @Test
    public void test2(){
        String word1 = "javascript";
        String word2 = "java";
        System.out.println("Test2");
        Assert.assertEquals(word1, word2);
    }
    @Test (priority = 1)
    public void  test3(){
        Assert.assertTrue(15>10);
        System.out.println("15 > 10");
        throw new SkipException("Just wanted to skip");
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
        System.out.println("After Test");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("After suite");
    }
}
