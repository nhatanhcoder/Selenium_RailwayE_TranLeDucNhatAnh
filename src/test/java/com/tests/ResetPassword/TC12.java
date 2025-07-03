package com.tests.ResetPassword;

import com.Railway.constant.Constants;
import com.Railway.pages.LoginPage;
import com.Railway.pages.ResetPasswordPage;
import com.Railway.thirdPartyPage.guerrillamailPage;
import com.Railway.utilities.Helpers;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends TestBase {
    @Test
    public void testResetPassword() {
        LogUtils.info("Bước 1: Truy cập trang đặt lại mật khẩu");
        LoginPage loginPage = new LoginPage();
        guerrillamailPage guerrillamailPage1 = new guerrillamailPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        LogUtils.info("Bước 2: Nhấp vào tab đăng nhập");
        loginPage.clickOnTab();

        LogUtils.info("Bước 3: Nhấp vào liên kết quên mật khẩu");
        loginPage.clickOnForgotPasswordLink();

        String Email= Helpers.CeateEmailForRegister();

        LogUtils.info("Bước 4: Nhập email để đặt lại mật khẩu: " + Email);
        loginPage.enterForgotPasswordEmail(Email);

        LogUtils.info("Bước 5: Mở hộp thư và thiết lập email, nhấp vào liên kết trong email");
        guerrillamailPage1.openMailBox();
        guerrillamailPage1.setupMailAndSelectEmailAndClickLink();

        String newPassword = Constants.accountData.NEW_PASSWORD;
        LogUtils.info("Bước 6: Đặt lại mật khẩu thành công với mật khẩu mới");
        resetPasswordPage.resetPassword(newPassword, newPassword);

       // Assert.assertEquals(resetPasswordPage.);
    }
}
