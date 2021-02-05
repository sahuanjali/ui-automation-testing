package com.efx.assignment.auto.test.amazon.search.test;
import org.testng.annotations.DataProvider;

public class DataproviderClass {
	
	@DataProvider(name = "TestDataProvider")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] { { "anjali.autotest@gmail.com", "Skywar@10", "Books", "qa testing for beginners" } };
	}
}