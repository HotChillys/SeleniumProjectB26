package com.cydeo.test.day4_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1 {
    public static void main(String[] args) {
        /*
TC #3: Practice Cydeo/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cydeo.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/forgot_password");

        //Enter any email into input box
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("abc@gmail.com");

        //Click on Retrieve password
        //Click on Retrieve password
        WebElement retrievePassword = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        retrievePassword.click();

        //Verify URL contains:
        //Expected: “email_sent”
        String expectedUrl = "email-sent";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        // Verify textbox displayed the content as expected.
        //        Expected: “Your e-mail’s been sent!”

        WebElement message = driver.findElement(By.name("confirmation_message"));

        String actualText = message.getText();
        String expectedText = "Your e-mail’s been sent!";

        if(actualText.equals(expectedText))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");




        driver.quit();


// TODO: 2022-06-01







    }
}
