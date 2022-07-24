package com.cydeo.office_hour.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_ID {
    public static void main(String[] args) {
        /*
         1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/
        3- Click to Multiple Buttons
        4- Click "Don't Click" button
        5- Verify Result is : "Now it's gone!"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");

        //locate multiple button
        WebElement multiButton = driver.findElement(By.partialLinkText("Multiple"));

        // click it
        multiButton.click();

        // click "don't click" button
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));

        dontClickButton.click();
        // verify "now it's gone"

        String result = driver.findElement(By.id("result")).getText();

        if (result.equals("Now it's gone!")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }



        driver.quit();
    }
}
