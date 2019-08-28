package com.resumehelp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resumehelp.qa.base.TestBase;

public class Dashboard extends TestBase

{  
	@FindBy(xpath ="//h1[text()='Welcome to your Dashboard']")
	@CacheLookup
	WebElement dashboardheader;
	
	@FindBy(xpath="//div[@id='currentResume160369']")
	WebElement document;
	
	
	public Dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	

	public String verifyDashboardTitle()
	{
		
		return driver.getTitle();	
				
	}
	
	public FinalizePage clickOnThumbnail()
	
	{
	//	driver.switchTo().frame("iframe160369");
		document.click();
		return new FinalizePage();
	}
	
	
}
