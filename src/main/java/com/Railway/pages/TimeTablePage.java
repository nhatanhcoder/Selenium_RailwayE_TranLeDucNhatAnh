package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
import com.Railway.utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends BasePage {

    @Override
    protected String getPageHeading() {
        LogUtils.info("Lấy tiêu đề trang Bảng giờ tàu");
        return Constants.pageHeading.TIMETABLE_PAGE;
    }

    @Override
    protected String getPageName() {
        LogUtils.info("Lấy tên trang Bảng giờ tàu");
        return Constants.pageName.TIMETABLE_PAGE;
    }


    private static WebElement getBookingLinkWithRoute(String departStation,String arriveStation, String linkText) {
        String xpath = String.format("//tr[td[2][normalize-space()='%s'] and td[3][normalize-space()='%s']]//a[contains(text(), '%s')]",
                departStation,
                arriveStation,
                linkText);
        LogUtils.info(String.format("Tìm link đặt vé với tuyến: %s -> %s, text: %s", departStation, arriveStation, linkText));
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    public void gotoBookingRoute(String departStation,String arriveStation, String linkText) {
        LogUtils.info(String.format("Chuyển đến đặt vé tuyến: %s -> %s, text: %s", departStation, arriveStation, linkText));
        Helpers.scrollToElement(getBookingLinkWithRoute(departStation,arriveStation,linkText));
        getBookingLinkWithRoute(departStation,arriveStation,linkText).click();
    }

    public String getBookingRouteData(String departStation,String arriveStation,String linkText) {
        LogUtils.info(String.format("Lấy dữ liệu tuyến: %s -> %s, text: %s", departStation, arriveStation, linkText));
        Helpers.scrollToElement(getBookingLinkWithRoute(departStation,arriveStation,linkText));
        String xpath = String.format("//tr[td[2][normalize-space()='%s'] and td[3][normalize-space()='%s']]", departStation, arriveStation);
        WebElement row = DriverManager.getDriver().findElement(By.xpath(xpath));

        String depart = row.findElement(By.xpath("td[2]")).getText();
        String arrive = row.findElement(By.xpath("td[3]")).getText();
        LogUtils.info(String.format("Dữ liệu lấy được: %s - %s", depart, arrive));
        return depart + arrive;
    }

}
