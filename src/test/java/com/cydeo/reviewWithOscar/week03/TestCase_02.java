package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase_02 {

    public static void main(String[] args) {

        //Test Case 2
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        //2.    Login with-----Username: Tester, password: test
       WebElement usernameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
       usernameInput.sendKeys("Tester");

       WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
       passwordInput.sendKeys("test");

       WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
       loginBtn.click();

        //3.    Select one of the checkbox and delete one person
       WebElement checkboxBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
       checkboxBtn.click();

        WebElement deleteBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));
        deleteBtn.click();

        //4.    Then verify that deleted item is no longer exists
        List<WebElement> list = driver.findElements(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        for (WebElement each : list) {
            if(!each.equals("Paul Brown")){
                System.out.println("Deleted item verification passed");
            }else{
                System.out.println("failed");
            }
        }
    }
}
