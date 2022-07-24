package com.cydeo.office_hour.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_TagName {
    /*
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/
        3- Verify first link text is "Home"
     */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");

        //Verify first link text is "Home"
        String linkText = driver.findElement(By.tagName("a")).getText();
        System.out.println(linkText);

        if (linkText.equals("Home")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        driver.quit();

        // TODO: 2022-05-25 study this





    }
}
