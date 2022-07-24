package com.cydeo.test.day5_checkbox_radio_button;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC2 {
    /*
    TC #4: FindElements Task
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/abtest
    3- Locate all the links in the page.
    4- Print out the number of the links on the page.
    5- Print out the texts of the links.
    6- Print out the HREF attribute values of the links
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/abtest");











    }
}
