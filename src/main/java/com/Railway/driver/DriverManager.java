package com.Railway.driver;

import java.io.FileReader;
import java.io.Reader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(){
        createDriver("chrome"); // default browser
    }
    
    public static void createDriver(String browserName){
        WebDriver webDriver;
        
        switch(browserName.toLowerCase()) {
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        
        webDriver.manage().window().maximize();
        driver.set(webDriver); //  Đúng cách sử dụng ThreadLocal
    }

    public static void quitDriver(){
        WebDriver webDriver = driver.get();
        if(webDriver != null){
            webDriver.quit();
            driver.remove(); //  Xóa reference trong ThreadLocal
        }
    }
    
    public static WebDriver getDriver(){
        return driver.get(); //  Đúng cách lấy driver từ ThreadLocal
    }

}
