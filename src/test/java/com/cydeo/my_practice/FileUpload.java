package com.cydeo.my_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {

    @Test
    public void file_upload_test(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        String path = "D:\\EU08 TEST AUTOMATION\\EU08_HTML\\HTML Class\\audi.jpg";

        Driver.getDriver().findElement(By.id("file-upload")).sendKeys(path);

        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));
        uploadBtn.click();

        String expectedResult = "File Uploaded!";

        WebElement actualResult = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));

        Assert.assertEquals(actualResult.getText(), expectedResult);



    }
}
