package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasksLink;
	@FindBy(xpath = "//a[text()='Quick Create»']")
	WebElement quickCreateLink;
	@FindBy(xpath = "//td[contains(text(),'User: ASHOK KUMAR')]")
	WebElement userNameLabel;
	//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsPageLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksPageLink() {
		tasksLink.click();
		return new TasksPage();	
	}
	public QuickCreatePage QuickCreatePage() {
		quickCreateLink.click();
		return new QuickCreatePage();	
	}
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
		
	}
	public void clickOnNewCreateContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		
	}
	
	
	

}
