package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class ClientCollectionPage extends PageBase {

	protected ClientCollectionPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='ClientCollectionFormRef']")
	private WebElement clientCollectionField;

	@FindBy(xpath = "//button[@id='C0_18']")
	private WebElement enterCollectionBtn;

	@FindBy(xpath = "//button[@id='C0_18']")
	private WebElement startCollectionBtn;

	@FindBy(xpath = "//input[@name='0_28']")
	private WebElement enterBarcodeField;

	@FindBy(xpath = "//button[@id='C0_61']")
	private WebElement enterBtn;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	public void workWithClientCollection() throws IOException {

		System.out.println("Inside WorkWithClientCollection");
		try {

			remoteDriver.switchTo().frame(iframe);
			// dataTable.getData("General_Data","PickNumber");
			String pickNo = getCollectDeColelctProperties("PickNumber");

			enterText(clientCollectionField, pickNo, "clientCollectionField");
			click(enterCollectionBtn, "enterCollectionBtn");
			Thread.sleep(3000);
			click(startCollectionBtn, "startCollectionBtn");
			Thread.sleep(6000);
			// dataTable.getData("General_Data", "Barcode");
			String barcode = getCollectDeColelctProperties("Barcode");
			enterText(enterBarcodeField, barcode, "enterBarcodeField");
			click(enterBtn, "enterBtn");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);
			click(cancelButton, "cancelButton");
			Thread.sleep(2000);  

			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With Client Collection Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}
}
