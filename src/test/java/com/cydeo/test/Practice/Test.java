package com.cydeo.test.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test  {


   @org.testng.annotations.Test
    public void test() throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       driver.get("https://discord.com/login");

      //username
       driver.findElement(By.xpath("//input[@class='inputDefault-3FGxgL input-2g-os5 inputField-2RZxdl']")).sendKeys("6478626222");
      //password
       driver.findElement(By.xpath("//input[@class='inputDefault-3FGxgL input-2g-os5']")).sendKeys("Uyghur@#485" + Keys.ENTER);









       driver.findElement(By.xpath("(//div[.='Tygrtraxx'])[3]")).click();

       driver.findElement(By.xpath("//div[@data-slate-node='element']")).sendKeys("WHAT DOES THE FOX SAY" + Keys.ENTER);

       driver.quit();
   }


}
