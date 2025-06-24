package com.tests.BookTicket;

import com.example.pages.BasePage;
import com.example.pages.LoginPage;
import com.tests.TestBase;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test
    public void testRedirectToLoginPageBockTicketPage(){
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();

        String loginTitle = "Login page";

        basePage.clickBookingTab();

        org.testng.Assert.assertEquals(loginPage.getLoginTitleText(),loginTitle);


    }
}
