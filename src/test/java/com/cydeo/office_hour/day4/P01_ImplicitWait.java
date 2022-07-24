package com.cydeo.office_hour.day4;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class P01_ImplicitWait extends TestBase {


    @Test
    public void test01(){
        driver.get("http://practice.cydeo.com/dynamic_loading/4");

        String helloWorld = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(helloWorld);

    }



}
