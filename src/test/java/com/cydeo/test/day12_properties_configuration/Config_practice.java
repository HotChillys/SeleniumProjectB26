package com.cydeo.test.day12_properties_configuration;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Config_practice {

//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod(){
//
//        //we are getting the  browserType dynamically from out configuration.properties file
//        String browserType = ConfigurationReader.getProperty("browser");
//
//        driver = WebDriverFactory.getDriver(browserType);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }

    @Test
    public void googleSearchTest(){
/*
TC: Google search
    1- Open a Chrome browser
    2- Go to: http://google.com
    3- Write "apple" in search box
    4- Verify title:
        Expected: apple - Google search

    Use 'configuration.properties' for the following:
    1- The browser type
    2- The URL
    3- The search keyword
    4- Make title verification dynamic. If search value changes, title assertion should not fail.
 */

        //Go to: http://google.com
        // Driver.getDriver() ---> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));

        // Write "apple" in search box
        Driver.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //Verify title:
        //Expected: apple-Google search
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);




        Driver.getDriver().quit();

    }

}
