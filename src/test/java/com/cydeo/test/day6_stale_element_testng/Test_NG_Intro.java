package com.cydeo.test.day6_stale_element_testng;

import org.testng.Assert;
import org.testng.annotations.*;

// @Test makes the code run.
// we can also put it on the class level, but it is not practical
// (priority = n) is for deciding which tests runs first

public class Test_NG_Intro {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("after class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }

@Test (priority = 2)
public void test1(){
    System.out.println("Test1 is running");
    String actual = "apple";
    String expected = "apple";
    Assert.assertEquals(actual, expected, "failed");// third argument only displays if test fails
}
@Test (priority = 1, dependsOnMethods = "test1")
public void test2(){
    System.out.println("Test2 is running");
    Assert.assertEquals("Orange", "Orange", "Test did not pass");
}

}
