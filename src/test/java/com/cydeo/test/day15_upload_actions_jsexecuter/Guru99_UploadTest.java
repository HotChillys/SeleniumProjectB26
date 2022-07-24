package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99_UploadTest {

    @Test
    public void test1() throws InterruptedException {
        /*
        TC : Guru99 Upload Test
            1. Go to  “http://demo.guru99.com/test/upload”
            2. Upload file into Choose File
            3. Click terms of servide check box
            4. Click Submit File button
            5. Verify expected message appeared. Expected: “1 file
            has been successfully uploaded.”
         */

        //  1. Go to  “http://demo.guru99.com/test/upload”
        Driver.getDriver().get("http://demo.guru99.com/test/upload");

        // 2. Upload file into Choose File
        String path = "C:\\Users\\gulif\\Pictures\\Camera Roll\\Itachi.jpg";
        WebElement chooseFile = Driver.getDriver().findElement(By.name("uploadfile_0"));
        chooseFile.sendKeys(path);

        //  3. Click terms of servide check box
        Driver.getDriver().findElement(By.id("terms")).click();

        // 4. Click Submit File button
        Driver.getDriver().findElement(By.id("submitbutton")).click();
        Thread.sleep(1000);

        //  5. Verify expected message appeared. Expected: “1 file has been successfully uploaded.”
        String expected = "1 file\nhas been successfully uploaded.";
        String actual = Driver.getDriver().findElement(By.id("res")).getText();

        Assert.assertEquals(actual, expected);

        Driver.getDriver().quit();
    }


}
