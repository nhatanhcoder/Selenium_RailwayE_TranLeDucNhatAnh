package com.tests.Register;

import com.example.pages.BasePage;
import com.example.pages.RegisterPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC07 extends TestBase {

    @Test
    public void testRegisterUser() {
        BasePage basePage = new BasePage();
        RegisterPage registerPage = new RegisterPage();

        basePage.clickRegisterTab();

        String validEmail = "nhatanh221@gmail.com";
        String validPassword = "123324234";
        String validConfirmPassword = "123324234";
        String validPID = "123324234";
        String expectedRegisterSuccessMessage = "Thank you for registering your account";

        basePage.scrollToBottom();
        registerPage.register(validEmail, validPassword, validConfirmPassword, validPID);

        org.testng.Assert.assertEquals(registerPage.getRegisterSuccessFullyMessageText(), expectedRegisterSuccessMessage);

    }
}
