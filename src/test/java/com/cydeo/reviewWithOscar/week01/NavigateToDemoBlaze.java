package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoBlaze {

    public static void main(String[] args) {

        // https://www.demoblaze.com/index.html
        // Verify Title "STORE"

        // Analogy: Taxi Driver Example
        // taxi car: browser-Chrome, taxiDriver: Selenium Webdriver- who can drive this particular car

        WebDriverManager.chromedriver().setup(); // I am setting up my taxi driver

        WebDriver driver = new ChromeDriver();// the car itself --- This line opens an empty Chrome webPage
        // there is polymorphism: WebDriver is an interface, ChromeDriver is the concrete class

        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/index.html");

        //  driver.navigate().to("https://www.demoblaze.com/index.html");

        String expectedTitle = "STORE"; // comes from documentation, SRS: Software Requirements Specification

        String actualTitle = driver.getTitle();

        // As a tester, without verification what is your VALUE to the Company
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
