package com.tests.ChangePassword;

import com.example.pages.BasePage;
import com.example.pages.ChangePasswordPage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    @Test
    public void testChangePasswordSuccessfully(){
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();

        String validUsername = "nhatanhkof@gmail.com";
        String validPassword = "password";
        String newPassword = "password22";
        String confirmNewPassword = "password22";
        String expectedChangePasswordSuccessMessage = "Your password has been updated";

        loginPage.login(validUsername, validPassword);

        basePage.clickChangePasswordTab();

        basePage.scrollToBottom();

        changePasswordPage.changePassword(validPassword, newPassword, confirmNewPassword);

        org.testng.Assert.assertEquals(changePasswordPage.getChangePasswordSuccessFullyMessageText(), expectedChangePasswordSuccessMessage);
    }
}
