package com.cydeo.office_hour.day6;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_Alerts extends TestBase {
    /*
         Task 1  -- HTML POP UP
             - Open "https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126"
             - Click Confirm button
             - Click YES from pop up
             - Verify message equals "You have accepted"
          */
    @Test
    public void htmlAlert(){
     driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126");

driver.findElement(By.xpath("//span[.='Confirm']")).click();// click confirm

driver.findElement(By.xpath("//*[@id=\"j_idt311:j_idt316\"]/span")).click();// click pop-up, yes

String actualMsg = driver.findElement(By.xpath("//*[@id=\"j_idt311:message_container\"]/div/div/div[2]/p")).getText();

String expected = "You have accepted";

        Assert.assertEquals(actualMsg, expected, "FAIL");
    }

    @Test
    public void information(){
        /*
        Task 2  -- INFORMATION
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Alert
			- Click OK button from Alert
			- Verify message equals "You have clicked on ok button in alert window"
         */

        driver.get("http://www.uitestpractice.com/Students/Switchto");

        //Click Alert
        driver.findElement(By.xpath("//button[@id='alert']")).click();

        // Click OK button from Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Verify message equals "You have clicked on ok button in alert window"
        String actualMsg = driver.findElement(By.xpath("//div[@id='demo']")).getText();
        String expectedMsg = "You have clicked on ok button in alert window";

        Assert.assertEquals(actualMsg, expectedMsg, "FAIL");
    }
    @Test
    public void confirm(){
        /*
        Task 3  -- CONFIRM
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Confirm
			- Click Cancel button from Alert
			- Verify message equals "You pressed Cancel in confirm window"
         */
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        //Click Confirm
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();

        //Click Cancel button from Alert
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        //Verify message equals "You pressed Cancel in confirm window"
        String actualMsg = driver.findElement(By.cssSelector("#demo")).getText();
        String expectedMsg = "You pressed Cancel in confirm window";
        Assert.assertEquals(actualMsg, expectedMsg, "FAIL");
    }

    @Test
    public void prompt(){
        /*
         Task 4  -- PROMPT
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Prompt
			- Send name as "Mike" into this alert field
			- CLick OK
			- Verify  message contains "Mike"
         */

        driver.get("http://www.uitestpractice.com/Students/Switchto");

        //Click Prompt
        driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();

        //Send name as "Mike" into this alert field
        String name = "Mike";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

        //Verify  message contains "Mike"
        String expectedMsg = "Mike";
        String actualMsg = driver.findElement(By.cssSelector("#demo")).getText();

        Assert.assertTrue(actualMsg.contains(expectedMsg), "FAIL");
    }
}
