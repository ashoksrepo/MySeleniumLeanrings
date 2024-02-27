package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import freemarker.core.InvalidFormatParametersException;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		 testUtil = new TestUtil();
		 contactsPage = new ContactsPage();
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		 homePage.clickOnContactsLink();
		 }
	
	@Test(priority=1)
	
	public void verifyContactPageName() {
		Assert.assertTrue(contactsPage.contactsPageNameDisplayed(),"contactsPage name is not displayed");
		
	}
	@Test(priority=2)
	
	public void selectContactName() {
		contactsPage.selectContactsByName("Ashok Kumar");
		
	}
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatParametersException {
		
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,dataProvider = "getCRMTestData")
	public void createNewContact(String title, String fname, String sname, String category, String status) {
		homePage.clickOnNewCreateContact();
		//contactsPage.createNewContact("Mr.", "Tom", "H", "Friend", "Hot");
		contactsPage.createNewContact(title, fname, sname, category, status);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
	}
	
