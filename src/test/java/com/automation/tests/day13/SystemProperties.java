package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){
       // System.out.println(System.getProperty("user.dir") );
        System.out.println(System.getProperty("user.dir") + "/pom.xml");
        System.out.println(System.getProperty("os.name"));

        //flexible path to downloads folder
        //System.get.Property("user.home") + "/Downloads";
        System.out.println(System.getProperty("user.home"));

        String pathToDownLoads = System.getProperty("user.home") + "\\Downloads";
        System.out.println(pathToDownLoads);

        System.out.println(System.getProperty("os.arch"));
    }
}
