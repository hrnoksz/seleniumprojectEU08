package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class radioButton {

    public static void main(String[] args) {

        Driver.getDriver().get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioButton = Driver.getDriver().findElement(By.id("blue"));
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());

        //click on red button
        WebElement redRadioButton = Driver.getDriver().findElement(By.id("red"));
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());
        redRadioButton.click();
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //identify green radio button
        WebElement greenRadioBtn = Driver.getDriver().findElement(By.id("green"));
        greenRadioBtn.click();

        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());

    }
}
