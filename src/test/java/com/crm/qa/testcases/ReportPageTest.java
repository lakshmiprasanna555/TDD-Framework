package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ReportPage;
import com.crm.qa.util.TestUtil;

public class ReportPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ReportPage reportPage;

	public ReportPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		reportPage = new ReportPage();
	}

	/*
	 * @Test public void callStatasticsClickTest() { homePage.clickReportPageLink();
	 * reportPage.callStatasticsClick(); }
	 * 
	 * @Test public void selectGraphTypeTest() { homePage.clickReportPageLink();
	 * reportPage.callStatasticsClick(); Select sel = new
	 * Select(driver.findElement(By.xpath("//select[@name='graph']")));
	 * sel.selectByIndex(4); }
	 */

	@Test
	public void selectDateByJSTest() {
		homePage.clickReportPageLink();
		reportPage.callStatasticsClick();
		reportPage.selectDateByJSFromDate(driver);
		reportPage.selectDateByJSToDate(driver);
		reportPage.getReport();

	}

	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
}
