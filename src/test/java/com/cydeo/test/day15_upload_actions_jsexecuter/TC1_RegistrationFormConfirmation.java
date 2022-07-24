package com.cydeo.test.day15_upload_actions_jsexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_RegistrationFormConfirmation {
/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.

Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */

    @Test
    public void test() throws InterruptedException {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form"));

        // 3. Enter first name
        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        //5. Enter username
       WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
       userName.sendKeys(faker.name().username().replace(".", ""));

       //6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));

        // 9. Select a gender from radio buttons
        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        gender.click();

        // 10. Enter date of birth
        WebElement DOB = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        DOB.sendKeys("05/25/2000");

        // 11. Select Department/Office
        Select department = new Select(Driver.getDriver().findElement(By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select")));

        department.selectByIndex(faker.number().numberBetween(1, 9));

        // 12. Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1, 8));

        // 13. Select programming language from checkboxes
        WebElement programLanguage = Driver.getDriver().findElement(By.xpath("(//input[@class='form-check-input'])[2]"));
        programLanguage.click();

        // 14. Click to sign up button
        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath("//button[.='Sign up']"));
        signUpBtn.click();

        // 15. Verify success message “You’ve successfully completed registration!” is
        //displayed.
        WebElement finalResult = Driver.getDriver().findElement(By.cssSelector("#content > div > div > p"));
        String expectedResult = "You've successfully completed registration!";

        Assert.assertEquals(finalResult.getText(), expectedResult);

        Driver.getDriver().quit();

    }


}
