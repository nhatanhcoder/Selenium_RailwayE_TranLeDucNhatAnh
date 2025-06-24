package com.tests.ResetPassword;

import com.example.pages.BasePage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC12 extends TestBase {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();

        String expectedWelcomeMessage = "Welcome to Safe Railway";
        String validUsername = "nhatanhkof@gmail.com";
        String validPassword = "12345678";

        loginPage.login(validUsername, validPassword);

        basePage.clickHomeTab();

        org.testng.Assert.assertEquals(homePage.getWelcomeMessageText(), expectedWelcomeMessage);
    }
}
