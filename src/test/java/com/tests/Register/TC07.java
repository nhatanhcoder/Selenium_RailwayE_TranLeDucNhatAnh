package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC07 extends TestBase {

    @Test
    public void testRegisterUser() {
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String validEmail = Constants.accountData.VALID_REGISTERING_EMAIL;
        String validPassword = Constants.accountData.VALID_REGISTERING_PASSWORD;
        String validConfirmPassword = validPassword;
        String validPID = Constants.accountData.VALID_REGISTERING_PID;
        String expectedRegisterSuccessMessage = Constants.message.REGISTER_SUCCESS_MESSAGE;

        registerPage.register(validEmail, validPassword, validConfirmPassword, validPID);

        org.testng.Assert.assertEquals(registerPage.getRegisterSuccessFullyMessageText(), expectedRegisterSuccessMessage);

    }
}
