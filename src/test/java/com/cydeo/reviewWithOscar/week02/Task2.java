package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {

    public static void main(String[] args) {


        //Basic login authentication
        //- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //- Verify title equals: String expectedTitle = "Web Orders Login"
        //- Enter username: Tester
        //- Enter password: test
        //- Click “Sign In” button
        //- Verify title equals: String expectedHomePageTitle = "Web Orders"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //title verification before log in
        String expectedTitleBeforeLogin = "Web Orders Login";
        if(expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("success");
        }else{
            System.exit(-1);
        }

        WebElement usernameBox = driver.findElement(By.id("ctl100_MainContent_username"));
        WebElement passwordBox = driver.findElement(By.id("ctl100_MainContent_password"));
        WebElement signInButton = driver.findElement(By.id("ctl100_MainContent_login_button"));

        usernameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle = "Web Orders";
        if(expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }


        HandleWait.staticWait(2);
        driver.close();

    }
}
