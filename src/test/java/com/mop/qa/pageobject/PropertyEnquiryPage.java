package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.Click;

import supportlibraries.ScriptHelper;


public class PropertyEnquiryPage extends PageBase {

	protected PropertyEnquiryPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNum;

	@FindBy(xpath = "//*[@id='drop_home']")
	private WebElement homeButton;

	@FindBy(xpath = "//input[@title='Inventory Location']")
	private WebElement inventroyLoc;

	@FindBy(xpath = "//input[@title='Outbound Order']")
	private WebElement outboundSitetransferOrder;

	@FindBy(xpath = "//input[@title='Inbound Order']")
	private WebElement inboundSitetransferOrder;

	@FindBy(xpath = "//input[@title='Remark 1']")
	private WebElement remark1;

	@FindBy(xpath = "//input[@title='Remark 2']")
	private WebElement remark2;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//input[@title='To Branch/Plant']")
	private WebElement toBranchPlant;

	@FindBy(xpath = "//input[@title='Order Date']")
	private WebElement orderDate;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectall;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='HE0_89']/tbody/tr/td[2]/span/nobr")
	private WebElement siteTransfer;

	@FindBy(xpath = "//*[@id='HE0_146']/tbody/tr/td[2]/span/nobr")
	private WebElement printPickList;
	
	TestBase test = new TestBase();

	public void siteTransferRequest() throws IOException {

		System.out.println("Inside siteTransferRequest");
		try {

			remoteDriver.switchTo().frame(iframe);
			String itemNumber = getJDEAppProperties("ItemNumber");
			enterText(itemNum, itemNumber, "itemNum");
			Thread.sleep(2000);
			inventroyLoc.clear();
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(selectall, "selectall");
			Thread.sleep(2000);
			click(selectall, "selectall");
			click(rowExit, "rowExit");
			siteTransfer.click();
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, " siteTransferRequest Failed" + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

	public void propertySiteTransfer() throws IOException {
		System.out.println("Inside propertySiteTransfer");

		try {
			toBranchPlant.clear();
			String toSite = rds.getValue("General_Data", test.currentTest, "ToSite");
			enterText(toBranchPlant, toSite, "toBranchPlant");
			Thread.sleep(2000);
			enterText(remark1, "Test", "remark1");
			Thread.sleep(2000);
			enterText(remark2, "test", "remark2");
			Thread.sleep(2000);
			click(saveButton,"saveButton");
			Thread.sleep(4000);
			String outbSite = outboundSitetransferOrder.getAttribute("value");
			String inbSite = inboundSitetransferOrder.getAttribute("value");

			propertiesJdeWrite("outbSiteOrder", outbSite);
			propertiesJdeWrite("inbSiteOrder", inbSite);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside propertySiteTransfer Page" + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public JdeHomePage goToHomepage() throws Exception {
		remoteDriver.switchTo().defaultContent();
		click(homeButton, "homeButton");
		Thread.sleep(2000);
		return new JdeHomePage(remoteDriver);
	}

}
