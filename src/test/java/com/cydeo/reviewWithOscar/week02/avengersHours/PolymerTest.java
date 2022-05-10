package com.cydeo.reviewWithOscar.week02.avengersHours;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        //maximize page
        driver.manage().window().maximize();

        // our driver object bring us many useful methods from the library
        driver.get("http://todomvc.com/");

        //click within the JavaScript tab

        WebElement JSElement = driver.findElement(By.xpath("//div[.='JavaScript']"));

        // why do we locate a web element? to do an action on it
        JSElement.click();

        //select the Polymer link
        WebElement polymerLink = driver.findElement(By.linkText("Polymer"));
        polymerLink.click();

        //The second step should be: Add one Todo item
        String toDoItem = "This Todo Item is added by user";

        HandleWait.staticWait(1);
        WebElement toDoBox = driver.findElement(By.id("new-todo"));
        toDoBox.sendKeys(toDoItem+ Keys.ENTER);

        //to locate the web element for item we entered: //label[.='customText']

        //String locator = "//label[.='customText']"; //I want to use text I am sending as String variable

        String locator = "//label[.='"+toDoItem+"']";
        HandleWait.staticWait(1);
        WebElement customToDoItem = driver.findElement(By.xpath(locator));

        if(customToDoItem.isDisplayed()){
            System.out.println("We added our toDo item successfully");
        }


    }


}
