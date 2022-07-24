package com.cydeo.test.day6_stale_element_testng;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1 {
    /*
    TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results 
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        // 2. Search for “wooden spoon”
       WebElement element = driver.findElement(By.id("global-enhancements-search-query"));
       element.sendKeys("wooden spoon" + Keys.ENTER);


//       WebElement search = driver.findElement(By.xpath(""))

       // Click on filters
        WebElement filters = driver.findElement(By.cssSelector("span[class='wt-hide-xs wt-show-md filter-expander']"));
        filters.click();

        // Select free shipping, on sale

        WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();
        WebElement onSale = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();

        WebElement under25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();

        WebElement apply = driver.findElement(By.xpath("//*[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
        apply.click();

        Thread.sleep(3000);

        //Print count of results
        String countResult = driver.findElement(By.xpath("//span[@class='wt-text-caption wt-text-link-no-underline']")).getText();

        System.out.println(countResult); // result should be 236 but it does not match why

        driver.quit();





    }


}
