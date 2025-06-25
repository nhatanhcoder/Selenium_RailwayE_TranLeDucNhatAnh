package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.driver.DriverManager;

public class HomePage {

    private final By welcomeMessage = By.xpath("//h1[text()='%s']");

    private WebElement getWelcomeMessage(String message){
        return DriverManager.getDriver().findElement(By.xpath(String.format(welcomeMessage.toString(), message)));
    }

    public String getWelcomeMessageText(String message){
        return getWelcomeMessage(message).getText();
    }

}
