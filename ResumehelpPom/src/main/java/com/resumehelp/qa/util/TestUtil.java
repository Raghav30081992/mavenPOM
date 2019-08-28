package com.resumehelp.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.resumehelp.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long  PAGELOAD_TIMEOUT = 20;
	public static long  IMPLICITYWAIT_TIMEOUT = 10;
	public static String TESTDATA_SHEET_PATH = "C:/Users/Raghav.Maheshwari/Desktop/ResumehelpPom/src/main/java/com/resumehelp/qa/testdata/ResumeHelp.xlsx";
	static Workbook  book;
    static Sheet sheet;
	
	
	
	// use this method directly if you want to switch to any particular frame
	public void switchtoframe(String framename)
	{
		driver.switchTo().frame(framename);
	}
	
	
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream file = null;
		try
		{
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book = WorkbookFactory.create(file);
		}
	
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
	
	
	Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for (int i=0;i<sheet.getLastRowNum();i++)
	{
		for (int j=0;j<sheet.getRow(0).getLastCellNum();j++)
		{
			data[i][j]= sheet.getRow(i+1).getCell(j).toString();

		}
	}
   return data;
 }


	public static void takeScreenshotAtEndOfTest() throws IOException 
	
	{

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,new File(CurrentDir+"\\screenshots\\"+currentTimeStamp()+".png"));
		
	}
	
	 public static String currentTimeStamp(){
		 
		 // Date format is an abstract class which is implemented by simple date format

		 DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 Date currentdate = new Date();
		 return customformat.format(currentdate);
		 }


	
}