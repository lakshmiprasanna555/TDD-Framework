package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase {

	@FindBy(xpath = "//a[@title='Calendar']")
	WebElement calendrLink;

	@FindBy(xpath = "//a[contains(text(),'New Event')]")
	WebElement newEvent;

	@FindBy(xpath = "//input[@id='title']")
	WebElement newEventTitle;

	@FindBy(xpath = "//input[@id='tags']")
	WebElement newEventTags;

	@FindBy(xpath = "//textarea[@name='location']")
	WebElement newEventLocation;

	@FindBy(xpath = "//textarea[@id='notes']")
	WebElement newEventNotes;

	@FindBy(xpath = "//textarea[@id='meeting_notes']")
	WebElement newEventMinutes;

	@FindBy(xpath = "//input[@ type='submit' and @ value='Save']")
	WebElement save;

	@FindBy(xpath = "//select[@name='assigned_to_user_id_src']//option[contains(text(),'Demo User')]")
	WebElement assignedto;

	@FindBy(xpath = "//input[@class='button']")
	WebElement addbutton;

	@FindBy(xpath = "//img[@id='f_trigger_c_start']")
	WebElement selectfromcalender;

	public CalenderPage() {
		PageFactory.initElements(driver, this);
	}

	public CalenderPage verifyCalenderPage() {
		calendrLink.click();
		return new CalenderPage();
	}

	public void clickCalenderPage() {
		calendrLink.click();

	}

	public void verifyNewEventPage() {

		Actions action = new Actions(driver);

		for (int i = 0; i < 2; i++) {
			action.moveToElement(calendrLink).build().perform();
			action.moveToElement(newEvent).build().perform();
		}
		newEvent.click();

	}

	public void selectFromCalender() {

		selectfromcalender.click();
	}

	public void selectDatefromcalender() {

		List<WebElement> allDates = driver.findElements(By.xpath("//td[@class='day selected weekend']"));

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("20")) {
				ele.click();
				break;
			}
		}
	}

	public void assignedTo() {

		addbutton.click();

	}

	public void createNewEvent(String title, String tags, String location, String notes, String minutes) {

		newEventTitle.sendKeys(title);
	
		newEventTags.sendKeys(tags);
		newEventLocation.sendKeys(location);
		newEventNotes.sendKeys(notes);
		newEventMinutes.sendKeys(minutes);
        save.click();

	}

}
