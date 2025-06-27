package com.tests.Common;

import com.Railway.driver.DriverManager;
import com.Railway.utilities.ScreenshotHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ScreenshotHelper.takeScreenshot(testName);
    }
}
