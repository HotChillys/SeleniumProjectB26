package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        // set up chrome and create WebDriver instance
        WebDriverManager.chromedriver().setup();

        // create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        // navigate.to(url)
        driver.navigate().to("https://www.etsy.com");

        // driver.get(url) same as above
        driver.get("https://www.etsy.com");

        // it is used for stopping code execution in application, we are giving time for application to see steps
        Thread.sleep(3000);

        //navigate.back()
        driver.navigate().back();

        Thread.sleep(3000);

        // navigate.forward()
        driver.navigate().forward();

        // navigate.refresh();
        driver.navigate().refresh();

        System.out.println("Etsy page driver.getTitle() = " + driver.getTitle());
        System.out.println("Etsy -> driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.get("https://www.tesla.com");

        System.out.println("Tesla page driver.getTitle() = " + driver.getTitle());
        System.out.println("Tesla -> driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //this will close (minimize) the current opened page
        //driver.close();

        // this will close the current opened page/tabs
        driver.quit();


    }
}
