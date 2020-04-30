package com.hs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hs.qa.base.TestBase;

public class CompaniesPage extends TestBase
{
	@FindBy(xpath = "//h1[contains(@class,'IndexPageRedesignHeader__StyledH1-ljkrr-1 gVbazu')]")
	@CacheLookup
	WebElement companieslabel;     //companies
	
	@FindBy(xpath ="//tbody//tr//td//div//label//span//span//span[2]")
	WebElement checkBoxKEC;
	
	@FindBy(xpath ="//tbody//tr//td//div//label//span//span//span[2]")
	WebElement checkBoxEenadu;
	
	@FindBy(xpath ="//input[@id = 'UIFormControl-26']")
	WebElement CompanyDomainName;
	
	@FindBy(xpath ="//input[@id='UIFormControl-38' and @class='form-control private-form__control']")
	WebElement phoneNumber;
	
	@FindBy(xpath ="//*[@id='UIFormControl-44']")
	WebElement City;
	
	@FindBy(xpath = "//input[@id='UIFormControl-46']")
	WebElement StateRegion;
	
	@FindBy(xpath = "//button[@class='uiButton private-button private-button--primary private-button--default private-loading-button private-button--primary private-button--non-link']")
	WebElement CreateCompanyButton;
	
	
	
public CompaniesPage()
{
	PageFactory.initElements(driver, this);
}

public boolean verifyCompanyLabel()
{
	return companieslabel.isDisplayed();
}

public void selectAnyOneCompanyByName(String name)
{
	driver.findElement(By.xpath("//a//span[contains(text(),'"+name+"')]")).click();
}


public void selectAnyOneCompanyByCheckBox()
{
	checkBoxKEC.click();
}

public void selectAllCompaniesByCheckBox()
{
	checkBoxKEC.click();
	checkBoxEenadu.click();
}

public void createNewCompany(String DomainName,String title1, String title2, String PhoneNumber, String title3,String city, String State_Region) throws InterruptedException
{
	driver.findElement(By.xpath("//button[@class='uiButton private-button private-button--primary private-button--default add-obj private-button--non-link']")).click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//div[@class='UIDialog__Div-axmggl-0 ftZMtr private-modal private-modal--sidebar uiDialog-root']"));
	
	Thread.sleep(3000);
	
	CompanyDomainName.sendKeys(DomainName);	//to enter domain name
	
	Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"UIFormControl-30\"]/span/span[1]")));
	select1.selectByVisibleText(title1); //drop down for company owner
	
    Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"uiabstractdropdown-button-36\"]/span/span[1]")));
	select2.selectByVisibleText(title2); //drop down for industry
	
	phoneNumber.sendKeys(PhoneNumber); //to enter phone number
	
     Select select3 = new Select(driver.findElement(By.xpath("//*[@id=\"uiabstractdropdown-button-42\"]/span/span[1]")));
	select3.selectByVisibleText(title3); //drop down for type
	
	City.sendKeys(city);  //to enter city
	
	StateRegion.sendKeys(State_Region);  //to enter state_region
	
	Thread.sleep(4000);
	
	CreateCompanyButton.click();
	
}
//div[@class='UIDialog__Div-axmggl-0 ftZMtr private-modal private-modal--sidebar uiDialog-root']
}

