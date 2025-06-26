package com.Railway.pages;

import com.Railway.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;

public class BookTicketPage extends BasePage{

    private final By bookTicketButton = By.xpath("//input[@type='submit']");
    private final By bookSuccessMessage = By.xpath("//div[@id='content']//h1");

    private WebElement getBookTicketButton() {
        return DriverManager.getDriver().findElement(bookTicketButton);
    }

    private WebElement getBookSuccessMessage() {
        return DriverManager.getDriver().findElement(bookSuccessMessage);
    }

    private WebElement getSelectBox(String selectBoxName) {
        String xpath = String.format("//select[@name='%s']", selectBoxName);
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    private WebElement getTicketDataAfterBook(String ticketTableHeading){
        String ticketDataAfterBookXpath = String.format("//tr[2]/td[count(//tr[1]/th[normalize-space(.)='%s']/preceding-sibling::th)+1]", ticketTableHeading);
        return DriverManager.getDriver().findElement(By.xpath(ticketDataAfterBookXpath));
    }

    public String getBookSuccessData() {
        String departStationData = getTicketDataAfterBook(Constants.ticketTableHeading.DEPART_STATION).getText();
        String arriveStationData = getTicketDataAfterBook(Constants.ticketTableHeading.ARRIVE_STATION).getText();
        String departDateData = getTicketDataAfterBook(Constants.ticketTableHeading.DEPART_DATE).getText();
        String seatTypeData = getTicketDataAfterBook(Constants.ticketTableHeading.SEAT_TYPE).getText();
        String ticketAmountData = getTicketDataAfterBook(Constants.ticketTableHeading.AMOUNT).getText();
    
        return String.join(" | ",
            departStationData,
            arriveStationData,
            departDateData,
            seatTypeData,
            ticketAmountData
        );
    }
    
    public String getBookSuccessMessageText(){
        return getBookSuccessMessage().getText();
    }

    public void bookingTicket(String departStation, String arriveStation, String departDate, String seatType, String ticketAmount) {
        getSelectBox(Constants.selectBox.DEPART_STATION).sendKeys(departStation);

        // Kiểm tra arriveStation có phải là "Sài Gòn"
        if (!"Sài Gòn".equalsIgnoreCase(arriveStation.trim())) {
            getSelectBox(Constants.selectBox.ARRIVE_STATION).sendKeys(arriveStation);
        }
        // Nếu là "Sài Gòn" thì không làm gì (giữ nguyên lựa chọn hiện tại)

        getSelectBox(Constants.selectBox.DEPART_DATE).sendKeys(departDate);
        getSelectBox(Constants.selectBox.SEAT_TYPE).sendKeys(seatType);

        // Sử dụng Select để chọn đúng ticket amount
        Select ticketAmountSelect = new Select(getSelectBox(Constants.selectBox.TICKET_AMOUNT));
        String currentSelected = ticketAmountSelect.getFirstSelectedOption().getText();
        if (!currentSelected.equals(ticketAmount)) {
            ticketAmountSelect.selectByVisibleText(ticketAmount);
        }

        Helpers.scrollToElement(getBookTicketButton());
        getBookTicketButton().click();
    }

    public String getPostBookingData() {
        Select departSelect = new Select(getSelectBox(Constants.selectBox.DEPART_STATION));
        Select arriveSelect = new Select(getSelectBox(Constants.selectBox.ARRIVE_STATION));

        String departStationData = departSelect.getFirstSelectedOption().getText();
        String arriveStationData = arriveSelect.getFirstSelectedOption().getText();

        return departStationData + arriveStationData;
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.BOOK_TICKET_PAGE;
    }

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.BOOK_TICKET_PAGE;
    }
}
