package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {

    public static void main(String[] args) {

        //open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome"); //open Chrome browser
        driver.manage().window().maximize(); // maximize your page

        //go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/"); // to navigate to a website

        //then click on "forgot_password" link
        // 2 ways of using web elements: long way or lazy way
        ReviewUtils.staticWait(1); //we are using Thread.sleep in a cleaner syntax
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        //enter any email
        ReviewUtils.staticWait(1);
        WebElement emailBox = driver.findElement(By.name("email"));
        String expectedEmail = "mike.smith@garbage.com";
        emailBox.sendKeys(expectedEmail);

        //verify that email is displayed in the input box
        //String actualEmail = emailBox.getText(); //let's see if it works?
        // not in the text of the element, it is at the 'value' attribute of the element
        String actualEmail = emailBox.getAttribute("value");

        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification");
        }else{
            System.out.println("FAILED email verification");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        // click on Retrieve password
        // use id
        // driver.findElement(By.id("form_submit")).click();

        // use CSS
        //  driver.findElement(By.cssSelector("#form_submit")).click();

        // using tagName locator, since it is the only one : //button
        //  driver.findElement(By.tagName("//button")).click();

        // use Retrieve word to locate with XPATH : //i[contains(text(),'Retrieve')]
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Message test verification passed");
        }else{
            System.out.println("Message test verification failed");
        }

        //close or quit the page
        driver.close();
    }
}
