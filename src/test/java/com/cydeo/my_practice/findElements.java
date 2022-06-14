package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class findElements {

    public static void main(String[] args) {

        Driver.getDriver().get("https://practice.cydeo.com/radio_buttons");

        List<WebElement> allColors = Driver.getDriver().findElements(By.name("color"));

        System.out.println("allColors.size() = " + allColors.size());

        for (WebElement eachColor : allColors) {
            System.out.println(eachColor.getAttribute("id"));
            System.out.println("eachColor.isSelected() = " + eachColor.isSelected());
            System.out.println("eachColor.isEnabled() = " + eachColor.isEnabled());
        }

        System.out.println("---------------------------------------------------------");

        List<WebElement> allSports = Driver.getDriver().findElements(By.name("sport"));

        System.out.println("allSports.size() = " + allSports.size());

        for (WebElement eachSport : allSports) {
            System.out.println(eachSport.getAttribute("id"));
            System.out.println(eachSport.isSelected());
            System.out.println(eachSport.isEnabled());
        }

    }
}
