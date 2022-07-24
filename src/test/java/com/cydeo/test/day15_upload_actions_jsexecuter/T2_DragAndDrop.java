package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_DragAndDrop {


    @Test
    public void test() throws InterruptedException{

        // https://demos.telerik.com/kendo-ui/dragdrop/index

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        System.out.println("bigCircle.getText() = " + bigCircle.getText());

        Actions actions = new Actions(Driver.getDriver());

        //actions.dragAndDrop(smallCircle, bigCircle).perform(); // moves small circle to big circle
        // or
        actions.moveToElement(smallCircle)
                        .clickAndHold().pause(1000)
                                .moveToElement(bigCircle).pause(1000)
                                        .release()
                                                .perform();
        System.out.println("bigCircle.getText() = " + bigCircle.getText());

        Assert.assertEquals(bigCircle.getText(), "You did great!");

        Thread.sleep(2000);




        Driver.getDriver().quit();

    }




}
