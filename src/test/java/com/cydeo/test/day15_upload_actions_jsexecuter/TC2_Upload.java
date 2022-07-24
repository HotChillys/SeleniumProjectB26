package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_Upload {


    @Test
    public void upload_test() throws InterruptedException {
            /*
    TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded! text is displayed on the page
     */
        // C:\Users\gulif\Pictures\Camera Roll\Itachi.jpg


        // 1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        // 2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\gulif\\Pictures\\Camera Roll\\Itachi.jpg";

        // 3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        fileUpload.sendKeys(path);

        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));
        uploadBtn.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement result = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));

        Assert.assertTrue(result.isDisplayed());

    Driver.getDriver().quit();
    }
}
