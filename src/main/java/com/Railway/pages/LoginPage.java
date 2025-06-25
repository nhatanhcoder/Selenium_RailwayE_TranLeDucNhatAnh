package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Railway.driver.DriverManager;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By loginButton = By.cssSelector("input[type='submit']");
    private final By loginFailMessage = By.xpath("//p[@class='message error LoginForm']");

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

    // Actions
    public void login(String username, String password) {
        clearLoginForm();
        getUsernameTextBox().sendKeys(username);
        getPasswordTextBox().sendKeys(password);
        getLoginButton().click();
    }

    public String getLoginFailMessageText() {
            return getLoginFailMessage().getText();
    }

    public void clearLoginForm() {
        getUsernameTextBox().clear();
        getPasswordTextBox().clear();
    }

    public void logiFailMulipletime(String failUsername, String failPassword){
        for (int i = 0; i <= 3; i++) {
            clearLoginForm();
            getUsernameTextBox().sendKeys(failUsername);
            getPasswordTextBox().sendKeys(failPassword);
            Helpers.scrollToElement(getLoginButton());
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
