package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class AutonettingPage extends PageBase {

	protected AutonettingPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		
	}

	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@name='E1']")
	private WebElement proofFinalMode;

	@FindBy(xpath = "//*[@name='E8']")
	private WebElement saleNumber;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement okButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	public void triggerAutoNetting() throws IOException {

		System.out.println("Inside triggerAutoNetting");
		try {
			
			String mode = getJDEAppProperties("proofOrFinalMode");
			enterText(proofFinalMode, mode, "proofFinalMode");

			Thread.sleep(1000);
			saleNumber.clear();
			String sale = getJDEAppProperties("SaleNumber");
			enterText(saleNumber,sale , "saleNumber");
			click(okButton, "okButton");
			Thread.sleep(2000);
			click(save, "save");
			ExtentUtility.getTest().log(LogStatus.PASS, "triggerAutoNetting successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in triggering AutoNetting",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

}
