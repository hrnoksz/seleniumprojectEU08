package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        //1- Set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the driver
        // This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //3- Test if the driver is working as expected
        driver.get("https://www.tesla.com");

        // get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using Selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        //Use selenium to navigate forward
        driver.navigate().forward();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use selenium to navigate refresh
        driver.navigate().refresh();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to()
        driver.navigate().to("https://www.google.com");

        // get the current title after getting the google page
        currentTitle = driver.getTitle();

        //get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        //String currentTitle = driver.getTitle(); //If we remove from here under driver.get("https://www.tesla.com");
        // then current title will be "tesla", otherwise "google"
        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using Selenium
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


    }
}
