package com.Railway.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static void createDriver(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static void quitDriver(){
        getDriver().quit();
        driver = null;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
