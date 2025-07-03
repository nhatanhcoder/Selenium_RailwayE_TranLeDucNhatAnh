package com.tests.ChangePassword;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.LogUtils;
import com.google.gson.JsonObject;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    @Test(dataProvider = "TestDataProvider")
    public void testChangePasswordSuccessfully(JsonObject testData){
        LogUtils.info("Bước 1: Truy cập trang đổi mật khẩu");
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        loginPage.clickOnTab();

        String expectedChangePasswordSuccessMessage = Constants.message.CHANGE_PASSWORD_SUCCESS_MESSAGE;

        LogUtils.info("Bước 2: Đăng nhập vào tài khoản");
        loginPage.loginSuccess();

        LogUtils.info("Bước 3: Truy cập trang đổi mật khẩu");
        changePasswordPage.clickOnTab();

        String password = testData.get("password").getAsString();
        String newPassword = testData.get("newPassword").getAsString();
        String confirmPassword = testData.get("confirmPassword").getAsString();

        LogUtils.info("Bước 4: Thay đổi mật khẩu");
        changePasswordPage.changePassword(password, newPassword, confirmPassword);

        LogUtils.info("Bước 5: Xác nhận thông báo đổi mật khẩu thành công");
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessFullyMessageText(), expectedChangePasswordSuccessMessage);
       }
}
