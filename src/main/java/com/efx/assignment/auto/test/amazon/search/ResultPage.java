package com.efx.assignment.auto.test.amazon.search;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	private WebDriver driver;
	
	@FindBy( css = "a[class='a-link-normal a-text-normal']")
	private WebElement listOfItems;
	
	@FindBy(className = "a-price-whole")
	private WebElement wholePrice;
	
	@FindBy(className = "a-price-fraction")
	private WebElement fractionPrice;

	
	public ResultPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create required elements WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void selectFirstResult() {
		
		WebElement hrefList = this.listOfItems;
		hrefList.click();
		System.out.println(hrefList.getText());
		/*
		for (int i = 0; i < hrefList.size(); i++) {
			
			String value = hrefList.get(i).getText();
			System.out.println("value=" + value);
			
		
			if(value!=null && value.contains("/gp/slredirect/picassoRedirect.html")) {
				
				System.out.println(" list "+hrefList.get(i).getAttribute("href"));
				hrefList.get(i).click();
				break;
			}
			
		}*/
	}
	
	public String getPriceWhole() {
		
		return this.wholePrice.getText();
	}
	
	public String getPriceFraction() {
		
		return this.fractionPrice.getText();
	}	
}
