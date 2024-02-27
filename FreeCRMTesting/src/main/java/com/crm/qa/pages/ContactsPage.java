package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
//Web Elements
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsPageName;
	@FindBy(xpath = "//select[@name='title']")
	WebElement titlexpath;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement fname;
	@FindBy(xpath = "//input[@name='surname']")
	WebElement sname;
	@FindBy(xpath = "//select[@name='category']")
	WebElement categoryx;
	@FindBy(xpath = "//select[@name='status']")
	WebElement statusx;
	@FindBy(xpath = "//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement savebtn;
	
	//Initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean contactsPageNameDisplayed() {
		return contactsPageName.isDisplayed();
	}
	
public void selectContactsByName(String name) {
	
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']")).click();
	
}
public void createNewContact(String title, String fm,String sn, String category, String status) {
	Select select = new Select(titlexpath);
	select.selectByVisibleText(title);
	fname.sendKeys(fm);
	sname.sendKeys(sn);
	Select select1 = new Select(categoryx);
	select1.selectByVisibleText(category);
	Select select2 = new Select(statusx);
	select2.selectByVisibleText(status);
	savebtn.click();
	
	
	
}
	
	
}
