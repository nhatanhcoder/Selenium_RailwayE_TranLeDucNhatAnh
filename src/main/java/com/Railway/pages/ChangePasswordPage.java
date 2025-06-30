package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private final By changePasswordTitle= By.xpath("//h1[text()='Change password']");
    private final By changePasswordSuccessFullyMessage= By.xpath("//p[@class='message success']");
    private final By changePasswordFailMessage= By.xpath("//p[@class='message error']");
    private final By oldPasswordTextBox= By.xpath("//input[@id='currentPassword']");
    private final By newPasswordTextBox= By.xpath("//input[@id='newPassword']");
    private final By confirmPasswordTextBox= By.xpath("//input[@id='confirmPassword']");
    private final By changePasswordButton= By.xpath("//input[@type='submit']");

    private WebElement getChangePasswordTitle(){
        return DriverManager.getDriver().findElement(changePasswordTitle);
    }

    private WebElement getChangePasswordSuccessFullyMessage(){
        return DriverManager.getDriver().findElement(changePasswordSuccessFullyMessage);
    }

    private WebElement getChangePasswordFailMessage(){
        return DriverManager.getDriver().findElement(changePasswordFailMessage);
    }

    private WebElement getOldPasswordTextBox(){
        return DriverManager.getDriver().findElement(oldPasswordTextBox);
    }
    private WebElement getNewPasswordTextBox(){
        return DriverManager.getDriver().findElement(newPasswordTextBox);
    }

    private WebElement getConfirmPasswordTextBox(){
        return DriverManager.getDriver().findElement(confirmPasswordTextBox);
    }

    private WebElement getChangePasswordButton(){
        return DriverManager.getDriver().findElement(changePasswordButton);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword){
        LogUtils.info(String.format("Đổi mật khẩu: mật khẩu cũ: %s, mật khẩu mới: %s, xác nhận: %s", oldPassword, newPassword, confirmPassword));
        getOldPasswordTextBox().sendKeys(oldPassword);
        getNewPasswordTextBox().sendKeys(newPassword);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        Helpers.scrollToElement(getChangePasswordButton());
        LogUtils.info("Click nút Đổi mật khẩu");
        getChangePasswordButton().click();
    }

    @Override
    protected String getPageName() {
        LogUtils.info("Lấy tên trang Đổi mật khẩu");
        return Constants.pageName.CHANGE_PASSWORD_PAGE;
    }

    @Override
    protected String getPageHeading() {
        LogUtils.info("Lấy tiêu đề trang Đổi mật khẩu");
        return Constants.pageHeading.CHANGE_PASSWORD_PAGE;
    }

    public String getChangePasswordFailMessageText(){
        LogUtils.info("Lấy thông báo lỗi đổi mật khẩu");
        return getChangePasswordFailMessage().getText();
    }

    public String getChangePasswordSuccessFullyMessageText(){
        LogUtils.info("Lấy thông báo đổi mật khẩu thành công");
        return getChangePasswordSuccessFullyMessage().getText();
    }
}
