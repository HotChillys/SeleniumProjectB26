package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2 {
    /*
    TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
     */

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");

        WebElement headerText = driver.findElement(By.tagName("h2"));

        String expectedHeader = "Registration form";
        String actualHeader = headerText.getText();

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("verification of header passed");
        } else {
            System.out.println("verification of header failed");
        }

        WebElement firstName = driver.findElement(By.className("form-control"));

        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstName.getAttribute("placeholder");

        if (actualPlaceHolder.equals(expectedPlaceHolder)) {
            System.out.println("placeholder text verification passed");
        } else {
            System.out.println("placeholder text verification failed");
        }

        driver.quit();
    }
}
