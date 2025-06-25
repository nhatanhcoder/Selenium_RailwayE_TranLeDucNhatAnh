package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.MY_TICKET_PAGE;
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.MY_TICKET_PAGE;
    }


}
