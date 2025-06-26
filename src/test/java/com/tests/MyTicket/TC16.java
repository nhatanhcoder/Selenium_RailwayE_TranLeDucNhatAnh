package com.tests.MyTicket;

import com.Railway.constant.Constants;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test
    public void userAbleToDeleteTicket() {
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        loginPage.clickOnTab();

        loginPage.login(Constants.accountData.VALID_USERNAME,  Constants.accountData.VALID_PASSWORD);

        myTicketPage.clickOnTab();

        int rowBeforeDelete= myTicketPage.getNumberRowsOfTable();
        myTicketPage.deleteATicket(
                Constants.ticketData.ticketDataTC14.DEPART_STATION,
                Constants.ticketData.ticketDataTC14.ARRIVE_STATION,
                Constants.ticketData.ticketDataTC14.SEAT_TYPE,
                Constants.ticketData.ticketDataTC14.DEPART_DATE,
                Constants.ticketData.ticketDataTC14.TICKET_AMOUNT
        );

        int rowAfterDelete= myTicketPage.getNumberRowsOfTable();

        Assert.assertEquals(rowAfterDelete,rowBeforeDelete-1);

    }
}
