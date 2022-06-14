package com.cydeo.reviewWithOscar.week06.Webstauranttask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchval")
    public WebElement searchBox;
}
