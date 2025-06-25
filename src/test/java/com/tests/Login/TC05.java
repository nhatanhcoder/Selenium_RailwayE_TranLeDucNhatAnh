package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    @Test
    public void testMultipleWrongPasswordAttempts() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickOnTab();

        String validUsername = Constants.accountData.VALID_USERNAME;
        String invalidPassword = Constants.accountData.INVALID_PASSWORD;
        String expectedMessage = Constants.errorMessage.LOGIN_FAIL_MULTIPLE_MESSAGE;

        // Repeat login attempts 3 times with the wrong password
        loginPage.logiFailMulipletime(validUsername, invalidPassword);

        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedMessage);
    }
}
