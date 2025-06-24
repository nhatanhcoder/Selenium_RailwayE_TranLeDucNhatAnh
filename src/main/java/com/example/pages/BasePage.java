package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.example.driver.DriverManager;

public class BasePage {

    private final  By loginTab= By.xpath("//span[text()='Login']");
    private final  By logoutTab= By.xpath("//span[text()='Log out']");
    private final  By homeTab= By.xpath("//span[text()='Home']");
    private final  By faqTab= By.xpath("//span[text()='FAQ']");
    private final  By contactTab= By.xpath("//span[text()='Contact']");
    private final  By timeTableTab= By.xpath("//span[text()='Time table']");
    private final  By bookingTab= By.xpath("//span[text()='Book ticket']");
    private final  By myTicketTab= By.xpath("//span[text()='My ticket']");
    private final  By changePasswordTab= By.xpath("//span[text()='Change password']");
    private final  By registerTab= By.xpath("//span[text()='Register']");

    private WebElement getLoginTab(){
        return DriverManager.getDriver().findElement(loginTab);
    }

    public WebElement getRegisterTabText(){
        return DriverManager.getDriver().findElement(registerTab);
    }

    private WebElement getLogoutTab(){
        return DriverManager.getDriver().findElement(logoutTab);
    }

    private WebElement getHomeTab(){
        return DriverManager.getDriver().findElement(homeTab);
    }

    private WebElement getFaqTab(){
        return DriverManager.getDriver().findElement(faqTab);
    }

    private WebElement getContactTab(){
        return DriverManager.getDriver().findElement(contactTab);
    } 

    private WebElement getTimeTableTab(){
        return DriverManager.getDriver().findElement(timeTableTab);
    }

    private WebElement getBookingTab(){
        return DriverManager.getDriver().findElement(bookingTab);
    }

    private WebElement getMyTicketTab(){
        return DriverManager.getDriver().findElement(myTicketTab);
    }

    private WebElement getChangePasswordTab(){
        return DriverManager.getDriver().findElement(changePasswordTab);
    }

    public void clickLoginTab(){
        getLoginTab().click();
    }

    public void clickLogoutTab(){
        getLogoutTab().click();
    }

    public void clickHomeTab(){
        getHomeTab().click();
    }

    public void clickFaqTab(){
        getFaqTab().click();
    }

    public void clickContactTab(){
        getContactTab().click();
    }

    public void clickTimeTableTab(){
        getTimeTableTab().click();
    }

    public void clickBookingTab(){
        getBookingTab().click();
    }

    public void clickMyTicketTab(){
        getMyTicketTab().click();
    }

    public void clickRegisterTab(){
        getRegisterTabText().click();
    }

    public void clickChangePasswordTab(){
        getChangePasswordTab().click();
    }

    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public boolean checkChangePasswordTabIsDisplayed(){
        return getChangePasswordTab().isDisplayed();
    }
    public boolean checkMyTicketTabIsDisplayed(){
        return getMyTicketTab().isDisplayed();
    }
    public boolean checkLogoutTabIsDisplayed(){
        return getLogoutTab().isDisplayed();
    }
}
