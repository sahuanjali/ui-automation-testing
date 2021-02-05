package com.efx.assignment.auto.test.amazon.cartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver;

	@FindBy( id = "hlb-ptc-btn-native")
	private WebElement proceedToCartButton;
	
	@FindBy( css = "span[class='a-color-price hlb-price a-inline-block a-text-bold']")
	private WebElement priceOnCart;

	
	public CartPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create required elements WebElements
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickOnProceedToCart(){
		
		proceedToCartButton.click();
		
	}
	
	public String getPriceAtCartPage() {
		
		return this.priceOnCart.getText().replace("$","");
	}

	public String getProceedToCartButtonText() {
		
		String text = this.proceedToCartButton.getText();
		
		System.out.println(" text "+text);
		text.substring(text.indexOf("(")+1,text.indexOf("(")+2);
		return text;
		
	}
	
}
