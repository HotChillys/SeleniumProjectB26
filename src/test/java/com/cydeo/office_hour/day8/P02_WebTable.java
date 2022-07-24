package com.cydeo.office_hour.day8;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P02_WebTable {
     /*
       Task 1  -- Example 1 Table

            - Open "http://practice.cydeo.com/tables"
            - Print out all table headers
            - Verify
                    - Table has 6 header
         */

    @Test
    public void test(){

        // - Open "http://practice.cydeo.com/tables"
        Driver.getDriver().get(ConfigurationReader.getProperty("tablesUrl"));

        //     - Print out all table headers
        List<WebElement> allHeaders = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//span"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement each : allHeaders) {
            System.out.println(each.getText());
        }

        Assert.assertEquals(allHeaders.size(), 6);
    }

    /*
              Task 2  -- Example 1 Table
                - Open "http://practice.cydeo.com/tables"
                - Print out all table information
                - Verify
                        - Table has 4 row
             */
    @Test
    public void test2(){

        Driver.getDriver().get(ConfigurationReader.getProperty("tablesUrl"));

        // second row info
        WebElement row2 = Driver.getDriver().findElement(By.xpath("//table[@id='table1']//tbody//tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());

        // get me all row info
       List<WebElement> allRow = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody//tr"));

//        for (int i = 1; i <= allRow.size(); i++) {
//            String eachRowPath = "//table[@id='table1']//tbody//tr[" +i+ "]";
//            System.out.println(Driver.getDriver().findElement(By.xpath(eachRowPath)).getText());
//        }

        for (WebElement eachRow : allRow) {
            System.out.println(eachRow.getText());
        }
        Assert.assertEquals(allRow.size(), 4);

        Driver.getDriver().quit();
    }

        /*
    Task 3  -- Example 1 Table
	        - Open "http://practice.cydeo.com/tables"
	        - Print out all infromation for firstname ="Frank"
	        - Verify
	        		- email equals "fbach@yahoo.com"
	       NOTE : This task needs to work for
	                firstname = Jason
	                email     = jdoe@hotmail.com
     */

    @Test
    public void test3(){

        Driver.getDriver().get(ConfigurationReader.getProperty("tablesUrl"));

        String firstName = "Jason";

        // dynamic locator to get email for username
        // xpath -- //table[@id='table1']//td[.="Frank"]/../td[contains(.,"@")]

        String emailLocator="//table[@id='table1']//td[.='"+firstName+"']/../td[contains(.,\"@\")]";

        WebElement email = Driver.getDriver().findElement(By.xpath(emailLocator));
        System.out.println(email.getText());

        Assert.assertEquals(email.getText(),"jdoe@hotmail.com");

        String name = "Frank";

        List<WebElement> allRow = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody//tr"));

        for (WebElement eachRow : allRow) {
            if (eachRow.getText().contains(name)){
                System.out.println(eachRow.getText());
            }
        }

        emailLocator="//table[@id='table1']//td[.='"+name+"']/../td[contains(.,\"@\")]";
        email = Driver.getDriver().findElement(By.xpath(emailLocator));
        Assert.assertEquals(email.getText(), "fbach@yahoo.com");

    }

}
