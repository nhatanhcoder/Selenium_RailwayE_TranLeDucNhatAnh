package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
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

    public String getValidationEmailMessageText(){
        return getValidationEmailMessage().getText();
    }

    public String getValidationPasswordMessageText(){
        return getValidationPasswordMessage().getText();
    }

    public String getValidationConfirmPasswordMessageText(){
        return getValidationConfirmPasswordMessage().getText();
    }

    public String getValidationPidNumberMessageText(){
        return getValidationPidNumberMessage().getText();
    }

    public String getErrorMessageText(){
        return getErrorMessage().getText();
    }

    public String getRegisterSuccessFullyMessageText(){
        return getRegisterSuccessFullyMessage().getText();
    }
    public void register(String email, String password, String confirmPassword, String pidNumber){
        getEmailTextBox().sendKeys(email);
        getPasswordTextBox().sendKeys(password);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        getPidNumberTextBox().sendKeys(pidNumber);
        Helpers.scrollToElement(getRegisterButton());
        getRegisterButton().click();
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.REGISTER_PAGE;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.REGISTER_PAGE;
    }

}
