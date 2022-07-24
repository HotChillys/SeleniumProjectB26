package com.cydeo.test.day7_testng_dropdown;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_StateDropdown extends TestBase {
/*
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)
 */

    @Test
    public void stateDropdownTest(){
        //Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        //Select Illinois with Value
        stateDropdown.selectByValue("IL");

        //Select Virginia with VisibleText
       stateDropdown.selectByVisibleText("Virginia");

        // Select California . with index
        stateDropdown.selectByIndex(5);

        //Verify final selected option is California
        //Use all Select options. (visible text, value, index)
        String actualStateOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualStateOption, "California", "FAIL");
    }
    /*
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.
     */
    @Test
    public void multiSelectDropdown(){
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        System.out.println(languages.isMultiple()); // to check if the selection is multiple or just one, return boolean

        //4. Print out all selected values.
        languages.selectByValue("java");
        languages.selectByVisibleText("C#");
        languages.deselectByIndex(3);

        /*
        getOption(); method returns all options in dropdown

        List<WebElement> allOptions = languages.getOptions();
        this is same as languages.getOption();
        */
        for (WebElement each : languages.getOptions()) {
            each.click();
            System.out.println("each.getText() = " + each.getText());
        }
        // 5. Deselect all values.
        languages.deselectAll();

    }




}
