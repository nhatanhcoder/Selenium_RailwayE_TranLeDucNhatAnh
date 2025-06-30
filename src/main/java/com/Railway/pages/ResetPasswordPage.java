package com.Railway.pages;

import com.Railway.driver.DriverManager;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {

    private final By newPasswordTextBox = By.id("newPassword");
    private final By confirmPasswordTextBox = By.id("confirmPassword");
    private final By TokenTextBox = By.id("resetToken");
    private final By resetPasswordButton = By.xpath("//input[@type='submit']");
    private final By resetPasswordFailMessage= By.xpath("//p[@class='message error']");
    private final By notMatchedPassValidation= By.xpath("//label[@for='confirmPassword' and contains(@class, 'validation-error')]");
    private final By invalidTokenValidation= By.xpath("//label[@for='resetToken' and contains(@class, 'validation-error')]");
    private final By blankNewPasswordValidation= By.xpath("//label[@for='newPassword' and contains(@class, 'validation-error')]");

    private WebElement getNewPasswordTextBox(){
        return DriverManager.getDriver().findElement(newPasswordTextBox);
    }

    private WebElement getConfirmPasswordTextBox(){
        return DriverManager.getDriver().findElement(confirmPasswordTextBox);
    }

    private WebElement getTokenTextBox(){
        return DriverManager.getDriver().findElement(TokenTextBox);
    }

    private WebElement getResetPasswordButton(){
        return DriverManager.getDriver().findElement(resetPasswordButton);
    }

    private WebElement getResetPasswordFailMessage(){
        return DriverManager.getDriver().findElement(resetPasswordFailMessage);
    }
    private WebElement getNotMatchedPassValidation(){
        return DriverManager.getDriver().findElement(notMatchedPassValidation);
    }
    private WebElement getInvalidTokenValidation(){
        return DriverManager.getDriver().findElement(invalidTokenValidation);
    }

    private WebElement getBlankNewPasswordValidation(){
        return DriverManager.getDriver().findElement(blankNewPasswordValidation);
    }
    public String getBlankNewPasswordValidationText(){
        LogUtils.info("Lấy thông báo mật khẩu mới bị bỏ trống");
        return getBlankNewPasswordValidation().getText();
    }
    public String getResetPasswordFailMessageText(){
        LogUtils.info("Lấy thông báo lỗi đặt lại mật khẩu");
        return getResetPasswordFailMessage().getText();
    }
    public String getNotMatchedPassValidationText(){
        LogUtils.info("Lấy thông báo xác nhận mật khẩu không khớp");
        return getNotMatchedPassValidation().getText();
    }
    public String getInvalidTokenValidationText(){
        LogUtils.info("Lấy thông báo token không hợp lệ");
        return getInvalidTokenValidation().getText();
    }

    public void resetPassword(String newPassword, String confirmPassword){
        LogUtils.info(String.format("Đặt lại mật khẩu: mật khẩu mới: %s, xác nhận: %s", newPassword, confirmPassword));
        getNewPasswordTextBox().sendKeys(newPassword);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        getTokenTextBox().clear();
        LogUtils.info("Click nút Đặt lại mật khẩu");
        getResetPasswordButton().click();
    }

    public void resetPasswordNotMatch(String newPassword, String confirmPassword){
        LogUtils.info(String.format("Đặt lại mật khẩu (không khớp): mật khẩu mới: %s, xác nhận: %s", newPassword, confirmPassword));
        getNewPasswordTextBox().sendKeys(newPassword);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        LogUtils.info("Click nút Đặt lại mật khẩu");
        getResetPasswordButton().click();
    }

}
