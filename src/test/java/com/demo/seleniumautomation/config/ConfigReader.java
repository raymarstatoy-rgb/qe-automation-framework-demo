package com.demo.seleniumautomation.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties ();

    static {
        try {
            System.out.println("DEBUG Loading config properties");
            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null){
                System.out.println("DEBUG config not found");
                throw new RuntimeException("config.properties not found");
            }
            properties.load(input);
            System.out.println("DEBUG config loaded success");

        } catch (Exception e){
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
