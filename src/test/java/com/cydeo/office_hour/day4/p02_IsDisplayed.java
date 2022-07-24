package com.cydeo.office_hour.day4;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class p02_IsDisplayed extends TestBase {

    @Test
    public void isDisplayed() {

        driver.get("http://practice.cydeo.com/registration_form");

        String xpathLocator = "//small[.='first name must be more than 2 and less than 64 characters long']";

        WebElement errorMessage = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));

        //errorMessage.click(); // this will throw an exception (not intractable)

        System.out.println(errorMessage.getText());
        System.out.println(errorMessage.isDisplayed());

        driver.findElement(By.name("firstname")).sendKeys("a");

        System.out.println(errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());

    }
}
