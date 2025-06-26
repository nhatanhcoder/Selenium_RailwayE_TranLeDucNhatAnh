package com.tests.ChangePassword;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.Helpers;
import com.tests.Common.TestBase;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    @Test
    public void testChangePasswordSuccessfully(){
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        loginPage.clickOnTab();

        String validUsername = Constants.accountData.VALID_USERNAME;
        String validPassword = Constants.accountData.VALID_PASSWORD;
        String newPassword = "password22";
        String confirmNewPassword = newPassword;
        String expectedChangePasswordSuccessMessage = Constants.message.CHANGE_PASSWORD_SUCCESS_MESSAGE;

        loginPage.login(validUsername, validPassword);

        changePasswordPage.clickOnTab();

        changePasswordPage.changePassword(validPassword, newPassword, confirmNewPassword);

        org.testng.Assert.assertEquals(changePasswordPage.getChangePasswordSuccessFullyMessageText(), expectedChangePasswordSuccessMessage);
       }
}
