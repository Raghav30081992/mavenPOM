package com.resumehelp.qa.pages;

import com.resumehelp.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage  extends TestBase
{
	
	// page factory or Object Repository of login page
	@FindBy(id = "UserName")
	@CacheLookup
	WebElement username;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement password;
	 
	@FindBy(id ="loginSubmit")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath ="//img[contains(@src,'rh-logo-mark.svg')]")
	WebElement rhlogo;
	
	// constructor in which we are going to initialize the page factory where "this" is current class object 
	// Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	// Method to get title of login page
	
	
	//actions or methods
	// To validate Login page Title
	public String validateLoginPageTitle()
	
	{
		return driver.getTitle();
	}
	
	// To verify Logo is present on Login page 
	public boolean validateLogo()
	
	{
		return rhlogo.isDisplayed();
	}
	
	// Login Method
	public Dashboard Login (String un ,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		
		// for every page you reach after clicking must return the object of that page
		return new Dashboard();
		
	}
	
}
