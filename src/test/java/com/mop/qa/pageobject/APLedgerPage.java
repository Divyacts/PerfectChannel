package com.mop.qa.pageobject;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


public class APLedgerPage extends PageBase {

	protected APLedgerPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='All']")
	private WebElement allOption;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//nobr[contains(text(),'Approval Review')]")
	private WebElement appReview;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//*[@id='selectAll0_11']")
	private WebElement selectAll;

	@FindBy(xpath = "//*[@id='HE0_412']/tbody/tr/td[2]/span/nobr")
	private WebElement speedStatGlobal;

	@FindBy(xpath = "//input[@title='Pay Status']")
	private WebElement payStatusField;

	@FindBy(xpath = "//input[@title='Pay StatusCB']")
	private WebElement payStatusCheck;

	@FindBy(xpath = "//input[@title='Due Date']")
	private WebElement dueDateField;

	@FindBy(xpath = "//input[@title='Due DateCB']")
	private WebElement dueDateCheck;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement batchesFirstRow;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//*[@id='HE0_84']/tbody/tr/td[2]/span/nobr")
	private WebElement GLDistribution;

	public APLedgerPage searchBatchNumberForSale() throws IOException {
		try {
			System.out.println("getBatchNumberForSale");

			remoteDriver.switchTo().frame(iframe);
			click(allOption, "allOption");
			allOption.click();
			String colindexcolindexValue = null;
			for (int i = 0; i < gridList.size(); i++) {
				WebElement element = gridList.get(i);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				if (element.getText().replace("\n", " ")
						.equalsIgnoreCase("Sale Number")) {
					colindexcolindexValue = element.getAttribute("colindex");
					System.out.println(colindexcolindexValue);
					break;
				}
			}
			remoteDriver.findElement(
					By.xpath("//*[@id='qbeRow0_11']/td[@colindex ='"
							+ colindexcolindexValue + "']/div/nobr/input"))
					.click();
			String SaleNum = functionallibraries.FunctionalLibrary
					.propertiesRead("SaleNumber");
			remoteDriver.findElement(
					By.xpath("//*[@id='qbeRow0_11']/td[@colindex ='"
							+ colindexcolindexValue + "']/div/nobr/input"))
					.sendKeys(SaleNum);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("searchBatchNumberForSale" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside searchBatchNumberForSale APLedgerPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new APLedgerPage(remoteDriver);

	}

	public GlLedgerPage getGlledgerValues() throws IOException {
		try {
			click(batchesFirstRow, "batchesFirstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			click(GLDistribution, "GLDistribution");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside getGlledgerValues",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new GlLedgerPage(remoteDriver);
	}

	public void updatePayStatusAndValidate() throws IOException {
		try {
			System.out.println("updatePayStatusAndValidate");
			Thread.sleep(2000);
			click(selectAll, "selectAll");
			click(rowExit, "rowExit");
			Thread.sleep(1000);
			moveToElement(speedStatGlobal, "speedStatGlobal");
			click(speedStatGlobal, "speedStatGlobal");
			Thread.sleep(5000);
			enterText(payStatusField, "A", "payStatusField");
			click(payStatusCheck, "payStatusCheck");
			Thread.sleep(1000);
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(payStatusCheck, strTodaysDate, "payStatusCheck");
			Thread.sleep(1000);
			click(dueDateCheck, "dueDateCheck");
			Thread.sleep(1000);
			click(saveButton, "saveButton");

		} catch (Exception ex) {
			System.out.println("updatePayStatusAndValidate" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside updatePayStatusAndValidate APLedgerPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void checkForPCStatusUpdate(String column) throws IOException {

		try {
			System.out.println("checkForPCStatusUpdate");
			boolean nextButton = IsTestElementPresent();
			if (nextButton) {
				click(lastArrow, "lastArrow");
			}
			Thread.sleep(5000);
			String row = rows.getText();
			ArrayList<String> list = new ArrayList<>();
			String[] values = row.split("-");
			for (String str : values) {
				list.add(str.trim());
				System.out.println("list" + list);
			}
			int rowCnt = Integer.parseInt(list.get(1));
			System.out.println("rowCnt" + rowCnt);
			ArrayList<String> pcStatus = new ArrayList<String>();
			for (int i = 0; i < rowCnt - 1; i++) {
				String Val = getValues(column, i);
				pcStatus.add(Val);
				if (column.equalsIgnoreCase("P C")) {
					if (pcStatus.get(i).equalsIgnoreCase("D")) {
						ExtentUtility.getTest().log(LogStatus.PASS, "PC Status has been Succesfully Updated to D in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

					} else {
						ExtentUtility.getTest().log(LogStatus.FAIL, "PC Status has not been updated to D in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					}
				} else if (column.equalsIgnoreCase("Pay Stat")) {
					if (pcStatus.get(i).equalsIgnoreCase("#")) {
						ExtentUtility.getTest().log(LogStatus.PASS, "Pay Stat is Updated to # in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					} else if (pcStatus.get(i).equalsIgnoreCase("A")) {
						ExtentUtility.getTest().log(LogStatus.PASS, "Pay Stat is Updated to # in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					} else {
						ExtentUtility.getTest().log(LogStatus.FAIL, "Pay Stat Not updated to # in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					}
				}

			}
			WebElement webEle2 = remoteDriver.findElement(By
					.xpath("//*[@id='selectAll0_11']"));
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(webEle2);
			actions.perform();
			System.out.println("Move to first coluimn");

		} catch (Exception ex) {
			System.out.println("checkForPCStatusUpdate" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside checkForPCStatusUpdate APLedgerPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public ArrayList<String> getBatchNumberForSale(ArrayList<String> batchNumber) throws IOException {

		try {
			System.out.println("getBatchNumberForSale");
			boolean nextButton = IsTestElementPresent();
			if (nextButton) {
				click(lastArrow, "lastArrow");
				lastArrow.click();
			}
			Thread.sleep(5000);
			String row = rows.getText();
			ArrayList<String> list = new ArrayList<>();
			String[] values = row.split("-");
			for (String str : values) {
				list.add(str.trim());
				System.out.println("list" + list);
			}
			int rowCnt = Integer.parseInt(list.get(1));
			System.out.println("rowCnt" + rowCnt);

			for (int i = 0; i < rowCnt - 1; i++) {
				String Val = getValues("Batch Number", i);
				System.out.println("Val" + Val);
				if (!Val.equals("")) {
					batchNumber.add(Val);
				}

			}
			batchNumber.removeAll(Collections.singleton(null));
			batchNumber.removeAll(Collections.singleton(" "));

			System.out.println("batchNumber removed null" + batchNumber);
			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(batchNumber);
			System.out.println("batchNumberbeforehas" + batchNumber);

			batchNumber.clear();
			batchNumber.addAll(lhs);
			System.out.println("batchNumber" + batchNumber);

		} catch (Exception ex) {
			System.out.println("getBatchNumberForSale" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside getBatchNumberForSale APLedgerPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return batchNumber;
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
		rowValue = remoteDriver.findElement(
				By.xpath("//tr[@id='G0_11_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		return rowValue;
	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
