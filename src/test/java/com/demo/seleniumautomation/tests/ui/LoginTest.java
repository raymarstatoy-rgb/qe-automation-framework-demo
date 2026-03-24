package com.demo.seleniumautomation.tests.ui;

import com.demo.seleniumautomation.base.BaseTest;
import com.demo.seleniumautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void validateLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage();
        loginPage.login("standard_user","secret_sauce");

        Assert.assertTrue(
                loginPage.isInventoryPageDisplayed(),
                "Inventory page should be displayed after a successful login"
        );
    }
}
