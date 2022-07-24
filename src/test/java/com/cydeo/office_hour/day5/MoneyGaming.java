package com.cydeo.office_hour.day5;

import com.cydeo.test.base.TestBase;
import org.testng.annotations.Test;

public class MoneyGaming extends TestBase {

    @Test
    public void moneyGaming(){
        /*
        Task IQ :  It is very slow website. Just try to locate your element and run.It will take 2-3 min to give result

        1. Navigate to: https://moneygaming.qa.gameaccount.com/
        2. Click the JOIN NOW button to open the registration page
        3. Select a title value from the dropdown
        4. Enter your first name and surname in the form
        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        6. Submit the form by clicking the JOIN NOW button
        7. Validate that a validation message with text "This field is required" appears under the date of birth box
        8. Validate that 18 "This field is required" messages  appears
         */
        driver.get("https://moneygaming.qa.gameaccount.com/");


    }


}
