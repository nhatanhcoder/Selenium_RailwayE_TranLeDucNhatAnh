package com.tests;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public static void BeforeTest(){
        DriverManager.createDriver();
        DriverManager.getDriver().get(Constants.BASE_URL);
    };

    @AfterMethod
    public static void AfterTest(){
        DriverManager.quitDriver();
    }
}
