package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Hover {

    @Test
    public void test1() throws InterruptedException {

        //Go to "http://practice.cybertekschool.com/hovers"
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        // Locate first images from the page
        WebElement firstImage = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));

        WebElement firstImageText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        System.out.println("Before hover firstImageText.isDisplayed() = " + firstImageText.isDisplayed());
        Assert.assertFalse(firstImageText.isDisplayed());

        // create Action class object
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(firstImage).perform();
        System.out.println("After hover firstImageText.isDisplayed() = " + firstImageText.isDisplayed());
        Assert.assertTrue(firstImageText.isDisplayed());
        System.out.println("END");

        Driver.getDriver().quit();

    }


}
