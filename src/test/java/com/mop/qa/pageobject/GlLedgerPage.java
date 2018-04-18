package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import supportlibraries.ScriptHelper;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class GlLedgerPage extends PageBase {
	// UI Map object definitions

	protected GlLedgerPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	@FindBy(xpath = "//input[@title='Document No/Type/Co']")
	private WebElement docNumber;

	@FindBy(xpath = "//input[@title='Batch Number']")
	private WebElement bacthNumber;

	@FindBy(xpath = "//input[@title='Amount']")
	private WebElement amount;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	public GlLedgerPage getDocumentbatchNo() throws IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			String batchNo = bacthNumber.getText();
			System.out.println("batchNo" + batchNo);
			propertiesJdeWrite("BatchNumber", batchNo);
			/*functionallibraries.FunctionalLibrary.writeIntoProperties(
					"CollectDecollect.properties", "BatchNumber", batchNo);*/

			String docNo = docNumber.getText();
			System.out.println("docNo" + docNo);
			propertiesJdeWrite("DocumentNumber", docNo);
			/*functionallibraries.FunctionalLibrary.writeIntoProperties(
					"CollectDecollect.properties", "DocumentNumber", docNo);*/
			remoteDriver.switchTo().defaultContent();
			ExtentUtility.getTest().log(LogStatus.PASS, "getDocumentbatchNo",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("batchReviewFromSeteport" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "getDocumentbatchNo",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new GlLedgerPage(remoteDriver);
	}
}