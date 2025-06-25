package com.tests.Login;
import com.Railway.pages.HomePage;
import com.tests.TestBase;
import com.Railway.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.constant.Constants;


public class TC01 extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        loginPage.clickOnTab();

        String expectedWelcomeMessage = Constants.message.WELCOME_MESSAGE;
        String validUsername = Constants.accountData.VALID_USERNAME;
        String validPassword = Constants.accountData.VALID_PASSWORD;

        loginPage.login(validUsername, validPassword);

        homePage.clickOnTab();

        Assert.assertEquals(homePage.getPageHeadingText(), expectedWelcomeMessage);
    }
}
