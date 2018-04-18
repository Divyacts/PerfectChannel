package com.mop.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

public class PerfectChannelSaleEditPage extends PageBase {
	// UI Map object definitions


	@FindBy(xpath = "//*[@id='main']/div/section[1]/div[2]/textarea")
	private WebElement texArea;

	@FindBy(xpath = "//*[@id='main']/div/section[1]/div[5]/select")
	private WebElement saleStatus;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	private WebElement saleNumber;

	@FindBy(xpath = "//*[@id='dp1519715022601']")
	private WebElement saleStartTime;

	@FindBy(xpath = "//*[@id='dp1519715022602']")
	private WebElement saleEndTime;
	
	@FindBy(xpath = "(//input[@type='text'])[9]")
	private WebElement saleType;
	
	@FindBy(xpath = "//*[@id='dp1519715022603;]")
	private WebElement paymentEndTime;
	
	@FindBy(xpath = "//div[@id='main']/div/section[3]/div[4]/label[2]")
	private WebElement lotInterval;
	
	@FindBy(xpath = "//div[@id='main']/div/section[8]/div/div/ul/li")
	private WebElement geoAttributes;
	
	@FindBy(xpath  = "(//input[@type='checkbox'])[10]")
	private WebElement explicitContent; 
	
	@FindBy(xpath  = "//*[@id='main']/div/section[3]/div[5]/div/ul/li[1]")
	private WebElement saleSession1; 
	
	@FindBy(xpath  = "//*[@id='main']/div/section[3]/div[5]/div/ul/li[2]")
	private WebElement saleSession2; 
	
	@FindBy(xpath  = "//*[@id='main']/div/section[4]/div[6]/select")
	private WebElement shippingConfigType; 
	
	@FindBy(xpath = "(//input[@type='text'])[14]")
	private WebElement creditThreshold; 
	
	@FindBy(xpath  = "//*[@id='main']/div/section[4]/div[1]/select")
	private WebElement baseCurrency;
	
	@FindBy(xpath  = "//*[@id='main']/div/section[1]/div[8]/input")
	private WebElement emailAddress;
	
	
	
	public PerfectChannelSaleEditPage(RemoteWebDriver remoteDriver) { 
		super(remoteDriver);
	}

	TestBase test = new TestBase();
	
	public PerfectChannelSaleEditPage validateSaleAPIDetials() {
		try { 
			Thread.sleep(3000);
			System.out.println("inside entertierDetailsAndSave");
			String title = rds.getValue("PerfectChannel", test.currentTest, "Title");
			String email = rds.getValue("PerfectChannel", test.currentTest, "email");
			String lotInterval = rds.getValue("PerfectChannel", test.currentTest, "lotInterval");
			String currency = getJDEAppProperties("Currency"); 
			String defaultItem = getFirstSelectedOption(saleStatus); 
			String currenc = getFirstSelectedOption(baseCurrency);  
			assertEquals("Title Validation", title.trim(), texArea.getAttribute("value").trim());    
			assertEquals("Status Validation", "Live",defaultItem);
			assertEquals("Base Currency Validation",currency.trim() ,currenc); 
			assertEquals("Email Validation",email.trim() ,emailAddress.getText()); 
			assertTrue(lotInterval.contains(lotInterval), "Lot interval Validation");
			assertEquals("Email Validation",email.trim() ,emailAddress.getText());   
			
		} catch (Exception ex) {
			System.out.println("Exception inside entertierDetailsAndSave" + ex);
		}
		return new PerfectChannelSaleEditPage(remoteDriver);
	}


}