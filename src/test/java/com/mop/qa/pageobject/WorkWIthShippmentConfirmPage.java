package com.mop.qa.pageobject;

import java.io.IOException;

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
public class WorkWIthShippmentConfirmPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(id = "//*[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//input[@title='From Site']")
	private WebElement fromSite;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div/input")
	private WebElement RecCnt1;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumber;

	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement shOrderNumber;

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public WorkWIthShippmentConfirmPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	public WorkWIthShippmentConfirmPage shipConfirm()
			throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(menuIframe);
			String ItemNumber = getJDEAppProperties("ItemNumber");
			String ShOutbOundNumber = getJDEAppProperties("ShOutbOundNumber");
			enterText(shOrderNumber, ShOutbOundNumber, "ShOutbOundNumber");
			Thread.sleep(2000);
			enterText(itemNumber, ItemNumber, "itemNumber");
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(checkBox, "checkBox");
			Thread.sleep(500);
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			enterText(RecCnt1, "1", "RecCnt1");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Inside shipConfirm" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception shipConfirm",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
		}
		return new WorkWIthShippmentConfirmPage(remoteDriver);
	}

	public WorkWIthShippmentConfirmPage shipConfirmForSitetransfer()
			throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(menuIframe);
			String ItemNumber = getJDEAppProperties("ItemNumber");
			String ShOutbOundNumber = getJDEAppProperties("ShOutbOundNumber");
			fromSite.clear();
			Thread.sleep(2000);
			enterText(itemNumber, ItemNumber, "ItemNumber");
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(checkBox, "checkBox");
			Thread.sleep(500);
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			enterText(RecCnt1, "1", "RecCnt1");
			Thread.sleep(2000);
			click(saveButton,"saveButton");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Inside Order Recipt 2" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception inside Inside Order Recipt page 2",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
		}
		return new WorkWIthShippmentConfirmPage(remoteDriver);
	}

	public boolean existsElement(String ele) {

		return true;
	}
}
