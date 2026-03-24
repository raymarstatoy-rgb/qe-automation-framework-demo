package com.demo.seleniumautomation.base;

import com.demo.seleniumautomation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        this.driver = DriverFactory.getDriver();
    }
}
