package com.hs.qa.pages;

import com.hs.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//*[@id='account-menu']/span")
	WebElement usernamelabel;     //lennoztech
	
	@FindBy(xpath = "//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-contacts-branch') and contains(@data-tracking,'click hover')]")
	WebElement contactsLink;     //contacts-link
	
	@FindBy(xpath = "//html/body/div[1]/nav/div/div[1]/div[1]/div/div/ul/li[2]/div/ul[1]/li[1]/a/div[1]")
	WebElement contactsExpandableLink;     //contacts expandable-link
	
	@FindBy(xpath = "//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-marketing-branch') and contains(@data-tracking,'click hover')]")
	WebElement marketingLink;   //marketing-link
	
	@FindBy(xpath = "//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-sales-branch') and contains(@data-tracking,'click hover')]")
	WebElement salesLink;   //sales-link
	
	@FindBy(xpath = "//*[@id=\"Layer_1\" and @class=\"nav-icon tool-icon gear-icon\"]")
	WebElement settingsLink;
	
	@FindBy(xpath = "//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-service-branch') and contains(@data-tracking,'click hover')]")
	WebElement serviceLink;   //service-link
	
	//initializing page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//this xpath can be used for mouse over or to select dropdowns
	By xpath = By.xpath("//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-contacts-branch') and contains(@data-tracking,'click hover')]");
	
	By xpath1 = By.xpath("//html/body/div[1]/nav/div/div[1]/div[1]/div/div/ul/li[2]/div/ul[1]/li[1]/a/div[1]");
	
	By xpath2 = By.xpath("//li[contains(@class,'expandable')]/a[contains(@id,'nav-primary-marketing-branch') and contains(@data-tracking,'click hover')]");
	
	By xpath3 = By.xpath("/html/body/div[2]/nav/div/div[1]/div[1]/div/div/ul/li[4]/div/ul[1]/li[1]/a/div[1]");
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return usernamelabel.isDisplayed();
	}
	
	public void ClickOnContactsLink()
	{
		contactsLink.click();
		
	}
	
	public CompaniesPage ClickOnExpandableContactsLink()
	{
		return new CompaniesPage();
	}
	
	public void clickOnMarketingLink()
	{
		marketingLink.click();
	}
	
	public AdsPage ClickOnExpandableMarketingLink()
	{
		return new AdsPage();
	}
	
	public SettingsPage clickOnSettingsLink()
	{
		settingsLink.click();
		return new SettingsPage();
	}
	
	
	
}
