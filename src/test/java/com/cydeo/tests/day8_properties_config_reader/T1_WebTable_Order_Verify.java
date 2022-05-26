package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void order_name_verify_test(){
        //Locate the cell that has Bob Martin text in it
        WebElement bopMartinCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        //2. Verify Bob’s name is listed as expected.

        String expectedBobName = "Bob Martin";
        String actualBobName = bopMartinCell.getText();
        Assert.assertEquals(actualBobName, expectedBobName);

        //3. Verify Bob Martin’s order date is as expected: 12/31/2021
        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        String expectedDate = "12/31/2021";
        String actualDate = bobMartinDateCell.getText();
        Assert.assertEquals(actualDate, expectedDate);

    }
    //We use the utility method we created.
    @Test
    public void test2(){



    }



}
/*
TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */