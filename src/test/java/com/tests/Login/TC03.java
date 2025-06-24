package com.tests.Login;

import com.example.pages.BasePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test
    public void loginFailWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();

        String validUserame = "nhatanhkof@gmail.com";
        String invalidPassword = "1234xx5678";
        String expectedLoginFailMessage = "There was a problem with your login and/or errors exist in your form.";

        loginPage.login(validUserame, invalidPassword);

        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginFailMessage);

    }

}
