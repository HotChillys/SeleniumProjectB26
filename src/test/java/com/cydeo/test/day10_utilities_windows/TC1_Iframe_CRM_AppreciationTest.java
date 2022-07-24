package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_Iframe_CRM_AppreciationTest extends TestBase {

    @Test
    public void sendingMsg() throws InterruptedException {
/*
    1- Open a chrome browser
    2- Go to: https://login2.nextbasecrm.com/
    3- Login Homepage ( Login with valid username and
    password)
    4- Click the MORE tab and select APPRECIATION
    5- Write an Appreciation message
    6- Click the SEND button
    7- Verify the Appreciation message is displayed on
    the feed
 */
        driver.get("https://login2.nextbasecrm.com/");

        //Login Homepage ( Login with valid username and password)
        // helpdesk48@cybertekschool.com & UserUser
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk48@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser" + Keys.ENTER);

        // 4- Click the MORE tab and select APPRECIATION // one day
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")).click();
        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        WebElement textBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        textBox.sendKeys("one day");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();

        Thread.sleep(2000);

        // Verify the Appreciation message is displayed on the feed
        String actualText = driver.findElement(By.xpath("//div[.='one day']")).getText();
        String expectedText = "one day";

        Assert.assertEquals(actualText, expectedText);





    }

}
