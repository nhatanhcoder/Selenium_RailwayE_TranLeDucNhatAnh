package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Account;
import com.Railway.pages.BasePage;
import com.Railway.pages.HomePage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;

import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test
    public void testLoginWithUnactive() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        LogUtils.info("Step 1: Go to login page");
        loginPage.clickOnTab();
        String expectedLoginWithUnactiveEmailMessage = Constants.errorMessage.LOGIN_INVALID_ACCOUNT_MESSAGE;
        String unactiveUsername = Constants.accountData.UNACTIVE_EMAIL;
        String validPassword = Constants.accountData.VALID_PASSWORD;
        LogUtils.info("Step 2: Login with unactive account");
        loginPage.login(Account.VALID_ACCOUNT);
        LogUtils.info("Step 3: Check error message for unactive account");
        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginWithUnactiveEmailMessage);
    }
}
