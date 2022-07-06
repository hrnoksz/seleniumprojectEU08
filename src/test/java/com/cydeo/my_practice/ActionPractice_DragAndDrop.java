package com.cydeo.my_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionPractice_DragAndDrop {

    @Test
    public void drag_and_drop_test(){

        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle, bigCircle).perform();

        BrowserUtils.sleep(5);

        Assert.assertEquals(bigCircle.getText(), "You did great!");


    }
}
