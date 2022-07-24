package com.cydeo.test.day4_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Xpath_css_isDisplayed {
    public static void main(String[] args) {
 /*
        TC #1: XPATH and cssSelector Practices
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/forgot_password
        3. Locate all the WebElements on the page using XPATH and/or CSS
        locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered by Cydeo text
        4. Verify all web elements are displayed.
 */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");

        //“Home” link
        WebElement home = driver.findElement(By.cssSelector("a.nav-link"));

        WebElement homeXpath = driver.findElement(By.xpath("//a[.='Home']"));

        //“Forgot password” header
        WebElement forgotPassword = driver.findElement(By.tagName("h2"));

        // “E-mail” text
        WebElement email = driver.findElement(By.tagName("label"));

        //E-mail input box
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));

        //“Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));

        //“Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //Verify all web elements are displayed
        System.out.println("home.isDisplayed() = " + home.isDisplayed());
        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());
        System.out.println("email.isDisplayed() = " + email.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());
        System.out.println();
        System.out.println(homeXpath.isDisplayed());


        driver.quit();
    }
}
