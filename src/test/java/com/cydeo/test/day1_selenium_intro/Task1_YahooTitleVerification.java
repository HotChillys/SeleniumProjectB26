package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {
        /*
        TC #1: Yahoo Title Verification
        1. Open Chrome browser
        2. Go to https://www.yahoo.com/
        3. Verify title:
        Expected: Yahoo
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        // actual title comes from selenium
        String actualTitle = driver.getTitle();

        //expected title comes from requirements
        String expectedTitle = "Yahoo";

        if (driver.getTitle().startsWith(expectedTitle)) {
            System.out.println("Title verification Passed");
        } else {
            System.out.println("Title verification Failed");
        }

        driver.quit();






    }
}
