package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownList {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void test(){
        //identify the select element
        WebElement dropdownElement = Driver.getDriver().findElement(By.id("dropdown"));

        //wrap this element inside select object
        Select selectObj = new Select(dropdownElement);

        //use ready methods to select options
        //select 2nd item at index 1
        selectObj.selectByIndex(2);

        // select item with value attribute 1
        selectObj.selectByValue("1");

        // select by visible text
        selectObj.selectByVisibleText("Option 2");
    }
    @Test
    public void test_02(){
        WebElement stateDropdown = Driver.getDriver().findElement(By.id("state"));

        Select select1 = new Select(stateDropdown);

        System.out.println("select1.getFirstSelectedOption() = " + select1.getFirstSelectedOption());

        select1.selectByVisibleText("Florida");

        List<WebElement> allStates = select1.getOptions();
        System.out.println("allStates.size() = " + allStates.size());

        for (WebElement eachState : allStates) {
            System.out.println("eachState.getText() = " + eachState.getText());
        }
    }
    @Test
    public void test_03(){
        //identify the dropdown with multiple select options
        WebElement multiItemDrop = Driver.getDriver().findElement(By.name("Languages"));

        Select select2 = new Select(multiItemDrop);

        select2.selectByVisibleText("JavaScript");

        List<WebElement> allProgLanguages = select2.getOptions();
        System.out.println("allProgLanguages.size() = " + allProgLanguages.size());

        for (WebElement each : allProgLanguages) {
            System.out.println("each.getText() = " + each.getText());
        }
    }
    @Test
    public void test_04(){
        //Identify the dropdown that does not have select tag
        WebElement websiteDropdown = Driver.getDriver().findElement(By.id("dropdownMenuLink"));
        websiteDropdown.click();
        WebElement google = Driver.getDriver().findElement(By.linkText("Google"));
        google.click();
    }
}
