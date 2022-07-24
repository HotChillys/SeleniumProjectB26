package com.cydeo.test.extra_task.smartbear;

import com.cydeo.test.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartbearLinkVerification extends TestBase {


    /*
        TC #1: Smartbear software link verification
        1. Open browser
        2. Go to website:
        http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3. Enter username: “Tester”
        4. Enter password: “test”
        5. Click to Login button
        6. Print out count of all the links on landing page
        7. Print out each link text on this page
     */

    @Test
    public void links() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");//username
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test"); // password
        driver.findElement(By.cssSelector(".button")).click(); // login button

        //Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement each : links) {
            System.out.println(each);
        }
        System.out.println(links.size());//6
    }

    @Test
    public void orderPlacing() throws InterruptedException {
        /*
            TC#2: Smartbear software order placing
            1. Open browser
            2. Go to website:
            http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            3. Enter username: “Tester”
            4. Enter password: “test”
            5. Click on Login button
            6. Click on Order
            7. Select familyAlbum from product, set quantity to 2
            8. Click to “Calculate” button
            9. Fill address Info with JavaFaker
            • Generate: name, street, city, state, zip code
            10. Click on “visa” radio button
            11. Generate card number using JavaFaker
            12. Click on “Process”
            13. Verify success message “New order has been successfully added.”
         */
        SmartbearLogin.login(driver);

        driver.findElement(By.xpath("//a[.='Order']")).click();

        //Select familyAlbum from product, set quantity to 2
        Select dropdown = new Select(driver.findElement(By.xpath("//select")));
        dropdown.selectByValue("FamilyAlbum");

        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.clear();
        quantity.sendKeys("2");

        //Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        Thread.sleep(2000);

        // Fill address Info with JavaFaker | Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(faker.name().fullName()); //customer name
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(faker.address().streetAddress()); // street
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(faker.address().city()); // city;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(faker.address().state()); // state
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("50213");

        //Click on “visa” radio button
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        //Generate card number using JavaFaker
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(faker.number().digit());
        Thread.sleep(2000);
        //expire date
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("06/22");

        //Click on “Process”
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Thread.sleep(2000);
        //Verify success message “New order has been successfully added.”
        WebElement newOrder = driver.findElement(By.xpath("//*[contains(text(),'New order has been successfully added')]"));
        String expectedNewOder = "New order has been successfully added.";

        Assert.assertTrue(newOrder.isDisplayed(), "FAILED TO DISPLAY");
        Assert.assertEquals(newOrder.getText(), expectedNewOder, "FAILED, DISPLAYED MESSAGE DOES NOT MATCH");
    }

    @Test
    public void orderVerification(){
        /*
            TC#3: Smartbear software order verification
            1. Open browser and login to Smartbear software
            2. Click on View all orders
            3. Verify Susan McLaren has order on date “01/05/2010”
         */

        // Open browser and login to Smartbear software
        SmartbearLogin.login(driver);

        //Click on View all orders
        driver.findElement(By.xpath("//a[.='View all orders']")).click();

        //Verify Susan McLaren has order on date “01/05/2010”
        List<WebElement> row = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

        List<WebElement> susan = new ArrayList<>();
        for (int i = 1; i < row.size(); i++) {
         if (row.get(i).getText().contains("Susan McLaren")) {
             susan.add(row.get(i));
         }
        } // this finds the susan row and stores it in susan List

        for (WebElement each : susan) {
            System.out.println(each.getText());
        } // this prints the whole susan row

        String expectedDate = "01/05/2010";
        susan.forEach(webElement -> {
            if (webElement.getText().equals(expectedDate)){
                Assert.assertEquals(webElement.getText(), expectedDate, "FAIL");
            }
        });
    }

}
