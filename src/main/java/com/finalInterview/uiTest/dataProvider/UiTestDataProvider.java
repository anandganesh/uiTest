package com.finalInterview.uiTest.dataProvider;

import org.testng.annotations.DataProvider;

public class UiTestDataProvider {
	
	
	@DataProvider(name="nameSearch")
	public Object[][] dataProvider(){
		
		Object[][] obj = {
				
				{"Andrew","FirstName","Tacoma"},{"Suyama","LastName","London"}
				
		};
		
		return obj;
	}
	

}
