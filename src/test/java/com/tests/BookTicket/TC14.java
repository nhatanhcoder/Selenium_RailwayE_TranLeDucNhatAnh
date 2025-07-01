package com.tests.BookTicket;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.dataObject.Ticket;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.utilities.LogUtils;
import com.tests.Common.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC14 extends TestBase {

    @Test(dataProvider = "TestDataProvider")
    public void testBookTicket(JsonObject testData) {
        String departStation = testData.get("departStation").getAsString();
        String arriveStation = testData.get("arriveStation").getAsString();
        int days = testData.get("days").getAsInt();
        String seatType = testData.get("seatType").getAsString();
        int amount = testData.get("amount").getAsInt();

        String ticketAmount = String.valueOf(amount);

        // ✅ Format ngày thành "M/dd/yyyy"
        LocalDate departDate = LocalDate.now().plusDays(days);
        String formattedDate = departDate.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));

        // ✅ Dùng ngày đã format
        Ticket ticket = new Ticket(departStation, arriveStation, formattedDate, seatType, ticketAmount);

        LogUtils.info("Bước 1: Truy cập trang đặt vé");
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab();

        LogUtils.info("Bước 2: Đăng nhập bằng tài khoản hợp lệ");
        loginPage.login(AccountEnum.VALID_ACCOUNT);

        LogUtils.info("Bước 3: Chuyển đến trang Đặt vé");
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickOnTab();

        LogUtils.info("Bước 4: Nhập thông tin chuyến đi và đặt vé");
        bookTicketPage.bookingTicket(ticket);

        LogUtils.info("Bước 5: Xác nhận dữ liệu đặt vé");
        Assert.assertEquals(bookTicketPage.getBookSuccessData(), ticket.toBookingDataString(),
                "Dữ liệu đặt vé hiển thị không khớp");

        LogUtils.info("Bước 6: Xác nhận thông báo thành công");
        Assert.assertEquals(bookTicketPage.getBookSuccessMessageText(),
                Constants.message.BOOK_SUCCESSFULLY_MESSAGE,
                "Thông báo thành công không đúng");
    }
}
