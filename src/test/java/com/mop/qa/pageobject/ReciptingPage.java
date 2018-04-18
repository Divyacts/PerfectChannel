package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class ReciptingPage extends PageBase {

	protected ReciptingPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "//*[@title='Receipt Number']")
	private WebElement reciptNumber;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//*[@id='HE0_75']/tbody/tr/td[2]/span/nobr")
	private WebElement voidRcpt;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@title='KY_InventoryStatus']")
	private WebElement invenStatus;

	public ReciptingPage voidRecipt() throws IOException {
		try {

			String reciptNo = getJDEAppProperties("ReciptNo");
			remoteDriver.switchTo().frame(iframe);
			enterText(reciptNumber, reciptNo, "reciptNumber");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			click(selectAll, "selectAll");
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(voidRcpt, "voidRcpt");
			click(voidRcpt, "voidRcpt");
			ExtentUtility.getTest().log(LogStatus.PASS, "voidRecipt Successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			Thread.sleep(4000);

		} catch (Exception ex) {
			System.out.println("voidRecipt Recipting Page" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside voidRecipt page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new ReciptingPage(remoteDriver);
	}

}
