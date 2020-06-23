package com.finalInterview.uiTest.frameworks;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class TestBase extends TestNGBase{

	WebDriver driver;
	
	public void setDriver() {
	//	PropertyConfigurator.configure("/configs/log4j.properties");
		System.setProperty("webdriver.chrome.driver", "/Users/anandganesh/spicejet/test-automation/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void loadHomePage(WebDriver driver) {
		driver.get("file:///Users/anandganesh/Downloads/ui-test-assessment-master/employees.html");
	}
	
	
	
}
