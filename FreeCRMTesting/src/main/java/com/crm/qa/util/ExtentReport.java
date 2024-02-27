package com.crm.qa.util;
/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.qa.base.TestBase;



public class ExtentReport extends TestBase {
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public static void extentTest() {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Ashok\\eclipse\\workspace\\FreeCRMTesting\\src\\test\\resources\\Spark.html");
		extent.attachReporter(spark);
	}
	}
	public static void sparkTear() {
		if(Objects.nonNull(extent)) {
		extent.flush();
	}
	}
	public static void createTest(String Testcasename) {
		test = extent.createTest(Testcasename);
	}
}