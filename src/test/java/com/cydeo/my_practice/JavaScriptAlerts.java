package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

        @BeforeMethod
        public void setup(){
            Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");
        }
        @Test
        public void test1(){
            WebElement alertBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']"));
            alertBtn.click();

            Alert alertObj = Driver.getDriver().switchTo().alert();
            alertObj.accept();

            WebElement resultText = Driver.getDriver().findElement(By.id("result"));
            String exceptedText = "You successfully clicked an alert";
            Assert.assertEquals(resultText.getText(), exceptedText);
        }
        @Test
        public void test2(){
            WebElement confirmBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
            confirmBtn.click();

            Alert alertObj = Driver.getDriver().switchTo().alert();
            alertObj.accept();

            WebElement resultTxt = Driver.getDriver().findElement(By.id("result"));
            String exceptedText = "You clicked: Ok";
            Assert.assertEquals(resultTxt.getText(), exceptedText);

        }

        @Test
        public void test3(){
            WebElement promptBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']"));
            promptBtn.click();

            Alert alertObj = Driver.getDriver().switchTo().alert();
            alertObj.sendKeys("Hello");
            alertObj.accept();

            WebElement resultText = Driver.getDriver().findElement(By.id("result"));
            String expectedText = "You entered: Hello";
            Assert.assertEquals(resultText.getText(), expectedText);


        }
}
/*
 Scenario: Add fields
    When user clicks filter and search box
    And user clicks "add field" button
    And user clicks favorites option
    Then user should see favorites title on the page

  Scenario: Remove fields
    When user clicks filter and search box
    And user clicks add field button
    And user clicks Author option
    Then user should not see "Author title" on the page
 */