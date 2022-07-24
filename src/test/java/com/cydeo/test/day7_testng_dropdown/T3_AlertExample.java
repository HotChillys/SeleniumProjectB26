package com.cydeo.test.day7_testng_dropdown;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_AlertExample extends TestBase {

    @Test
    public void alertTest(){
/*        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
       3. Click to “Click for JS Alert” button
        4. Click to OK button from the alert
        5. Verify “You successfully clicked an alert” text is displayed.
      */

        // 2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

        // 4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert(); // this navigates to the pop-up alert
        alert.accept(); // this clicks ok button

        //5. Verify “You successfully clicked an alert” text is displayed.
        String actualText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualText, "You successfully clicked an alert", "FAIL");





    }
}
