package com.cydeo.office_hour.day5;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority_DependsOn {

    String usename;

    @Test
    public void priority(){
        System.out.println("hello" + usename);
    }
    @Test (priority = 1)
    public void createUser(){
        usename = "Mike";
        System.out.println(usename + " is created");
        Assert.assertEquals("Mike", usename);
    }

    @Test (priority = 2, dependsOnMethods = {"createUser"})
    public void updateUser(){
        usename = "John";
        System.out.println(usename + " is updated");
    }

    @Test (priority = 2, dependsOnMethods = {"createUser"})
    public void deleteUser(){
        System.out.println(usename + " is deleted");
        usename = "";
    }
    @Test@Ignore
    public void ignored(){
        System.out.println("This test case is ignored");
    }
}
