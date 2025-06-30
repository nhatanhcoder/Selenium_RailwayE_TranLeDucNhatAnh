package com.tests.BookTicket;

import com.Railway.constant.Constants;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.LogUtils;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC04 extends TestBase {
    @Test
    public void testRedirectToLoginPageBockTicketPage(){
        LogUtils.info("Start test: testRedirectToLoginPageBockTicketPage");
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        String loginHeading = Constants.pageHeading.LOGIN_PAGE;
        LogUtils.info("Click Book Ticket tab");
        bookTicketPage.clickOnTab();
        LogUtils.info("Verify redirected to Login page");
        Assert.assertEquals(loginPage.getPageHeadingText(),loginHeading);
        LogUtils.info("End test: testRedirectToLoginPageBockTicketPage");
    }
}
