package com.Railway.pages;

import com.Railway.constant.Constants;

public class BookTicketPage extends BasePage{

    @Override
    protected String getPageName() {
        return Constants.pageName.BOOK_TICKET_PAGE;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.BOOK_TICKET_PAGE;
    }
}
