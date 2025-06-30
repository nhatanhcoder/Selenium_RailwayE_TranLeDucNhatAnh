package com.Railway.pages;

import com.Railway.constant.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Railway.driver.DriverManager;
import com.Railway.utilities.LogUtils;

public class HomePage extends BasePage{

    @Override
    protected String getPageName() {
        LogUtils.info("Lấy tên trang HomePage");
        return Constants.pageName.HOME_PAGE;
    }

    @Override
    protected String getPageHeading() {
        LogUtils.info("Lấy tiêu đề trang HomePage");
        return Constants.pageHeading.HOME_PAGE;
    }
}
