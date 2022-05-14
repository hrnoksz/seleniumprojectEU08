package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase_01 {

    public static void main(String[] args) {

        //Test Case 1 :  Verify CheckBox, CheckAll and UncheckAll Buttons
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

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        //3.    Click on check all button verify all the checkboxes are checked
        WebElement checkAllBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']"));
        checkAllBtn.click();

        List<WebElement> lists = driver.findElements(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        for (WebElement each : lists) {
            System.out.println("each.isSelected() = " + each.isSelected());
        }

        //4.    Click on uncheck all button verify that all the checkboxes are unchecked
        WebElement uncheckAllBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
        uncheckAllBtn.click();
        List<WebElement> lists1 = driver.findElements(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        for (WebElement each : lists1) {
            System.out.println("each.isSelected() = " + each.isSelected());
        }



    }
}
