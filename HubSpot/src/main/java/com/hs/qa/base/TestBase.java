package com.hs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hs.qa.util.TestUtil;
import com.hs.qa.util.WebEventListener;

public class TestBase 
{
	//Global variables - can be used in child class and test base also
		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		
		//constructor
		public TestBase()
		{
			try
			{
				prop = new Properties();
				FileInputStream ip = new FileInputStream("H:\\Java\\HubSpot\\src\\main\\java\\com\\hs\\qa\\config\\config.properties");
				prop.load(ip);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			}
		
		//method
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			 if(browserName.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinay muralidhar\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe"); 
				driver = new FirefoxDriver();
		   }
			 
			 e_driver = new EventFiringWebDriver(driver);
			 
			 //creating object of EventListenerHandler to register it with EventFiringWebDriver
			 eventListener = new WebEventListener();
			 e_driver.register(eventListener);
			 driver = e_driver;
			 
			 
			 driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
				
				//Global Waits or dynamic waits
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);					
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				driver.get(prop.getProperty("url"));
		}
}
