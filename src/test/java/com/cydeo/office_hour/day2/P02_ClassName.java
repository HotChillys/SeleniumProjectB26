package com.cydeo.office_hour.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_ClassName {
    /*
        1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/
    3- Get Text of Test Automaton Practice
    4- Locate A/B Testing
    5- Click on A/B Testing
    6- Verify title is "No A/B Test"
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");

        //Get Text of Test Automaton Practice
       WebElement element = driver.findElement(By.className("h1y"));
        String testFromElement = element.getText();
        System.out.println(testFromElement);

        //Locate A/B Testing
        WebElement abTesting = driver.findElement(By.partialLinkText("A/B Testing"));

        //Click on A/B Testing
        abTesting.click();

        // Verify title is "No A/B Test"
        String title = driver.getTitle();

        if (title.equals("No A/B Test")){
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        System.out.println("test");
        driver.quit();
    }
}
