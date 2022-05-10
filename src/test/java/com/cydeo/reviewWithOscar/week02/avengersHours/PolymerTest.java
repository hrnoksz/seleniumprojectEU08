package com.cydeo.reviewWithOscar.week02.avengersHours;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class PolymerTest {
    /*
    Write a basic browser automation framework to validate a Polymer website.
    The focus should be on the interaction with the browser.
    The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
     */
    public static void main(String[] args) {

        //The first step should be to load the website
        //From Selenium Library (Version 3 - pom.xml: dependency) we use WebDriver Interface, and
        // with a polymorphic way we create driver instance
        // driver instance initiates a 'session', until we say driver.close or driver.quit

        WebDriver driver = WebDriverFactory.getDriver("Chrome"); //opens an empty Chrome browser
        driver.manage().window().maximize();

        // our driver object bring us many useful methods from the library
        driver.get("http://todomvc.com/");


    }


}
