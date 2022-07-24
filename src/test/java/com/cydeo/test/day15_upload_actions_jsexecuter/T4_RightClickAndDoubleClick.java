package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_RightClickAndDoubleClick extends TestBase {

    @Test
    public void rightClick() throws InterruptedException {

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        // locate the div element inside iframe
        // with scc selector and right click on it
        driver.switchTo().frame("iframeResult");
        WebElement area = driver.findElement(By.cssSelector("div[contextmenu='mymenu']"));

        // right click -> context click
        Actions actions = new Actions(driver);
        actions.contextClick(area).perform();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        Thread.sleep(1000);

    }

    @Test
    public void doubleClick(){

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

        driver.switchTo().frame("iframeResult");

        // double click this paragraph to trigger a function
        WebElement pElement = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(pElement).perform();

        // assert new p element with "Hello World" text displayed
        WebElement result = driver.findElement(By.xpath("//p[.='Hello World']"));

        Assert.assertTrue(result.isDisplayed());


    }


}
