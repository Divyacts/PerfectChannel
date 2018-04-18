package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


public class StatementRefreshAdhocPage extends PageBase {

	protected StatementRefreshAdhocPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='Data Selection']")
	private WebElement dataSelectionchkbox;

	@FindBy(xpath = "//img[@id='hc0']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@id='RightOperand7']")
	private WebElement selectRightBox7;

	@FindBy(xpath = "//input[@id='LITtf']")
	private WebElement literalInputField;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "	(//a[@title='Refresh'])[2]")
	private WebElement refreshButton;

	public void workWithStatementRefreshPage() throws IOException {
		try {
			System.out.println("Auto Payment");

			remoteDriver.switchTo().frame(iframe);

			Thread.sleep(2000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(4000);
			 
			selectOPtionByVisibleText(selectRightBox7, "Literal");

			Thread.sleep(3000);
			String addressNo = getCollectDeColelctProperties("AddressNo");

			enterText(literalInputField, addressNo, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);

			System.out.println("Navigated to processing options screen");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception inside workWithStatementRefreshPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

}
