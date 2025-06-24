package com.tests.Register;

import com.example.pages.BasePage;
import com.example.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC10 extends TestBase {

    @Test
    public void testRegisterPasswordNotMatch() {
        BasePage basePage = new BasePage();
        RegisterPage registerPage = new RegisterPage();

        basePage.clickRegisterTab();

        String validEmail = "nhatanh221@gmail.com";
        String validPassword = "1324234chao";
        String unmatchConfirmPassword = "1324234";
        String validPID = "21312321";
        String expectedConfirmPasswordValidationMessage = "The two passwords do not match";

        basePage.scrollToBottom();
        registerPage.register(validEmail, validPassword, unmatchConfirmPassword, validPID);

        org.testng.Assert.assertEquals(registerPage.getValidationConfirmPasswordMessageText(), expectedConfirmPasswordValidationMessage);

    }
}
