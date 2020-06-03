package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalenderPageTest extends TestBase {

	String sheetName = "events";

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CalenderPage calenderPage;

	public CalenderPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		calenderPage = new CalenderPage();
		testUtil.switchToFrame();
	}

	@Test
	public void verifyCalenderPageTest() {
		calenderPage = calenderPage.verifyCalenderPage();
	}

	@Test
	public void selectYearCalenderTest() {
		driver.findElement(By.xpath("//a[@title='Calendar']")).click();
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		sel1.selectByIndex(5);
	}

	@Test
	public void verifyNewEventPageTest() {
		calenderPage.verifyNewEventPage();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(dataProvider = "getCRMTestData")
	public void createNewEventTest(String title, String tags, String location, String notes, String minutes) {
		calenderPage.verifyNewEventPage();
		calenderPage.createNewEvent(title, tags, location, notes, minutes);
//		calenderPage.createNewEvent("Mr", "tag1", "Worthing", "New Event 1 is created", "30mins");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
