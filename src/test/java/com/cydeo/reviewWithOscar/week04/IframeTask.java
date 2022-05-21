package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTask {

    @Test
    public void iframeTest(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // we need to change frame
        driver.switchTo().frame(0);

        ReviewUtils.staticWait(2);
        WebElement demoElement =    driver.findElement(By.id("demo"));

        String demoText = demoElement.getText();

        System.out.println("demoText = " + demoText);

        driver.close();

    }

}
