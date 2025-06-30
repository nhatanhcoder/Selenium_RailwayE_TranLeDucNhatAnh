package com.tests.ChangePassword;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Account;
import com.Railway.pages.BasePage;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import com.tests.Common.TestBase;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    @Test
    public void testChangePasswordSuccessfully(){
        LogUtils.info("Bước 1: Truy cập trang đổi mật khẩu");
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        loginPage.clickOnTab();

        String validUsername = Constants.accountData.VALID_USERNAME;
        String validPassword = Constants.accountData.VALID_PASSWORD;
        String newPassword = "password22";
        String confirmNewPassword = newPassword;
        String expectedChangePasswordSuccessMessage = Constants.message.CHANGE_PASSWORD_SUCCESS_MESSAGE;

        LogUtils.info("Bước 2: Đăng nhập vào tài khoản");
        loginPage.login(Account.VALID_ACCOUNT);

        LogUtils.info("Bước 3: Truy cập trang đổi mật khẩu");
        changePasswordPage.clickOnTab();

        LogUtils.info("Bước 4: Thay đổi mật khẩu");
        changePasswordPage.changePassword(validPassword, newPassword, confirmNewPassword);

        LogUtils.info("Bước 5: Xác nhận thông báo đổi mật khẩu thành công");
        org.testng.Assert.assertEquals(changePasswordPage.getChangePasswordSuccessFullyMessageText(), expectedChangePasswordSuccessMessage);
       }
}
