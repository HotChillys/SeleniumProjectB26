package com.cydeo.naidrs_assignment;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends TestBase {
/*
    User Story
    As a truck driver I should be able to access Vehicle service Log

    => Scenario: Header should display properly
        Given I logged into VyTrack
        And I am a truck driver
        When I clicked on Vehicle Service Log under the Fleet module
        Then I should be able to see VehicleServicesLogs header



    => Scenario: Truck driver should be able to see al the information
        Given I logged into VyTrack
        And I am a truck driver
        When I clicked on Vehicle Service Log under the Fleet module
        Then I can see all the vehicle information


    => Scenario: Truck driver should be able to create vehicle service log
        Given I logged into VyTrack
        And I am a truck driver
        And I should be able to create vehicle service log
        And during creation all dropdown menu should be displayed


    => Scenario: Truck driver should be able to see all dropdown while creating vehicle service log
        Given I logged into VyTrack
        And I am a truck driver
        When I am creating vehicle service log all dropdown menu should be displayed


    => Scenario: Truck driver should be able to cancel vehicle service log while creating vehicle service log
        Given I logged into VyTrack
        And I am a truck driver
        And I should be able to edit vehicle service log


    => Scenario: Truck driver should be able to delete vehicle service log
        Given I logged into VyTrack
        And I am a truck driver
        And I should be able to edit vehicle service log
*/



    @Test
    public void test12AC1() throws InterruptedException {

        //Scenario: Truck driver should be able to see all the information on Vehicle Service Logs page
        // 1. open chrome browser
        // 2. go to https://qa2.vytrack.com/user/login
        // 3. click on Vehicle Service Log
        // 4. verify if all following options are displayed
        // "SERVICE TYPE", "TOTAL PRICE", "ODOMETER VALUE". "DATE", "PURCHASE", "VENDOR", "INVOICE REFERENCE"


        // log in using credentials
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user3");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(2000);
        // find fleet element
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        //move the element to fleet and click on vehicle service log
        Actions action = new Actions(driver);
        action.moveToElement(fleet).build().perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Vehicle Services Logs']")).click();
        Thread.sleep(3000);

        // 4. verify if all following options are displayed
        // "SERVICE TYPE", "TOTAL PRICE", "ODOMETER VALUE". "DATE", "PURCHASE", "VENDOR", "INVOICE REFERENCE"

        WebElement serviceType, totalPrice, odometerValue, date, purchase, vendor, invoiceReference;

        serviceType = driver.findElement(By.xpath("//span[.='Service Type']"));
        totalPrice  = driver.findElement(By.xpath("//span[.='Total Price']"));
        odometerValue  = driver.findElement(By.xpath("//span[.='Odometer Value']"));
        date  = driver.findElement(By.xpath("//span[.='Date']"));
        purchase  = driver.findElement(By.xpath("//span[.='Purchaser']"));
        vendor = driver.findElement(By.xpath("//span[.='Vendor']"));
        invoiceReference = driver.findElement(By.xpath("//span[.='Invoice Reference']"));

        Assert.assertTrue(serviceType.isDisplayed(), "Service type is not displayed");
        Assert.assertTrue(totalPrice.isDisplayed(), "Total price is not displayed");
        Assert.assertTrue(odometerValue.isDisplayed(), "Odometer value is not displayed");
        Assert.assertTrue(date.isDisplayed(), "Date is not displayed");
        Assert.assertTrue(purchase.isDisplayed(), "Purchase is not displayed");
        Assert.assertTrue(vendor.isDisplayed(), "Vendor is not displayed");
        Assert.assertTrue(invoiceReference.isDisplayed(), "Invoice reference is not displayed");





    }




}
