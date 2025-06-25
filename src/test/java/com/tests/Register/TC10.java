package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC10 extends TestBase {

    @Test
    public void testRegisterPasswordNotMatch() {
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String validEmail = Constants.accountData.VALID_REGISTERING_EMAIL;
        String validPassword = Constants.accountData.VALID_REGISTERING_PASSWORD;
        String unmatchConfirmPassword = validPassword+"sadasd";
        String validPID = Constants.accountData.VALID_REGISTERING_PID;
        String expectedConfirmPasswordValidationMessage = Constants.validationMessage.PASSWORD_NOT_MATCH;

        registerPage.register(validEmail, validPassword, unmatchConfirmPassword, validPID);

        org.testng.Assert.assertEquals(registerPage.getValidationConfirmPasswordMessageText(), expectedConfirmPasswordValidationMessage);

    }
}
