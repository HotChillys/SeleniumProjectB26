package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC5_ActionsScrollPractice {
    /*
    TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
     */


    @Test
    public void test() throws InterruptedException {
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        // 3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());

        // locating cydeo link to be able to pass in the actions method
        WebElement cydeoLinkBtn = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Thread.sleep(3000);

        // 4- Scroll using Actions class “moveTo(element)” method\
        actions.moveToElement(cydeoLinkBtn).pause(3000).perform();

        Thread.sleep(3000);
      // 2- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP ).perform();
        Thread.sleep(3000);

        Driver.closeDriver();

    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver(); // this is coming from the utility class that we created called Driver, we use this to get our driver ready to use for next test
    }
}
