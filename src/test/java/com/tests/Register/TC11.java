package com.tests.Register;

import com.Railway.constant.Constants;
import com.Railway.pages.RegisterPage;
import com.Railway.utilities.Helpers;
import com.google.gson.JsonObject;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.utilities.LogUtils;

public class TC11 extends TestBase {

    @Test(dataProvider = "TestDataProvider")
    public void testRegisterWithEmptyPIDnPassword(JsonObject testData) {
        LogUtils.info("Bước 1: Truy cập trang đăng ký với PID và mật khẩu để trống");
        RegisterPage registerPage = new RegisterPage();

        registerPage.clickOnTab();

        String newEmail= Helpers.CeateEmailForRegister();
        String password = testData.get("password").getAsString();
        String confirmPassword = testData.get("confirmPassword").getAsString();
        String pid = testData.get("pid").getAsString();


        String expectedPasswordValidationMessage = Constants.validationMessage.INVALID_PASSWORD_FORMAT;
        String expectedPIDValidationMessage = Constants.validationMessage.INVALID_PID_FORMAT;
        String expectedRegisterErrorMessage = Constants.errorMessage.REGISTER_ERROR_MESSAGE;

        LogUtils.info("Bước 2: Nhập địa chỉ email hợp lệ: " + newEmail);
        LogUtils.info("Bước 3: Để trống mật khẩu và xác nhận mật khẩu");
        LogUtils.info("Bước 4: Nhập PID để trống");
        LogUtils.info("Bước 5: Nhấn nút đăng ký");

        registerPage.register(newEmail, password, confirmPassword, pid);

        LogUtils.info("Bước 6: Xác nhận thông báo lỗi đăng ký hiển thị đúng");
        Assert.assertEquals(registerPage.getErrorMessageText(), expectedRegisterErrorMessage);
        LogUtils.info("Bước 7: Xác nhận thông báo lỗi định dạng mật khẩu hiển thị đúng");
        Assert.assertEquals(registerPage.getValidationMessageText(Constants.validationLocator.PASSWORD), expectedPasswordValidationMessage);
        LogUtils.info("Bước 8: Xác nhận thông báo lỗi định dạng PID hiển thị đúng");
        Assert.assertEquals(registerPage.getValidationMessageText(Constants.validationLocator.PID), expectedPIDValidationMessage);
    }
}
