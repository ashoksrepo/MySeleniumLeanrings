package com.crm.qa.extentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {
	public void extendReports() {
ExtentReports extentReports = new ExtentReports();
ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Ashok\\eclipse\\workspace\\report.html");
extentReports.attachReporter(sparkReporter);
extentReports.flush();
}
}
