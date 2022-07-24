package com.cydeo.test.extra_task.smartbear;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearIterate extends TestBase {
    /*
            TC#3: Smartbear software order verification
            1. Open browser and login to Smartbear software
            2. Click on View all orders
            3. Verify Susan McLaren has order on date “01/05/2010”
         */
    @Test
    public void susan() {
        // Open browser and login to Smartbear software
        SmartbearLogin.login(driver);

        //Click on View all orders
        driver.findElement(By.xpath("//a[.='View all orders']")).click();

        //Verify Susan McLaren has order on date “01/05/2010”

        List<WebElement> dates = driver.findElements(By.xpath("//table//tbody//tr//td[5]"));

        List<WebElement> name = driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        String actualDate = "";
        String expectedDate = "01/05/2010";

        for (int i = 0; i < dates.size(); i++) {

            if (dates.get(i).getText().equals("01/05/2010") && name.get(i).getText().equals("Susan McLaren")){
               actualDate = dates.get(i).getText();
            }
        }
        Assert.assertEquals(actualDate, expectedDate, "FAIL");

    }


}
