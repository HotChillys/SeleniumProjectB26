package com.cydeo.test.extra_task.smartbear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartbearLogin {
    /*
        Mini-Task: CREATE A CLASS à SmartBearUtils
        • Create a method called loginToSmartBear
        • This method simply logs in to SmartBear when you call it.
        • Accepts WebDriver type as parameter
     */

    public static void login(WebDriver driver) {
        String username = "Tester";
        String password = "test";

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(username);//username
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password); // password
        driver.findElement(By.cssSelector(".button")).click(); // login button

    }




}
