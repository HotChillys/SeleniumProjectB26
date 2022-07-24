package com.cydeo.test.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("https://login1.nextbasecrm.com/%22");


                //Expected: Remember me on this computer
                WebElement rememberMeElement = driver.findElement(By.className("login-item-checkbox-label"));

        String actualRememberMeText = rememberMeElement.getText();
        String expectedRememberMeText = "Remember me on this computer";

        System.out.println(actualRememberMeText);

        if(actualRememberMeText.equals(expectedRememberMeText)){
            System.out.println("TC - remember me confirmation - PASSED");
        } else {
            System.out.println("TC - remember me confirmation - FAILED");
        }

        // 4- Verify “forgot password” link text is as expected:Forgot your password?
        WebElement forgotPassElement = driver.findElement(By.className("login-link-forgot-pass"));

        String actualForgotPassText = forgotPassElement.getText();
        String expectedForgotPassText = "Forgot your password?";

        System.out.println(actualForgotPassText);

        if(actualForgotPassText.equals(expectedForgotPassText)){
            System.out.println("TC - forgot Password confirmation - PASSED");
        } else {
            System.out.println("TC - forgot Password confirmation - FAILED");
        }

        //  5- Verify “forgot password” href attribute’s value contains expected:
        //  Expected: forgot_password=yes

        WebElement hrefElement = driver.findElement(By.cssSelector("a[href ='/?forgot_password=yes']"));


        String actualHrefValue = hrefElement.getAttribute("href");
        String expectedHrefValue = "forgot_password=yes";

        System.out.println(actualHrefValue);

        if(actualHrefValue.contains(expectedHrefValue)){
            System.out.println("TC - Href Value confirmation - PASSED");
        } else {
            System.out.println("TC - Href Value confirmation - FAILED");
        }


        driver.quit();
    }
}
