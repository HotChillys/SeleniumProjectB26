package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC4_JSExecuter_Scroll {
    /*
    TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times

JavaScript method to use : window.scrollBy(0,0)
     */

    @Test
    public void javascript_executor_test1() throws InterruptedException {

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        // or this
        //((JavascriptExecutor)Driver.getDriver()).executeAsyncScript("");

        // 3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Thread.sleep(2000);

        //   a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }

        //   b.  750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-750)");
        }

Driver.getDriver().quit();

    }

}
