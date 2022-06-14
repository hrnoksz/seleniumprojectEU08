package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {

    public static void main(String[] args) {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //identify the select element
        WebElement dropDownElement = Driver.getDriver().findElement(By.id("dropdown"));

        //Wrap this element inside Select object
        Select selectObject = new Select(dropDownElement);

        //use ready methods to select option
        selectObject.selectByIndex(2); //index number starts from ZERO
        selectObject.selectByValue("2");
        selectObject.selectByVisibleText("Option 2");

        //verify determined option is selected
        String expectedObj = "Option 2";
        String actualObj = selectObject.getFirstSelectedOption().getText();

        if(actualObj.equals(expectedObj)){
            System.out.println("Option 2 selection is passed");
        }else{
            System.out.println("Failed");
        }

        System.out.println("---------------------------------------------------------");

        WebElement dropDown = Driver.getDriver().findElement(By.id("state"));

        Select select = new Select(dropDown);

        select.selectByIndex(1);

        select.selectByValue("AL");

        select.selectByVisibleText("Alabama");

        System.out.println("select.getOptions().size() = " + select.getOptions().size());

        List<WebElement> options = select.getOptions();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        int size = options.size();

        for (int i = 0; i < size; i++) {
            System.out.println(options.get(i).getText());
        }



        System.out.println("--------------------------------------------------------------");

        WebElement dropDownYear = Driver.getDriver().findElement(By.id("year"));

        Select selectDropDownYear = new Select(dropDownYear);

        List<WebElement> years = selectDropDownYear.getOptions();

        int size1 = years.size();

        System.out.println(size1);

        for (int i = 0; i < size1; i++) {
            System.out.println(years.get(i).getText());
        }

        System.out.println("----------------------------------------------------");

        WebElement dropDownMonth = Driver.getDriver().findElement(By.id("month"));

        Select selectDropDownMonth = new Select(dropDownMonth);

        List<WebElement> months = selectDropDownMonth.getOptions();

        int size2 = months.size();

        System.out.println(size2);

        for (WebElement eachMonth : months) {
            System.out.println(eachMonth.getText());
        }

        System.out.println("----------------------------------------------------");

        WebElement dropDownDay = Driver.getDriver().findElement(By.id("day"));

        Select selectDropDownDay = new Select(dropDownDay);

        List<WebElement> days = selectDropDownDay.getOptions();

        int size3 = days.size();

        System.out.println(size3);

        for (WebElement eachDay : days) {
            System.out.println(eachDay.getText());
        }



    }
}
