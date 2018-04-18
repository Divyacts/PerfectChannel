package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class FreightUpdateBillablesPage extends PageBase {

	protected FreightUpdateBillablesPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
	}

	// TODO Auto-generated constructor stub

	// UI Map object definitions
	@FindBy(xpath = "//img[@name='hc0']")
	private WebElement submittingButton;

	@FindBy(xpath = "//input[@id='C0_23']")
	private WebElement dataSelectionCheckBox;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//select[@id='RightOperand1']")
	private WebElement selectRightBox1;

	@FindBy(xpath = "//input[@name='Etf']")
	private WebElement literalInputField;

	@FindBy(xpath = "//img[@name='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//img[@name='hc_OK']")
	private WebElement saveButton;

	public void workWithFreightUpdatePage() throws IOException {

		System.out.println("Inside workWithFreightUpdatePage");

		try {
			remoteDriver.switchTo().frame(iframe);
			click(dataSelectionCheckBox, "dataSelectionCheckBox");
			Thread.sleep(2000);
			click(submittingButton, "submittingButton");
			Thread.sleep(2000);
			
			selectOPtionByVisibleText(selectRightBox1, "Literal");
			Thread.sleep(3000);
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
	
			System.out.println(shippmentNo);
			enterText(literalInputField, shippmentNo, "literalInputField");

			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);

			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With Freight Update Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

}
