package com.finalInterview.uiTest.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.finalInterview.uiTest.frameworks.TestBase;

public class EmployeePage extends TestBase {

	WebDriver driver;

	@FindBy(id = "contenttabletreeGrid")
	WebElement tableId;

	@FindBy(xpath = "//button[@id='btn']")
	WebElement dataItem;

	public EmployeePage() {
		driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	public void searchOperation(WebDriver driver, String name, String value) {
		loadHomePage(driver);

		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));

		int indexValue = 0;
		String tempStr = "", spanText = "/span[2]";
		if (value.equals("FirstName")) {
			indexValue = 1;
			tempStr = "/span[3]";

		} else if (value.equals("LastName")) {
			indexValue = 2;
		} else if (value.equals("Title")) {
			indexValue = 3;
		}

		for (int i = 0; i < list.size(); i++) {
			WebElement str = list.get(i).findElement(By.xpath("td[" + indexValue + "]" + tempStr));
			WebElement checkBox = list.get(i).findElement(By.xpath("td[" + indexValue + "]" + tempStr));

			if (str.getText().equals(name)) {

				list.get(i).findElement(By.xpath("td[" + indexValue + "]" + spanText)).click();
				break;
			}
		}

	}

	public boolean validateItems(WebDriver driver, String cityName, String name) {
		dataItem.click();
		List<WebElement> listCity = driver.findElements(By.xpath("//div[@id='listBoxContentlistBoxSelected']/div/div"));
		for (WebElement elem : listCity) {
			if (elem.findElement(By.xpath("/span")).getText().contentEquals(cityName)&&
					elem.findElement(By.xpath("/span")).getText().contentEquals(name)) {
				return true;
			}
		}
		return false;
	}

}
