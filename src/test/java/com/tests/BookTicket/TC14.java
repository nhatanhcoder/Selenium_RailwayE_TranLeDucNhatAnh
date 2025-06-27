package com.tests.BookTicket;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Railway.constant.Constants;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.tests.TestBase;

public class TC14 extends TestBase {

    @Test
    public void testBookTicket(){
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        loginPage.clickOnTab();

        loginPage.login(Constants.accountData.VALID_USERNAME, Constants.accountData.VALID_PASSWORD);

        bookTicketPage.clickOnTab();

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

        Assert.assertEquals(bookingData, bookTicketPage.getBookSuccessData());
        Assert.assertEquals(bookTicketPage.getBookSuccessMessageText(), Constants.message.BOOK_SUCCESSFULLY_MESSAGE);
    }
}