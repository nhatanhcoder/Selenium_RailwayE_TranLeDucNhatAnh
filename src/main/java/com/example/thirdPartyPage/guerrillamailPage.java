package com.example.thirdPartyPage;

import com.example.driver.DriverManager;

public class guerrillamailPage {

    public static void openMailBox(){
        DriverManager.createDriver();
        DriverManager.getDriver().get("https://www.guerrillamail.com/");
    }

    public static void closeMailBox(){
        DriverManager.quitDriver();
    }
}
