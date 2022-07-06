package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClassPractice {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
    }

    @Test
    public void test1(){

        //identify the first element, verify the text displayed under
        /**
         * //img[@src='/img/avatar-blank.jpg'][1]
         *
         * //h5[.='name: user1']
         */
        WebElement img1 = Driver.getDriver().findElement(By.xpath("//img[@src='/img/avatar-blank.jpg'][1]"));

        WebElement img1Text = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        //Create Actions class object
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();
        //verify the text under image is displayed or not
        Assert.assertTrue(img1Text.isDisplayed(), "Text is not displayed");
    }

    @Test
    public void test2(){
        //identify the second element, verify the text displayed under
        /**
         * //div[@class='figure'][2]
         *
         * //h5[.='name: user2']
         */

        WebElement img2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));

        WebElement img2Text = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(img2).perform();

        Assert.assertTrue(img2Text.isDisplayed());
    }
}
