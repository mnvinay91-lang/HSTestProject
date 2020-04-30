
/* *** @Author : vinay muralidhar *** */

package com.hs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hs.qa.base.TestBase;
import com.hs.qa.pages.HomePage;
import com.hs.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage Loginpage;
	 HomePage HomePage;
	
	public LoginPageTest()
	{
		super(); //super is called first. obtains property from TestBase
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization(); //super which is called first, come to this step for initialization of browser from TestBase
		
		Loginpage = new LoginPage();  //this object is created to access all the methods from login page
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() throws InterruptedException
	{
		Thread.sleep(5000);
		String title = LoginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void HSLogoImageTest()
	{
		boolean flag = LoginPage.ValidateHSLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void LoginTest() 
	{
		
	 HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit(); //after performing actions, browser quits
	}
}
