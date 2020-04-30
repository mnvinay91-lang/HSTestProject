package com.hs.qa.pages;

import com.hs.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
	//page factory or object repository
		@FindBy(id="username")
		static
		WebElement username;
		
		@FindBy(id="password")
		static
		WebElement password;
		
		@FindBy(xpath = "//*[@id='loginBtn']")
		static
		//@FindBy(id="loginBtn")
		WebElement LoginBtn;

		
		@FindBy(xpath = "//a[@class='m-left-1']")
		WebElement SignUpBtn;
		
		
		@FindBy(xpath = "//div[@class='auth-box marketing-box']")
		static
		WebElement HSLogo;
		
		//constructor used to initialize page objects
		public LoginPage()
		{
			//this means current class objects as initialized above or else we can use LoginPage.class
			PageFactory.initElements(driver, this);
		}
		//methods to perform actions
		public static String ValidateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public static boolean ValidateHSLogo()
		{
			return HSLogo.isDisplayed();
		}
		
		public static HomePage Login(String un, String pwd)
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			LoginBtn.click();
			
			return new HomePage();
					
		}
		
	}



