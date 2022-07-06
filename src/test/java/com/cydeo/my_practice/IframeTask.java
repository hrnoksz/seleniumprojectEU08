package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTask {

    @Test
    public void test(){
        Driver.getDriver().get("https://practice.cydeo.com/iframe");

        //switch to the iframe using index
        //Driver.getDriver().switchTo().frame(0);

        //switch to the iframe using id or name
        Driver.getDriver().switchTo().frame("mce_0_ifr");

        //switch to the iframe using WebElement

        //WebElement iFrameElm = Driver.getDriver().findElement(By.cssSelector("iframe[title^='Rich Text Area']"));
        //Driver.getDriver().switchTo().frame(iFrameElm);

        //identify the <p> element inside the iframe
        WebElement pTagElmInsideFrame = Driver.getDriver().findElement(By.tagName("p"));
        System.out.println("pTagElmInsideFrame.getText() = " + pTagElmInsideFrame.getText());

        //switch out of the frame
        //Driver.getDriver().switchTo().defaultContent(); //this will switch to top level html

        Driver.getDriver().switchTo().parentFrame(); //this will switch back up one level inside nested html document

        //click on home button to go back to main practice page
        Driver.getDriver().findElement(By.linkText("Home")).click();

    }
}
