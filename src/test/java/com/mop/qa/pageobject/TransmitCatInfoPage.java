package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import supportlibraries.ScriptHelper;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TransmitCatInfoPage extends PageBase {
	// UI Map object definitions

	protected TransmitCatInfoPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	@FindBy(xpath = "(//input[@title ='Sale Number'])[1]")
	private WebElement saleNumber;
	
	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//input[@title='Christies.com']")
	private WebElement christiescom;
	
	@FindBy(xpath = "//input[@title='CMID']")
	private WebElement cmid;
	
	@FindBy(xpath = "//input[@title='Saleroom Notices']")
	private WebElement saleroom;
	
	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;
	
	TestBase test = new TestBase();

	public TransmitCatInfoPage transmitToDoctom() throws IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			String saleNum = rds.getValue("LCT", test.currentTest, "SaleNumb");
			enterText(saleNumber, saleNum, "saleNumber");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(select, "select");
			Thread.sleep(2000);
			click(christiescom, "christiescom"); 
			click(save, "save"); 
			Thread.sleep(3000);
		    assertTrue(elementIsDisplayed(saleNumber), "Sale Successfully transmitted to Lot Finder");
			ExtentUtility.getTest().log(LogStatus.PASS, "transmitToDoctom",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("transmitToDoctom" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "transmitToDoctom",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new TransmitCatInfoPage(remoteDriver);
	}
	
	
	public TransmitCatInfoPage transmitSaleRoom() throws IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			String saleNum = rds.getValue("LCT", test.currentTest, "SaleNumb");
			enterText(saleNumber, saleNum, "saleNumber");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(select, "select");
			Thread.sleep(2000);
			click(saleroom, "saleroom"); 
			click(save, "save"); 
			Thread.sleep(3000);
			assertTrue(elementIsDisplayed(saleNumber), "Sale Successfully transmitted Perfect Channel");
			ExtentUtility.getTest().log(LogStatus.PASS, "transmitSaleRoom",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("transmitSaleRoom" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "transmitSaleRoom",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new TransmitCatInfoPage(remoteDriver);
	}
	
	public TransmitCatInfoPage transmitCMID() throws IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			String saleNum = rds.getValue("LCT", test.currentTest, "SaleNumb");
			enterText(saleNumber, saleNum, "saleNumber");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(select, "select");
			Thread.sleep(2000);
			//click(cmid, "cmid"); 
			click(save, "save"); 
			Thread.sleep(3000);
			assertTrue(elementIsDisplayed(saleNumber), "Sale Successfully transmitted to CMID");
			ExtentUtility.getTest().log(LogStatus.PASS, "transmitCMID",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("transmitCMID" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "transmitCMID",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new TransmitCatInfoPage(remoteDriver);
	}
}