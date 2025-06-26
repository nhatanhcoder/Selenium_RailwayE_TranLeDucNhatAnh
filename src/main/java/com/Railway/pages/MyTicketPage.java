package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    private final By ticketManageTable = By.xpath("//table[@class='MyTable']");

    private WebElement getTicketManageTable(){
        return DriverManager.getDriver().findElement(ticketManageTable);
    };
    public WebElement getCancelButton(String depart, String arrive, String seatType, String departDate, String amount) {
        String xpath = String.format(
                "//table[@class='MyTable']//tr[" +
                        "td[2][normalize-space(text())='%s'] and " +
                        "td[3][normalize-space(text())='%s'] and " +
                        "td[4][normalize-space(text())='%s'] and " +
                        "td[5][normalize-space(text())='%s'] and " +
                        "td[9][normalize-space(text())='%s']" +
                        "]//input[@type='button' and @value='Cancel']",
                depart, arrive, seatType, departDate, amount
        );
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }


    public void deleteATicket(String depart, String arrive, String seatType, String departDate, String amount){
        getCancelButton(depart, arrive, seatType, departDate, amount).click();
    }

    public int getNumberRowsOfTable(){
        return getTicketManageTable().findElements(By.xpath(".//tr")).size();
    }


    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.MY_TICKET_PAGE;
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.MY_TICKET_PAGE;
    }


}
