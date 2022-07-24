package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TC2_WindowsHandle extends TestBase {
    /*
        1. Open a chrome browser
        2. Go to : https://practice.cydeo.com/windows
        3. Assert: Title is “Windows”
        4. Click to: “Click Here” link
        5. Switch to new Window.
        6. Assert: Title is “New Window”
     */

    @Test
    public void windowsHandle(){

        driver.get("https://practice.cydeo.com/windows");

        // Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle, expectedTitle, "Title Failed");

        // Click to: “Click Here” link
        driver.findElement(By.linkText("Click Here")).click();

        // Switch to new Window
        Set<String> allWindows = driver.getWindowHandles();

        for (String each : allWindows) {
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        // Assert: Title is “New Window”
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "FAIL");


    }

}
