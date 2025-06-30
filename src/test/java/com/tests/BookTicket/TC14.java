package com.tests.BookTicket;

import com.Railway.dataObject.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Railway.constant.Constants;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;

public class TC14 extends TestBase {

    @Test
    public void testBookTicket() {
        LogUtils.info("Bước 1: Truy cập trang đặt vé");
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        loginPage.clickOnTab();

        LogUtils.info("Bước 2: Đăng nhập bằng tài khoản hợp lệ");
        loginPage.login(Account.VALID_ACCOUNT);

        bookTicketPage.clickOnTab();

        LogUtils.info("Bước 3: Nhập thông tin chuyến đi");
        bookTicketPage.bookingTicket(
            Constants.ticketData.ticketDataTC14.DEPART_STATION,
            Constants.ticketData.ticketDataTC14.ARRIVE_STATION, 
            Constants.ticketData.ticketDataTC14.DEPART_DATE, 
            Constants.ticketData.ticketDataTC14.SEAT_TYPE, 
            Constants.ticketData.ticketDataTC14.TICKET_AMOUNT
        );
        String bookingData = String.join(" | ",
                Constants.ticketData.ticketDataTC14.DEPART_STATION,
                Constants.ticketData.ticketDataTC14.ARRIVE_STATION,
                Constants.ticketData.ticketDataTC14.DEPART_DATE,
                Constants.ticketData.ticketDataTC14.SEAT_TYPE,
                Constants.ticketData.ticketDataTC14.TICKET_AMOUNT
        );

        LogUtils.info("Bước 4: Xác nhận đặt vé thành công");
        Assert.assertEquals(bookingData, bookTicketPage.getBookSuccessData());
        Assert.assertEquals(bookTicketPage.getBookSuccessMessageText(), Constants.message.BOOK_SUCCESSFULLY_MESSAGE);
    }
}