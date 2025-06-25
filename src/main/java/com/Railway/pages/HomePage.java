package com.Railway.pages;

import com.Railway.constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Railway.driver.DriverManager;

public class HomePage extends BasePage{

    @Override
    protected String getPageName() {
        return Constants.pageName.HOME_PAGE;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.HOME_PAGE;
    }
}
