package com.mop.qa.pageobject;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class TMSShipConfirmCatPage extends PageBase {

	protected TMSShipConfirmCatPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//img[@name='hc0']")
	private WebElement submittingButton;

	@FindBy(xpath = "//input[@id='C0_23']")
	private WebElement dataSelectionCheckBox;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@id='Select3']")
	private WebElement businessUnitCheckBox;

	@FindBy(xpath = "//img[@id='hc952']")
	private WebElement deletingButton;

	@FindBy(xpath = "//select[@name='LeftOperand3']")
	private WebElement selectLeftBox3;

	@FindBy(xpath = "//select[@name='Comparison3']")
	private WebElement comparisonBox3;

	@FindBy(xpath = "//select[@name='RightOperand3']")
	private WebElement selectRightBox3;

	@FindBy(xpath = "//input[@name='Etf']")
	private WebElement literalInputField;

	@FindBy(xpath = "//img[@name='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//img[@name='hc_OK']")
	private WebElement saveButton;

	public void workWithTMSShipConfirmCat() throws IOException {

		System.out.println("Inside workWithTMSShipConfirmCatPage");

		try {
			remoteDriver.switchTo().frame(iframe);
			click(dataSelectionCheckBox, "dataSelectionCheckBox");
			Thread.sleep(3000);
			click(submittingButton, "submittingButton");
			Thread.sleep(3000);

			click(businessUnitCheckBox, "businessUnitCheckBox");
			Thread.sleep(2000);
			click(deletingButton, "deletingButton");
			Thread.sleep(3000);
			
			selectOPtionByVisibleText(selectLeftBox3, "Shipment Number (F4215) (SHPN) [BC]");

			Thread.sleep(3000);
			
			selectOPtionByVisibleText(comparisonBox3, "is equal to");

			Thread.sleep(3000);

			selectOPtionByVisibleText(selectRightBox3, "Literal");

			Thread.sleep(3000);

			String shippmentNo = getJDEAppProperties("ShipmentNumber");

			System.out.println(shippmentNo);
			literalInputField.clear();
			Thread.sleep(1000);
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
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With TMS Ship Confirm Cat Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	
		}

	}

}
