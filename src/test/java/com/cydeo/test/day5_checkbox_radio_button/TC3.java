package com.cydeo.test.day5_checkbox_radio_button;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC3 {
    /*
    Practice: Checkboxes
    1. Go to http://practice.cydeo.com/checkboxes
    2. Confirm checkbox #1 is NOT selected by default
    3. Confirm checkbox #2 is SELECTED by default.
    4. Click checkbox #1 to select it.
    5. Click checkbox #2 to deselect it.
    6. Confirm checkbox #1 is SELECTED.
    7. Confirm checkbox #2 is NOT selected.
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cydeo.com/checkboxes");





    }
}
