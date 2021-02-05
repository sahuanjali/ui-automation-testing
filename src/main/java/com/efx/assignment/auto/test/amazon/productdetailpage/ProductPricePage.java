package com.efx.assignment.auto.test.amazon.productdetailpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPricePage {

	private WebDriver driver;

	@FindBy(id = "newBuyBoxPrice") // price
	WebElement bookPriceOpt1;

	@FindBy(id = "price") // price
	WebElement bookPriceOpt2;

	@FindBy(id = "add-to-cart-button")
	WebElement clickAddToCart;

	public ProductPricePage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create required elements WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Amazon product price at product details page comes with dynamic ids some time
	 * ib by "newBuyBoxPrice" and sometime by "price" so handled dynamically
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getBookPrice() {

		// WebElement priceDynamicElement1 = (new WebDriverWait(driver, 10))
		// .until(ExpectedConditions.visibilityOfElementLocated(By.id("newBuyBoxPrice")));

		Boolean isPresent = driver.findElements(By.id("newBuyBoxPrice")).size() > 0;

		// boolean priceDynamicElementPresence = priceDynamicElement1.isDisplayed();
		// boolean priceDynamicElementEnabled = priceDynamicElement1.isEnabled();

		String price = "";

		if (isPresent) {
			// click on the search button
			price = bookPriceOpt1.getText().replace("$", "");
		} else {

			//WebElement priceDynamicElement2 = (new WebDriverWait(driver, 10))
			//		.until(ExpectedConditions.visibilityOfElementLocated(By.id("price")));
			// click on the search button
			price = bookPriceOpt2.getText().replace("$", "");
		}

		return price;

	}

	public void clickAddToCartButton() {

		this.clickAddToCart.click();
	}
}
