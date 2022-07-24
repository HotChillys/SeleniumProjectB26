package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4 {
    public static void main(String[] args) {
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes 3- Verify “Reset password” button text is as expected:
Expected: Reset password
 */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        String expectedResetPassword = "Reset password";

        WebElement resetPassword = driver.findElement(By.cssSelector("button.login-btn"));
        //or //WebElement resetPassword = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String actualResetPassword = resetPassword.getText();

        if (actualResetPassword.equals(expectedResetPassword)) {
            System.out.println("Reset password button test verification passed");
        } else {
            System.out.println("Reset password button test verification failed");
        }

        driver.quit();


    }


}
