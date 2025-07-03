package com.Railway.pages;

import com.Railway.WrapElement.ElementWrapper;
import com.Railway.constant.Constants;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage {

    private final By resetPasswordButton = By.xpath("//input[@type='submit']");
    private final By resetPasswordFailMessage = By.xpath("//p[@class='message error']");

    // ===== Dynamic Locators =====

    private By getTextboxById(String id) {
        return By.id(id);
    }

    private By getValidationByFor(String forAttr) {
        return By.xpath(String.format("//label[@for='%s' and contains(@class, 'validation-error')]", forAttr));
    }

    // ===== Actions =====

    public void resetPassword(String newPassword, String confirmPassword, String token) {
        LogUtils.info(String.format("Đặt lại mật khẩu: %s / %s / token: %s", newPassword, confirmPassword, token));

        ElementWrapper.sendKeyElement(getTextboxById("newPassword"), newPassword);
        ElementWrapper.sendKeyElement(getTextboxById("confirmPassword"), confirmPassword);
        ElementWrapper.sendKeyElement(getTextboxById("resetToken"), token);

        ElementWrapper.clickElement(resetPasswordButton);
    }

    public void resetPasswordWithoutToken(String newPassword, String confirmPassword) {
        LogUtils.info("Đặt lại mật khẩu KHÔNG nhập token");

        ElementWrapper.sendKeyElement(getTextboxById("newPassword"), newPassword);
        ElementWrapper.sendKeyElement(getTextboxById("confirmPassword"), confirmPassword);

        ElementWrapper.clickElement(resetPasswordButton);
    }

    // ===== Getters =====

    public String getValidationMessage(String forAttribute) {
        LogUtils.info("Lấy thông báo lỗi của trường: " + forAttribute);
        return ElementWrapper.getElementText(getValidationByFor(forAttribute));
    }

    public String getResetPasswordFailMessageText() {
        LogUtils.info("Lấy thông báo lỗi tổng thể khi đặt lại mật khẩu");
        return ElementWrapper.getElementText(resetPasswordFailMessage);
    }

    public void resetPasswordNotMatch(String newPassword, String confirmPassword, String token) {
        LogUtils.info(String.format("Đặt lại mật khẩu KHÔNG khớp: %s / %s", newPassword, confirmPassword));

        ElementWrapper.sendKeyElement(getTextboxById("newPassword"), newPassword);
        ElementWrapper.sendKeyElement(getTextboxById("confirmPassword"), confirmPassword);
        ElementWrapper.sendKeyElement(getTextboxById("resetToken"), token);

        ElementWrapper.clickElement(resetPasswordButton);
    }

    // ===== Override Page Info =====

    @Override
    protected String getPageName() {
        return Constants.pageName.LOGOUT;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.REGISTER_PAGE;
    }
}
