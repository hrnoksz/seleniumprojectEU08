package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathPractice {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://search.yahoo.com");
    }
    @Test
    public void test(){
        //use xpath to identify search box and enter "xpath"
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='p']"));
        searchBox.sendKeys("xpath");

        //click on x icon to clear out the text
        WebElement xIcon = Driver.getDriver().findElement(By.xpath("//button[@id='sbq-clear']//span[@class='sprite']"));
        xIcon.click();

        //enter "selenium locators" into search box
        searchBox.sendKeys("selenium locators");
        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//span[@title='Search']"));
        searchBtn.click();

    }
}
