package com.efx.assignment.auto.test.amazon.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	private WebDriver driver;

	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement signInLink;
	
	@FindBy(id="ap_email")
	private WebElement userEmail;
	
	@FindBy(id="continue")
	private WebElement continueButton;

	@FindBy(id="ap_password")
	private WebElement password;

	@FindBy(id="signInSubmit")
	private WebElement signInButton;
	
	@FindBy(id="ap-account-fixup-phone-skip-link")
	private WebElement notNow;
	
	public AmazonHomePage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create required elements WebElements
        PageFactory.initElements(driver, this);
    }

	// Get title for the amazon Home Page
	public String getHomePageTitle() {

		return driver.getTitle();

	}
	
	
	public void clickOnSignIn() {
		
		this.signInLink.click();
	}
	
	public void setEmailId(String emailid) {
		
		this.userEmail.sendKeys(emailid);
		
	}
	
	public void clickContinue() {
		
		this.continueButton.click();
		
	}
	
	public void setPassword(String password) {
		
		this.password.sendKeys(password);
	}
	
	public void submitSignIn() {
		
		this.signInButton.click();
	}
	
	public void clickNotNow() {
		
		this.notNow.click();
	}
	
}