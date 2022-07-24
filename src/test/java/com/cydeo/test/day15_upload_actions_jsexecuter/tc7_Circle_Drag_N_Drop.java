package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc7_Circle_Drag_N_Drop {


    @Test
    public void test() throws InterruptedException {
        /*
         1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
         2. Drag and drop the small circle to bigger circle
         3. Assert:
                - Text in big circle changed to : "You did great!"
         */

        // 1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // locate "Accept Cookies" button and click
        WebElement cookie = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();

        // locate big and small circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        // 2. Drag and drop the small circle to bigger circle
        Actions actions = new Actions(Driver.getDriver());
//        actions.dragAndDrop(smallCircle, bigCircle).perform();

        // or

        actions.clickAndHold(smallCircle)
                .moveToElement(bigCircle)
                .release()
                .perform();

        // 3. Assert:    - Text in big circle changed to : "You did great!"
        String actualText = bigCircle.getText();
        String expectedText = "You did great!";
        Assert.assertEquals(actualText, expectedText);

        Driver.closeDriver();





    }

}
