package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class PurchaseOrderEntryPage extends PageBase {

	protected PurchaseOrderEntryPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Add']")
	private WebElement addButton;

	@FindBy(xpath = "//input[@title='Business Unit']")
	private WebElement brnachPlant;

	@FindBy(xpath = "//input[@title='Supplier']")
	private WebElement supplierNoField;

	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement orderNum;

	@FindBy(xpath = "//input[@title='Invoice Date']")
	private WebElement invoiceDateField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[4]/div/input")
	private WebElement grossAmnt;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement search;

	@FindBy(xpath = "//input[@title='Currency Code']")
	private WebElement currencyField;

	@FindBy(xpath = "//input[@title='G/L Date']")
	private WebElement glDateField;

	@FindBy(xpath = "//input[@title='Approver']")
	private WebElement approverField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[4]/div/input")
	private WebElement priceField;

	@FindBy(xpath = "//*[@id='G0_1_R1']/td[4]/div/input")
	private WebElement nextPriceField;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@title='Batch No']")
	private WebElement batchNoField;

	@FindBy(xpath = "//input[@title='Prev Doc']")
	private WebElement prevDocField;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "(//input[@title='Batch Number'])[1]")
	private WebElement batchNumber;

	@FindBy(xpath = "//*[@id='G0_11_R0']/td[1]/div")
	private WebElement rowAfterSelect;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement warning;
	
	TestBase test = new TestBase();

	public PurchaseOrderEntryPage createPurOrderEntry() throws IOException {
		try {
			System.out.println("Inside createPurOrderEntry");

			String supplierNumber = null, cost = null, invoiceNo = null, currency = null;

			remoteDriver.switchTo().frame(iframe);
			String deptID = rds.getValue("General_Data", test.currentTest, "Department");
			enterText(brnachPlant, deptID,"brnachPlant");

			Thread.sleep(2000);

			click(addButton, "addButton");
			Thread.sleep(3000);

			supplierNumber = getJDEAppProperties("SupplierNumber");
			enterText(supplierNoField, supplierNumber, "supplierNoField");

			Thread.sleep(2000);
			enterTableValues(0);

			click(saveButton, "saveButton");
			Thread.sleep(2000);

			String purchaseOrderNum = orderNum.getAttribute("value");
			System.out.println("purchaseOrderNum" + purchaseOrderNum);
			propertiesJdeWrite("PurchaseOrderNumber", purchaseOrderNum);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			click(cancelButton, "cancelButton");
			// driver.switchTo().defaultContent();

		}

		catch (Exception ex) {
			System.out.println(" Inside createPurOrderEntry Page" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside createPurOrderEntry Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new PurchaseOrderEntryPage(remoteDriver);

	}

	public PurchaseOrderEntryPage verifyPurchaseORdeCreated() throws IOException {
		try {
			System.out.println("Inside verifyPurchaseORdeCreated");
			// driver.switchTo().frame(iframe);
			Thread.sleep(4000);
			String deptID = rds.getValue("General_Data",test.currentTest,"Department");
			enterText(brnachPlant, deptID, "brnachPlant");

			Thread.sleep(2000);
			String purchaseORder = getJDEAppProperties("PurchaseOrderNumber");
			enterText(orderNum, purchaseORder, "orderNum");
			click(search, "search");
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.PASS, "PurchaseORdeCreated Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(" Inside createPurOrderEntry Page" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside createPurOrderEntry Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new PurchaseOrderEntryPage(remoteDriver);

	}

	public void enterTableValues(int count) throws IOException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add("Item Number");
			list.add("Extended Cost");
			// list.add("Value");
			String Price = functionallibraries.FunctionalLibrary
					.propertiesRead("Price");

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add("RES");
			list1.add(Price);

			rowCreation(count, list, list1);
			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));
			WebElement element = webEle2.get(0);
			moveToElement(element, "element");

		} catch (Exception ex) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in entering table values in SellerAgreementDetailsPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws InterruptedException {
		Thread.sleep(3000);
		for (int j = 0; j < list.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
		}

	}

	public void enterValues(String fieldName, int RowCount, String list1) {
		List<WebElement> webEle2 = remoteDriver.findElements(By
				.className("JSGridHeaderCell"));
		System.out.println(webEle2.size());
		String colindexcolindexValue;
		colindexcolindexValue = null;
		for (int i = 0; i < webEle2.size(); i++) {
			// System.out.println( webEle2.get(i).getText());

			WebElement element = webEle2.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			System.out.println("element" + element.getText());
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).click();
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).clear();
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).sendKeys(
				list1.trim());
	}

	public PurchaseOrderEntryPage checkPayStatus() throws InterruptedException, IOException {
		try {
			System.out.println("checkPayStatus");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);
			System.out.println("afte switching iframe");
			String batchNo = getJDEAppProperties("BatchNumber");
			System.out.println("afte propertiesRead");
			Thread.sleep(2000);
			enterText(batchNumber, batchNo, "batchNumber");
			click(search, "search");
			Thread.sleep(2000);

			if (rowAfterSelect.isDisplayed()) {
				String fieldname = "Pay Stat";
				String finalStatus = getValues(fieldname, 0);

				if (finalStatus.equalsIgnoreCase("#")) {
					ExtentUtility.getTest().log(LogStatus.PASS, "Payment Status is # Proceed to Complete Payment",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				} else if (finalStatus.equalsIgnoreCase("P")) {
					ExtentUtility.getTest().log(LogStatus.PASS, "Payment Process has been successfully completed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
			}
		}

		catch (Exception ex) {
			System.out.println(" Inside Voucher Screen Page" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside VoucherScreen Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new PurchaseOrderEntryPage(remoteDriver);

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
				By.xpath("//tr[@id='qbeRow" + RowCount + "_11']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		return rowValue;

	}

	public String generatePIN() {
		int x = (int) (Math.random() * 9);
		x = x + 1;
		String randomPIN = (x + "") + (((int) (Math.random() * 1000)) + "");
		return randomPIN;
	}

}
