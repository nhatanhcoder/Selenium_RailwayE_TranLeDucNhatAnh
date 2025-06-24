package com.tests.Register;

import com.example.pages.BasePage;
import com.example.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    @Test
    public void testRegisterWithEmptyPIDnPassword() {
        BasePage basePage = new BasePage();
        RegisterPage registerPage = new RegisterPage();

        basePage.clickRegisterTab();

        String validEmail = "nhatanh221@gmail.com";
        String emptyPassword = "";
        String validConfirmPassword = "123324234";
        String emptyPID = "123324234";
        String expectedPasswordValidationMessage = "Invalid password length";
        String expectedPIDValidationMessage = "Invalid PID length";

        basePage.scrollToBottom();
        registerPage.register(validEmail, emptyPassword, validConfirmPassword, emptyPID);

        org.testng.Assert.assertEquals(registerPage.getValidationPasswordMessageText(), expectedPasswordValidationMessage);

    }
}
