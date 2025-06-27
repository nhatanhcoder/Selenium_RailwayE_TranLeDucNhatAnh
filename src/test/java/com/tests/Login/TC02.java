package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    @Test
    public void testLoginFail() {
        LoginPage loginPage = new LoginPage();


        loginPage.clickOnTab();

        String nullUsername = Constants.accountData.NULL_USERNAME;
        String validPassword = Constants.accountData.VALID_PASSWORD;
        String expectedLoginFailMessage = Constants.errorMessage.LOGIN_ERROR_MESSAGE;

        loginPage.login(nullUsername, validPassword);

        Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginFailMessage);

    }
}
