package com.cydeo.office_hour.day6;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_Iframe extends TestBase {

    @Test
    public void task1(){
        /*
        Task 1
			- Open "https://demoqa.com/frames"
			- Verify child frames texts are equal : "This is a sample page"
         */

        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame1\"]")));

        String actualMsg = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
        String expectedMsg = "This is a sample page";

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void task2(){
        /*
        Task 2
			- Open "http://practice.cybertekschool.com/nested_frames"
			- Switch to middle frame
			- Verify text is equal "MIDDLE"
		    - Switch to right frame
		    - Verify text is equal "RIGHT"
		    - Switch to bottom frame
		    - Verify text is equal "BOTTOM"
         */

        driver.get("http://practice.cybertekschool.com/nested_frames");

       // Switch to middle frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        //Verify text is equal "MIDDLE"
        String actualText;
        String expectedText = "MIDDLE";
        actualText = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
        Assert.assertEquals(actualText, expectedText, "MIDDLE FAIL");

        //Switch to right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);

        //Verify text is equal "RIGHT"
        actualText = driver.findElement(By.xpath("/html/body")).getText();
        expectedText = "RIGHT";
        Assert.assertEquals(actualText, expectedText, "RIGHT FAIL");

        //Switch to bottom frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

        //Verify text is equal "BOTTOM"
        actualText = driver.findElement(By.tagName("body")).getText();
        expectedText = "BOTTOM";
        Assert.assertEquals(actualText, expectedText, "BOTTOM FAIL");

    }

}
