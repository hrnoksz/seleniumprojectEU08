package com.cydeo.tests.sallyTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SallyTask {

    WebDriver driver;
    //1. Open browser

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website:https://www.amazon.com/
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void amazon_search_selenium() throws InterruptedException {
        //3. Write "selenium" in the search box

        WebElement informationAlertButton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        informationAlertButton.click();

        /*
        WebElement acceptButton = driver.findElement(By.xpath("//input[@name='accept']"));
        acceptButton.click();

         */
        Thread.sleep(1500);
        informationAlertButton.sendKeys("selenium");


        //4-Verify that you see 10 suggestions as dropdown
        List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class ='s-suggestion-container']"));

        //  Select Dropdown = new Select(driver.findElement(By.xpath("//div[@class ='s-suggestion-container']")));
        Thread.sleep(3000);
        System.out.println("dropdown size = " + dropdown.size());
        Assert.assertEquals(dropdown.size(), 10);

        //5-Verify that all 10 suggestions contain your search term
        List<WebElement> dropdown2 = driver.findElements(By.xpath("//div[@class ='s-suggestion-container']"));
        for (WebElement each : dropdown2) {
            //Thread.sleep(1000);
            //waitForStaleElement(each);
            String actual = each.getText();
            System.out.println(actual);

            Assert.assertTrue(actual.contains("selenium"));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
/*
In this task, you will automate one of your favorite web-page: amazon.com

Here follow the steps:
1-Open the browser
2-Navigate to https://www.amazon.com/
3-Write "selenium" in the search box
4-Verify that you see 10 suggesstions as dropdown
5-Verify that all 10 suggesstions contain your search term
Optional:
6-Verify the same steps with the search term "java" (here you need to make your code dynamic)
Optional 2:
Follow the same steps for each of the browser types with same steps. Here, you will make your code more dynamic.
You will do the same test for each of the browser types but you will use the same code only.
 */