package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.example.driver.DriverManager;

public class BasePage {

    private final  By tabNameBy= By.xpath("//span//a[text()='%s']");


    private WebElement getTabName(String tabName){
        return DriverManager.getDriver().findElement(By.xpath(String.format(tabNameBy.toString(), tabName)));
    }


    public void clickOnTab(String tabName){
        getTabName(tabName).click();
    }

    public String getPageTitle(String tabName){
        return DriverManager.getDriver().getTitle();
    }

}
