package com.cydeo.test.day5_checkbox_radio_button;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1 {
    /*
        TC #1: Tesla “Solar Panel” header verification
        1. Open a Chrome browser
        2. Go to: https://www.tesla.com
        3. Locate Solar Panels header
        4. Verify if it is displayed on the page
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tesla.com ");

        WebElement solarPanel = driver.findElement(By.xpath("//span[.='Solar Panels']"));
        System.out.println("solarPanel is Displayed = " + solarPanel.isDisplayed());

      driver.quit();














    }



}
