package com.hs.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hs.qa.base.TestBase;
import com.hs.qa.pages.CompaniesPage;
import com.hs.qa.pages.ContactsPage;
import com.hs.qa.pages.HomePage;
import com.hs.qa.pages.LoginPage;
import com.hs.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase
{
	 LoginPage Loginpage;
	 HomePage HomePage;
	 ContactsPage ContactsPage;
	 CompaniesPage CompaniesPage;
	 TestUtil TestUtil;
	 
	 String sheetName = "Companies";
	 
	public CompaniesPageTest()
	{
		super(); //super is called first. obtains property from TestBase
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialization(); //super which is called first, come to this step for initialization of browser from TestBase
		
		Loginpage = new LoginPage();             //this object is created to access all the methods from login page
		TestUtil = new TestUtil();              //this object is created to access all the methods from TestUtil page
		ContactsPage = new ContactsPage();      //this object is created to access all the methods from contacts page
		CompaniesPage = new CompaniesPage();   //this object is created to access all the methods from companies page
		
		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 HomePage.ClickOnContactsLink();
		 
		TestUtil.ClickOnExpandableContacts();
		
		 Thread.sleep(3000);
		
		
	}
	
	@Test(priority=1)
	public void verifyCompanyPageLabelTest()
	{
		Assert.assertTrue(CompaniesPage.verifyCompanyLabel(), "company label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectAnyOneCompanyByNameTest()
	{
		CompaniesPage.selectAnyOneCompanyByName("Kec.ac.in Powered by Dotweb.in");
	}
	
	@Test(priority=3)
	public void selectAnyOneCompanyByCheckBoxTest()
	{
		CompaniesPage.selectAnyOneCompanyByCheckBox();
	}
	
	@Test(priority=4)
	public void selectAllCompaniesByCheckBoxTest()
	{
		CompaniesPage.selectAllCompaniesByCheckBox();
	}
	
	@DataProvider
	public Object[][] getHSTestData() throws InvalidFormatException, org.openxml4j.exceptions.InvalidFormatException
	{
		Object data [][] = TestUtil.getHSTestData(sheetName);
		return data;
	}
	
	@Test(priority=5, dataProvider = "getHSTestData")
	public void ValidatecreateNewComapanyTest(String CompanyDomainName, String CompanyOwner, String Industry, String PhoneNumber, String Type, String city, String State_Region ) throws InterruptedException
	{
	CompaniesPage.createNewCompany("www.goblue.com", "No owner", "Fishery", "78965678", "other","Hyderabad", "Karnataka");
	
	CompaniesPage.createNewCompany(CompanyDomainName, CompanyOwner, Industry, PhoneNumber, Type, city, State_Region);
	
	}
	
	
	@AfterMethod
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit(); //after performing actions, browser quits
	}
}
