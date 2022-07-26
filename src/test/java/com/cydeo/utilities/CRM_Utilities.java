package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CRM_Utilities {
    /*
        TC : Create utility methods for CRM_Utilities class
        1. Create a new method for login
        2. Create a method to make CRM Login test logic re-usable
        3. When method is called, it should simply login

        This method should have at least 2 overloaded versions.

        Method #1 info:
        • Name: login_crm()
        • Return type: void
        • Arg1: WebDriver

        Method #2 info:
        • Name: login_crm()
        • Return type: void
        • Arg1: WebDriver
        • Arg2: String username
        • Arg3: String password
     */

    public static void crm_login(WebDriver driver){
        driver.get("https://login2.nextbasecrm.com/");

        //Login Homepage ( Login with valid username and password)
        // helpdesk48@cybertekschool.com & UserUser
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk48@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser" + Keys.ENTER);
    }

    public static void crm_login(WebDriver driver, String username, String password) {
        driver.get("https://login2.nextbasecrm.com/");

        //Login Homepage ( Login with valid username and password)
        // helpdesk48@cybertekschool.com & UserUser
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password + Keys.ENTER) ;
    }



}
