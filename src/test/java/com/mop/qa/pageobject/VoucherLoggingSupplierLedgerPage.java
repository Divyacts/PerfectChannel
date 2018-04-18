package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class VoucherLoggingSupplierLedgerPage extends PageBase {

	protected VoucherLoggingSupplierLedgerPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(xpath = "(//input[@title='Batch Number'])[1]")
	private WebElement batchNoField;

	@FindBy(xpath = "//*[@id='G0_11_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(id = "hc_Find")
	private WebElement searchButton;

	@FindBy(id = "ROW_EXIT_BUTTON")
	private WebElement rowExitButton;

	@FindBy(xpath = "//*[@id='HE0_412']/tbody/tr/td[2]/span/nobr")
	private WebElement speedStatGlobal;

	@FindBy(xpath = "//input[@title='Pay Status']")
	private WebElement payStatusField;

	@FindBy(xpath = "//input[@title='Pay StatusCB']")
	private WebElement payStatusCheck;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='HE0_84']/tbody/tr/td[2]/span/nobr")
	private WebElement GLDistribution;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='drop_home']")
	private WebElement homeButton;

	@FindBy(xpath = "//*[@id='G0_11_R0']/td[14]/div")
	private WebElement checkStatus;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//input[@title='Due Date']")
	private WebElement dueDateField;

	@FindBy(xpath = "//input[@title='Due DateCB']")
	private WebElement dueDateCheck;

	@FindBy(xpath = "//input[@title='Payment Instrument']")
	private WebElement paymentField;

	@FindBy(xpath = "//input[@title='Payment InstrumentCB']")
	private WebElement paymentCheck;

	public VoucherLoggingSupplierLedgerPage statusChangePrerequisite()
			throws InterruptedException {
		try {
			System.out.println("Prerequisite for Auto Payment");

			String batchNumber = null;
			// batchNumber=dataTable.getData("General_Data", "Batch Number");
			batchNumber = getJDEAppProperties("BatchNumber");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);
			enterText(batchNoField, batchNumber, "batchNoField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(firstRow, "firstRow");
			click(rowExitButton, "rowExitButton");
			Thread.sleep(2000);
			moveToElement(speedStatGlobal, "speedStatGlobal");
			Thread.sleep(5000);
			enterText(payStatusField, "A", "payStatusField");
			click(payStatusCheck, "payStatusCheck");
			Thread.sleep(1000);
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			enterText(dueDateField, strTodaysDate, "dueDateField");
			click(dueDateCheck, "dueDateCheck");
			Thread.sleep(3000);
			enterText(paymentField, "C", "paymentField");
			click(paymentCheck, "paymentCheck");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

			String newStatus = checkStatus.getText();
			System.out.println(newStatus);
			if (newStatus.equalsIgnoreCase("A")) {
				System.out.println("Status changed successfully");
				ExtentUtility.getTest().log(LogStatus.PASS, "Status Updated Approved status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Status changed failed");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Status Didnt update approved status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
		} catch (Exception ex) {
			System.out
					.println("statusChangePrerequisite in VoucherLoggingSupplierLedgerPage"
							+ ex);
		}

		return new VoucherLoggingSupplierLedgerPage(remoteDriver);

	}

	public GlLedgerPage searchByBatchAndGoToGL() throws  IOException {
		try {
			String batchNumber = getJDEAppProperties("BatchNumber");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);
			enterText(batchNoField, batchNumber, "batchNoField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);
			click(firstRow, "firstRow");
			click(rowExitButton, "rowExitButton");
			Thread.sleep(2000);
			click(GLDistribution, "GLDistribution");
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out
					.println("searchByBatchAndGoToGL in VoucherLoggingSupplierLedgerPage"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "searchByBatchAndGoToGL",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		return new GlLedgerPage(remoteDriver);

	}

	public void checkForPCStatusUpdate(String column) {

		try {
			System.out.println("checkForPCStatusUpdate");
			Thread.sleep(2000);
			String batchNumber = getJDEAppProperties("BatchNumber");
			enterText(batchNoField, batchNumber, "batchNoField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
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
						ExtentUtility.getTest().log(LogStatus.PASS, "PC Status has not been updated in APLedgerPage",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

					}

				}
				WebElement webEle2 = remoteDriver.findElement(By
						.xpath("//*[@id='selectAll0_11']"));
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(webEle2);
				actions.perform();
				System.out.println("Move to first coluimn");

			}
		} catch (Exception ex) {
			System.out.println("checkForPCStatusUpdate" + ex);
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

	public JdeHomePage goToHomepage() throws Exception {
		remoteDriver.switchTo().defaultContent();
		click(homeButton, "homeButton");
		Thread.sleep(2000);
		return new JdeHomePage(remoteDriver);
	}

}
