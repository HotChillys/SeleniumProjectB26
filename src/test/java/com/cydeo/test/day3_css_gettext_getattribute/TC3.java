package com.cydeo.test.day3_css_gettext_getattribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC3 {
    /*
    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        String expectedText = "Log In";

        WebElement login = driver.findElement(By.cssSelector("input[type='submit']"));

        String actualText = login.getAttribute("value");

        if (actualText.equals(expectedText)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        driver.quit();


    }
}
