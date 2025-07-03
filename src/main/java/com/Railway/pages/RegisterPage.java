package com.Railway.pages;

import com.Railway.WrapElement.ElementWrapper;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By registerButton = By.xpath("//input[@type='submit']");
    private final By registerSuccessFullyMessage = By.xpath("//h1[text()='Thank you for registering your account']");
    private final By errorMessage = By.xpath("//p[@class='message error']");

    // Dynamic locator for input textbox by ID
    private By getTextboxById(String id) {
        return By.xpath(String.format("//input[@id='%s']", id));
    }

    // Dynamic locator for validation message label
    private By getValidationMessageByFor(String forAttr) {
        return By.xpath(String.format("//label[@for='%s' and @class='validation-error']", forAttr));
    }

    // ========== ACTIONS ==========

    public void registerSuccessFully(String email, String password) {
        LogUtils.info(String.format("Đăng ký tài khoản với email: %s", email));

        ElementWrapper.sendKeyElement(getTextboxById("email"), email);
        ElementWrapper.sendKeyElement(getTextboxById("password"), password);
        ElementWrapper.sendKeyElement(getTextboxById("confirmPassword"), password);
        ElementWrapper.sendKeyElement(getTextboxById("pid"), Constants.accountData.VALID_PID);

        Helpers.scrollToElement(ElementWrapper.getElement(registerButton));
        LogUtils.info("Click nút Đăng ký");
        ElementWrapper.clickElement(registerButton);
    }

    public void register(String email, String password, String confirmPassword, String pidNumber) {
        LogUtils.info(String.format("Đăng ký với email: %s | Password: %s | Confirm: %s | PID: %s", email, password, confirmPassword, pidNumber));

        ElementWrapper.sendKeyElement(getTextboxById("email"), email);
        ElementWrapper.sendKeyElement(getTextboxById("password"), password);
        ElementWrapper.sendKeyElement(getTextboxById("confirmPassword"), confirmPassword);
        ElementWrapper.sendKeyElement(getTextboxById("pid"), pidNumber);

        Helpers.scrollToElement(ElementWrapper.getElement(registerButton));
        ElementWrapper.clickElement(registerButton);
    }

    // ========== GETTERS ==========

    public String getRegisterSuccessFullyMessageText() {
        LogUtils.info("Lấy thông báo đăng ký thành công");
        return ElementWrapper.getElementText(registerSuccessFullyMessage);
    }

    public String getErrorMessageText() {
        LogUtils.info("Lấy thông báo lỗi đăng ký");
        return ElementWrapper.getElementText(errorMessage);
    }

    public String getValidationMessageText(String forAttribute) {
        LogUtils.info(String.format("Lấy thông báo lỗi của trường: %s", forAttribute));
        return ElementWrapper.getElementText(getValidationMessageByFor(forAttribute));
    }

    // ========== OVERRIDE BASE METHODS ==========

    @Override
    protected String getPageName() {
        LogUtils.info("Lấy tên trang Đăng ký");
        return Constants.pageName.REGISTER_PAGE;
    }

    @Override
    protected String getPageHeading() {
        LogUtils.info("Lấy tiêu đề trang Đăng ký");
        return Constants.pageHeading.REGISTER_PAGE;
    }
}
