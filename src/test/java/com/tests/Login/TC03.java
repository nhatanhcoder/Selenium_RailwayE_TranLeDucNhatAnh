package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test
    public void loginFailWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickOnTab();

        String validUserame = Constants.accountData.VALID_USERNAME;
        String invalidPassword = Constants.accountData.INVALID_PASSWORD;
        String expectedLoginFailMessage = Constants.errorMessage.LOGIN_ERROR_MESSAGE;

        loginPage.login(validUserame, invalidPassword);

        Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginFailMessage);

    }

}
