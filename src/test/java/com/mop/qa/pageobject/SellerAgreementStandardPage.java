package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

public class SellerAgreementStandardPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@title='Source Site']")
	private WebElement sourceSite;

	
	@FindBy(xpath = "//input[@title='Seller Agreement']")
	private WebElement sellerAgreement;
	
	

	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement add;
	
	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;
	
	@FindBy(xpath = "//button[contains(text(),'Generate Contract')]")
	private WebElement generateContract;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement close;
	
	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yesButton;
	
	
	
	TestBase test = new TestBase();

	public SellerAgreementStandardPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public SellerAgreementStandardPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	public JdeHomePage close() {
		try {
			System.out.println("inside close");
			remoteDriver.switchTo().frame(menuIframe);

			click(close, "Close Button JDE");
			Thread.sleep(3000);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out
					.println("Exception in close seller agreement after creation"
							+ e);
		}
		return new JdeHomePage(remoteDriver); 
	}

	public SellerAgreementDetailsPage addNewSelAgrreement(int i) {
		try {
			System.out.println("inside addNewSelAgrStand");
			if (i == 0) {
				remoteDriver.switchTo().frame(menuIframe);
			}
			click(add,"Add button Click");
			Thread.sleep(5000);
		}catch (Exception ex) {
			System.out.println("Exception inside createSellerAgrStand" + ex);
		}
		return new SellerAgreementDetailsPage(remoteDriver);
	}
	
	public SellerAgreementDetailsPage searchForSellerAgreement(){
		try{
		System.out.println("inside close");
		remoteDriver.switchTo().frame(menuIframe);
		sourceSite.clear();
		String sellerAgreem = rds.getValue("LCT", test.currentTest, "SellerAgreement");
		enterText(sellerAgreement, sellerAgreem, "sellerAgreement");
		click(search, "search");
		getStatus();
		}
		catch (Exception e){
			System.out.println("Exception in close seller agreement after creation"+ e);
		}
		return new SellerAgreementDetailsPage(remoteDriver); 
	}
	
	public SellerAgreementDetailsPage ammendSellerAgreement() throws IOException{
		try{
		System.out.println("inside close");
		//remoteDriver.switchTo().frame(menuIframe);
		click(select, "select"); 
		click(save, "save");
		Thread.sleep(3000); 
		click(generateContract, "generateContract"); 
		Thread.sleep(1000);  
		click(yesButton, "yesButton");
		Thread.sleep(15000);
		click(search, "search");
		Thread.sleep(2000);
		getStatus();
		ExtentUtility.getTest().log(LogStatus.PASS, "Contract Experess status is Pending for approval",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		catch (Exception e){
			System.out.println("Exception in ammendSellerAgreement"+ e);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in ammendSellerAgreement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SellerAgreementDetailsPage(remoteDriver); 
	}
	
	
	
	public String getValues(String fieldName, int RowCount) {
		System.out.println(gridList.size());
		String colindexcolindexValue, rowValue;
		colindexcolindexValue = null;
		rowValue = null;
		for (int i = 0; i < gridList.size(); i++) {
			WebElement element = gridList.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		rowValue = remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.getText();
		return rowValue;
	}
	
	public SellerAgreementDetailsPage getStatus() throws IOException{
		String status = null;
		try{
		System.out.println("inside close");
		status = getValues("Contract Express Status",0);
		assertTrue(status.equalsIgnoreCase("20"), "The status is pending for approval");
		ExtentUtility.getTest().log(LogStatus.PASS, "Contract express status is 20",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} 
		catch (Exception e){
			System.out.println("Exception in getStatus"+ e);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Contract express status is " + status + "",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SellerAgreementDetailsPage(remoteDriver); 
	}

}