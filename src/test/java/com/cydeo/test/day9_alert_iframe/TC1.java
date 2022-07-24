package com.cydeo.test.day9_alert_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends TestBase {
    /*
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Prompt” button
        4. Send “hello” text to alert
        5. Click to OK button from the alert
        6. Verify “You entered: hello” text is displayed.
     */

    @Test
    public void jsPrompt(){

        driver.get("http://practice.cydeo.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText, expectedText, "FAIL");

        System.out.println("You entered: hello is displayed? = " + driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());


    }


}
