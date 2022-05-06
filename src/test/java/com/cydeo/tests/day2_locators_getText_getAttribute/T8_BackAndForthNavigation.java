package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T8_BackAndForthNavigation {

    public static void main(String[] args) {

        //TC #8: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.


        //4- Verify title contains:
        //Expected: Gmail
        //5- Go back to Google by using the .back();
        //6- Verify title equals:
        //Expected: Google



    }
}
