package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

    public static void main(String[] args) {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //identify the dropdown with multiple select options
        WebElement multiItemDrop = Driver.getDriver().findElement(By.name("Languages"));

        //Wrap this element into Select object
        Select multiItemSelect = new Select(multiItemDrop);

        //Check if this element has multi select option
        System.out.println("multiItemSelect.isMultiple() = " + multiItemSelect.isMultiple());

        //select items
        multiItemSelect.selectByIndex(2);
        multiItemSelect.selectByValue("ruby");
        multiItemSelect.selectByVisibleText("Python");

        //deselect items
       // multiItemSelect.deselectByIndex(2);
       // multiItemSelect.deselectByValue("ruby");
       // multiItemSelect.selectByVisibleText("Python");

        //or we can use deselectAll() method instead of these three methods
        multiItemSelect.deselectAll();


    }
}
