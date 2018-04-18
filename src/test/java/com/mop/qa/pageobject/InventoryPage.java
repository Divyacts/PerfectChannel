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

public class InventoryPage extends PageBase {

	protected InventoryPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement orderNumberField;

	@FindBy(xpath = "//input[@title='Order Type']")
	private WebElement orderTypeField;

	@FindBy(xpath = "//input[@title='Item Location']")
	private WebElement itemLocationField;

	@FindBy(xpath = "//input[@title='Long Address Number']")
	private WebElement longAddressNumber;

	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement SHSJOutBoundOrderNumber;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//input[@title='To Be Collected By']")
	private WebElement collectby;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='C0_18']")
	private WebElement printPopUpButton;

	@FindBy(xpath = "//img[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectall;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRowPropertyArrival;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div/input")
	private WebElement recieveOption;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[11]/div/input")
	private WebElement location;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='HE0_147']/tbody/tr/td[2]/span/nobr")
	private WebElement printReleaseForm;

	@FindBy(xpath = "//*[@id='HE0_148']/tbody/tr/td[2]/span/nobr")
	private WebElement printSiteTransferNote;

	@FindBy(xpath = "//*[@id='HE0_146']/tbody/tr/td[2]/span/nobr")
	private WebElement printPickList;
	
	TestBase test = new TestBase();

	public void workWithInventoryPage() throws IOException {

		System.out.println("Inside workWithInventoryPage");

		try {

			remoteDriver.switchTo().frame(iframe);
			
			String posoNumber = getJDEAppProperties("PoSoNumber");
			enterText(orderNumberField, posoNumber, "orderNumberField");


			// String
			// orderType=functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			itemLocationField.clear();
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			click(firstRow, "firstRow");
			click(selectButton, "selectButton");
			Thread.sleep(3000);
			
			click(firstRowPropertyArrival, "firstRowPropertyArrival");
			String receiveOpt = getJDEAppProperties("ReceiveOption");
			click(recieveOption, "recieveOption");
			enterText(recieveOption, receiveOpt, "recieveOption");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);

			click(saveButton, "saveButton");
			Thread.sleep(3000);
			click(closeButton, "closeButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With Inventory Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

	public void tempRelCreateOutBoundOrder() throws IOException {

		System.out.println("Inside tempRelCreateOutBoundOrder");

		try {
			remoteDriver.switchTo().frame(iframe);
			click(add, "add");
			Thread.sleep(3000);
			String sendToLoc = rds.getValue("General_Data", test.currentTest, "SendToLocation");
			enterText(longAddressNumber, sendToLoc, "longAddressNumber");

			Thread.sleep(2000);

			enterTableValues(0);
			click(saveButton, "saveButton");
			Thread.sleep(6000);
			String value = remoteDriver.findElement(By.id("C0_17")).getAttribute(
					"value");
			String ShOutbOundNumber = SHSJOutBoundOrderNumber.getText();
			System.out.println("value" + value);
			propertiesJdeWrite("ShOutBoundNumber", value);
			click(saveButton, "saveButton");
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With tempRelCreateOutBoundOrder",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

	public void enterTableValues(int count) throws IOException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add("Item Number");
			list.add("Location");
			list.add("Barcode Number");

			ArrayList<String> list1 = new ArrayList<String>();
			String itemNumber = functionallibraries.FunctionalLibrary
					.propertiesRead("ItemNumber");
			list1.add(itemNumber);
			list1.add("NOT-YET-LOCATED");
			list1.add("40");

			rowCreation(count, list, list1);
			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));
			WebElement element = webEle2.get(0);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);

		} catch (Exception ex) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Work With tempRelCreateOutBoundOrder",
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
		if (colindexcolindexValue.equalsIgnoreCase("22")) {
			remoteDriver.findElement(
					By.xpath("//tr[@id='G0_1_R" + RowCount
							+ "']/td[@colindex='" + colindexcolindexValue
							+ "']/div/input[@class='JSTextfield']")).clear();
		}
	}

	public void printPickListFromSiteTransfer() throws IOException {
		System.out.println("Inside printPickList");

		try {
			remoteDriver.switchTo().frame(iframe);
			String outbSiteOrder = getJDEAppProperties("outbSiteOrder");
			enterText(SHSJOutBoundOrderNumber, outbSiteOrder, "SHSJOutBoundOrderNumber");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(printSiteTransferNote, "printSiteTransferNote");
			Thread.sleep(1000);
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(printSiteTransferNote, "printSiteTransferNote");
			click(printSiteTransferNote, "printSiteTransferNote");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			// selectall.click();
			// Thread.sleep(3000);
			click(rowExit, "rowExit");
			moveToElement(printPickList, "printPickList");
			click(printPickList, "printPickList");									
			Thread.sleep(3000);
			click(printPopUpButton, "printPopUpButton");	
			Thread.sleep(5000);
			click(saveButton, "saveButton");	
			Thread.sleep(5000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside temp releaseOutbound printPickList ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void printPickList() throws IOException {
		System.out.println("Inside printPickList");

		try {
			remoteDriver.switchTo().frame(iframe);
			String ShOutbOundNumber = getJDEAppProperties("ShOutBoundNumber");
			enterText(SHSJOutBoundOrderNumber, ShOutbOundNumber, "SHSJOutBoundOrderNumber");
			Thread.sleep(1000);
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(firstRowPropertyArrival, "firstRowPropertyArrival");
			Thread.sleep(1000);
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(printReleaseForm, "printReleaseForm");
			click(printReleaseForm, "printReleaseForm");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			// selectall.click();
			// Thread.sleep(3000);
			click(rowExit, "rowExit");
			Thread.sleep(2000);
			moveToElement(printPickList, "printPickList");
			click(printPickList, "printPickList");
			Thread.sleep(3000);
			click(printPopUpButton, "printPopUpButton");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside temp releaseOutbound printPickList ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
}
