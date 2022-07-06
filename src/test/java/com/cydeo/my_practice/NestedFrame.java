package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NestedFrame {

    @Test
    public void test(){
        Driver.getDriver().get("https://practice.cydeo.com/nested_frames");

        //main content--> top, bottom
        //top --> left, middle, right frame

        //get the text out of bottom frame
        Driver.getDriver().switchTo().frame("frame-bottom");
        WebElement bottoFromBodyElm = Driver.getDriver().findElement(By.tagName("body"));
        System.out.println("bottoFromBodyElm.getText() = " + bottoFromBodyElm.getText());

        //switch out to the parent frame
        Driver.getDriver().switchTo().parentFrame();

        //go to the middle frame and get the text
        //first go to top frame then go to middle frame
        Driver.getDriver().switchTo().frame("frame-top");
        Driver.getDriver().switchTo().frame("frame-middle");
        WebElement middleFrameDiv = Driver.getDriver().findElement(By.id("content"));
        System.out.println("middleFrameDiv.getText() = " + middleFrameDiv.getText());

        //go to the right frame and get the text
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame("frame-right");
        WebElement rightFrameBodyElm = Driver.getDriver().findElement(By.tagName("body"));
        System.out.println("rightFrameBodyElm.getText() = " + rightFrameBodyElm.getText());

        //go back to default content
        Driver.getDriver().switchTo().defaultContent();
    }
}
