package com.tests.TimeTable;

import com.Railway.constant.Constants;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.TimeTablePage;
import com.tests.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TC15 extends TestBase {
    @Test
    public void matchTimeTableBookTicketRoute() {
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        loginPage.clickOnTab();

        loginPage.login(Constants.accountData.VALID_USERNAME,  Constants.accountData.VALID_PASSWORD);

        timeTablePage.clickOnTab();

        String timetableData = timeTablePage.getBookingRouteData(Constants.ticketData.ticketDataTC15.DEPART_STATION,
                Constants.ticketData.ticketDataTC15.ARRIVE_STATION,"book ticket" );

        timeTablePage.gotoBookingRoute(Constants.ticketData.ticketDataTC15.DEPART_STATION,
                Constants.ticketData.ticketDataTC15.ARRIVE_STATION,"book ticket");

        String bookTicketData = bookTicketPage.getPostBookingData();

        Assert.assertEquals(timetableData,bookTicketData);

    }
}
