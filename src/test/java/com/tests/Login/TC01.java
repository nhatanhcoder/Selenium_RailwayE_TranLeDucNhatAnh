package com.tests.Login;
import com.Railway.pages.HomePage;
import com.Railway.utilities.LogUtils;
import com.google.gson.JsonObject;
import com.tests.Common.TestBase;
import com.Railway.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.constant.Constants;


public class TC01 extends TestBase {

    @Test(dataProvider = "TestDataProvider")
    public void testLogin(JsonObject data) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        String username = data.get("username").getAsString();
        String password = data.get("password").getAsString();

        LogUtils.info("Step 1: Go to login page");
        loginPage.clickOnTab();

        LogUtils.info("Step 2: Login with valid account");
        loginPage.login(username, password);

        LogUtils.info("Step 3: Go to home page");
        homePage.clickOnTab();

        LogUtils.info("Check point: Check welcome message");
        Assert.assertEquals(homePage.getPageHeadingText(), Constants.pageHeading.HOME_PAGE);
    }
}
