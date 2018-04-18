package com.mop.qa.pageobject;

import java.io.IOException;

import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class InboundConsignmentPage extends PageBase {
	protected InboundConsignmentPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='OrderNumber']")
	private WebElement orderNumberField;
	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div")
	private WebElement shippmentNo;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_306']/span/nobr")
	private WebElement tmsStatus;

	@FindBy(xpath = "//input[@title='Business Unit1']")
	private WebElement branchField;

	@FindBy(xpath = "//*[@id='HE0_307']/tbody/tr/td[2]/span/nobr")
	private WebElement catRequested;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//a[@id='CT0_173.2']")
	private WebElement shippmentDetailsTab;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumberField;

	public void catRequestForInbound() throws IOException {
		try {
			System.out.println("Inside InboundConsignmentPage");

			remoteDriver.switchTo().frame(iframe);

			// String orderNo =
			// functionallibraries.FunctionalLibrary.propertiesRead("PoSoNumber");

			orderNumberField.clear();
			branchField.clear();
			// String itemNumber = dataTable.getData("General_Data",
			String itemNumber = getJDEAppProperties("ItemNumber");
			click(shippmentDetailsTab, "shippmentDetailsTab");

			Thread.sleep(2000);
			enterText(itemNumberField, itemNumber, "itemNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");
				String shippmentNum = shippmentNo.getText(); 

				propertiesJdeWrite("ShipmentNumber", shippmentNum);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(tmsStatus, "tmsStatus");
				click(tmsStatus, "tmsStatus");
				Thread.sleep(2000);
				click(catRequested, "catRequested");
				Thread.sleep(3000);
				ExtentUtility.getTest().log(LogStatus.PASS, "cat Requested ForInbound",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			} else {
				System.out.println("Row not found");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No row displayed in InboundConsignmentPag",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} 

			// if(!firstRow.isDisplayed()){
			// System.out.println("Row got processed");
			// closeButton.click();
			//
			// }

			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside InboundConsignmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

}
