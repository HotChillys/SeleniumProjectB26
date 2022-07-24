package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {
        /*
            1- Open a Chrome browser
            2- Go to: https://practice.cydeo.com/
            3- Click to A/B Testing from top of the list.
            4- Verify title is:
              Expected: No A/B Test
            5- Go back to home page by using the .back();
            6- Verify title equals:
              Expected: Practice
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
        WebElement abLinkText = driver.findElement(By.linkText("A/B Testing"));
        abLinkText.click();

        //4- Verify title is:
        // Expected: No A/B Test
        String expectedResult = "No A/B Test";
        String actualResult = driver.getTitle();
        if (expectedResult.equals(actualResult)) {
            System.out.println("title verification passed");
        } else {
            System.out.println("title verification failed");
        }

        //5- Go back to home page by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        // Expected: Practice
        expectedResult = "Practice";
        actualResult = driver.getTitle();
        if (expectedResult.equals(actualResult)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }

        driver.quit();

    }
}
