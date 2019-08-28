package com.resumehelp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resumehelp.qa.base.TestBase;

public class FinalizePage extends TestBase
{
	@FindBy(xpath="//h3[text()='FORMATTING ']")
	 WebElement FormattingLabel;
		
		
		public FinalizePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean VerifyFormattingLabel()
		
		{
			
			return FormattingLabel.isDisplayed();
			
		}
		

	}
	
	
	


