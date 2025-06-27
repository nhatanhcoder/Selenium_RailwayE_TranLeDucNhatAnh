package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Account;
import com.Railway.pages.BasePage;
import com.Railway.pages.HomePage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;

import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test
    public void testLoginWithUnactive() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        loginPage.clickOnTab();

        String expectedLoginWithUnactiveEmailMessage = Constants.errorMessage.LOGIN_INVALID_ACCOUNT_MESSAGE;
        String unactiveUsername = Constants.accountData.UNACTIVE_EMAIL;
        String validPassword = Constants.accountData.VALID_PASSWORD;

        loginPage.login(Account.VALID_ACCOUNT);


        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginWithUnactiveEmailMessage);
    }
}
