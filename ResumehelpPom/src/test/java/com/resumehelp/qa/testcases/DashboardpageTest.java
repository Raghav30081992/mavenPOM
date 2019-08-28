package com.resumehelp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.resumehelp.qa.base.TestBase;
import com.resumehelp.qa.pages.Dashboard;
import com.resumehelp.qa.pages.FinalizePage;
import com.resumehelp.qa.pages.LoginPage;

public class DashboardpageTest extends TestBase {
	
	Dashboard dashboard;
	LoginPage loginpage;
	FinalizePage finalizepage;
	
	//Test class constructor to call the base class constructor
	public DashboardpageTest()
		{
			// This will initialize the base class constructor
			super();
		}
	@BeforeMethod()
	public void setup()
	
	{
		initialization();
		loginpage = new LoginPage();
		dashboard =loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyDashboardTitleTest()
	{
		// Message will be displayed only when assertion gets failed 
		String dashboardtitle = dashboard.verifyDashboardTitle();
		Assert.assertEquals(dashboardtitle, "Dashboard | ResumeHelp" , "Dashboard Title is not Matched ");
		
	}
	
//	@Test(priority=2)
//	public void verifyClickOnThumbnailTest()
//	{
//		finalizepage = dashboard.clickOnThumbnail();
//		Assert.assertTrue(finalizepage.VerifyFormattingLabel(), "Formatting label not available on Finalize page");
//	}
	
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
	
		
		

}
