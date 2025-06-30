package com.tests.Common;

import com.Railway.utilities.LogUtils;
import com.Railway.utilities.ScreenshotHelper;
import com.Railway.reports.ExtentReportManager;
import com.Railway.reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext context) {
        LogUtils.info("===== SUITE STARTED: " + context.getName() + " =====");
        // Khởi tạo Extent Report (nếu cần)
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtils.info("===== SUITE FINISHED: " + context.getName() + " =====");
        // Flush Extent Report để lưu file
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("START TEST: " + result.getMethod().getMethodName());
        // Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("PASSED: " + result.getMethod().getMethodName());
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogUtils.error("FAILED: " + testName + result.getThrowable());
        // Chụp ảnh khi test fail
        ScreenshotHelper.takeScreenshot(testName);
        // Đính kèm screenshot vào Extent Report
        ExtentTestManager.addScreenshot(Status.FAIL, "Screenshot on failure: " + testName);
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("⚠SKIPPED: " + result.getMethod().getMethodName());
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable() != null ? result.getThrowable().toString() : "Test skipped");
    }
}
