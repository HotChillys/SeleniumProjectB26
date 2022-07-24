package com.cydeo.test.day8_dropdown_alert;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 extends TestBase {
    /*
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Prompt” button
        4. Send “hello” text to alert
        5. Click to OK button from the alert
        6. Verify “You entered: hello” text is displayed.
     */


    @Test
    public void informationAlert() throws InterruptedException {

        driver.get("http://practice.cydeo.com/javascript_alerts");

        // Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // Send “hello” text to alert
        driver.switchTo().alert().sendKeys("hello");

        // Click to OK button from the alert
        driver.switchTo().alert().accept();

        // Verify “You entered:  hello” text is displayed.
        WebElement text = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String actualText = text.getText();
        String expectedText = "You entered: hello";
        Assert.assertTrue(text.isDisplayed(), "text is not displayed");
        Assert.assertEquals(actualText, expectedText, "text does not match, failed");



    }
}
