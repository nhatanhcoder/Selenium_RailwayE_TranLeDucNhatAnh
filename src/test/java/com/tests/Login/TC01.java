package com.tests.Login;

import com.tests.TestBase;
    
import com.example.pages.LoginPage;
import com.example.pages.BasePage;
import com.example.pages.HomePage;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

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
