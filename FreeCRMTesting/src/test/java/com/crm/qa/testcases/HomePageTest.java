package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.QuickCreatePage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	 HomePage homePage;
	 ContactsPage contactsPage;
	 TestUtil testUtil;
	 DealsPage dealsPage;
	TasksPage tasksPage;
	QuickCreatePage quickCreatePage;
	
 public HomePageTest() {
	 super();
 }

 @BeforeMethod
 public void setUp() {
 Initialization();
 loginPage = new LoginPage();
 testUtil = new TestUtil();
 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 }
 @Test(priority=1)
 public void verifyHomePageTitle(){
	 String homePageTitle = homePage.verifyHomePageTitle();
	 Assert.assertEquals(homePageTitle, "CRMPRO","HomePage title is not matched");
	 
 }
 @Test(priority=2)
 public void contactsPage() {
	 testUtil.switchToFrame();
	 contactsPage = homePage.clickOnContactsLink();
	 
 }
 @Test(priority=3)
 public void dealsPage() {
	 testUtil.switchToFrame();
	 dealsPage = homePage.clickOnDealsPageLink();
	 
 }
 @Test(priority=4)
public void tasksPage() {
	 testUtil.switchToFrame();
	 tasksPage = homePage.clickOnTasksPageLink();
	 
}
 @Test(priority=5)
public void quickCreatePage() {
	 testUtil.switchToFrame();
	 quickCreatePage = homePage.QuickCreatePage();
	 
}
 @Test
 public void verifyUsername() {
	 testUtil.switchToFrame();
	 Assert.assertTrue(homePage.verifyUserName());
 }
 @AfterMethod
 public void tearDown() {
	 driver.close();
 }
 
 
}
