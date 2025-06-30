package com.Railway.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public synchronized static ExtentReports getExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            // Thêm ngày giờ vào tên file report
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = "Result/report/extentreport_" + timestamp + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Extent Report | Tran Le Duc Nhat Anh");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Framework Name", "Selenium Java");
            extentReports.setSystemInfo("Author", "Tran Le Duc Nhat Anh");
        }
        return extentReports;
    }
}
