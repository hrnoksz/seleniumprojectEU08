package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonTwo {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com/radio_buttons");
    }
    @Test
    public void test(){
        WebElement basketballRadioButton = Driver.getDriver().findElement(By.id("basketball"));
        System.out.println("basketballRadioButton.isSelected() = " + basketballRadioButton.isSelected());

        basketballRadioButton.click();

        List<WebElement> allSportRadios = Driver.getDriver().findElements(By.name("sport"));
        System.out.println("allSportRadios.size() = " + allSportRadios.size());

        for (WebElement eachRadioBtn : allSportRadios) {
            System.out.println("eachRadioBtn.getText() = " + eachRadioBtn.getText());
            System.out.println("eachRadioBtn.isSelected() = " + eachRadioBtn.isSelected());
            System.out.println("eachRadioBtn.isEnabled() = " + eachRadioBtn.isEnabled());
        }

    }
}
