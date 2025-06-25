package com.Railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Railway.driver.DriverManager;

public abstract class BasePage {
    private final String pageNameBy = "//a//span[text()='%s']";
    private final String pageHeading = "//h1[text()='%s']";

    protected abstract String getPageName();
    protected abstract String getPageHeading();


    private WebElement getPageName(String pageName){
        String tabNameXpath = String.format(pageNameBy, pageName);
        return DriverManager.getDriver().findElement(By.xpath(tabNameXpath));
    }

    private WebElement getPageTitle(String pageTitle){
        String pageTitleXpath = String.format(pageHeading, pageTitle);
        return DriverManager.getDriver().findElement(By.xpath(pageTitleXpath));
    }

    public void clickOnTab(){
        getPageName(getPageName()).click();
    }

    public String getPageHeadingText(){
        return getPageTitle(getPageHeading()).getText();
    }

    public String getPageNameText(){
        return getPageName(getPageName()).getText();
    }

    public String getPageNameText(String PageName){
        return getPageName(PageName).getText();
    }

}
