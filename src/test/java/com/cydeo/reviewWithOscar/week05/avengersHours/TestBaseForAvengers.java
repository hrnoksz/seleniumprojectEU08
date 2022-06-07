package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseForAvengers {

    @BeforeMethod
    public void setupTestEnvironment(){

        Driver.getDriver().get(ConfigurationReader.getProperty("urlExercise"));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
