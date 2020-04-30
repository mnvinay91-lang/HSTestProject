package com.hs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hs.qa.base.TestBase;
import com.hs.qa.pages.LoginPage;
import com.hs.qa.pages.HomePage;
import com.hs.qa.util.TestUtil;
import com.hs.qa.pages.ContactsPage;
import com.hs.qa.pages.CompaniesPage;

public class HomePageTest extends TestBase
{
	LoginPage Loginpage;
	HomePage HomePage;
	ContactsPage ContactsPage;
	CompaniesPage CompaniesPage;
	TestUtil TestUtil;
	
	
	public HomePageTest()
	{
	super(); //super is called first. obtains property from TestBase
	}
	
	//test cases must be independent - dependency of test cases is not recommended
	//1. choose before method, picks a test case, executes and quits the browser.
	@BeforeMethod
	public void SetUp()
	{
		initialization(); //super which is called first, come to this step for initialization of browser from TestBase
		
		Loginpage = new LoginPage();  //this object is created to access all the methods from login page
		TestUtil = new TestUtil();   //this object is created to access all the methods from TestUtil page
		ContactsPage = new ContactsPage(); //this object is created to access all the methods from contacts page
		CompaniesPage = new CompaniesPage(); //this object is created to access all the methods from companies page
		
		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest() throws InterruptedException
	{
		Thread.sleep(6000);
		String homePageTitle = HomePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"[Account Setup | HubSpot]", "HomePage title not matched");
	}
	
	@Test
	public void verifyUserNameTest() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(HomePage.verifyCorrectUserName());
	}
	
	@Test
	public void verifyContactsLinkTest() throws InterruptedException
	{
		HomePage.ClickOnContactsLink(); 
		TestUtil.ClickOnExpandableContacts();
		CompaniesPage = HomePage.ClickOnExpandableContactsLink();
	}

	
	@AfterMethod
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit(); //after performing actions, browser quits
	}
}
