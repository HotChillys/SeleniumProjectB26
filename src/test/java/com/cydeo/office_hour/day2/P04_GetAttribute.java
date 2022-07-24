package com.cydeo.office_hour.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_GetAttribute {
    /*
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/
    3- Click Registration Form
    4- Verify following fields has these default values
            - First name ---> first name
            - Last name  ---> last name
            - Username   ---> username
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");

        // Click Registration Form
        driver.findElement(By.linkText("Registration Form")).click();

        // Verify following fields has these default values
        //  - First name ---> first name
        String first = driver.findElement(By.name("firstname")).getAttribute("placeholder");

        String last = driver.findElement(By.name("lastname")).getAttribute("placeholder");

        String user = driver.findElement(By.name("username")).getAttribute("placeholder");

        System.out.println(first);
        System.out.println(last);
        System.out.println(user);









        driver.quit();
    }
}
