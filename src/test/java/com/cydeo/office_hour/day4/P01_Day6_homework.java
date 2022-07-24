package com.cydeo.office_hour.day4;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class P01_Day6_homework extends TestBase {
    /*
    TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results
     */

    @Test
    public void searchResult() throws InterruptedException {

        driver.get("https://www.etsy.com");

       // 2. Search for “wooden spoon”
        driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']")).sendKeys("wooden spoon" + Keys.ENTER);

        // Click on filters
        driver.findElement(By.xpath("//span[.='All Filters']")).click();

        //Select free shipping, on sale
        driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']")).click();

        driver.findElement(By.xpath("//label[@for='special-offers-on-sale']")).click();

        //5. Select under $25 Click on apply filters
        driver.findElement(By.xpath("//label[@for='price-input-1']")).click();

        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")).click();

        Thread.sleep(3000);

        String result = driver.findElement(By.xpath("//span[contains(text(),\"results,\")]")).getText();

        System.out.println(result);










    }

}

















