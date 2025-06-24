package com.tests.Login;

import com.example.pages.BasePage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    @Test
    public void testLoginFail() {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();
        
        String nullUsername = "";
        String validPassword = "12345678";
        String expectedLoginFailMessage = "There was a problem with your login and/or errors exist in your form.";

        loginPage.login(nullUsername, validPassword);

        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginFailMessage);

    }
}
