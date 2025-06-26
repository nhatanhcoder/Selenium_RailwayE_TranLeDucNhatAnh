package com.tests.ResetPassword;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.HomePage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.ResetPasswordPage;
import com.Railway.thirdPartyPage.guerrillamailPage;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends TestBase {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        guerrillamailPage guerrillamailPage1 = new guerrillamailPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        loginPage.clickOnTab();

        loginPage.clickOnForgotPasswordLink();

        String Email= Constants.accountData.MAIL_SERVICE_NAME+"@"+Constants.accountData.MAIL_SERVICE_DOMAIN;

        loginPage.enterForgotPasswordEmail(Email);

        guerrillamailPage1.openMailBox();
        guerrillamailPage1.setupMailAndSelectEmailAndClickLink();

        String newPassword = Constants.accountData.NEW_PASSWORD;
        resetPasswordPage.resetPassword(newPassword, newPassword);

       // Assert.assertEquals(resetPasswordPage.);
    }
}
