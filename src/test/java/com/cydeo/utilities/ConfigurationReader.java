package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1-Create properties obj, we make it private so it's not
    // accessible from other classes, static to make sure its created and loaded before everything else
    private static Properties properties = new Properties();

    static{
        try {
            //2 - Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file"
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }
    //create utility method to use the object to read
    public static String getProperty (String keyword){
        return properties.getProperty(keyword);
    }
}