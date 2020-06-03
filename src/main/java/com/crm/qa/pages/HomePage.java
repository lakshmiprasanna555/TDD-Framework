package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//body/table/tbody/tr/td[@class='headertable']/table/tbody/tr/td[1]")
	WebElement userNameLablel;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasksLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
     WebElement newContactLink;
	// Initialising the pageobjects
	
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement clickreportspagelink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
	return driver.getTitle();
	}

	public boolean verifyCorrectUsrName() {
    return userNameLablel.isDisplayed();
	}

	public ContactsPage clickContactLink() {
	contactsLink.click();
	return new ContactsPage();
	}

	public ContactsPage clickNewContactLink() {
    newContactLink.click();
	return new ContactsPage();
	}
	public DealsPage clickDealsLink() {
	dealsLink.click();
	return new DealsPage();
	}
    public TasksPage clickTasksLink() {
	tasksLink.click();
	return new TasksPage();
	}
    public ReportPage clickReportPageLink() {
    	clickreportspagelink.click();
    	return new ReportPage();
    	}
    

	public void clickOnNewContactLink() {
	Actions action = new Actions(driver);
	for (int i = 0; i < 2; i++) {
	action.moveToElement(contactsLink).build().perform();
	action.moveToElement(newContactLink).build().perform();
		
	}

	newContactLink.click();
}}