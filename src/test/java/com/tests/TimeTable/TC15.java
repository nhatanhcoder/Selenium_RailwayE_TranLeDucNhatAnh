package com.tests.TimeTable;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Account;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.TimeTablePage;
import com.tests.Common.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import com.Railway.utilities.LogUtils;

public class TC15 extends TestBase {
    @Test
    public void matchTimeTableBookTicketRoute() {
        LogUtils.info("Bước 1: Truy cập trang bảng giờ tàu");
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        loginPage.clickOnTab();

        LogUtils.info("Bước 2: Đăng nhập vào tài khoản");
        loginPage.login(Account.VALID_ACCOUNT);

        timeTablePage.clickOnTab();

        LogUtils.info("Bước 3: Lấy dữ liệu tuyến đường từ bảng giờ tàu");
        String timetableData = timeTablePage.getBookingRouteData(Constants.ticketData.ticketDataTC15.DEPART_STATION,
                Constants.ticketData.ticketDataTC15.ARRIVE_STATION,"book ticket" );

        LogUtils.info("Bước 4: Chuyển đến tuyến đường đặt vé");
        timeTablePage.gotoBookingRoute(Constants.ticketData.ticketDataTC15.DEPART_STATION,
                Constants.ticketData.ticketDataTC15.ARRIVE_STATION,"book ticket");

        LogUtils.info("Bước 5: Lấy dữ liệu sau khi đặt vé");
        String bookTicketData = bookTicketPage.getPostBookingData();

        LogUtils.info("Bước 6: So sánh dữ liệu bảng giờ tàu và dữ liệu đặt vé");
        Assert.assertEquals(timetableData,bookTicketData);

    }
}
