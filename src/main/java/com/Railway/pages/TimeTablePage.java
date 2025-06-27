package com.Railway.pages;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends BasePage {

    @Override
    protected String getPageHeading() {
        return Constants.pageHeading.TIMETABLE_PAGE;
    }

    @Override
    protected String getPageName() {
        return Constants.pageName.TIMETABLE_PAGE;
    }


    private static WebElement getBookingLinkWithRoute(String departStation,String arriveStation, String linkText) {
        String xpath = String.format("//tr[td[2][normalize-space()='%s'] and td[3][normalize-space()='%s']]//a[contains(text(), '%s')]",
                departStation,
                arriveStation,
                linkText);
        System.out.println(xpath);
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    public void gotoBookingRoute(String departStation,String arriveStation, String linkText) {
        Helpers.scrollToElement(getBookingLinkWithRoute(departStation,arriveStation,linkText));
        getBookingLinkWithRoute(departStation,arriveStation,linkText).click();
    }

    public String getBookingRouteData(String departStation,String arriveStation,String linkText) {
        Helpers.scrollToElement(getBookingLinkWithRoute(departStation,arriveStation,linkText));
        String xpath = String.format("//tr[td[2][normalize-space()='%s'] and td[3][normalize-space()='%s']]", departStation, arriveStation);
        WebElement row = DriverManager.getDriver().findElement(By.xpath(xpath));

        String depart = row.findElement(By.xpath("td[2]")).getText();
        String arrive = row.findElement(By.xpath("td[3]")).getText();
        System.out.println(depart);
        System.out.println(arrive);
        return depart + arrive;
    }

}
