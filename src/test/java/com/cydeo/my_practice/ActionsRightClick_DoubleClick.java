package com.cydeo.my_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsRightClick_DoubleClick {

    @Test
    public void right_click_test(){

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement area = Driver.getDriver().findElement(By.xpath("//div[@contextmenu='mymenu']"));

        //right click --> contextClick
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(area).perform();

        Driver.getDriver().switchTo().alert().accept();

        BrowserUtils.sleep(3);

    }

    @Test
    public void double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement pElm = Driver.getDriver().
                findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(pElm).perform();

        //assert new p element with Hello World text displayed
        WebElement resultElm = Driver.getDriver().findElement(By.xpath("//p[.='Hello World']"));
        Assert.assertTrue(resultElm.isDisplayed());
    }
}
