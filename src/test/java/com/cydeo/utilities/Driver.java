package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing access to the object of this class from outside the class
     */
    private Driver(){

    }


    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    private static WebDriver driver;


    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driver == null) {
            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will be return from configuration.properties file, switch statement will determine the case, and open the matching browser
             */

            switch (browserType.toLowerCase()) {

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }

        return driver;

    }

    public static void closeDriver(){
        /*
        this method will make sure our driver value is always null after using quit() method
         */
        if (driver != null) {
            driver.quit(); // this will terminate the existing session. value will not even be null
            driver = null;
        }

    }

    // driver.quit() --> noSuchSession
    // driver.close() -->
    // try to create a method named closeDriver
}
/*
Why did we create this util class?
    1- We had to write too many lines just to instantiate our "driver"
    2- We were having hard time passing the SAME(current) driver instance in different classes and different packages.
    3- Now we are not only instantiating our driver in just one line, we are also optimizing the setups.
        - determine the type of browser by reading from "configuration.properties" file
        - window.maximize is implemented in our Driver util class
        - timeOut.implicitlyWait is implemented in our Driver util class

How are we able to return the same instance of our driver?
    We implemented Singleton Design Pattern
 */