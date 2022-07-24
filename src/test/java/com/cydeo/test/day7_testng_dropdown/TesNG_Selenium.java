package com.cydeo.test.day7_testng_dropdown;

import com.cydeo.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TesNG_Selenium extends TestBase {

//    @BeforeMethod
//    public void setUpMethod(){
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }

    // above was handled with extending TestBase class

    @Test
     public void googleTitle(){
         /* set up chrome and create WebDriver instance
            get "http://google.com"
            Assert: title is "Google"
          */

        driver.get("https://google.com");

        Assert.assertEquals(driver.getTitle(), "Google", "hard fail");

     }











        }
