package com.tests.BookTicket;

import com.Railway.constant.Constants;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC04 extends TestBase {
    @Test
    public void testRedirectToLoginPageBockTicketPage(){
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        String loginHeading = Constants.pageHeading.LOGIN_PAGE;

        bookTicketPage.clickOnTab();

        Assert.assertEquals(loginPage.getPageHeadingText(),loginHeading);

    }
}
