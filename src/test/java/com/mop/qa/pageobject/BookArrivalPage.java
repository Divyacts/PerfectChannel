package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class BookArrivalPage extends PageBase {

	protected BookArrivalPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Scan Order Number'])[2]")
	private WebElement orderNumber;

	@FindBy(xpath = "(//*[@title='Scan Barcode'])[2]")
	private WebElement barcode;

	@FindBy(xpath = "//button[contains(text(),'Enter')]")
	private WebElement button;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	public BookArrivalPage arriveItem(ArrayList<String> finalBarcodes,
			ArrayList<String> poSoForArrival, String stNo)
			throws InterruptedException, IOException {
		try {
			// String
			// orderNumb=functionallibraries.FunctionalLibrary.propertiesRead("OrderNumber");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);
			/*
			 * for(int i=0;i<finalmap.size();i++){ barc = finalmap.get(stNo); }
			 */
			System.out.println("stNo" + stNo);
			for (int j = 0; j < finalBarcodes.size(); j++) {
				Thread.sleep(3000);
				String barVal = finalBarcodes.get(j);
				System.out.println("barVal" + barVal);
				enterText(orderNumber, poSoForArrival.get(j), "orderNumber");
				Thread.sleep(2000);
				click(button, "button");
				Thread.sleep(5000);
				// String
				// barCode=functionallibraries.FunctionalLibrary.propertiesRead("Barcode1");
				enterText(barcode, barVal, "barcode");
				Thread.sleep(2000);
				click(button, "button");
				Thread.sleep(5000);
				click(cancelButton, "cancelButton");
				Thread.sleep(3000);
				// save.click();
				// Thread.sleep(3000);
			}
		} catch (Exception ex) {
			System.out.println("arriveItem BookArrivalPage" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside BookArrivalPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new BookArrivalPage(remoteDriver);
	}

	public BookArrivalPage arriveInventoryItem(String orderNumb)
			throws InterruptedException, IOException {
		try {
			String ohNumber = functionallibraries.FunctionalLibrary
					.propertiesRead("ohNumber");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(3000);
			enterText(orderNumber, orderNumb, "orderNumber");
			Thread.sleep(2000);
			click(button, "button");
			Thread.sleep(5000);
			String barcoe = getJDEAppProperties("barcode");
			enterText(barcode, barcoe, "barcode");
			Thread.sleep(2000);
			click(button, "button");
			Thread.sleep(5000);
			click(cancelButton, "cancelButton");
			Thread.sleep(3000);
			// save.click();
			// Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("arriveItem BookArrivalPage" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside BookArrivalPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new BookArrivalPage(remoteDriver);
	}

	public void closeScreen() throws Exception {
		remoteDriver.switchTo().frame(iframe);
		click(cancelButton, "cancelButton");
		Thread.sleep(3000);
	}

}
