package com.tests.Common;

import com.Railway.driver.DriverManager;
import com.Railway.utilities.LogUtils;
import com.Railway.utilities.ScreenshotHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        LogUtils.info("===== SUITE STARTED: " + context.getName() + " =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtils.info("===== SUITE FINISHED: " + context.getName() + " =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("START TEST: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogUtils.error("FAILED: " + testName+ result.getThrowable());

        // Chụp ảnh khi test fail
        ScreenshotHelper.takeScreenshot(testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("⚠SKIPPED: " + result.getMethod().getMethodName());
    }
}
