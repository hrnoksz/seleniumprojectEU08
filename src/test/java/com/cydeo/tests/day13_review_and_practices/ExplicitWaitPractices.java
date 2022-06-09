package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }
    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        /*
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//!!!!!!!!!!!!!implicit way is off
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);//explicit way
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
         */
        //Since we create waitForInvisibilityOf() method within BrowserUtils, we can use this method
        //instead of three lines of codes above(between line 30 and 32)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try {
            //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
            //assertFalse method will pass the test, if the boolean value returned is: false
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));
    }
}
/*
TC #3: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.
 */