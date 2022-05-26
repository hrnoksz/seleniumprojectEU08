package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {


    @Test
    public void reading_from_properties_test() throws IOException {
        //1- Create the object of Properties
        Properties properties = new Properties();

        //2- We need to open the file in java memory: FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");
        //To get "configuration.properties"
        // right-click on the configuration.properties files
        // then click on the copy path / reference button
        // next select "Path From Content Root"

        //3- Load the properties object using FileInputStream object
        properties.load(file); // to handle checked exception, we use "throws" keyword in the method signature

        //4- Use "properties" object to read value
        properties.getProperty("chrome"); //we get "chrome" configuration.properties file
        properties.getProperty("env"); // we get "env" configuration.properties file
        properties.getProperty("username"); //we get "username" configuration.properties file

        //properties.getProperty("chrome").soutv
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }
}
