package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MyTicketPage extends BasePage {

    private final By ticketManageTable = By.xpath("//table[@class='MyTable']");

    private WebElement getTicketManageTable(){
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
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    public void deleteATicket(String depart, String arrive, String seatType, String departDate, String amount){
        // 1) Đếm số dòng ban đầu
        int initialCount = getNumberRowsOfTable();

        // 2) Click nút Cancel
        getCancelButton(depart, arrive, seatType, departDate, amount).click();

        // 3) Đợi alert xuất hiện và accept (tương đương Enter)
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // 4) Đợi số dòng trong table giảm đi 1
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//table[@class='MyTable']//tr[position()>1]"),
                initialCount - 1
        ));
    }

    public int getNumberRowsOfTable(){
        // Nếu bạn chỉ muốn đếm dữ liệu (không tính header), dùng position()>1
        return getTicketManageTable()
                .findElements(By.xpath(".//tr[position()>1]"))
                .size();
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
