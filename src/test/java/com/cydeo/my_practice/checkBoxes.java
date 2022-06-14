package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class checkBoxes {

    public static void main(String[] args) {

        Driver.getDriver().get("http://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = Driver.getDriver().findElement(By.id("box1"));
        System.out.println("Before click checkbox1.isSelected() = " + checkbox1.isSelected());
        checkbox1.click();
        System.out.println("After click checkbox1.isSelected() = " + checkbox1.isSelected());

        WebElement checkbox2 = Driver.getDriver().findElement(By.id("box2"));
        System.out.println("Before click checkbox2.isSelected() = " + checkbox1.isSelected());
        checkbox2.click();
        System.out.println("After click checkbox2.isSelected() = " + checkbox1.isSelected());


        //Driver.closeDriver();
    }
}
