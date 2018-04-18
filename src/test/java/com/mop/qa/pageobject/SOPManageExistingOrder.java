package com.mop.qa.pageobject;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class SOPManageExistingOrder extends PageBase {

	protected SOPManageExistingOrder(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	// @FindBy(xpath = "(//input[@title='Order Number'])[1]")
	// private WebElement orderNumberField;

	@FindBy(xpath = "(//input[@title='Sale Site'])[1]")
	private WebElement saleSiteField;

	@FindBy(xpath = "(//input[@title='Transaction Type'])[1]")
	private WebElement transactionTypeField;
	//
	@FindBy(xpath = "(//input[@title='Sale Number'])[1]")
	private WebElement saleNumberField;

	@FindBy(xpath = "(//input[@title='Lot Number'])[2]")
	private WebElement lotNumberField;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "(//a[@title='Refresh'])[2]")
	private WebElement refreshButton;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_41_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//img[@id='FORM_EXIT_BUTTON']")
	private WebElement formExitBtn;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_612']/span/nobr")
	private WebElement christiesRow;

	@FindBy(xpath = "//*[@id='HE0_689']/tbody/tr/td[2]/span/nobr")
	private WebElement printREcollection;

	@FindBy(xpath = "//input[@title='CollectedBy_Edit']")
	private WebElement collectedByField;

	@FindBy(xpath = "//input[@title='CollectedByNotes']")
	private WebElement collectedByNotesField;

	@FindBy(xpath = "//td[contains(text(),'View Job Status')]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement submittedJobs;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToPrint;

	@FindBy(xpath = "//*[@id='HE0_630']/tbody/tr/td[2]/span/nobr")
	private WebElement deCollect;

	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement orderNumberField;

	@FindBy(xpath = "//input[@title='Or Ty']")
	private WebElement ordertypeField;

	@FindBy(xpath = "//input[@title='Sale Site']")
	private WebElement saleSiteTableField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRowDecollection;

	@FindBy(xpath = "//*[@id='HE0_64']/tbody/tr/td[2]/span/nobr")
	private WebElement selectedRowExit;

	@FindBy(xpath = "(//input[@title='Order Number'])[1]")
	private WebElement getOrderNumber;

	@FindBy(xpath = "(//input[@title='Order Type'])[1]")
	private WebElement getOrderType;

	@FindBy(xpath = "//*[@id='HE0_633']/tbody/tr/td[2]/span/nobr")
	private WebElement printDeCollection;

	public void getNextStatus() throws IOException {

		System.out.println("Inside WorkWithShipmentPage getNextStatus");

		try {

			remoteDriver.switchTo().frame(iframe);

			// String saleSite=dataTable.getData("General_Data", "SaleNumber");
			String saleSite = getCollectDeColelctProperties("SaleNumber");
			saleSiteField.clear();
			Thread.sleep(1000);
			
			enterText(saleNumberField, saleSite, "saleNumberField");


			// String transactnType=dataTable.getData("General_Data",
			// "TransactionType");
			
			String transactnType = getCollectDeColelctProperties("TransactionType");

			enterText(transactionTypeField, transactnType, "transactionTypeField");
			Thread.sleep(1000);

			// String lotNo=dataTable.getData("General_Data", "LotNumber");
			String lotNo = getCollectDeColelctProperties("LotNumber");
			
			enterText(lotNumberField, lotNo, "lotNumberField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);

			String fieldName = "Next Status";
			String status = getValues(fieldName, 0);
			// dataTable.putData("General_Data", "NextStatus", status);
			propertiesCollectDeCWrite("NextStatus",status);

			System.out.println("status" + status);
			Thread.sleep(2000);

			String fieldName2 = "Charge Item  Number";
			String chargeNo = getValuesForOrderNumber(fieldName2, 0);
			System.out.println("chargeNo" + chargeNo);
			Thread.sleep(2000);
			
			// dataTable.putData("General_Data", "ChargeItemNo", chargeNo);
			propertiesCollectDeCWrite("ChargeItemNo",chargeNo);

			Thread.sleep(2000);
			click(closeButton, "closeButton");
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

	public void getChargeItemNumber() throws IOException {

		System.out.println("Inside WorkWithShipmentPage getChargeItemNumber");

		try {

			remoteDriver.switchTo().frame(iframe);

			// String saleSite=dataTable.getData("General_Data", "SaleNumber");
			String saleSite = getCollectDeColelctProperties("SaleNumber");

			saleSiteField.clear();
			Thread.sleep(1000);
			
			enterText(saleNumberField, saleSite, "saleNumberField");

			// String transactnType=dataTable.getData("General_Data",
			// "TransactionType");
			String transactnType = getCollectDeColelctProperties("TransactionType");
			
			Thread.sleep(1000);
			enterText(transactionTypeField, transactnType, "transactionTypeField");

			click(searchButton, "searchButton");
			Thread.sleep(2000);

			String fieldName2 = "Charge Item  Number";
			String chargeNo = getValuesForOrderNumber(fieldName2, 0);
			System.out.println("chargeNo" + chargeNo);
			Thread.sleep(2000);

			// dataTable.putData("General_Data", "ChargeItemNo", chargeNo);
			propertiesCollectDeCWrite("ChargeItemNo",chargeNo);

			Thread.sleep(2000);

			closeButton.click();
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}
	
	
	public void validateStatus() throws IOException{
		String status = getCollectDeColelctProperties("NextStatus");
		if (status.equalsIgnoreCase("640")) {
			System.out.println("Status update successful");
			ExtentUtility.getTest().log(LogStatus.PASS, "Successfully updatec",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} else {
			System.out.println("Status update failed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Update failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		
	}

	public void workWithSOPpage() throws IOException {

		System.out.println("Inside workWithSOPpage");
		try {

			remoteDriver.switchTo().frame(iframe);

			Actions actions = new Actions(remoteDriver);

			// String saleSite=dataTable.getData("General_Data", "SaleNumber");
			String saleSite = getCollectDeColelctProperties("SaleNumber");

			saleSiteField.clear();
			Thread.sleep(1000);

			enterText(saleNumberField, saleSite, "saleNumberField");


			// String transactnType=dataTable.getData("General_Data",
			// "TransactionType");
			String transactnType = getCollectDeColelctProperties("TransactionType");
	
			enterText(transactionTypeField, transactnType, "transactionTypeField");

			Thread.sleep(1000);

			String lotNo = getCollectDeColelctProperties("LotNumber");
			enterText(lotNumberField, lotNo, "lotNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			// String status=dataTable.getData("General_Data", "NextStatus");
			String status = getJDEAppProperties("NextStatus");


			if (status.equalsIgnoreCase("621")) {
				click(firstRow, "firstRow");
				Thread.sleep(2000);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(christiesRow, "christiesRow");
				click(christiesRow, "christiesRow");
				Thread.sleep(3000);
				moveToElement(printREcollection, "printREcollection");
				click(printREcollection, "printREcollection");
				Thread.sleep(3000);

				enterText(collectedByField, "CLI", "collectedByField");
				Thread.sleep(2000);
				enterText(collectedByNotesField, "For Testing purpose", "collectedByNotesField");
				Thread.sleep(2000);

				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(5000);

				remoteDriver.switchTo().defaultContent();
				Thread.sleep(2000);

				click(viewJobStatus, "viewJobStatus");
				Thread.sleep(3000);
				remoteDriver.switchTo().frame(iframe);

				click(submittedJobs, "submittedJobs");
				Thread.sleep(2000);
				enterText(submittedJobs, "R5842002*", "submittedJobs");
				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(3000);
				click(linkToPrint, "linkToPrint");
				Thread.sleep(3000);
				click(closeButton, "closeButton");
				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(3000);

				String fieldName1 = "Next Status";
				String newStatus = getValues(fieldName1, 0);
				System.out.println("newStatus" + newStatus);
				Thread.sleep(2000);

				if (newStatus.equalsIgnoreCase("630")) {
					System.out
							.println("Status update successful from 621 to 630");
					ExtentUtility.getTest().log(LogStatus.PASS, "Status update successful from 621 to 630",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


					remoteDriver.switchTo().defaultContent();
					Thread.sleep(2000);
					click(viewJobStatus, "viewJobStatus");
					Thread.sleep(3000);
					remoteDriver.switchTo().frame(iframe);
					click(submittedJobs, "submittedJobs");
					Thread.sleep(2000);
					enterText(submittedJobs, "R5842002*", "submittedJobs");

					Thread.sleep(2000);
					click(searchButton, "searchButton");
					Thread.sleep(3000);
					click(linkToPrint, "linkToPrint");
					Thread.sleep(3000);
					click(closeButton, "closeButton");
					Thread.sleep(2000);
					click(searchButton, "searchButton");
					Thread.sleep(3000);

					String fieldName3 = "Pick Number";
					String pickNo = getValues(fieldName3, 0);
					System.out.println("pickNo" + pickNo);
					Thread.sleep(2000);
					// dataTable.putData("General_Data", "PickNumber", pickNo);
					propertiesCollectDeCWrite("PickNumber", pickNo);
					System.out.println("Collection Order Form is downloaded");
					ExtentUtility.getTest().log(LogStatus.PASS, "Successfully downloaded Collection Order Form",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				} else {
					System.out.println("Status update fail from 621 to 630");
					ExtentUtility.getTest().log(LogStatus.PASS, "Status update fail from 621 to 630",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				}

			} else {
				System.out.println("Status is not 621,cannot proceed");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to proceed since status is not 621",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

			Thread.sleep(2000);
			click(closeButton, "closeButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();

		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithSOPpage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
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
				By.xpath("//tr[@id='G0_41_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		return rowValue;

	}

	public String getValuesForOrderNumber(String fieldName, int RowCount) {
		System.out.println(gridList.size());
		String colindexcolindexValue, rowValue;
		colindexcolindexValue = null;
		rowValue = null;
		for (int i = 0; i < gridList.size(); i++) {
			WebElement element = gridList.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			if (element.getText().replace("\n", "  ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		rowValue = remoteDriver.findElement(
				By.xpath("//tr[@id='G0_41_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		return rowValue;

	}

	public void workforDecollection() throws IOException {

		System.out.println("Inside WorkWithShipmentPage workforDecollection");
		try {

			remoteDriver.switchTo().frame(iframe);

			Actions actions = new Actions(remoteDriver);

			// String saleSite=dataTable.getData("General_Data", "SaleNumber");
			String saleSite = getCollectDeColelctProperties("SaleNumber");

			saleSiteField.clear();
			Thread.sleep(1000);
			
			enterText(saleNumberField, saleSite, "saleNumberField");


			// String transactnType=dataTable.getData("General_Data",
			// "TransactionType");
			String transactnType = getCollectDeColelctProperties("TransactionType");
			enterText(transactionTypeField, transactnType, "transactionTypeField");
			String lotNo = getCollectDeColelctProperties("LotNumber");
			enterText(lotNumberField, lotNo, "lotNumberField");

			click(searchButton, "searchButton");
			Thread.sleep(2000);

			String fieldName = "Order Type";
			String orderTyp = getValues(fieldName, 0);
			// dataTable.putData("General_Data", "OrderType", orderTyp);
			propertiesCollectDeCWrite("OrderType", orderTyp);
			String fieldName1 = "Order Number";
			String orderNo = getValues(fieldName1, 0);
			// dataTable.putData("General_Data", "OrderNumber", orderNo);
			propertiesCollectDeCWrite("OrderNumber", orderNo);


			// String status=dataTable.getData("General_Data", "NextStatus");
			String status = getCollectDeColelctProperties("NextStatus");
			if (status.equalsIgnoreCase("640")) {

				// firstRow.click();
				// Thread.sleep(2000);
				click(formExitBtn, "formExitBtn");
				Thread.sleep(2000);

				moveToElement(deCollect, "deCollect");
				click(deCollect, "deCollect");
				Thread.sleep(2000);

				enterText(orderNumberField, orderNo, "orderNumberField");
				Thread.sleep(2000);
				
				enterText(ordertypeField, orderTyp, "ordertypeField");
				Thread.sleep(2000);

				// saleSiteTableField.clear();
				// saleSiteTableField.sendKeys(saleSite);
				// Thread.sleep(2000);

				click(searchButton, "searchButton");
				Thread.sleep(2000);
				
				click(firstRowDecollection, "firstRowDecollection");

				Thread.sleep(2000);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);

				moveToElement(selectedRowExit, "selectedRowExit");
				click(selectedRowExit, "selectedRowExit");
				Thread.sleep(5000);

				String newOrderType = getOrderType.getAttribute("value");
				System.out.println("newOrderType" + newOrderType);
				// dataTable.putData("General_Data", "NewOrderType",
				// newOrderType);
				propertiesCollectDeCWrite("NewOrderType", newOrderType);

				Thread.sleep(2000);

				String newOrderNo = getOrderNumber.getAttribute("value");
				System.out.println("newOrderNo" + newOrderNo);
				// dataTable.putData("General_Data", "NewOrderNo", newOrderNo);
				propertiesCollectDeCWrite("NewOrderNo", newOrderNo);
				Thread.sleep(2000);

				click(searchButton, "searchButton");
				Thread.sleep(3000);

				click(firstRow, "firstRow");
				Thread.sleep(2000);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(christiesRow, "christiesRow");
				click(christiesRow, "christiesRow");
				Thread.sleep(2000);
				moveToElement(printDeCollection, "printDeCollection");
				click(printDeCollection, "printDeCollection");
				Thread.sleep(3000);

				enterText(collectedByField, "CAT", "collectedByField");
				Thread.sleep(2000);
				
				enterText(collectedByNotesField, "For Testing purpose", "collectedByNotesField");
				Thread.sleep(2000);

				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(saveButton, "saveButton");

				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(5000);

				String fieldName3 = "Pick Number";
				String pickNo = getValues(fieldName3, 0);
				System.out.println("pickNo" + pickNo);
				Thread.sleep(2000);
				// dataTable.putData("General_Data", "PickNumber", pickNo);
				propertiesCollectDeCWrite("PickNumber",pickNo);
				click(closeButton, "closeButton");
				Thread.sleep(2000);

			} else {
				System.out.println("Status is not 640,cannot proceed");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to proceed since status is not 640",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

			remoteDriver.switchTo().defaultContent();

		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithSOPpage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

	public void getNextStatusDecollection() throws IOException {

		System.out.println("Inside WorkWithSOPpage getNextStatusDecollection");
		try {

			remoteDriver.switchTo().frame(iframe);

			// String orderNo=dataTable.getData("General_Data","NewOrderNo");
			String orderNo = getCollectDeColelctProperties("NewOrderNo");

			enterText(getOrderNumber, orderNo, "getOrderNumber");

			// String orderTyp=dataTable.getData("General_Data","NewOrderType");
			String orderTyp = getCollectDeColelctProperties("NewOrderType");
			enterText(getOrderType, orderTyp, "getOrderType");


			// String saleSite=dataTable.getData("General_Data", "SaleNumber");
			String saleSite = getCollectDeColelctProperties("SaleNumber");

			saleSiteField.clear();
			Thread.sleep(1000);

			enterText(saleNumberField, saleSite, "saleNumberField");

			// String transactnType=dataTable.getData("General_Data",
			// "TransactionType");'
			String transactnType = getCollectDeColelctProperties("TransactionType");
			enterText(transactionTypeField, transactnType, "transactionTypeField");
			String lotNo = getCollectDeColelctProperties("LotNumber");
			enterText(lotNumberField, lotNo, "lotNumberField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);

			String fieldName = "Next Status";
			String status = getValues(fieldName, 0);

			// dataTable.putData("General_Data", "NextStatus", status);
			propertiesCollectDeCWrite("NextStatus", status);

			System.out.println("status" + status);
			Thread.sleep(2000);

			if (status.equalsIgnoreCase("630")) {
				System.out
						.println("Status update successful.Current status-630 ");
				ExtentUtility.getTest().log(LogStatus.PASS, "Successfully updated status to 630",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			} else {
				System.out.println("Status update failed ");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to updated status to 630",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


			}
			click(closeButton, "closeButton");
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithSOPpage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

}
