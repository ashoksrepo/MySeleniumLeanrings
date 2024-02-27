package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.ExtentReport;

public class LoginPage extends TestBase  {
	//Page Factory - OR
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	@FindBy(name ="password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement Signbtn;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginTitlePage() {
		ExtentReport.test.pass("title passed");
		return driver.getTitle();
		
	}
	public boolean validatecrmImage() {
	return crmLogo.isDisplayed();
	}
	public HomePage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		return new HomePage();
	}

}
