package com.efx.assignment.auto.test.amazon.cartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver;
	
	//locate Proceeed to Cart web element 
	@FindBy( id = "hlb-ptc-btn-native")
	private WebElement proceedToCartButton;
	
	//locate price in cart web element 
	@FindBy( css = "span[class='a-color-price hlb-price a-inline-block a-text-bold']")
	private WebElement priceInCart;

	
	public CartPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create required elements WebElements
        PageFactory.initElements(driver, this);
    }
	
	/**
	 * This method is to click on proceed to cart button  
	 */
	public void clickOnProceedToCart(){
		
		proceedToCartButton.click();
		
	}
	/**
	 * This method returns price 
	 * @return price in cart
	 */
	public String getPriceAtCartPage() {
		
		return this.priceInCart.getText();
	}
	
}
