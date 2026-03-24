package com.demo.seleniumautomation.base;

import com.demo.seleniumautomation.utils.DriverFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
