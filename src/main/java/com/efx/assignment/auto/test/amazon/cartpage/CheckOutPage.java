package com.efx.assignment.auto.test.amazon.cartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	private WebDriver driver;
	//Locate confirm address button
	@FindBy(css = "a[class='a-declarative a-button-text ']")
	private WebElement confirmAddressCart;
	
	//Locate Price on payment and shipping page
	@FindBy(className = "a-color-price")
	private WebElement priceAtPaymentShiping;

	public CheckOutPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create required elements WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click on confirm address button
	 */
	public void clickConfirmAddressCart() {

		confirmAddressCart.click();

	}
	/**
	 * This method returns price at checkout page
	 * @return Price on checkout page
	 */
	public String getPriceAtPaymentShiping() {

		return this.priceAtPaymentShiping.getText();
	}

}
