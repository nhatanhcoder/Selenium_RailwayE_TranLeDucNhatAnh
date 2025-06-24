package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.driver.DriverManager;

public class HomePage {

    private final By welcomeMessage = By.xpath("//h1[text()='Welcome to Safe Railway']");

    private WebElement getWelcomeMessage(){
        return DriverManager.getDriver().findElement(welcomeMessage);
    }

    public String getWelcomeMessageText(){
        return getWelcomeMessage().getText();
    }

}
