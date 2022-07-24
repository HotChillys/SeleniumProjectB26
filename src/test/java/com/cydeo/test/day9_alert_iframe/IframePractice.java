package com.cydeo.test.day9_alert_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {
    /*
       TC #6: Iframe Task
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/iframe
        3- Clear text from comment body
        4- Type "Hello World" in comment body
        5- Verify "Hello World" text is written in comment body
        6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
     */

    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://practice.cydeo.com/iframe");

        //3- Clear text from comment body
        driver.switchTo().frame("mce_0_ifr"); // locate frame with id

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // locate frame with locator

        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();

        // 4- Type "Hello World" in comment body
        textBox.sendKeys("Hello World");

        // 5- Verify "Hello World" text is written in comment body

        Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "Hello World");

        driver.switchTo().defaultContent();
        //or below to switch back to main frame
        //driver.switchTo().parentFrame();

       WebElement header = driver.findElement(By.xpath("//h3"));

        System.out.println("is header displayed? " + (header.isDisplayed() ? "yes" : "no"));
        Assert.assertTrue(header.isDisplayed(), "Header did not appear");
        Assert.assertEquals(header.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor", "FAIL");

    }


}
