package com.resumehelp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.resumehelp.qa.util.TestUtil;
import com.resumehelp.qa.util.WebEventListener;

public class TestBase {
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventlistner;
	 
	
	public TestBase ()
	{
		try 
		{
		 prop = new Properties();
		FileInputStream ip;
		ip = new FileInputStream("C:\\Users\\Raghav.Maheshwari\\Desktop\\ResumehelpPom\\src\\main\\java\\com\\resumehelp\\qa\\config\\config.properties");
	    prop.load(ip);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		public static void initialization()
		
		{
			
			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
				
			}
			if (browsername.equals("FF"))
			{
				System.setProperty("Webdriver.gecko.driver", "C:/Users/raghav.maheshwari/.m2/repository/org/seleniumhq/selenium/selenium-firefox-driver/2.53.0/selenium-firefox-driver-2.53.0");
				driver = new FirefoxDriver();
			}
			
			EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
			WebEventListener eventlistner  = new WebEventListener();
			e_driver.register(eventlistner);
			driver=e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITYWAIT_TIMEOUT , TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
					    
			
		}
	}

