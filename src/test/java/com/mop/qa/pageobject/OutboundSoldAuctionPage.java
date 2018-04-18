package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


public class OutboundSoldAuctionPage extends PageBase {

	protected OutboundSoldAuctionPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='OrderNumber']")
	private WebElement orderNumberField;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='OrderType']")
	private WebElement orderTypeField;

	@FindBy(xpath = "//input[@title='Business Unit1']")
	private WebElement branchField;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@id='CT0_173.2']")
	private WebElement shippmentDetailsTab;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumberField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div")
	private WebElement shippmentNo;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_306']/span/nobr")
	private WebElement tmsStatus;

	@FindBy(xpath = "//*[@id='HE0_307']/tbody/tr/td[2]/span/nobr")
	private WebElement catRequested;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//*[@id='gtab0_1']")
	private WebElement dropDownGrid;

	public void catRequestForOutbound() throws IOException {
		try {
			System.out.println("Inside OutboundSoldAuctionPage");

			remoteDriver.switchTo().frame(iframe);

			branchField.clear();
			String itemNumber = getJDEAppProperties("SBItemNumber");
			click(shippmentDetailsTab,"shippmentDetailsTab");
			Thread.sleep(2000);
			enterText(itemNumberField, itemNumber, "itemNumberField");
			
			click(searchButton, "searchButton");

			Thread.sleep(2000);
			
			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER"); 

			Thread.sleep(6000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");

				String shippmentNum = shippmentNo.getText();

				propertiesJdeWrite("SBShipmentNumber", shippmentNum);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(tmsStatus, "tmsStatus");
				click(tmsStatus, "tmsStatus");
				Thread.sleep(2000);
				moveToElement(catRequested, "catRequested");
				click(catRequested, "catRequested");
				Thread.sleep(3000);

				System.out.println("Requested Outbound Shippment");

			} else {
				System.out.println("No rows displayed");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside OutboundSoldAuctionPage as no rows displayed",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
			click(closeButton, "closeButton");
			Thread.sleep(3000);

			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside OutboundSoldAuctionPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

}
