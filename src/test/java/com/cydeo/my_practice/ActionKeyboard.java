package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionKeyboard {

    @Test
    public void action_keyboard_test(){

        Driver.getDriver().get("https://www.google.com");

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        // click on the element
        // hold down to the shift and enter text
        // release the shift and enter text
        // hold down to Command on mac , Control on windows enter A to select all
        // send keys backspace
        // pause 1 seconds in between actions
        Actions actions = new Actions(Driver.getDriver());
        actions.click(searchBox).pause(1000)
                .keyDown(Keys.SHIFT)
                .sendKeys("typing by holding down to shift").pause(2000)
                .keyUp(Keys.SHIFT)
                .sendKeys("typing after releasing shift").pause(2000)
                .keyDown(Keys.CONTROL).sendKeys("A").pause(2000)
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }
}
