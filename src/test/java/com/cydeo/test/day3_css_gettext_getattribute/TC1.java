package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1 {
    public static void main(String[] args) {
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

PS: Inspect and decide which locator you should be using to locate web
elements.
 */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("incorrect");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

        WebElement login = driver.findElement(By.className("login-btn"));
        login.click();

        WebElement errorMsg = driver.findElement(By.className("errortext"));

        String expectedText = "Incorrect login or password";
        String actualText = errorMsg.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();



    }
}
