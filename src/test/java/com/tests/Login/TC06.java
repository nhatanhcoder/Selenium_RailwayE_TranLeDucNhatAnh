package com.tests.Login;

import com.example.pages.BasePage;
import com.example.pages.ChangePasswordPage;
import com.example.pages.LoginPage;
import com.example.pages.MyTicketPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC06 extends TestBase {

    @Test
    public void testAdditionalPagesAfterLogin() {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();

        MyTicketPage myTicketPage = new MyTicketPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        basePage.clickLoginTab();

        String validUsername = "nhatanhkof@gmail.com";
        String validPassword = "12345678";

        // Login with valid credentials
        loginPage.login(validUsername, validPassword);

        // "My ticket", "Change password" and "Logout" tabs are displayed.
        basePage.checkMyTicketTabIsDisplayed();
        basePage.checkChangePasswordTabIsDisplayed();
        basePage.checkLogoutTabIsDisplayed();

        // Verify user is directed to My ticket page
        basePage.clickMyTicketTab();
        String myTicketTitle = "Manage ticket";
        org.testng.Assert.assertEquals(myTicketPage.getMyticketTilteText(), myTicketTitle);

        // Verify user is directed to the Change password page
        basePage.clickChangePasswordTab();
        String changePasswordTitle = "Change password";
        org.testng.Assert.assertEquals(changePasswordPage.getChangePasswordTitleText(), changePasswordTitle);



    }
}



