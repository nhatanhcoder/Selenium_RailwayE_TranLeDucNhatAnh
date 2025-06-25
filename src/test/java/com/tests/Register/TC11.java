package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    @Test
    public void testRegisterWithEmptyPIDnPassword() {
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String validEmail = Constants.accountData.VALID_REGISTERING_EMAIL;
        String emptyPassword = "";
        String validConfirmPassword = "123324234";
        String emptyPID = "";
        String expectedPasswordValidationMessage = Constants.validationMessage.INVALID_PASSWORD_FORMAT;
        String expectedPIDValidationMessage = Constants.validationMessage.INVALID_PID_FORMAT;
        String expectedRegisterErrorMessage = Constants.errorMessage.REGISTER_ERROR_MESSAGE;

        registerPage.register(validEmail, emptyPassword, validConfirmPassword, emptyPID);

        Assert.assertEquals(registerPage.getErrorMessageText(), expectedRegisterErrorMessage);
        Assert.assertEquals(registerPage.getValidationConfirmPasswordMessageText(), expectedPasswordValidationMessage);
        Assert.assertEquals(registerPage.getValidationPidNumberMessageText(), expectedPIDValidationMessage);
    }
}
