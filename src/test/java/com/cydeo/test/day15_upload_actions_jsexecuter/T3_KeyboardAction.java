package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T3_KeyboardAction extends TestBase {


    @Test
    public void test() throws InterruptedException {

        // https://wwww.goole.com
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));

        // click on the element
        // hold down the shift and enter text
        // release the shift and enter text
        // hold down to Ctl on Windows enter A to select all
        // sendKeys backspace
        // pause 1 second in between actions

        Actions actions = new Actions(driver);

        actions.click(searchBox).pause(1000)
                .keyDown(Keys.SHIFT)
                .sendKeys("typing by holding down to shift").pause(1000)
                .keyUp(Keys.SHIFT)
                .sendKeys(" typing after releasing the shift").pause(1000)
                .keyDown(Keys.CONTROL)
                .sendKeys("A").pause(1000)
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        Thread.sleep(2000);


driver.quit();

    }




}
