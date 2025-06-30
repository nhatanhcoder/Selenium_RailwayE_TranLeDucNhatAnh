package com.tests.ResetPassword;

import com.Railway.constant.Constants;
import com.Railway.pages.LoginPage;
import com.Railway.pages.ResetPasswordPage;
import com.Railway.thirdPartyPage.guerrillamailPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 extends TestBase {
    @Test
    public void testResetNotMatchPassword() {
        LogUtils.info("Bước 1: Truy cập trang đăng nhập");
        LoginPage loginPage = new LoginPage();
        LogUtils.info("Bước 2: Nhấn vào liên kết 'Quên mật khẩu?'");
        loginPage.clickOnTab();
        loginPage.clickOnForgotPasswordLink();

        LogUtils.info("Bước 3: Nhập địa chỉ email để nhận liên kết đặt lại mật khẩu");
        String Email= Constants.accountData.MAIL_SERVICE_NAME+"@"+Constants.accountData.MAIL_SERVICE_DOMAIN;
        loginPage.enterForgotPasswordEmail(Email);

        LogUtils.info("Bước 4: Mở hộp thư và nhấp vào liên kết trong email");
        guerrillamailPage guerrillamailPage1 = new guerrillamailPage();
        guerrillamailPage1.openMailBox();
        guerrillamailPage1.setupMailAndSelectEmailAndClickLink();

        LogUtils.info("Bước 5: Đặt lại mật khẩu với mật khẩu không khớp");
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        String newPassword = Constants.accountData.NEW_PASSWORD;
        String unmatchNewPassword = Constants.accountData.NEW_PASSWORD+"sdad";;
        resetPasswordPage.resetPasswordNotMatch(newPassword,unmatchNewPassword);

        LogUtils.info("Bước 6: Xác nhận thông báo lỗi khi mật khẩu không khớp");
        Assert.assertEquals(resetPasswordPage.getResetPasswordFailMessageText(), Constants.errorMessage.RESET_PASS_ERROR_MESSAGE);
        Assert.assertEquals(resetPasswordPage.getNotMatchedPassValidationText(), Constants.validationMessage.RESET_CONFIRM_NOTMATCH);
    }
}

