package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import supportlibraries.ScriptHelper;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class OrderInquiryChargePage extends PageBase {

	protected OrderInquiryChargePage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "(//*[@title='Order Number'])[2]")
	private WebElement orderNumber;

	@FindBy(xpath = "(//*[@title='Sale Site'])[2]")
	private WebElement saleSite;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='G0_41_R0']/td[1]/div/input")
	private WebElement firstRow;

	// @FindBy(xpath = "(//*[@title='Order Number'])[1]")
	// private WebElement orderNumberField;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[17]/div")
	private WebElement statusRow1;

	@FindBy(xpath = "//*[@id='qbeRow0_1']/td[2]/div/nobr/input")
	private WebElement orderNumberField;

	@FindBy(xpath = "//*[@title='Business Unit1']")
	private WebElement businessUnitField;

	@FindBy(id = "hc_Find")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement checkBox;

	@FindBy(xpath = "//table[@id='jdeGridData0_1']/tbody/tr")
	private List<WebElement> rowcnt;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement select;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='jdeGridData0_1']/tbody/tr")
	private WebElement tableGrid;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//*[@id='HE0_290']/tbody/tr/td[2]/span/nobr")
	private WebElement prinPO;

	@FindBy(xpath = "//td[@class='JSSelectHeader']")
	private WebElement checkBoxHeader;

	@FindBy(xpath = "//*[@id='drop_home']")
	private WebElement homeButton;

	@FindBy(xpath = "//div[contains(text(),'Order Processing')]")
	private WebElement breadCrum;

	@FindBy(xpath = "//div[contains(text(),'Purchase to Pay')]")
	private WebElement brpurchaseToPay;

	int cnt;
	
	TestBase test = new TestBase();

	public void orderInquiry() {
		try {
			System.out.println("Order Inquiry Charge Page");

			remoteDriver.switchTo().frame(iframe);
			enterText(businessUnitField, "*", "businessUnitField");
			String orderNum = getJDEAppProperties("PurchaseOrderNumber");
			enterText(orderNumberField, orderNum, "orderNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(5000);
			// get new order number
			String[] values;
			values = new String[5];

			String parameter[] = { "Supplier Number", "Amount To Receive",
					"Last Status", "Next Status" };
/*
			for (int p = 0; p < parameter.length; p++) {
				values[p] = getValues(parameter[p], 0);
				System.out.println(values[p]);
				dataTable.putData("General_Data", parameter[p], values[p]);
			}*/
			
			
			String supplierNumber = rds.getValue("P2P", test.currentTest, "Supplier Number");
		    propertiesJdeWrite("SupplierNumber", supplierNumber);
		    String price = rds.getValue("P2P", test.currentTest, "Amount To Receive");
		    propertiesJdeWrite("Price", price);

		} catch (Exception ex) {
			System.out.println("Inside Voucher Logging" + ex);

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
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		return rowValue;

	}

	public OrderInquiryChargePage searchPOOrder() throws InterruptedException {
		try {

			remoteDriver.switchTo().frame(iframe);
			moveToElement(businessUnitField, "businessUnitField");
			businessUnitField.clear();
			Thread.sleep(3000);
			String orderNumber = getJDEAppProperties("PurchaseOrderNumber");
			enterText(orderNumberField, orderNumber, "orderNumberField");
			Thread.sleep(3000);
			click(searchButton, "searchButton");
		} catch (Exception ex) {
			System.out.println("searchPOOrder " + ex);

		}
		return new OrderInquiryChargePage(remoteDriver);
	}

	public PrinterSelectionPage printPoOrder() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(3000);
			click(checkBox, "checkBox");
			Thread.sleep(2000);
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(prinPO, "prinPO");
			Thread.sleep(7000);
			ExtentUtility.getTest().log(LogStatus.PASS, "PO Order printed Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			
		} catch (Exception ex) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in print PO Order",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new PrinterSelectionPage(remoteDriver);
	}

	public PrinterSelectionPage printPoOrderFrame() throws InterruptedException {
		try {
			Thread.sleep(5000);
			// driver.switchTo().frame(iframe);
			// Thread.sleep(3000);
			click(checkBox, "checkBox");
			Thread.sleep(2000);
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(prinPO, "prinPO");
			Thread.sleep(7000);
		} catch (Exception ex) {
			System.out.println("printPoOrder " + ex);

		}
		return new PrinterSelectionPage(remoteDriver);
	}

	public OrderInquiryChargePage searchAndAmend() throws InterruptedException {
		try {
			remoteDriver.switchTo().frame(iframe);
			moveToElement(businessUnitField, "businessUnitField");
			businessUnitField.clear();
			Thread.sleep(3000);
			String orderNumber = getJDEAppProperties("OrderNumber");
			enterText(orderNumberField, orderNumber, "orderNumberField");
			Thread.sleep(3000);
			click(searchButton, "searchButton");

			Thread.sleep(3000);
			click(checkBox, "checkBox");
			click(select, "select");
			cnt = amendment();
			Thread.sleep(1000);
			click(save, "save");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			System.out.println("rowcnt2222.getSize();" + rowcnt.size());
			int rowCnt2 = rowcnt.size();
			matchRowCnt(cnt, rowCnt2);
		} catch (Exception ex) {
			System.out.println("Inside Order Inquiry" + ex);

		}
		return new OrderInquiryChargePage(remoteDriver);
	}

	public void matchRowCnt(int cnt, int rowCnt2) throws IOException {
		if (cnt - 1 == rowCnt2) {
			ExtentUtility.getTest().log(LogStatus.PASS, "Click on Element " + rowCnt2 + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

	public int amendment() throws InterruptedException {
		Thread.sleep(5000);

		System.out.println("inside Amendment");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Item Number");
		list.add("Quantity Ordered");
		list.add("Unit Cost");

		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("RES");
		list1.add("1");
		list1.add("1000");

		for (int k = 1; k <= 1; k++) {
			System.out.println(k);
			cnt = rowCreation(k, list, list1);
			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));
			WebElement element = webEle2.get(0);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
		}
		return cnt;
	}

	public int rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element3 = remoteDriver.findElement(By.xpath("//*[@id='G0_1_R"
				+ (count - 1) + "']/td[6]/div/input"));
		Actions actions1 = new Actions(remoteDriver);
		actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
		for (int j = 0; j < list.size(); j++) {
			cnt = enterValues(list.get(j), count, list1.get(j));
		}
		return cnt;

	}

	public int enterValues(String fieldName, int RowCount, String list1) {
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
		System.out.println("rowcnt1111.getSize();" + rowcnt.size());
		int rowCnt1 = rowcnt.size();
		return rowCnt1;
	}

	public String returnStatus() {
		String status1 = null;
		Actions actions = null;
		try {

			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));

			System.out.println(webEle2.size());
			String colindexcolindexValue;
			colindexcolindexValue = null;
			for (int i = 0; i < webEle2.size(); i++) {
				WebElement element = webEle2.get(i);
				actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				System.out.println("element" + element.getText());
				if (element.getText().replace("\n", " ")
						.equalsIgnoreCase("Next Status")) {
					colindexcolindexValue = element.getAttribute("colindex");
					System.out.println(colindexcolindexValue);
					break;
				}
			}
			status1 = remoteDriver.findElement(
					By.xpath("//tr[@id='G0_1_R0']/td[@colindex='"
							+ colindexcolindexValue + "']/div")).getText();
			System.out.println("status1" + status1);
			functionallibraries.FunctionalLibrary.captureScreenShot(
					"TC4 Scenario 1", remoteDriver);
			Thread.sleep(5000);
			actions = new Actions(remoteDriver);
			actions.moveToElement(checkBoxHeader).build().perform();
			// actions.perform();
			Thread.sleep(5000);
			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Inside Order Inquiry" + ex);

		}
		return status1;
	}

	public OrderApprovalPage gotoApprovalPage() throws Exception {
		remoteDriver.switchTo().defaultContent();
		remoteDriver.switchTo().parentFrame();
		Thread.sleep(5000);
		moveToElement(breadCrum, "breadCrum");
		Actions action = new Actions(remoteDriver);
		// breadCrum.click();
		Thread.sleep(5000);
		action.moveToElement(
				remoteDriver.findElement(By
						.xpath("(//a[contains(text(),'Orders') and contains(text(),'Awaiting') and contains(text(),'Approval')])[3]")))
				.click().build().perform();
		return new OrderApprovalPage(remoteDriver);
	}

	public JdeHomePage goToHomepage() throws Exception {
		remoteDriver.switchTo().defaultContent();
		click(homeButton, "homeButton");
		Thread.sleep(2000);
		return new JdeHomePage(remoteDriver);
	}

	public void checkApprovalStatus(int cnt, int rowCnt2) throws IOException {
		if (cnt - 1 == rowCnt2) {
			ExtentUtility.getTest().log(LogStatus.PASS, "Rown count matches " + rowCnt2 + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		
		}

	}

}
