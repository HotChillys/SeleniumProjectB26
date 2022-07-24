package com.cydeo.test.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NadirAssignment {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login2.nextbasecrm.com/");

        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("hr48@cybertekschool.com");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser");

        WebElement login = driver.findElement(By.className("login-btn"));
        login.click();

        driver.getTitle();

        String expected = "https://login2.nextbasecrm.com/stream/?login=yes";
        if (driver.getTitle().equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("failed");
        }

        driver.quit();










    }
}
