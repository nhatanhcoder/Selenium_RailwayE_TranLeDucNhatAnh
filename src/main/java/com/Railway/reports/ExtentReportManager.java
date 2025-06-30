package com.Railway.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Result/report/extentreport.html");
        reporter.config().setReportName("Extent Report | Tran Le Duc Nhat Anh");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java");
        extentReports.setSystemInfo("Author", "Tran Le Duc Nhat Anh");
        return extentReports;
    }
}
