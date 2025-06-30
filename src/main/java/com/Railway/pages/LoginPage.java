package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Account;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Railway.driver.DriverManager;

public class LoginPage extends BasePage {
    LogUtils log = new LogUtils();
    // Locators
    private final By usernameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By loginButton = By.cssSelector("input[type='submit']");
    private final By loginFailMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password page']");
    private final By forgotPasswordTextBox = By.xpath("//input[@type='text']");
    private final By forgotPasswordButton = By.xpath("//input[@type='submit']");
    // Getters
    private WebElement getUsernameTextBox() {
        return DriverManager.getDriver().findElement(usernameTextBox);
    }

    private WebElement getPasswordTextBox() {
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getLoginButton() {
        return DriverManager.getDriver().findElement(loginButton);
    }

    private WebElement getLoginFailMessage() {
        return DriverManager.getDriver().findElement(loginFailMessage);
    }

    private WebElement getForgotPasswordLink(){
        return DriverManager.getDriver().findElement(forgotPasswordLink);
    }

    private WebElement getForgotPasswordTextBox(){
        return DriverManager.getDriver().findElement(forgotPasswordTextBox);
    }

    private WebElement getForgotPasswordButton(){
        return DriverManager.getDriver().findElement(forgotPasswordButton);
    }


    public void clickOnForgotPasswordLink(){
        LogUtils.info("Click Forgot Password link");
        getForgotPasswordLink().click();
    }
    public void enterForgotPasswordEmail(String email){
        LogUtils.info("Nhập email vào Forgot Password: " + email);
        getForgotPasswordTextBox().sendKeys(email);
        getForgotPasswordButton().click();
    }

    // Actions
    public void login(Account account) {
        clearLoginForm();
        LogUtils.info("Input username");
        getUsernameTextBox().sendKeys(account.getUsername());
        LogUtils.info("Input password");
        getPasswordTextBox().sendKeys(account.getPassword());
        LogUtils.info("Click login Button");
        getLoginButton().click();
    }

    public void loginSuccess() {
        LogUtils.info("Login với tài khoản hợp lệ");
        clearLoginForm();
        login(Account.VALID_ACCOUNT);
    }

    public String getLoginFailMessageText() {
        LogUtils.info("Lấy thông báo lỗi đăng nhập");
        return getLoginFailMessage().getText();
    }

    public void clearLoginForm() {
        LogUtils.info("Clear form đăng nhập");
        getUsernameTextBox().clear();
        getPasswordTextBox().clear();
    }

    public void logiFailMulipletime(String failUsername, String failPassword){
        for (int i = 0; i <= 3; i++) {
            clearLoginForm();
            LogUtils.info("Input username");
            getUsernameTextBox().sendKeys(failUsername);
            LogUtils.info("Input password");
            getPasswordTextBox().sendKeys(failPassword);
            Helpers.scrollToElement(getLoginButton());
            LogUtils.info("Click login Button");
            getLoginButton().click();
        }
    }

    @Override
    public void clickOnTab() {
        super.clickOnTab();
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.LOGIN_PAGE;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.LOGIN_PAGE;
    }



}
