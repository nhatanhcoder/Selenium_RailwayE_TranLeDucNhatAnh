package com.tests;

import com.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeMethod
    public static void BeforeTest(){
        DriverManager.createDriver();
        DriverManager.getDriver().get("http://saferailway.somee.com/");
    };

    @AfterMethod
    public static void AfterTest(){
        DriverManager.quitDriver();
    }
}
