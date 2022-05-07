package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task3 {

    public static void main(String[] args) {

        /*
        Task 3:
        You have to implement the following Web automated checks over our
        DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
         • Customer navigation through product categories: Phones, Laptops and Monitors
         Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        driver.findElement(By.partialLinkText("Laptops")).click();

        HandleWait.staticWait(1);

        driver.findElement(By.partialLinkText("Sony vaio i5")).click();

        int expectedPrice = 790;

        HandleWait.staticWait(1);

        //System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = "
               // + driver.findElement(By.tagName("h3")).getText()); $790* includes tax

        String priceText = driver.findElement(By.tagName("h3")).getText();

        int actualPrice = Integer.parseInt(priceText.split(" ")[0].substring(1));
        System.out.println("actualPrice = " + actualPrice);

        if(actualPrice == expectedPrice){
            System.out.println("PASSED");
        }else{
            System.exit(-1);
        }
        driver.close();

    }
}
