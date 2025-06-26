package com.Railway.pages;

import com.Railway.driver.DriverManager;
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
        return getBlankNewPasswordValidation().getText();
    }
    public String getResetPasswordFailMessageText(){
        return getResetPasswordFailMessage().getText();
    }
    public String getNotMatchedPassValidationText(){
        return getNotMatchedPassValidation().getText();
    }
    public String getInvalidTokenValidationText(){
        return getInvalidTokenValidation().getText();
    }

    public void resetPassword(String newPassword, String confirmPassword){
        getNewPasswordTextBox().sendKeys(newPassword);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        getTokenTextBox().clear();
        getResetPasswordButton().click();
    }

    public void resetPasswordNotMatch(String newPassword, String confirmPassword){
        getNewPasswordTextBox().sendKeys(newPassword);
        getConfirmPasswordTextBox().sendKeys(confirmPassword);
        getResetPasswordButton().click();
    }

}
