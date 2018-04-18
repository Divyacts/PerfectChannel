package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class InboundPropertyPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;
	

	@FindBy(id = "C0_19")
	private WebElement item;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@id='G0_1_R1']/td[1]/div/input")
	private WebElement checkBox1;

	@FindBy(xpath = "//*[@id='REPORT_EXIT_BUTTON']")
	private WebElement reportExit;

	@FindBy(id = "//input[@title='Item Number']")
	private WebElement itemNumber;

	@FindBy(id = "//input[@title='Order Number']")
	private WebElement itemNorderumber;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div")
	private WebElement ohNumber;

	@FindBy(xpath = "//*[@id='HE0_381']/tbody/tr/td[2]/span/nobr")
	private WebElement arrivalPickList;

	@FindBy(xpath = "//*[@id='C0_18']")
	private WebElement PrintOnly;

	@FindBy(id = "//input[@tid='C0_7']")
	private WebElement busUnit;

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public InboundPropertyPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	public String getOhNumber() throws InterruptedException, IOException {
		String ohval = null;
		try {
			System.out.println("inside getOhNumebr");
			// driver.switchTo().frame(menuIframe);

			WebElement iframeSwitch = remoteDriver.findElement(By
					.id("e1menuAppIframe"));
			remoteDriver.switchTo().frame(iframeSwitch);
			System.out.println("Switched");
			String ItemNumber = getJDEAppProperties("ItemNumber");

			enterText(item, ItemNumber, "item");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			ohval = ohNumber.getText();
			propertiesJdeWrite("ohNumber", ohval);
			click(checkBox, "checkBox");
			click(reportExit, "reportExit");
			Thread.sleep(1000);
			click(arrivalPickList, "arrivalPickList");
			Thread.sleep(1000);
			click(PrintOnly, "PrintOnly");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);

		} catch (Exception ex) {
			System.out.println("Inside Order Recipt 2" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Inside Order Recipt page 2",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return ohval;
	}

	public String printArrivalPickList() throws InterruptedException, IOException {
		String inbSiteOrder = null;
		try {
			System.out.println("inside getOhNumebr");
			// driver.switchTo().frame(menuIframe);
			
			WebElement iframeSwitch = remoteDriver.findElement(By
					.id("e1menuAppIframe"));
			remoteDriver.switchTo().frame(iframeSwitch);
			System.out.println("Switched");
			String ItemNumber = getJDEAppProperties("ItemNumber");
			inbSiteOrder = getJDEAppProperties("inbSiteOrder");
			enterText(item, ItemNumber, "item");
			Thread.sleep(2000);
			remoteDriver.findElement(By.id("C0_7")).clear();
			// busUnit.clear();
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(checkBox, "checkBox");
			click(reportExit, "reportExit");
			Thread.sleep(1000);
			click(arrivalPickList, "arrivalPickList");
			Thread.sleep(1000);
			click(PrintOnly, "PrintOnly");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);

		} catch (Exception ex) {
			System.out.println("Inside Order Recipt 2" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Inside Order Recipt page 2",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return inbSiteOrder;
	}

	public boolean existsElement(String ele) {

		return true;
	}
}
