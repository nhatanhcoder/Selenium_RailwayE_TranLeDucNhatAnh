package com.Railway.pages;

import com.Railway.WrapElement.ElementWrapper;
import com.Railway.constant.Constants;
import com.Railway.dataObject.Ticket;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class BookTicketPage extends BasePage {

    // ===== Locators =====
    private final By bookTicketButton = By.xpath("//input[@type='submit']");
    private final By bookSuccessMessage = By.xpath("//div[@id='content']//h1");

    // ===== Generic Select Box By =====
    private By getSelectBoxByName(String name) {
        return By.xpath(String.format("//select[@name='%s']", name));
    }

    // ===== Table data after booking =====
    private By getBookedTicketDataByHeading(String headingText) {
        String xpath = String.format(
                "//tr[2]/td[count(//tr[1]/th[normalize-space(.)='%s']/preceding-sibling::th)+1]",
                headingText);
        return By.xpath(xpath);
    }

    // ===== Public Methods =====

    public String getBookSuccessMessageText() {
        LogUtils.info("Lấy thông báo thành công sau khi đặt vé");
        return ElementWrapper.getElementText(bookSuccessMessage);
    }

    public String getBookSuccessData() {
        LogUtils.info("Lấy dữ liệu thành công sau khi đặt vé");

        String departStationData = ElementWrapper.getElementText(getBookedTicketDataByHeading(Constants.ticketTableHeading.DEPART_STATION));
        String arriveStationData = ElementWrapper.getElementText(getBookedTicketDataByHeading(Constants.ticketTableHeading.ARRIVE_STATION));
        String departDateData = ElementWrapper.getElementText(getBookedTicketDataByHeading(Constants.ticketTableHeading.DEPART_DATE));
        String seatTypeData = ElementWrapper.getElementText(getBookedTicketDataByHeading(Constants.ticketTableHeading.SEAT_TYPE));
        String ticketAmountData = ElementWrapper.getElementText(getBookedTicketDataByHeading(Constants.ticketTableHeading.AMOUNT));

        return String.join(" | ",
                departStationData,
                arriveStationData,
                departDateData,
                seatTypeData,
                ticketAmountData);
    }
    public static String getElementIdBySelector(String cssSelector) {
        WebDriver driver = DriverManager.getDriver();
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        return element.getAttribute("id");
    }


    public void bookingTicket(Ticket ticket) {
        LogUtils.info("Đặt vé với dữ liệu: " + ticket);

        // Step 1: Chọn ngày đi
        ElementWrapper.selectDropdownByText(getSelectBoxByName(Constants.selectBoxName.DEPART_DATE), ticket.getDepartDate());

        // Step 2: Lấy phần tử ArriveStation trước khi chọn Depart
        By arriveBy = getSelectBoxByName(Constants.selectBoxName.ARRIVE_STATION);
        RemoteWebElement oldElement = (RemoteWebElement) DriverManager.getDriver().findElement(arriveBy);
        String oldId = oldElement.getId();

        // Step 3: Chọn DepartStation (gây trigger thay đổi DOM)
        ElementWrapper.selectDropdownByText(getSelectBoxByName(Constants.selectBoxName.DEPART_STATION), ticket.getDepartStation());

        // Step 4: Đợi phần tử ArriveStation đổi ID
        ElementWrapper.fluentWaitForDynamicElement(arriveBy, oldId);

        // Step 5: Chọn các dropdown còn lại
        ElementWrapper.selectDropdownByText(arriveBy, ticket.getArriveStation());
        ElementWrapper.selectDropdownByText(getSelectBoxByName(Constants.selectBoxName.SEAT_TYPE), ticket.getSeatType());
        ElementWrapper.selectDropdownByText(getSelectBoxByName(Constants.selectBoxName.TICKET_AMOUNT), ticket.getTicketAmount());

        // Step 6: Click đặt vé
        LogUtils.info("Click đặt vé");
        ElementWrapper.clickElement(bookTicketButton);
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
