package com.hs.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openxml4j.exceptions.InvalidFormatException;

import com.hs.qa.base.TestBase;

public class TestUtil extends TestBase
{
public static long PAGE_LOAD_TIMEOUT = 20;
public static long IMPLICIT_WAIT = 10;

public static String TESTDATA_SHEET_PATH = "H:\\Java\\HubSpot\\src\\main\\java\\com\\hs\\qa\\testdata\\HubSpotTestData.xlsx";

static Workbook book;
static Sheet sheet;

//public void switchToFrame()
//{
//	driver.switchTo().frame("mainpanel");
//}

public void ClickOnExpandableContacts() throws InterruptedException
{
	Thread.sleep(3000);

	driver.findElement(By.linkText("Companies")).click();

}

public static Object [][] getHSTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, InvalidFormatException
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
	
	sheet= book.getSheet(sheetName);
	Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i = 0; i< sheet.getLastRowNum(); i++)	
	{
		for(int k = 0; i< sheet.getRow(0).getLastCellNum(); k++)	
		{
			data[i][k] = sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}

public static void takeScreenshotAtEndOfTest() throws IOException
{ 
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	  FileUtils.copyFile(src, new File("E:\\selenium\\selenium web driver tutorials\\outputs\\ScreenshotsfromHS\\ScreenShotTestUtil.png"));
	
}
}
