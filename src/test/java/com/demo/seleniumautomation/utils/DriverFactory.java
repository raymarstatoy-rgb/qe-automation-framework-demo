package com.demo.seleniumautomation.utils;

import com.demo.seleniumautomation.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    //Thread-safe Webdriver (for parallel execution)
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Creating driver
    public static void initDriver(){
        String browser = ConfigReader.get("browser");

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else {
            throw new RuntimeException("Unsupported browser : " + browser);
        }

        getDriver().manage().window().maximize();
    }

    //Get Driver
    public static WebDriver getDriver(){
        return driver.get();
    }

    //Quit driver
    public static void quitDriver(){
        if(getDriver() != null){
            getDriver().quit();
            driver.remove();
        }
    }
}
