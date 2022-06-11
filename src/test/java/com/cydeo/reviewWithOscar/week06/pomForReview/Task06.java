package com.cydeo.reviewWithOscar.week06.pomForReview;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {

    @Test
    public void test(){
        //1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        // create object so that you can use elements and methods
        ContactUsPage page = new ContactUsPage();

        //    3. Click on 'Contact Us' button
        page.getElement("Contact us").click();

        //for scrolling test cases
        // create actions object
        // first way
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReviewUtils.staticWait(2);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        ReviewUtils.staticWait(2);

        // second way
        actions.moveToElement(page.submit).perform();

        // third way
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0, 750)");
        ReviewUtils.staticWait(1);
        jse.executeScript("window.scrollBy(0, -750)");
        ReviewUtils.staticWait(1);

        // last way
        jse.executeScript("arguments[0].scrollIntoView(true)",page.submit);
        ReviewUtils.staticWait(2);

        // 4. Enter name, email, subject and message
        Faker faker = new Faker();
        page.name.sendKeys(faker.name().fullName());
        page.email.sendKeys(faker.internet().emailAddress());
        page.subject.sendKeys(faker.chuckNorris().fact());
        page.message.sendKeys(faker.howIMetYourMother().catchPhrase());

        //    5. Upload file
        String path = "C:\\Users\\hrnok\\OneDrive\\Masaüstü\\HTML Class";
        page.uploadFile.sendKeys(path);

        //    6. Click 'Submit' button
        page.submit.click();

        //  7. Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //    8. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String expectedValue = "Success! Your details have been submitted successfully.";
        String actualValue = page.success.getText();

        Assert.assertEquals(actualValue,expectedValue,"Message Test Failed!");

        //    9. Click 'Home' button and verify that landed to home page successfully

    }
}
