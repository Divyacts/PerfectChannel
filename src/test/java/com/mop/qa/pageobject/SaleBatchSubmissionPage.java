package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


public class SaleBatchSubmissionPage extends PageBase {

	protected SaleBatchSubmissionPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "(//*[@title='Sale Site'])[2]")
	private WebElement saleSite;

	@FindBy(xpath = "(//*[@title='Sale Number'])[2]")
	private WebElement saleNumber;

	@FindBy(xpath = "(//*[@title='Shipment Number'])[2]")
	private WebElement shipmentNumber;

	@FindBy(xpath = "(//*[@title='Lot Number'])[2]")
	private WebElement lotNumber;

	@FindBy(xpath = "//button[contains(text(),'Submit Combined Batching')]") 
	private WebElement submitCombinedBatch;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//button[@title = 'Ctrl+Alt+O']")
	private WebElement okButton;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	public SaleBatchSubmissionPage submitCombineBtachingForSale() throws IOException {
		try {
			Thread.sleep(2000);
			remoteDriver.switchTo().frame(iframe);
			System.out.println("in submitCombineBtaching");
			String SaleSource = getJDEAppProperties("SaleSourceSite");
			enterText(saleSite, SaleSource, "saleSite");
			Thread.sleep(1000);
			String SaleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, SaleNum, "saleNumber");
			Thread.sleep(1000);
			click(submitCombinedBatch, "submitCombinedBatch");
			Thread.sleep(3000);
			click(okButton, "okButton");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("submitCombineBtaching" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside submitCombineBtaching SaleBatchSubmissionPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}

	public SaleBatchSubmissionPage submitCombineBtachingForAdHoc() throws IOException {
		try {
			Thread.sleep(2000);
			remoteDriver.switchTo().frame(iframe);
			System.out.println("in submitCombineBtachingForAdHoc");

			String SaleSource = functionallibraries.FunctionalLibrary
					.propertiesRead("SaleSourceSite");
			saleSite.sendKeys(SaleSource);
			Thread.sleep(1000);
			String SaleNum = functionallibraries.FunctionalLibrary
					.propertiesRead("SaleNumber");
			saleNumber.sendKeys(SaleNum);
			Thread.sleep(1000);
			String LotNumForAdhocBatching = functionallibraries.FunctionalLibrary
					.propertiesRead("LotNumForAdhocBatching");
			Thread.sleep(1000);
			lotNumber.clear();
			lotNumber.sendKeys(LotNumForAdhocBatching);
			submitCombinedBatch.click();
			Thread.sleep(3000);
			okButton.click();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("submitCombineBtaching" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside submitCombineBtaching SaleBatchSubmissionPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}

	public SaleBatchSubmissionPage submitCombineBtachingForPostSaleFreight() throws IOException {
		try {
			Thread.sleep(2000);
			remoteDriver.switchTo().frame(iframe);
			System.out.println("in submitCombineBtachingForAdHoc");

			String SaleSource = functionallibraries.FunctionalLibrary
					.propertiesRead("SaleSourceSite");
			saleSite.sendKeys(SaleSource);
			Thread.sleep(1000);
			String ShipmentNum = functionallibraries.FunctionalLibrary
					.propertiesRead("ShipmentNumber");
			shipmentNumber.sendKeys(ShipmentNum);
			Thread.sleep(1000);
			submitCombinedBatch.click();
			Thread.sleep(3000);
			okButton.click();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("submitCombineBtaching" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside submitCombineBtaching SaleBatchSubmissionPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}

}
