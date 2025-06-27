package com.Railway.utilities;

import com.Railway.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotHelper {

    public static void takeScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File destDir = new File("Result/screenshots");
            if (!destDir.exists()) {
                destDir.mkdirs(); // tạo thư mục nếu chưa tồn tại
            }
            File destFile = new File(destDir, fileName);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("⚠️ Failed to save screenshot: " + e.getMessage());
        }
    }

}
