package com.cydeo.reviewWithOscar.week03.avengersHour;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase07 {

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com/'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */
    WebDriver driver; // declare your variable global
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome"); //initialize
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test7(){
        driver.get("http://automationexercise.com/");

        // Verify that home page is visible successfully : What they mean? --> Verify that you have Hope Page URL and Title, another option verify that test cases button is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        // verify Title
        Assert.assertEquals(actualTitle,expectedTitle,"Home Page is NOT displayed");

        WebElement testCases = driver.findElement(By.xpath("(//button[.='Test Cases'])[1]"));

        testCases.click();

        // Verify user is navigated to test cases page successfully
        //Verification with the text inside the webPage
        String expectedText = "TEST CASES";
        String actualText = driver.findElement(By.xpath("//h2/b")).getText();
        Assert.assertEquals(actualText,expectedText,"Verify Page HAS Test Cases in it");
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));

        // Better way: verify URL has test_cases in it
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));
    }

}
