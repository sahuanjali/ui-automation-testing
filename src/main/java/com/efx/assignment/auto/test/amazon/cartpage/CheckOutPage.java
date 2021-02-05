package com.efx.assignment.auto.test.amazon.cartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	private WebDriver driver;

	@FindBy(css = "a[class='a-declarative a-button-text ']")
	private WebElement confirmAddressCart;

	@FindBy(className = "a-color-price")
	private WebElement priceAtPaymentShiping;

	public CheckOutPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create required elements WebElements
		PageFactory.initElements(driver, this);
	}

	public void clickConfirmAddressCart() {

		confirmAddressCart.click();

	}

	public String getPriceAtPaymentShiping() {

		return this.priceAtPaymentShiping.getText().replace("$", "");
	}

}
