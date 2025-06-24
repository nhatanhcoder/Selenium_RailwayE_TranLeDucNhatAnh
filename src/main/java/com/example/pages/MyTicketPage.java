package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {

    private final By myticketTilte= By.xpath("//h1[text()='Manage ticket']");

    private WebElement getMyticketTilte(){
        return DriverManager.getDriver().findElement(myticketTilte);
    }

    public String getMyticketTilteText(){
        return getMyticketTilte().getText();
    }

}
