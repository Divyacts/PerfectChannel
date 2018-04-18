package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;


public class ReturnToOwnerPage extends PageBase {

	protected ReturnToOwnerPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@title='Return Date']")
	private WebElement dateVal;

	@FindBy(xpath = "//input[@title='Return Reason']")
	private WebElement returReason;

	@FindBy(xpath = "//input[@title='Return Notes']")
	private WebElement returnNotes;

	@FindBy(xpath = "//input[@title='Sale Site']")
	private WebElement saleSite;

	@FindBy(xpath = "//button[contains(text(),'Return To Owner')]")
	private WebElement retrunOwner;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//img[@name='hc_OK']")
	private WebElement saveButton;
	
	TestBase test = new TestBase();

	public WorkWithPropertyPage setItemReturnToOwner() throws IOException {

		System.out.println("Inside workWithTMSShipConfirmCatPage");
		try {

			remoteDriver.switchTo().frame(iframe);
			Date currentDate = new Date(); 
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(dateVal, strTodaysDate, "dateVal");
			Thread.sleep(2000);
			String retrunReason = rds.getValue("General_Data",test.currentTest , "RetrunReason");
			System.out.println("retrunReason" + retrunReason);
			enterText(returReason, retrunReason, "returReason");
			Thread.sleep(2000);
			String retrunNotes = rds.getValue("General_Data",test.currentTest , "RetrunNotes");
			System.out.println("retrunNotes" + retrunNotes);
			enterText(returnNotes, retrunNotes, "returnNotes");
			Thread.sleep(2000);
			enterText(saleSite, "CKS", "saleSite");
			Thread.sleep(2000);
			click(retrunOwner, "retrunOwner");
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.PASS, 
					"RTO Successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception setItemReturnToOwner",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

		return new WorkWithPropertyPage(remoteDriver);

	}

}
