package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //Assertion
        verifyEquals(expected, actual);
    }
    @Test (description = "verify if method can reverse a string")
    public void test(){
        String expected = "elpp";
        String actual = reverseString("apple");
        //it is coming from testNG, JUnit also has this class
        //we can verify any date types here" Strings, primitives, arrays, objects
        //this is to verify if expected equals actual
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void test2(){
            String expected = "rac";
            String actual = reverseString("car");
        Assert.assertEquals(actual, expected);
    }
    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    public static String reverseString(String str){
        String reversed = "";
        for (int i=str.length()-1; i>=0; i--) {
            reversed +=str.charAt(i);
        }
        return reversed;

    }
}
