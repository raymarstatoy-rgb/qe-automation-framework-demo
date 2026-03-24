package com.demo.seleniumautomation.pages;

import com.demo.seleniumautomation.base.BasePage;
import com.demo.seleniumautomation.config.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    //Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    private By inventoryTitle = By.className("title");

    //Opening login page using config
    public void openLoginPage(){
        String env = ConfigReader.get("env");
        String url = ConfigReader.get(env+".url");
        driver.get(url);
    }

    //Login to site
    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    //Validating Login
    public boolean isInventoryPageDisplayed() {
        return driver.findElement(inventoryTitle).isDisplayed();
    }

}
