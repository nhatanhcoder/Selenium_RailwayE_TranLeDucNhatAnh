package com.tests.Login;

import com.example.pages.BasePage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test
    public void testLoginWithUnactive() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();

        String expectedLoginWithUnactiveEmailMessage = "Invalid username or password. Please try again.";
        String unactiveUsername = "nhatanh221@gmail.com";
        String validPassword = "123324234";

        loginPage.login(unactiveUsername, validPassword);


        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginWithUnactiveEmailMessage);
    }
}
