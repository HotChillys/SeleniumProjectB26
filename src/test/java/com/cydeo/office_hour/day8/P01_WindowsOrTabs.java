package com.cydeo.office_hour.day8;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class P01_WindowsOrTabs {
    /*
    Task 1
			- Open "http://automationpractice.com/index.php"
			- Click twitter from Follow us
			- Switch to twitter tab
			- Verify title contains "Selenium Framework"
			- Switch to original tab
			- Verify title equals "My Store"
     */

   @Test
    public void test() throws InterruptedException {

       Driver.getDriver().get(ConfigurationReader.getProperty("practicePage"));

       // click twitter    css -- .twitter

       // current window handle
       String currentWindow = Driver.getDriver().getWindowHandle();
       System.out.println(currentWindow);

       WebElement twitter = Driver.getDriver().findElement(By.cssSelector(".twitter"));
       twitter.click();

       // current window handle
       currentWindow = Driver.getDriver().getWindowHandle();
       System.out.println(currentWindow);


       // get all window handles
       Set<String> allHandles = Driver.getDriver().getWindowHandles();
       System.out.println(allHandles);

       System.out.println("======================");
       for (String each : allHandles) {
           System.out.println(each);
           Driver.getDriver().switchTo().window(each);
           if(Driver.getDriver().getCurrentUrl().contains("twitter")){
               Thread.sleep(3000);
               System.out.println("Driver is here "+Driver.getDriver().getTitle());
               break;
           }
       }

       String expectedTitle = "Selenium Framework";
       Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));


       System.out.println("SWITCH BACK TO MAIN PAGE ");
       Driver.getDriver().switchTo().window(currentWindow);

       expectedTitle = "My Store";
       Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);


   }


}
