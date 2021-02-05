package com.efx.assignment.auto.test.amazon.search.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.efx.assignment.auto.test.amazon.cartpage.CartPage;
import com.efx.assignment.auto.test.amazon.cartpage.CheckOutPage;
import com.efx.assignment.auto.test.amazon.homepage.AmazonHomePage;
import com.efx.assignment.auto.test.amazon.productdetailpage.ProductPricePage;
import com.efx.assignment.auto.test.amazon.search.ResultPage;
import com.efx.assignment.auto.test.amazon.search.SearchItem;

public class SearchItemTest  {

	protected String driverPath = System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe";

	protected WebDriver driver;
	
	AmazonHomePage amazonHomePage;
	SearchItem searchItem;
	ResultPage resultPage;
	ProductPricePage productPricePage;
	CartPage cartPage;
	CheckOutPage shipAndPayment;
	
	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");

	}
	/**
	 * Test book price 
	 * @param userName
	 * @param password
	 * @param category
	 * @param searchText
	 */
	@Test(groups = { "include-test-one" }, priority = 0, dataProvider="TestDataProvider", dataProviderClass = DataproviderClass.class) 
	public void test_Item_Search_Book_Price_Test(String userName, String password, String category, String searchText) {
		
		System.out.println(userName + "  @@@ "+password);

		// Create Page objects
		amazonHomePage = new AmazonHomePage(driver);
		searchItem = new SearchItem(driver);
		resultPage = new ResultPage(driver);
		productPricePage = new ProductPricePage(driver);
		cartPage = new CartPage(driver);
		shipAndPayment = new CheckOutPage(driver);
		
		
		// Step 1 open amazon page and login
		//amazon website requires login to complete the test at cart page so click here
		amazonHomePage.clickOnSignIn();
		amazonHomePage.setEmailId(userName);
		amazonHomePage.clickContinue();
		amazonHomePage.setPassword(password);
		amazonHomePage.submitSignIn();
		//amazonHomePage.clickNotNow();
		
		//Select Books category from dropdown
		searchItem.setSelectCategoryDropDown(category);
		
		//Set Search key
		searchItem.setSearchText(searchText);
		
		//click on search 
		searchItem.submitSearch();
		
		//Step 2 get price at result page. price at result page is combination of whole price and fraction price from two different element
		String bookPrice = resultPage.getPriceWhole()+"."+resultPage.getPriceFraction();
		
		System.out.println("bookPrice :: "+bookPrice);

		resultPage.selectFirstResult();
		
		String bookPriceFromAddCartPage="";
		//Step 3 get book price from product detail page  
		try {
			bookPriceFromAddCartPage = productPricePage.getBookPrice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("bookPriceFromAddCartPage = "+bookPriceFromAddCartPage);
		
		
		//Assert price at cart page against book price at search result
		Assert.assertEquals(bookPrice, bookPriceFromAddCartPage);
		
		// add book to cart
		productPricePage.clickAddToCartButton();
		
		//get price from cart page
		String priceAtCart = cartPage.getPriceAtCartPage();
		System.out.println("priceAtCart ### "+priceAtCart);
		
		//Assert price at cart against book price at search result(Step 3)
		Assert.assertEquals(bookPrice, priceAtCart);

		//proceed to next page
		String string = cartPage.getProceedToCartButtonText();
		System.out.println("proceedToCartButton ### "+priceAtCart);
		
		cartPage.clickOnProceedToCart();
		shipAndPayment.clickConfirmAddressCart();
		//Get price at checkout page 
		String priceAtPaymentShiping = shipAndPayment.getPriceAtPaymentShiping();
		System.out.println(priceAtPaymentShiping);
		
		//Assert  price at shiping against book price at search result (Step 3)
		Assert.assertEquals(bookPrice, priceAtPaymentShiping);

	}
	
	
	@AfterTest
	public void closeAllResources() {

		driver.quit();
	}
}
