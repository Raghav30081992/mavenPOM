package com.resumehelp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.resumehelp.qa.base.TestBase;
import com.resumehelp.qa.pages.Dashboard;
import com.resumehelp.qa.pages.LoginPage;
import com.resumehelp.qa.util.TestUtil;

public class LoginPageTest extends TestBase 

{
	
	LoginPage loginpage;
	Dashboard dashboard;
	String Sheetname =  "Login";
//Test class constructor to call the base class constructor
	public LoginPageTest()
	{
		// This will initialize the base class constructor
		super();
	}
	
	@BeforeMethod()
	public void setup()
	
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test (priority = 1)
	public void loginpagetitletest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login | ResumeHelp");
	}
	
	@Test (priority = 2)
	public void loginPageLogoImagetest()
	{
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		
	}
	
	@DataProvider
	public Object [][] LoginTestData()
	{
		Object data [][] = TestUtil.getTestData(Sheetname);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "LoginTestData")
	public void loginTest(String userName , String Password)
	{
		dashboard = loginpage.Login(userName,Password);
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
	
}
