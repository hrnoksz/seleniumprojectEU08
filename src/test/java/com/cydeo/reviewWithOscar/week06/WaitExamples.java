package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.WaitTasksPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExamples {

   WaitTasksPage page; //declare
   WebDriverWait wait;

   @BeforeMethod
   public void  setupMethod(){
       Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
       page = new WaitTasksPage(); //initialize
       wait = new WebDriverWait(Driver.getDriver(), 10);
   }
   @AfterMethod
    public void tearDown(){
       //screenshot option - if your test case fail you will need screenshot
       ReviewUtils.staticWait(2); //optional
       Driver.closeDriver();
   }
   @Test
   public void task_1(){
      page.alertActivate.click();
      //selenium.NoAlertPresentException: no such alert
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = Driver.getDriver().switchTo().alert();
      alert.accept();
   }

   @Test
   public void task_2(){
      //Click on "Enable button after 10 seconds"
      page.enable.click();

      // Explicitly wait until the button is enabled
      wait.until(ExpectedConditions.elementToBeClickable(page.disable));

      // Then verify the button is enabled
      Assert.assertTrue(page.disable.isEnabled());

   }

   /*
-> Implicit wait time is set once globally and applies to all steps.
-> Explicit wait is applied to a specific element on the page

-> Implicit wait works with findElement method and waits until element is present in html/dom (document object model)
-> Explicit wait can be applied with different conditions that are available in ExpectedConditions class

-> Implicit wait stops waiting as soon as element is found in the html/dom
-> Explicit wait stops waiting when certain condition is met. like visibility of elem. or enable of elem etc

-> Implicit wait throws NoSuchElementException if element does not appear in html/dom during the timeout
-> Explicit wait throws TimeOutException if condition is not met within the specified seconds
    */



    //Task1:
    //    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    //    2. Click on "Click me, to Open an alert after 5 seconds"
    //    3. Explicitly wait until alert is present
    //    4. Then handle the Javascript alert

   //Task2
   //    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
   //    2. Click on "Enable button after 10 seconds"
   //    3. Explicitly wait until the button is enabled
   //    4. Then verify the button is enabled
}
