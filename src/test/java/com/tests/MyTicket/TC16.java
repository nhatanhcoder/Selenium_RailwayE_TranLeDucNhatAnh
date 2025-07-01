package com.tests.MyTicket;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import com.Railway.utilities.LogUtils;
import com.tests.Common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test
    public void userAbleToDeleteTicket() {
        LogUtils.info("Bước 1: Truy cập trang vé của tôi");
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        loginPage.clickOnTab();

        LogUtils.info("Bước 2: Đăng nhập vào tài khoản");
        loginPage.login(AccountEnum.VALID_ACCOUNT);

        myTicketPage.clickOnTab();

        LogUtils.info("Bước 3: Xóa một vé đã đặt");
        int rowBeforeDelete= myTicketPage.getNumberRowsOfTable();
        myTicketPage.deleteATicket(
                Constants.ticketData.ticketDataTC14.DEPART_STATION,
                Constants.ticketData.ticketDataTC14.ARRIVE_STATION,
                Constants.ticketData.ticketDataTC14.SEAT_TYPE,
                Constants.ticketData.ticketDataTC14.DEPART_DATE,
                Constants.ticketData.ticketDataTC14.TICKET_AMOUNT
        );

        int rowAfterDelete= myTicketPage.getNumberRowsOfTable();

        LogUtils.info("Bước 4: Xác nhận vé đã được xóa");
        Assert.assertEquals(rowAfterDelete,rowBeforeDelete-1);

    }
}
