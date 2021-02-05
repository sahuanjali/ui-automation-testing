package com.efx.assignment.auto.test.amazon.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchItem {

	WebDriver driver;
	
	@FindBy(id="searchDropdownBox")
	private WebElement selectCategoryDropDown;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchText;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement submitButton;

	public SearchItem(WebDriver driver){

        this.driver = driver;
        //This initElements method will create required elements WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void setSelectCategoryDropDown(String category) {
		
		Select dropDownCategory = new Select(this.selectCategoryDropDown);
		dropDownCategory.selectByVisibleText(category);
		
	}
	
	
	public void setSearchText(String searchText) {
		
		this.searchText.sendKeys(searchText);
		
	}
	
	public void submitSearch() {
		
		this.submitButton.click();
	}
}
