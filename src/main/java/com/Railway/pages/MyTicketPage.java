package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MyTicketPage extends BasePage {

    private final By ticketManageTable = By.xpath("//table[@class='MyTable']");

    private WebElement getTicketManageTable(){
        LogUtils.info("Lấy bảng quản lý vé của tôi");
        return DriverManager.getDriver().findElement(ticketManageTable);
    }

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
        LogUtils.info(String.format("Tìm nút Hủy vé với thông tin: %s-%s-%s-%s-%s", depart, arrive, seatType, departDate, amount));
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    public void deleteATicket(String depart, String arrive, String seatType, String departDate, String amount){
        LogUtils.info("Bắt đầu xóa vé khỏi bảng vé của tôi");
        int initialCount = getNumberRowsOfTable();
        LogUtils.info("Số dòng ban đầu: " + initialCount);
        getCancelButton(depart, arrive, seatType, departDate, amount).click();
        LogUtils.info("Đã click nút Hủy vé, chờ xác nhận alert");
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        LogUtils.info("Đã xác nhận alert, chờ cập nhật bảng vé");
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//table[@class='MyTable']//tr[position()>1]"),
                initialCount - 1
        ));
        LogUtils.info("Đã xóa vé thành công");
    }

    public int getNumberRowsOfTable(){
        int count = getTicketManageTable()
                .findElements(By.xpath(".//tr[position()>1]"))
                .size();
        LogUtils.info("Số lượng vé hiện tại trong bảng: " + count);
        return count;
    }

    @Override
    protected String getPageHeading() {
        LogUtils.info("Lấy tiêu đề trang Vé của tôi");
        return Constants.pageHeading.MY_TICKET_PAGE;
    }

    @Override
    protected String getPageName() {
        LogUtils.info("Lấy tên trang Vé của tôi");
        return Constants.pageName.MY_TICKET_PAGE;
    }

}
