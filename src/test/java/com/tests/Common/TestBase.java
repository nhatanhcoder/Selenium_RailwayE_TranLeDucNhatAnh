package com.tests.Common;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(AppListener.class)
public class TestBase {

    @BeforeMethod
    public  void BeforeTest(){
        DriverManager.createDriver();
        DriverManager.getDriver().get(Constants.BASE_URL);
    };

    @AfterMethod
    public  void AfterTest(){
        DriverManager.quitDriver();
    }
}
