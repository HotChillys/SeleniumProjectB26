package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkNumberOne {
    /*
        TC #3: Back and forth navigation
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
          Expected: Gmail
        5- Go back to Google by using the .back();
        6- Verify title equals:
          Expected: Google
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement gmail = driver.findElement(By.className("gb_d"));
        gmail.click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }

        driver.navigate().back();

        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();

        System.out.println(actualTitle2);

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }


        driver.quit();






    }
}
