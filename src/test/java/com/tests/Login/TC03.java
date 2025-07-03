package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.LogUtils;
import com.google.gson.JsonObject;
import com.tests.Common.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test(dataProvider = "TestDataProvider")
    public void loginFailWithInvalidPassword(JsonObject testData) {
        LoginPage loginPage = new LoginPage();
        LogUtils logUtils = new LogUtils();

        String expectedLoginFailMessage = testData.get("expectedLoginFailMessage").getAsString();
        String username = testData.get("username").getAsString();
        String password = testData.get("password").getAsString();

        //Step1
        logUtils.info("Step 1: Go to login page");
        loginPage.clickOnTab();
        //Step2
        logUtils.info("Step 2: Login with invalid account");
        loginPage.login(username, password);

        //Step3
        logUtils.info("Step 3: Check error message");
        Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedLoginFailMessage);

    }

}
