package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework2 {
    /*
    TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //Enter incorrect username into login box:
        WebElement element = driver.findElement(By.cssSelector("input.login-inp"));
        element.sendKeys("Incorrect user name");
        WebElement resetButton = driver.findElement(By.cssSelector("button.login-btn"));
        resetButton.click();

        String error = driver.findElement(By.cssSelector("div.errortext")).getText();

        if (error.equals("Login or E-mail not found")){
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        driver.quit();
    }
}
