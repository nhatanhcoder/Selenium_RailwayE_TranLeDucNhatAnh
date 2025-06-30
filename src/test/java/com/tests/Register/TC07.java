package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;

import org.testng.annotations.Test;

public class TC07 extends TestBase {

    @Test
    public void testRegisterUser() {
        LogUtils.info("Bước 1: Truy cập trang đăng ký");
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String validEmail = Constants.accountData.VALID_REGISTERING_EMAIL;
        String validPassword = Constants.accountData.VALID_REGISTERING_PASSWORD;
        String validConfirmPassword = validPassword;
        String validPID = Constants.accountData.VALID_REGISTERING_PID;
        String expectedRegisterSuccessMessage = Constants.message.REGISTER_SUCCESS_MESSAGE;

        LogUtils.info("Bước 2: Nhập thông tin đăng ký");
        registerPage.register(validEmail, validPassword, validConfirmPassword, validPID);

        LogUtils.info("Bước 3: Xác nhận đăng ký thành công");
        org.testng.Assert.assertEquals(registerPage.getRegisterSuccessFullyMessageText(), expectedRegisterSuccessMessage);

    }
}
