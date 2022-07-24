package com.cydeo.test.day7_testng_dropdown;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DropdownExample extends TestBase {
/*
    TC #1: Verifying “Simple dropdown” and “State selection”
    dropdown default values
    1. Open Chrome browser
    2. Go to https://practice.cydeo.com/dropdown
    3. Verify “Simple dropdown” default selected value is correct
    Expected: “Please select an option”
    4. Verify “State selection” default selected value is correct
    Expected: “Select a State”
 */

    @Test
    public void dropdownTest() throws InterruptedException {

//        2. Go to https://practice.cydeo.com/dropdown

        driver.get("https://practice.cydeo.com/dropdown");

//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        Thread.sleep(3000);
        String actualDropdown = simpleDropdown.getFirstSelectedOption().getText();
        Thread.sleep(3000);
        String expectedDropdown = "Please select an option";
        Assert.assertEquals(actualDropdown, expectedDropdown, "FAIL");

        Thread.sleep(3000);
//        4. Verify “State selection” default selected value is correct
//           Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        String actualSelect = stateDropdown.getFirstSelectedOption().getText();
        Thread.sleep(3000);
        Assert.assertEquals(actualSelect, "Select a State", "FAIL");


    }



}
