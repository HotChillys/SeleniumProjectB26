package com.cydeo.test.day8_dropdown_alert;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_alert extends TestBase {
    /*
        TC #2: Confirmation alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Confirm” button
        4. Click to OK button from the alert
        5. Verify “You clicked: Ok” text is displayed.
     */

    @Test
    public void confirmAlert() {

        driver.get("http://practice.cydeo.com/javascript_alerts");

        // 3. Click to “Click for JS Confirm” button
        //WebElement confirm =
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        // 4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert(); //Alert is javaScript, it doesn't appear in HTML
        alert.accept();

        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "You clicked: Ok";
        Assert.assertEquals(actualText, expectedText, "FAIL");

    }
}
