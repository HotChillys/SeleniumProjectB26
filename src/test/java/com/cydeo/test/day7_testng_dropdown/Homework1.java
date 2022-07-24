package com.cydeo.test.day7_testng_dropdown;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework1 extends TestBase {
    /*
    TC : Selecting date on dropdown and verifying
    1. Open Chrome browser
    2. Go to https://practice.cydeo.com/dropdown
    3. Select “December 1st, 1923” and verify it is selected.
     Select year using   : visible text
    Select month using    : value attribute Select
    day using : index number
    Verify each year, month and day selected correctly
     */

    @Test
    public void verifyDropdown(){
        driver.get("https://practice.cydeo.com/dropdown ");

        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1923");

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);


        // Verify each year, month and day selected correctly
        String actualYear = year.getFirstSelectedOption().getText();
        String actualMonth = month.getFirstSelectedOption().getText();
        String actualDay = day.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertEquals(actualYear, expectedYear, "YEAR FAIL");
        Assert.assertEquals(actualMonth, expectedMonth, "MONTH FAIL");
        Assert.assertEquals(actualDay, expectedDay, "DAY FAIL");
    }





}
