package com.cydeo.test.day6_stale_element_testng;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1 {
    /*
    TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
 3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button['addElement']"));
        addElement.click();

        //Verify “Delete” button is displayed after clicking.
       WebElement delete = driver.findElement(By.cssSelector("button[class='added-manually']"));
        System.out.println("before clicking delete button is displayed?  = " + delete.isDisplayed());
        delete.click();

        // Verify “Delete” button is NOT displayed after clicking.
        //System.out.println("after clicking delete button is displayed? = " + delete.isDisplayed());

        try {
            System.out.println("after clicking delete button is displayed? = " + delete.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("Web element is deleted from the page and html");
        }











        driver.quit();








    }

}
