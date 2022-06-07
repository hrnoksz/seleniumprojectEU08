package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchBlue extends TestBaseForAvengers{

    @Test
    public void search_blue_test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        //3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        ReviewUtils.getLink("Products");

        WebElement searchBox = Driver.getDriver().findElement(By.id("search_product"));
        searchBox.sendKeys("blue" + Keys.ENTER);

        WebElement searchButton = Driver.getDriver().findElement(By.id("submit_search"));
        searchButton.click();

        //get the names of products that comes with search
        List<WebElement> elementsList = Driver.getDriver().findElements(By.xpath("//img[contains(@src,'product_picture')]/../p"));
        for (WebElement webElement : elementsList) {
            System.out.println("webElement.getText() = " + webElement.getText());
            Assert.assertTrue(webElement.getText().toLowerCase().contains("blue"));
        }
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //6. Enter "blue" in search input and click search button
        //7. Verify 'SEARCHED PRODUCTS' have only items that have "blue" keyword in it.
    }
}
