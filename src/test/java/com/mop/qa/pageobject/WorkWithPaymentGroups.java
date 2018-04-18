package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class WorkWithPaymentGroups extends PageBase {

	public WorkWithPaymentGroups(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@title='Originator']")
	private WebElement originator;

	@FindBy(xpath = "//input[@title='Bank Account']")
	private WebElement bankAccnt;

	@FindBy(xpath = "//input[@title='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//img[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//nobr[contains(text(),'Write')]")
	private WebElement writePayment;

	@FindBy(xpath = "//nobr[contains(text(),'Update')]")
	private WebElement update;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	public void WorkWithPaymentGroup() throws IOException {
		System.out.println("WorkWithPayment");

		try {
			remoteDriver.switchTo().frame(iframe);
			enterText(originator, "INJRENJIN", "originator");
	
			bankAccnt.clear();
			click(find, "find");
			Thread.sleep(3000);
			click(selectAll, "selectAll");
			click(rowExit, "rowExit");
			moveToElement(writePayment, "writePayment");
			click(writePayment,"writePayment");
			Thread.sleep(3000);
			click(save, "save");
			Thread.sleep(2000);
			remoteDriver.switchTo().alert().dismiss();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception inside createPaymentForSettlement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

}
