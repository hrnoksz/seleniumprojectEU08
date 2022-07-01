package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengeTask {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://saucedemo.com");
    }
    @Test
    public void test2(){
        //print out the page title
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

        //Enter username provided: standard_user
        WebElement username = Driver.getDriver().findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Enter password provided: secret_sauce
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click ol login button to log in
        WebElement login = Driver.getDriver().findElement(By.id("login-button"));
        login.submit();

        //Get the name and price of the first product
        WebElement firstProduct = Driver.getDriver().findElement(By.className("inventory_item_name"));
        System.out.println("firstProduct.getText() = " + firstProduct.getText());

        WebElement firstProPrice = Driver.getDriver().findElement(By.className("inventory_item_price"));

        System.out.println("firstProPrice.getText() = " + firstProPrice.getText());

        //Get all product names into list<WebElement>
        List<WebElement> allProductTitle = Driver.getDriver().findElements(By.className("inventory_item_name"));

            //get the count
        System.out.println("allProductTitle.size() = " + allProductTitle.size());

            //print out the text of all products
        for (WebElement eachProduct : allProductTitle) {
            System.out.println("eachProduct.getText() = " + eachProduct.getText());
        }

        //Click on the shopping cart link top right corner
        WebElement shoppingCart = Driver.getDriver().findElement(By.id("shopping_cart_container"));
        shoppingCart.click();

        //Click on continue to shop button to come back to product page
        WebElement shopBtn = Driver.getDriver().findElement(By.id("continue-shopping"));
        shopBtn.click();

    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
