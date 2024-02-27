package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExtentReport;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.extentTest();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitelTest() {
		ExtentReport.createTest("loginPageTitleTest");

		String ExpectedTitle = "Free CRM software for customer relationship management, sales, and support.";
		String title = loginPage.validateLoginTitlePage();
		Assert.assertEquals(title, ExpectedTitle);
	}

	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean flag = loginPage.validatecrmImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@AfterSuite
	public void flush() {
		ExtentReport.sparkTear();
	}

}
