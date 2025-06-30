package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    @Test
    public void testMultipleWrongPasswordAttempts() {
        LoginPage loginPage = new LoginPage();
        LogUtils.info("Bước 1: Truy cập trang đăng nhập");
        loginPage.clickOnTab();
        String validUsername = Constants.accountData.VALID_USERNAME;
        String invalidPassword = Constants.accountData.INVALID_PASSWORD;
        String expectedMessage = Constants.errorMessage.LOGIN_FAIL_MULTIPLE_MESSAGE;
        LogUtils.info("Bước 2: Thử đăng nhập sai mật khẩu 3 lần");
        loginPage.logiFailMulipletime(validUsername, invalidPassword);
        LogUtils.info("Bước 3: Kiểm tra thông báo lỗi sau nhiều lần đăng nhập thất bại");
        org.testng.Assert.assertEquals(loginPage.getLoginFailMessageText(), expectedMessage);
    }
}
