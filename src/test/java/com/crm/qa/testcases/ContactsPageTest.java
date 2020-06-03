package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	String sheetName = "contacts";

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactLink();

	}

	@Test(priority = 1)
	public void showfullformTabTest() {
		boolean flag1 = contactsPage.showfullformTab();
		Assert.assertTrue(flag1);
	}

	@Test(priority = 2)
	public void selectContactsByNameTest() {
		contactsPage.selectContactsByName("Alley1 Yu");

	}

	@Test(priority = 3)
	public void selectMultipleContactsByNameTest1() {
		contactsPage.selectContactsByName("Alley3 Yu");
		contactsPage.selectContactsByName("Alley2 Yu");
	}

	@Test(priority = 4)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectContactsByName("Alley2 Yu");
		contactsPage.selectContactsByName("Alley3 Yu");
	}

	@Test(priority = 5)
	public void clickOnNewContactLink() {
		contactsPage.selectContactsByName("Alley1 Yu");
		contactsPage.selectContactsByName("Alley2 Yu");

	}

	@Test(dataProvider = "getCRMTestData")
	public void clickOnNewContactLinkTest(String title, String ftName, String ltName, String comp) {
		homePage.clickOnNewContactLink();
//	contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, ftName, ltName, comp);
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
