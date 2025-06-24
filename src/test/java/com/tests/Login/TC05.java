package com.tests.Login;

import com.example.pages.BasePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    @Test
    public void testMultipleWrongPasswordAttempts() {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();

        basePage.clickLoginTab();

        String validUsername = "nhatanhkof@gmail.com";
        String invalidPassword = "wrongpassword";
        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        // Repeat login attempts 4 times with the wrong password
        for (int i = 0; i <= 4; i++) {
            loginPage.login(validUsername, invalidPassword);
            loginPage.clearLoginForm();
            basePage.scrollToBottom();
        }

        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedMessage);
    }
}
