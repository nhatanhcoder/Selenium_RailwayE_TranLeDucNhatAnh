package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    private final  By usernameTextBox= By.xpath("//input[@id='username']");
    private final  By passwordTextBox= By.xpath("//input[@id='password']");
    private final  By loginButton= By.xpath("//input[@type='submit']");


    private WebElement getUsernameTextBox(){
        return DriverManager.getDriver().findElement(usernameTextBox);
    }

    private WebElement getPasswordTextBox(){
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getLoginButton(){
        return DriverManager.getDriver().findElement(loginButton);
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

}

