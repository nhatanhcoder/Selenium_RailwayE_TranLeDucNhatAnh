package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;
import com.tests.Common.TestBase;
import org.testng.annotations.Test;
import com.Railway.utilities.LogUtils;

public class TC10 extends TestBase {

    @Test
    public void testRegisterPasswordNotMatch() {
        LogUtils.info("Bước 1: Truy cập trang đăng ký với dữ liệu không hợp lệ");
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String validEmail = Constants.accountData.VALID_REGISTERING_EMAIL;
        String validPassword = Constants.accountData.VALID_REGISTERING_PASSWORD;
        String unmatchConfirmPassword = validPassword+"sadasd";
        String validPID = Constants.accountData.VALID_REGISTERING_PID;
        String expectedConfirmPasswordValidationMessage = Constants.validationMessage.PASSWORD_NOT_MATCH;

        LogUtils.info("Bước 2: Nhập địa chỉ email hợp lệ");
        LogUtils.info("Bước 3: Nhập mật khẩu hợp lệ");
        LogUtils.info("Bước 4: Nhập lại mật khẩu không khớp");
        LogUtils.info("Bước 5: Nhập PID hợp lệ");
        LogUtils.info("Bước 6: Gửi biểu mẫu đăng ký");
        registerPage.registerSuccessFully(validEmail, validPassword);

        LogUtils.info("Bước 7: Xác nhận thông báo lỗi mật khẩu không khớp");
        org.testng.Assert.assertEquals(registerPage.getValidationMessageText(Constants.validationLocator.CONFIRM_PASSWORD), expectedConfirmPasswordValidationMessage);

    }
}
