package com.vsc.framework.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class ConfigReader {
    private static Properties properties;

    static {
        properties = new Properties();

          try {
           FileInputStream  fileInputStream = new FileInputStream("src/main/resources/config.properties");
                   properties.load(fileInputStream);

       }catch (IOException exception){

              throw new RuntimeException(
                      "Failed to load config.properties",exception
              );

       }
    }

    public static String getProperty (String key){
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
