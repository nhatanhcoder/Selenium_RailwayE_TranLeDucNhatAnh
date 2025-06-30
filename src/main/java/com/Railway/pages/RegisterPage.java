package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{


    private final By emailTextBox = By.xpath("//input[@id='email']");
    private final By passwordTextBox = By.xpath("//input[@id='password']");
    private final By confirmPasswordTextBox = By.xpath("//input[@id='confirmPassword']");
    private final By pidNumberTextBox = By.xpath("//input[@id='pid']");
    private final By registerButton = By.xpath("//input[@type='submit']");
    private final By registerSuccessFullyMessage= By.xpath("//h1[text()='Thank you for registering your account']");
    private final By validationEmailMessage= By.xpath("//label[@for='email' and @class='validation-error']");
    private final By validationPasswordMessage= By.xpath("//label[@for='password' and @class='validation-error']");
    private final By validationConfirmPasswordMessage= By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
    private final By validationPidNumberMessage= By.xpath("//label[@for='pid' and @class='validation-error']");
    private final By errorMessage= By.xpath("//p[@class='message error']");

    private WebElement getEmailTextBox(){
        return DriverManager.getDriver().findElement(emailTextBox);
    }

    private WebElement getPasswordTextBox(){
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getConfirmPasswordTextBox(){
        return DriverManager.getDriver().findElement(confirmPasswordTextBox);
    }

    private WebElement getPidNumberTextBox(){
        return DriverManager.getDriver().findElement(pidNumberTextBox);
    }

    private WebElement getRegisterButton(){
        return DriverManager.getDriver().findElement(registerButton);
    }

    private WebElement getRegisterSuccessFullyMessage(){
        return DriverManager.getDriver().findElement(registerSuccessFullyMessage);
    }

    private WebElement getValidationEmailMessage(){
        return DriverManager.getDriver().findElement(validationEmailMessage);
    }

    private WebElement getValidationPasswordMessage(){
        return DriverManager.getDriver().findElement(validationPasswordMessage);
    }

    private WebElement getValidationConfirmPasswordMessage(){
        return DriverManager.getDriver().findElement(validationConfirmPasswordMessage);
    }

    private WebElement getValidationPidNumberMessage(){
        return DriverManager.getDriver().findElement(validationPidNumberMessage);
    }


    private WebElement getErrorMessage(){
        return DriverManager.getDriver().findElement(errorMessage);
    }

    public void register(String email, String password, String confirmPassword, String pidNumber){
        LogUtils.info(String.format("Đăng ký tài khoản với email: %s, mật khẩu: %s, xác nhận: %s, PID: %s", email, password, confirmPassword, pidNumber));
        getEmailTextBox().sendKeys(email);
        getPasswordTextBox().sendKeys(password);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        getPidNumberTextBox().sendKeys(pidNumber);
        Helpers.scrollToElement(getRegisterButton());
        LogUtils.info("Click nút Đăng ký");
        getRegisterButton().click();
    }

    public String getRegisterSuccessFullyMessageText(){
        LogUtils.info("Lấy thông báo đăng ký thành công");
        return getRegisterSuccessFullyMessage().getText();
    }
    public String getErrorMessageText(){
        LogUtils.info("Lấy thông báo lỗi đăng ký");
        return getErrorMessage().getText();
    }
    public String getValidationEmailMessageText(){
        LogUtils.info("Lấy thông báo validate email");
        return getValidationEmailMessage().getText();
    }
    public String getValidationPasswordMessageText(){
        LogUtils.info("Lấy thông báo validate mật khẩu");
        return getValidationPasswordMessage().getText();
    }
    public String getValidationConfirmPasswordMessageText(){
        LogUtils.info("Lấy thông báo validate xác nhận mật khẩu");
        return getValidationConfirmPasswordMessage().getText();
    }
    public String getValidationPidNumberMessageText(){
        LogUtils.info("Lấy thông báo validate PID");
        return getValidationPidNumberMessage().getText();
    }
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
