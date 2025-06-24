package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final  By usernameTextBox= By.xpath("//input[@id='username']");
    private final  By passwordTextBox= By.xpath("//input[@id='password']");
    private final  By loginButton= By.xpath("//input[@type='submit']");
    private final  By loginFailMessage = By.xpath("//p[@class='message error LoginForm']");
    private final  By loginTitle= By.xpath("//h1[text()='Login page']");
    private final  By forgotPassword= By.xpath("//a[text()='Forgot Password page']");

    private WebElement getUsernameTextBox(){
        return DriverManager.getDriver().findElement(usernameTextBox);
    }

    private WebElement getPasswordTextBox(){
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getLoginButton(){
        return DriverManager.getDriver().findElement(loginButton);
    }

    private WebElement getLoginFailMessage(){
        return DriverManager.getDriver().findElement(loginFailMessage);
    }

    private WebElement getLoginTitle(){
        return DriverManager.getDriver().findElement(loginTitle);
    }
    public void login(String username, String password){
        getUsernameTextBox().sendKeys(username);
        getPasswordTextBox().sendKeys(password);
        getLoginButton().click();
    }

    public void clearLoginForm(){
        getUsernameTextBox().clear();
        getPasswordTextBox().clear();
    }
    public String getLoginTitleText(){
        return getLoginTitle().getText();
    }

    public String getLoginFailMessageText(){
        return getLoginFailMessage().getText();
    }
}

