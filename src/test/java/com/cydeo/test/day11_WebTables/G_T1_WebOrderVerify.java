package com.cydeo.test.day11_WebTables;

import com.cydeo.test.base.TestBase;
import com.cydeo.utilities.WebTableUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class G_T1_WebOrderVerify extends TestBase {
/*
        TC #1: Web table practice
            1. Go to: https://practice.cydeo.com/web-tables
            2. Verify Bob’s name is listed as expected.
            Expected: “Bob Martin”
            3. Verify Bob Martin’s order date is as expected
            Expected: 12/31/2021
 */

    @Test
    public void verifyOrder(){

        driver.get("https://practice.cydeo.com/web-tables");

        //Verify Bob’s name is listed as expected.
        String bob = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]//td[.='Bob Martin']")).getText();
        //Expected: “Bob Martin”
        String expectedBob = "Bob Martin";

        Assert.assertEquals(bob, expectedBob, "FAIL");

        //Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        String bobDate = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]//td[.='Bob Martin']/following-sibling::td[3]")).getText();
        String expectedBobDate = "12/31/2021";

        Assert.assertEquals(bobDate, expectedBobDate, "FAIL");
    }

    @Test
    public void verifyOrderDate(){
        // use created method to do above task

        System.out.println(WebTableUtil.returnOrderDate(driver, "Alexandra Gray"));
    }

    @Test
    public void test3(){

        WebTableUtil.verifyOrder(driver, "Ned Stark", "05/12/2021");

    }




}
