package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homework1 {
    /*
    TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
    1- Open a chrome browser
    2- Go to: https://login1.nextbasecrm.com/
    3- Verify “remember me” label text is as expected:
    Expected: Remember me on this computer
    4- Verify “forgot password” link text is as expected:
    Expected: Forgot your password?
    5- Verify “forgot password” href attribute’s value contains expected:
    Expected: forgot_password=yes
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        //  Verify “remember me” label text is as expected:
        //    Expected: Remember me on this computer
        String rememberMe = driver.findElement(By.cssSelector("label[for='USER_REMEMBER']")).getText();
        if (rememberMe.equals("Remember me on this computer")){
            System.out.println("Remember me passed");
        } else {
            System.out.println("Remember me failed");
        }

 //       // Verify “forgot password” link text is as expected:
        //    Expected: Forgot your password?
        String forgotPassword = driver.findElement(By.className("login-link-forgot-pass")).getText();
        if (forgotPassword.equalsIgnoreCase("Forgot your password?")){
            System.out.println("Forgot your password passed");
        } else {
            System.out.println("Forgot your password failed");
        }

        //Verify “forgot password” href attribute’s value contains expected:
        //    Expected: forgot_password=yes
        String forgotPasswordHref = driver.findElement(By.cssSelector("a.login-link-forgot-pass")).getAttribute("href");
        if (forgotPasswordHref.contains("forgot_password=yes")){
            System.out.println("yes passed");
        } else {
            System.out.println("href does not contain that string");
        }









        driver.quit();
    }
}
