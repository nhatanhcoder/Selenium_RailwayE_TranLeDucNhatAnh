package com.tests.TimeTable;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.dataObject.Ticket;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.TimeTablePage;
import com.google.gson.JsonObject;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Railway.utilities.LogUtils;

public class TC15 extends TestBase {

    @Test(dataProvider = "TestDataProvider")
    public void matchTimeTableBookTicketRoute(JsonObject testData) {
        LogUtils.info("Bước 1: Truy cập trang bảng giờ tàu");
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        Ticket ticket = new Ticket(
                testData.get("departFrom").getAsString(),
                testData.get("arriveAt").getAsString(),
                "", "", ""
        );


        loginPage.clickOnTab();

        LogUtils.info("Bước 2: Đăng nhập vào tài khoản");
        loginPage.loginSuccess();

        timeTablePage.clickOnTab();

        LogUtils.info("Bước 3: Lấy dữ liệu tuyến đường từ bảng giờ tàu");
        String timetableData = timeTablePage.getBookingRouteData(ticket,"book ticket" );

        LogUtils.info("Bước 4: Chuyển đến tuyến đường đặt vé");
        timeTablePage.gotoBookingWithTicket(ticket,"book ticket");

        LogUtils.info("Bước 5: Lấy dữ liệu trước khi đặt vé");
        String bookTicketData = bookTicketPage.getPreBookingData(ticket);

        LogUtils.info("Bước 6: So sánh dữ liệu bảng giờ tàu và dữ liệu đặt vé");
        Assert.assertEquals(timetableData,bookTicketData);

    }
}
