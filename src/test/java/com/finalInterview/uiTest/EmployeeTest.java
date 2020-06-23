package com.finalInterview.uiTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.finalInterview.uiTest.dataProvider.UiTestDataProvider;
import com.finalInterview.uiTest.frameworks.TestBase;
import com.finalInterview.uiTest.pageObjects.EmployeePage;

public class EmployeeTest extends TestBase {
	
	EmployeePage empPage;
	WebDriver driver;
	
	@BeforeTest
	public void init() {
		empPage = new EmployeePage();
		setDriver();
		driver = getDriver();
		
	}

	
	@Test(dataProvider = "nameSearch", dataProviderClass = UiTestDataProvider.class)
	public void testEmployeeTable(String name, String value, String cityName) {
		
		empPage.searchOperation(driver,name, value);
		
		Assert.assertEquals(empPage.validateItems(driver, cityName,name), true);
		
	}
	
}
