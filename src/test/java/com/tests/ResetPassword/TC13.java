package com.tests.ResetPassword;

import com.Railway.constant.Constants;
import com.Railway.pages.LoginPage;
import com.Railway.pages.ResetPasswordPage;
import com.Railway.thirdPartyPage.guerrillamailPage;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 extends TestBase {
    @Test
    public void testResetNotMatchPassword() {
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
        String unmatchNewPassword = Constants.accountData.NEW_PASSWORD+"sdad";;
        resetPasswordPage.resetPasswordNotMatch(newPassword,unmatchNewPassword);

        Assert.assertEquals(resetPasswordPage.getResetPasswordFailMessageText(), Constants.errorMessage.RESET_PASS_ERROR_MESSAGE);
        Assert.assertEquals(resetPasswordPage.getNotMatchedPassValidationText(), Constants.validationMessage.RESET_CONFIRM_NOTMATCH);
    }
}

