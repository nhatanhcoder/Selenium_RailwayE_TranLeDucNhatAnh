package com.tests.Login;
import com.Railway.dataObject.Account;
import com.Railway.pages.HomePage;
import com.Railway.utilities.LogUtils;
import com.tests.Common.TestBase;
import com.Railway.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.constant.Constants;


public class TC01 extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        LogUtils logUtils = new LogUtils();

        //Step1
        LogUtils.info("Step 1: Go to login page");
        loginPage.clickOnTab();

        //Step2
        LogUtils.info("Step 2: Login with valid account");
        loginPage.loginSuccess();

        //Step3
        logUtils.info("Step 3: Go to home page");
        homePage.clickOnTab();

        //Check point
        homePage.clickOnTab();
        logUtils.info("Check point: Check welcome message");

        Assert.assertEquals(homePage.getPageHeadingText(), Constants.message.LOGIN_SUCCESS_MESSAGE);
    }
}
