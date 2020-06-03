package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ReportPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Call Statistics')]")
	WebElement callstatastics;

	@FindBy(xpath = "//input[@class='button'and @value='Get Report']")
	WebElement getReport;

	public ReportPage() {

		PageFactory.initElements(driver, this);

	}

	public void callStatasticsClick() {
		callstatastics.click();
	}

//	 String dateVal = "03-06-2018";

	public void selectDateByJSFromDate(WebDriver driver) {

		WebElement element = driver.findElement(By.id("fieldId_from"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '07-12-2018');", element);
	}

	public void selectDateByJSToDate(WebDriver driver) {

		WebElement element = driver.findElement(By.id("fieldId_to"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '07-10-2019');", element);
	}

	public void getReport() {
		getReport.click();
	}

}
