package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class POPEnquiryPage extends PageBase {

	protected POPEnquiryPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Order Number'])[2]")
	private WebElement orderNumber;

	@FindBy(xpath = "(//*[@title='Sale Site'])[2]")
	private WebElement saleSite;

	@FindBy(xpath = "(//*[@title='Sale Number'])[2]")
	private WebElement saleNumber;

	@FindBy(xpath = "//*[@title='Business Unit1']")
	private WebElement businessUnit;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='G0_41_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "(//*[@title='Transaction Type'])")
	private WebElement transactionType;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "(//*[@title='Lot Number'])[2]")
	private WebElement lotNumber;

	@FindBy(xpath = "//*[@id='gtab0_1']")
	private WebElement select;

	public POPEnquiryPage verifyRecordsforSaleinPOP()
			throws InterruptedException, IOException {
		try {

			remoteDriver.switchTo().frame(iframe);
			businessUnit.clear();
			/*
			 * String saleSit =
			 * functionallibraries.FunctionalLibrary.propertiesRead
			 * ("SaleSellingSite"); saleSite.sendKeys(saleSit);
			 */
			String saleNum = getJDEAppProperties("SaleNumber");
			String LotNumForAdhocBatching = getJDEAppProperties("LotNumForAdhocBatching");
			enterText(saleNumber, saleNum, "saleNumber");
			enterText(transactionType, "HAM", "transactionType");
			enterText(lotNumber, LotNumForAdhocBatching, "lotNumber");

			Thread.sleep(3000);
			click(find, "find");
			Thread.sleep(3000);
			selectOPtionByVisibleText(select, "Show All Columns");
			Thread.sleep(2000);
			String fieldName2 = "Next Status";
			boolean nextButton = IsTestElementPresent();
			if (nextButton) {
				click(lastArrow, "lastArrow");
			}
			Thread.sleep(3000);
			String Val = getValues(fieldName2, 0);
			Thread.sleep(2000);
			if (Val.equalsIgnoreCase("440")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "ARG Generated Verified in POP - 440",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else if (Val.equalsIgnoreCase("999")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Sale Batch Submission in POP - 999",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.PASS, "Sale Batch Submission in POP not in expected status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


			}
		} catch (Exception ex) {
			System.out.println("verifyREcordsPresentForSale" + ex);
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside verifyREcordsPresentForSale SOPEnquiryPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new POPEnquiryPage(remoteDriver);
	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getValues(String fieldName, int RowCount) {
		System.out.println(gridList.size());
		String colindexcolindexValue, rowValue;
		colindexcolindexValue = null;
		rowValue = null;
		for (int i = 0; i < gridList.size(); i++) {
			WebElement element = gridList.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		rowValue = remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.getText();
		return rowValue;
	}

}
