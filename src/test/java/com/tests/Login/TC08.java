package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.pages.LoginPage;
import com.Railway.pages.RegisterPage;
import com.Railway.utilities.Helpers;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;

import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test
    public void testLoginWithUnactive() {
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();

        LogUtils.info("Step 1: Go to Register page");
        registerPage.clickOnTab();

        LogUtils.info("Step 2: Register new account");
        String newMail = Helpers.CeateEmailForRegister();
        registerPage.registerSuccessFully(newMail, Constants.accountData.VALID_PASSWORD);

        LogUtils.info("Step 3: Check register new account");
        registerPage.registerSuccessFully(registerPage.getRegisterSuccessFullyMessageText(), Constants.message.REGISTER_SUCCESS_MESSAGE);

        LogUtils.info("Step 4: Go to login page");
        loginPage.clickOnTab();

        String expectedLoginWithUnactiveEmailMessage = Constants.errorMessage.LOGIN_INVALID_ACCOUNT_MESSAGE;
        String validPassword = Constants.accountData.VALID_PASSWORD;
        LogUtils.info("Step 5: Login with unactive account");
        loginPage.login(newMail, validPassword);
        LogUtils.info("Step 6: Check error message for unactive account");
        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginWithUnactiveEmailMessage);
    }
}
