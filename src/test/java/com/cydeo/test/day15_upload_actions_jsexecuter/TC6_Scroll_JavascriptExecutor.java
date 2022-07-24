package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC6_Scroll_JavascriptExecutor {
    /*
    TC #7: Scroll using JavascriptExecutor
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/large
        3- Scroll down to “Cydeo” link
        4- Scroll up to “Home” link
        5- Use below provided JS method only

        JavaScript method to use : arguments[0].scrollIntoView(true)

        Note: You need to locate the links as web elements and pass them as
        arguments into executeScript() method
     */

    @Test
    public void test() throws InterruptedException {

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large

        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeolink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Thread.sleep(2000);

        //  3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeolink);

        Thread.sleep(2000);

        // 4- Scroll up to “Home” link
        // 5- Use below provided JS method only
        js.executeScript("arguments[1].scrollIntoView(true)", cydeolink, homeLink);

        Thread.sleep(2000);


        Driver.closeDriver();


    }


}
