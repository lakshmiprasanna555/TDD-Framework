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
import com.crm.qa.pages.ReportPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealPage;
	TasksPage taskPage;
	ReportPage reportPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		dealPage = new DealsPage();
		// testUtil.switchToFrame();
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO", "HomePage title not matched");
	}

	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsrName(), "Username is not matched");
	}

	@Test(priority=3)
	public void clickContactLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactLink();
	}

	@Test(priority=4)
	public void clickDealsLinkTest() {
		testUtil.switchToFrame();
		dealPage = homePage.clickDealsLink();
	}

	@Test(priority=5)
	public void clickTasksLinkTest() {
		testUtil.switchToFrame();
		taskPage = homePage.clickTasksLink();
	}
	
	@Test(priority=6)
	public void clickReportPageLinkTest() {
		testUtil.switchToFrame();
		reportPage = homePage.clickReportPageLink();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
