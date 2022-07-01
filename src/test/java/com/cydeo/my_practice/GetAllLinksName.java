package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllLinksName {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com");
    }

    @Test
    public void test1(){
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        for (WebElement eachLink : allLinks) {
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }
    }

    @AfterMethod
    public void teardown(){
        //Driver.getDriver().close();
    }

}
