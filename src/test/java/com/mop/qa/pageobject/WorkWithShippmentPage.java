package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


public class WorkWithShippmentPage extends PageBase {
	protected WorkWithShippmentPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='OrderNumber']")
	private WebElement orderNumberField;

	@FindBy(xpath = "//*[@id='HE0_313']/tbody/tr/td[2]/span/nobr")
	private WebElement importExportOption;

	@FindBy(xpath = "//button[@id='C0_15']")
	private WebElement importButton;

	@FindBy(xpath = "//button[@id='C0_13']")
	private WebElement exportButton;

	@FindBy(xpath = "(//input[@title='Shipment Number'])[1]")
	private WebElement shipmentNoField;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//*[@id='va0_80']")
	private WebElement lookUp;

	@FindBy(xpath = "(//a[@title='Refresh'])[2]")
	private WebElement refreshButton;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//*[@id='HE0_98']/tbody/tr/td[2]/span/nobr")
	private WebElement routingOption;

	@FindBy(xpath = "//input[@title='Business Unit1']")
	private WebElement branchField;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='Carrier Number']")
	private WebElement carrierField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRowRouting;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[14]/div")
	private WebElement statusfield;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_306']/span/nobr")
	private WebElement tmsStatus;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_168']/span/nobr")
	private WebElement confirmProof;

	@FindBy(xpath = "//*[@id=HE0_169']/tbody/tr/td[2]/span/nobr")
	private WebElement confirmDelivery;

	@FindBy(xpath = "//*[@id='HE0_308']/tbody/tr/td[2]/span/nobr")
	private WebElement rfqSent;

	@FindBy(xpath = "//*[@id='HE0_309']/tbody/tr/td[2]/span/nobr")
	private WebElement soqSent;

	@FindBy(xpath = "//*[@id='HE0_73']/tbody/tr/td[2]/span/nobr")
	private WebElement shipmentCharges; // *[@id="HE0_73"]/tbody/tr/td[2]/span/nobr

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[7]/div/input")
	private WebElement netAmountField;

	@FindBy(xpath = "//button[contains(text(),'Copy Payable')]")
	private WebElement copyPayabletoBillable;

	@FindBy(xpath = "//*[@id='HE0_310']/tbody/tr/td[2]/span/nobr")
	private WebElement soqConfirmed;

	@FindBy(xpath = "//*[@id='HE0_156']/tbody/tr/td[2]/span/nobr")
	private WebElement deliveryDocuments;

	@FindBy(xpath = "//input[@title='Print Single Document Code']")
	private WebElement printSingleRadioBtn;

	@FindBy(xpath = "//td[contains(text(),'View Job Status')]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement submittedJobs;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToPrint;

	@FindBy(xpath = "//*[@id='G0_1_R2']/td[1]/div/input")
	private WebElement bookingSheetRadioBtn;

	@FindBy(xpath = "//input[@title='Document Code']")
	private WebElement documentCode;

	@FindBy(xpath = "(//td[contains(text(),'Christies Document Forms Print')])[2]")
	private WebElement firstDocument;

	@FindBy(xpath = "//*[@id='HE0_40']/tbody/tr/td[2]/span/nobr")
	private WebElement attachmentsPDF;

	@FindBy(xpath = "//input[@id='urlName']")
	private WebElement urlNameField;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//img[@id='hc1']")
	private WebElement addButton;

	@FindBy(xpath = "//*[@id='gtab0_1']")
	private WebElement dropDownGrid;

	@FindBy(xpath = "//input[@title='Delivery Date']")
	private WebElement deliveryDate;

	@FindBy(xpath = "//input[@title='Received By']")
	private WebElement recvdBy;

	@FindBy(xpath = "//input[@title='Delivery Time Character']")
	private WebElement delvrytime;

	@FindBy(xpath = "//input[@title='OrderType']")
	private WebElement orderTypeField;

	@FindBy(xpath = "//img[@id='BUTTONSAVEEXIT']")
	private WebElement saveExitButton;

	@FindBy(xpath = "//*[@id='HE0_73']/tbody/tr/td[2]/span/nobr")
	private WebElement shipmentCharge;

	@FindBy(xpath = "//*[@id='HE0_312']/tbody/tr/td[2]/span/nobr")
	private WebElement bookedStatus;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[2]/div/img")
	private WebElement firstRowShipment;

	@FindBy(xpath = "//input[@id='C0_78']")
	private WebElement billableRadioBtn;

	@FindBy(xpath = "//input[@title='Carrier Number']")
	private WebElement carrierNumber;

	@FindBy(xpath = "//img[@id='BUTTONADDIMAGE']")
	private WebElement addImage;

	@FindBy(xpath = "(//input[@name='location'])[2]")
	private WebElement localfile;

	@FindBy(xpath = "//button[@id='C0_15']")
	private WebElement yesPayablePop;

	@FindBy(xpath = "//*[@id='HE0_362']/tbody/tr/td[2]/span/nobr")
	private WebElement payablesConfirmed;

	@FindBy(xpath = "//a[@id='CT0_173.2']")
	private WebElement shippmentDetailsTab;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumberField;

	@FindBy(xpath = "//input[@title='Shipment Number']")
	private WebElement shipement;

	@FindBy(xpath = "//input[@name='qbe0_1.8']")
	private WebElement sbOrderTypeField;

	Actions actions = new Actions(remoteDriver);

	public void importRecordCreation() throws IOException {
		System.out.println("Inside WorkWithShipmentPage");

		try {

			remoteDriver.switchTo().frame(iframe);

			/*
			 * String orderNo =
			 * functionallibraries.FunctionalLibrary.propertiesRead(
			 * "OrderNumber"); orderNumberField.clear();
			 * orderNumberField.sendKeys(orderNo);
			 */
			String ShipmentNumber = getJDEAppProperties("ShipmentNumber");
			enterText(shipement, ShipmentNumber, "shipement");

			branchField.clear();
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(importExportOption, "importExportOption");
				click(importExportOption, "importExportOption");

				Thread.sleep(4000);
				click(importButton, "importButton");
				Thread.sleep(3000);
				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(closeButton, "closeButton");
				Thread.sleep(2000);

				remoteDriver.switchTo().defaultContent();

			} else {
				System.out.println("Row not found");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No row displayed in workWithShipmentPage",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

	public void exportRecordCreation() throws IOException {
		System.out.println("Inside exportRecordCreation");

		try {

			remoteDriver.switchTo().frame(iframe);

			/*
			 * String orderNo =
			 * functionallibraries.FunctionalLibrary.propertiesRead(
			 * "OrderNumber"); orderNumberField.clear();
			 * orderNumberField.sendKeys(orderNo);
			 */
			String ShipmentNumber = getJDEAppProperties("ShipmentNumber");
			enterText(shipement, ShipmentNumber, "shipement");

			branchField.clear();
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(importExportOption, "importExportOption");
				click(importExportOption, "importExportOption");
				Thread.sleep(3000);
				click(exportButton, "exportButton");
				Thread.sleep(3000);
				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(closeButton, "closeButton"); 
				Thread.sleep(2000);
				remoteDriver.switchTo().defaultContent();
				ExtentUtility.getTest().log(LogStatus.FAIL, "exportRecordCreation Successfull",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Row not found");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No row displayed in workWithShipmentPage",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));;
		}

	}

	public void proofOfDelivery() throws IOException {
		System.out.println("Inside proofOfDelivery");
		try {
			remoteDriver.switchTo().frame(iframe);
			String ShOutBoundNumber = getJDEAppProperties("ShOutBoundNumber");
			enterText(orderNumberField, ShOutBoundNumber, "orderNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(firstRow, "firstRow");
			ExtentUtility.getTest().log(LogStatus.PASS, "proofOfDelivery Done Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside proofOfDelivery",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShippmentOutbound() throws IOException {
		System.out.println("Inside workWithShippmentOutbound");
		try {

			remoteDriver.switchTo().frame(iframe);

			branchField.clear();
			Thread.sleep(2000);
			String itemNumber = getJDEAppProperties("ItemNumber");
			String orderType = getJDEAppProperties("SBOrderType");
			click(shippmentDetailsTab, "shippmentDetailsTab");

			Thread.sleep(2000);
			enterText(itemNumberField, itemNumber, "itemNumberField");

			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

			Thread.sleep(6000);
			enterText(sbOrderTypeField, orderType, "sbOrderTypeField");
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			if (firstRow.isDisplayed()) {
				String status = statusfield.getText();
				if (status.equalsIgnoreCase("05")) {
					System.out.println("Outbound item found");
					ExtentUtility.getTest().log(LogStatus.PASS, "Outbound rows inside workWithShippmentOutbound",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} else if (status.equalsIgnoreCase("07")) {
					System.out.println("Temp Release Outbound item found");
					ExtentUtility.getTest().log(LogStatus.PASS, "Outbound rows inside TempRelease Outbound",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} else {
					System.out
							.println("No outbound items with status 05 or 07");
					ExtentUtility.getTest().log(LogStatus.FAIL, "No outbound rows inside workWithShippmentOutbound",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


				}
			} else {
				System.out.println("No outbound items");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No outbound rows inside workWithShippmentOutbound",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			click(closeButton, "closeButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShippmentOutbound",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void confirmProofOfDelivery() throws IOException {
		System.out.println("Inside confirmProofOfDelivery");

		try {

			remoteDriver.switchTo().frame(iframe);

			branchField.clear();
			Thread.sleep(2000);
			String itemNumber = getJDEAppProperties("ItemNumber");
			String orderType = getJDEAppProperties("OrderType");
			click(shippmentDetailsTab, "shippmentDetailsTab");

			Thread.sleep(2000);
			enterText(itemNumberField, itemNumber, "itemNumberField");

			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

			Thread.sleep(6000);
			enterText(sbOrderTypeField, orderType, "sbOrderTypeField");
			click(searchButton, "searchButton");

			Thread.sleep(3000);

			if (firstRow.isDisplayed()) {
				String status = statusfield.getText();
				if (status.equalsIgnoreCase("07")) {
					System.out.println("Temp Release Outbound item found");
					ExtentUtility.getTest().log(LogStatus.PASS, "Outbound rows inside TempRelease Outbound",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				} else {
					System.out.println("No outbound items with status 07");
					ExtentUtility.getTest().log(LogStatus.FAIL, "No outbound rows inside workWithShippmentOutbound",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


				}
			} else {
				System.out.println("No outbound items");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No outbound rows inside workWithShippmentOutbound",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
			Thread.sleep(2000);
			click(firstRow, "firstRow");
			Thread.sleep(2000);
			click(rowExitBtn, "rowExitBtn");
			moveToElement(confirmProof, "confirmProof");
			click(confirmProof, "confirmProof");
			Thread.sleep(2000);
			moveToElement(confirmDelivery, "confirmDelivery");
			click(confirmDelivery, "confirmDelivery");
			Thread.sleep(3000);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 1); // Adding 1 day
			String output = sdf.format(c.getTime());
			System.out.println("output" + output);
			enterText(deliveryDate, output, "deliveryDate");
			Thread.sleep(1000);
			enterText(delvrytime, "11", "delvrytime");
			Thread.sleep(1000);
			enterText(recvdBy, "Client", "recvdBy");
			Thread.sleep(1000);
			click(saveButton, "saveButton");
			Thread.sleep(1000);

			remoteDriver.switchTo().defaultContent();
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside workWithShippmentOutbound",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShippmentOutbound",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void workWithShippmentFinalCheck() throws IOException {
		System.out.println("Inside workWithShipmentFreightUpdate Page");

		try {

			remoteDriver.switchTo().frame(iframe);

			// String PoSoNumber =
			// functionallibraries.FunctionalLibrary.propertiesRead("PoSoNumber");
			// orderNumberField.clear();
			// orderNumberField.sendKeys(PoSoNumber);
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			System.out.println(shippmentNo);
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");


			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			Select select = new Select(dropDownGrid);
			select.selectByVisibleText("CAT WWS MASTER");
			Thread.sleep(6000);

			String statusCheck = statusfield.getText();
			if (statusCheck.equalsIgnoreCase("80")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Status Updated Successfully from 75 to 80",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				System.out.println("Final Freight Updated");
			} else {
				System.out.println("Status update fail from 75 to 80");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to updat",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShipmentFreightUpdate() throws IOException {

		System.out.println("Inside workWithShipmentFreightUpdate Page");

		try {

			remoteDriver.switchTo().frame(iframe);

			// String PoSoNumber =
			// functionallibraries.FunctionalLibrary.propertiesRead("PoSoNumber");
			// orderNumberField.clear();
			// orderNumberField.sendKeys(PoSoNumber);
			String shippmentNo = getJDEAppProperties("ShipmentNumber");

			System.out.println(shippmentNo);
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");

			

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");
			Thread.sleep(6000);
			click(firstRow, "firstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(shipmentCharges, "shipmentCharges");
			click(shipmentCharges, "shipmentCharges");
			Thread.sleep(2000);
			click(billableRadioBtn, "billableRadioBtn");
			Thread.sleep(4000);
			click(yesPayablePop, "yesPayablePop");
			Thread.sleep(2000);

			if (firstRowShipment.isDisplayed()) {
				click(cancelButton, "cancelButton");
				Thread.sleep(4000);
				workWithShippmentPayable();
			} else {
				System.out.println("FreightUpdateBillable didnt work");
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "workWithShipmentFreightUpdate Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void workWithShippmentPayable() throws IOException {
		System.out.println("Inside workWithShipmentPayable Page");
		try {
			click(rowExitBtn, "rowExitBtn");
			moveToElement(tmsStatus, "tmsStatus");
			click(tmsStatus, "tmsStatus");
			Thread.sleep(2000);
			moveToElement(payablesConfirmed, "payablesConfirmed");
			click(payablesConfirmed, "payablesConfirmed");
			Thread.sleep(3000);
			click(closeButton, "closeButton");
			Thread.sleep(3000);

			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPayable Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

	public void shippingQuotesToRequestor() throws IOException {

		/*
		 * 30-40 Shipping quotes to requestor
		 */

		System.out.println("Inside shippingQuotesToRequestor");
		try {

			remoteDriver.switchTo().frame(iframe);

			// String orderNo =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderNumber");
			orderNumberField.clear();
			// orderNumberField.sendKeys(orderNo);

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();

			shipmentNoField.clear();
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");
			Thread.sleep(6000);
 
			click(firstRow, "firstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(tmsStatus, "tmsStatus");
			click(tmsStatus, "tmsStatus");
			Thread.sleep(2000);
			moveToElement(soqSent, "soqSent");
			click(soqSent, "soqSent");
			Thread.sleep(4000);

			String statusCheck2 = statusfield.getText();
			Thread.sleep(2000);
			System.out.println("statusCheck2" + statusCheck2);
			if (statusCheck2.equalsIgnoreCase("35")) {
				click(firstRow, "firstRow");
				Thread.sleep(2000);
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(3000);
				moveToElement(shipmentCharges, "shipmentCharges");
				click(shipmentCharges, "shipmentCharges");
				Thread.sleep(4000);
				click(firstRow, "firstRow");
				String netAmount = getJDEAppProperties("NetAmount");
				System.out.println(netAmount);
				enterText(netAmountField, netAmount, "netAmountField");
				
				Thread.sleep(2000);
				click(copyPayabletoBillable, "copyPayabletoBillable");
				/*
				 * check point => if payable is updated amount should i click
				 * radio button & see ???
				 */
				Thread.sleep(3000);
				click(saveButton, "saveButton");
				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(2000);

				// firstRow.click();
				// rowExitBtn.click();
				// Thread.sleep(2000);
				// actions.moveToElement(shipmentCharges).click().build().perform();
				// Thread.sleep(2000);
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				moveToElement(tmsStatus, "tmsStatus");
				click(tmsStatus, "tmsStatus");
				Thread.sleep(3000);
				moveToElement(soqConfirmed, "soqConfirmed");
				click(soqConfirmed, "soqConfirmed");
				Thread.sleep(3000);
				click(searchButton, "searchButton");
				Thread.sleep(3000); 

				String statusCheck3 = statusfield.getText();
				if (statusCheck3.equalsIgnoreCase("40")) {
					System.out
							.println("Status update successfull from 35 to 40");
					ExtentUtility.getTest().log(LogStatus.PASS, "Successfully updated status",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));


				} else {
					System.out.println("Status update fail from 35 to 40");
					ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to update  status",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				}

				System.out.println("Out of status 35 ");

			} else {
				System.out.println("Status update fail from 30 to 35");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to update  status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			System.out.println("Out of status 30 ");
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPageAfterRFQ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void bookingShippment() throws IOException {

		/*
		 * 40-50 bookShippment()
		 */

		System.out.println("Inside bookingShippment");
		try {

			remoteDriver.switchTo().frame(iframe);

			// String orderNo =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderNumber");
			orderNumberField.clear();
			// orderNumberField.sendKeys(orderNo);

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();

			shipmentNoField.clear();
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			
			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");
			Thread.sleep(6000);
			click(firstRow, "firstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(deliveryDocuments, "deliveryDocuments");
			click(deliveryDocuments, "deliveryDocuments");
			Thread.sleep(2000);
			click(printSingleRadioBtn, "printSingleRadioBtn");
			Thread.sleep(2000);
			documentCode.clear();
			enterText(documentCode, "B1", "documentCode");
			click(bookingSheetRadioBtn,"bookingSheetRadioBtn");

			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();
			click(refreshButton, "refreshButton");
			Thread.sleep(8000);

			// if(firstDocument.isDisplayed()){

			// firstDocument.click();
			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);
			click(submittedJobs, "submittedJobs");
			Thread.sleep(2000);
			enterText(submittedJobs, "R5849004*", "submittedJobs");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(linkToPrint, "linkToPrint");
			Thread.sleep(3000);

			String dirPath = System.getProperty("user.home") + "\\Downloads";
			
			String fileName = functionallibraries.FunctionalLibrary
					.getLatestFilefromDir(dirPath).getName();
			System.out.println(fileName);
			Thread.sleep(2000);
			// closeButton.click();
			Thread.sleep(2000);
			click(rowExitBtn, "rowExitBtn");
			moveToElement(attachmentsPDF, "attachmentsPDF");
			click(attachmentsPDF, "attachmentsPDF");
			Thread.sleep(3000);

			/*
			 * String strFilepath = System.getProperty("user.home") +
			 * "\\Downloads\\" + fileName; System.out.println(strFilepath);
			 * 
			 * addImage.click(); Thread.sleep(2000); localfile.click();
			 * Thread.sleep(2000);
			 * 
			 * urlNameField.sendKeys(strFilepath); addButton.click();
			 * Thread.sleep(2000); saveExitButton.click(); Thread.sleep(2000);
			 */
			click(closeButton, "closeButton");
			Thread.sleep(3000);
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(tmsStatus, "tmsStatus");
			click(tmsStatus, "tmsStatus");
			Thread.sleep(2000);
			click(bookedStatus, "bookedStatus");
			Thread.sleep(2000);

			String statusCheck4 = statusfield.getText();
			if (statusCheck4.equalsIgnoreCase("50")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Status Updated Successfully",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			} else {
				System.out.println("Status update fail from 40 to 50");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate Status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPageAfterRFQ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShipmentTMSConfirmCAT() throws IOException {
		System.out.println("Inside workWithShipmentTMSConfirmCAT");
		try {

			remoteDriver.switchTo().frame(iframe);

			// String PoSoNumber =
			// functionallibraries.FunctionalLibrary.propertiesRead("PoSoNumber");
			String itemNumber = getJDEAppProperties("ItemNumber");

			orderNumberField.clear();
			// orderNumberField.sendKeys(PoSoNumber);

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();
			click(shippmentDetailsTab, "shippmentDetailsTab");
			Thread.sleep(2000);
			enterText(itemNumberField, itemNumber, "itemNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);

			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

			Thread.sleep(6000);

			String statusCheck = statusfield.getText();

			if (statusCheck.equalsIgnoreCase("70")) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Status Updated Successfully from 50 to 70",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				System.out.println("Booked TMS Confirm CAT");
				click(closeButton, "closeButton");
				Thread.sleep(3000);

			} else {
				System.out.println("Status update fail from 50 to 70");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Status update fail from 50 to 70",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentTMSConfirmCAT",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

	}

	public void printDocuments(String docCode) throws IOException {
		try {
			remoteDriver.switchTo().frame(iframe);

			// String orderNo =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderNumber");
			orderNumberField.clear();
			// orderNumberField.sendKeys(orderNo);

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();
			Thread.sleep(2000);
			shipmentNoField.clear();
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);
			selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

			Thread.sleep(6000);
			click(firstRow, "firstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(deliveryDocuments, "deliveryDocuments");
			click(deliveryDocuments, "deliveryDocuments");
			Thread.sleep(4000);
			click(printSingleRadioBtn, "printSingleRadioBtn");
			Thread.sleep(2000);
			enterText(documentCode, docCode, "documentCode");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(4000);
			remoteDriver.switchTo().defaultContent();
			Thread.sleep(8000);
			click(refreshButton, "refreshButton");
			Thread.sleep(8000);
			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);
			click(submittedJobs, "submittedJobs");
			Thread.sleep(2000);
			enterText(submittedJobs, "R5849004*", "submittedJobs");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(linkToPrint, "linkToPrint");
			Thread.sleep(3000);

			String dirPath = System.getProperty("user.home") + "\\Downloads";
			String fileName = functionallibraries.FunctionalLibrary
					.getLatestFilefromDir(dirPath).getName();
			System.out.println(fileName);
			Thread.sleep(2000);
			// ascloseButton.click();
			Thread.sleep(2000);
			click(rowExitBtn, "rowExitBtn");
			moveToElement(attachmentsPDF, "attachmentsPDF");
			click(attachmentsPDF, "attachmentsPDF");
			Thread.sleep(3000);

			/*
			 * String strFilepath = System.getProperty("user.home") +
			 * "\\Downloads\\" + fileName; System.out.println(strFilepath);
			 * 
			 * addImage.click(); Thread.sleep(2000); localfile.click();
			 * Thread.sleep(2000);
			 * 
			 * urlNameField.sendKeys(strFilepath); addButton.click();
			 * Thread.sleep(2000); saveExitButton.click(); Thread.sleep(2000);
			 */
			closeButton.click();
			remoteDriver.switchTo().defaultContent();
			// closeButton.click();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void shippingQutoesToSuppliers() throws IOException {
		/*
		 * 11-30 Shipping quotes to suppliers Inbound
		 */
		System.out.println("Inside shippingQutoesToSuppliers");
		try {

			remoteDriver.switchTo().frame(iframe);

			// String orderNo =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderNumber");
			orderNumberField.clear();
			// orderNumberField.sendKeys(orderNo);

			// String orderType =
			// functionallibraries.FunctionalLibrary.propertiesRead("OrderType");
			orderTypeField.clear();
			// orderTypeField.sendKeys(orderType);

			branchField.clear();

			shipmentNoField.clear();
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");
			click(searchButton, "searchButton"); 
			Thread.sleep(2000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(routingOption, "routingOption");
				click(routingOption, "routingOption");

				Thread.sleep(40000);
				System.out.println("Processing");
				Thread.sleep(20000);
				
				String carrierNo = getJDEAppProperties("CarrierNumber");

				System.out.println(carrierNo);
				Thread.sleep(8000);
				carrierField.clear();
				Thread.sleep(2000);
				enterText(carrierField, carrierNo, "carrierField");
				Thread.sleep(2000);
				click(searchButton, "searchButton");
				Thread.sleep(15000);
				click(firstRowRouting, "firstRowRouting");
				click(selectButton, "selectButton");

				Thread.sleep(4000);
				
				selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

				Thread.sleep(6000);

				int statusCheck = Integer.parseInt(statusfield.getText());
				System.out.println("statusCheck" + statusCheck);
				if (statusCheck >= 11 && statusCheck <= 20) {
					click(firstRow, "firstRow");
					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(tmsStatus, "tmsStatus");
					click(tmsStatus, "tmsStatus");
					Thread.sleep(2000);
					moveToElement(rfqSent, "rfqSent");
					click(rfqSent, "rfqSent");
					Thread.sleep(2000);

					String statusCheck1 = statusfield.getText();
					if (statusCheck1.equalsIgnoreCase("30")) {
						System.out.println(
								"Status update successful from 11 to 30");
						ExtentUtility.getTest().log(LogStatus.PASS, "Successfully updated 11 to 30",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					} else {
						System.out.println("Status update fail from 11 to 30");
						ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to update 11 to 30",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					}
				} else {
					System.out.println("Status update fail from 10 to 11");
					ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to update 11 to 30",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				}

			} else {
				System.out.println("Row not found");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No row displayed in workWithShipmentPage",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	
			}

			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShipment() throws IOException {
		System.out.println("Inside WorkWithShipmentPage");

		try {

			remoteDriver.switchTo().frame(iframe);
			String orderNo = getJDEAppProperties("OrderNumber");

			enterText(orderNumberField, orderNo, "orderNumberField");

			String orderType = getJDEAppProperties("OrderType");

			enterText(orderTypeField, orderType, "orderTypeField");


			branchField.clear();

			shipmentNoField.clear();
			String shippmentNo = getJDEAppProperties("ShipmentNumber");
			enterText(shipmentNoField, shippmentNo, "shipmentNoField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);

			if (firstRow.isDisplayed()) {
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(routingOption, "routingOption");
				click(routingOption, "routingOption");

				Thread.sleep(40000);
				System.out.println("Processing");
				Thread.sleep(20000);
				
				String carrierNo = getJDEAppProperties("CarrierNumber");

				System.out.println(carrierNo);
				Thread.sleep(8000);

				enterText(carrierField, carrierNo, "carrierField");
				Thread.sleep(2000);
				
				click(searchButton, "searchButton");
				Thread.sleep(15000);

				click(firstRowRouting, "firstRowRouting");
				click(selectButton, "selectButton");

				Thread.sleep(4000);
				
				selectOPtionByVisibleText(dropDownGrid, "CAT WWS MASTER");

				Thread.sleep(6000);

				String statusCheck = statusfield.getText();
				if (statusCheck.equalsIgnoreCase("11")) {
					click(firstRow, "firstRow");
					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(tmsStatus, "tmsStatus");
					click(tmsStatus, "tmsStatus");
					Thread.sleep(2000);
					moveToElement(rfqSent, "rfqSent");
					click(rfqSent, "rfqSent");
					Thread.sleep(2000);

					String statusCheck1 = statusfield.getText();
					if (statusCheck1.equalsIgnoreCase("30")) {
						workWithShipmentAfterRfqSent();
					} else {
						System.out.println("Status update fail from 11 to 30");
						ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate 11 to 30",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

					}
				} else {
					System.out.println("Status update fail from 10 to 11");
					ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate 11 to 30",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}

			} else {
				System.out.println("Row not found");
				ExtentUtility.getTest().log(LogStatus.FAIL, "No row displayed in workWithShipmentPage",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShipmentAfterRfqSent() throws IOException {
		try {
			click(firstRow, "firstRow");
			click(rowExitBtn, "rowExitBtn");
			Thread.sleep(2000);
			moveToElement(tmsStatus, "tmsStatus");
			click(tmsStatus, "tmsStatus");
			Thread.sleep(2000);
			moveToElement(soqSent, "soqSent");
			click(soqSent, "soqSent");
			Thread.sleep(2000);

			String statusCheck2 = statusfield.getText();

			if (statusCheck2.equalsIgnoreCase("35")) {
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(shipmentCharges, "shipmentCharges");
				click(shipmentCharges, "shipmentCharges");
				Thread.sleep(3000);

				click(firstRow, "firstRow");

				String netAmount = getJDEAppProperties("NetAmount");

				System.out.println(netAmount);

				enterText(netAmountField, netAmount, "netAmountField");
				click(copyPayabletoBillable, "copyPayabletoBillable");

				/*
				 * check point => if payable is updated amount should i click
				 * radio button & see ???
				 */
				Thread.sleep(2000);
				click(saveButton, "saveButton");
				Thread.sleep(2000);

				click(saveButton, "saveButton");
				Thread.sleep(2000);

				// firstRow.click();
				// rowExitBtn.click();
				// Thread.sleep(2000);
				// actions.moveToElement(shipmentCharges).click().build().perform();
				// Thread.sleep(2000);
				//
				click(firstRow, "firstRow");
				click(rowExitBtn, "rowExitBtn");
				Thread.sleep(2000);
				moveToElement(soqConfirmed, "soqConfirmed");
				click(soqConfirmed, "soqConfirmed");
				Thread.sleep(2000);

				click(searchButton, "searchButton");
				Thread.sleep(3000);

				String statusCheck3 = statusfield.getText();
				if (statusCheck3.equalsIgnoreCase("40")) {
					click(firstRow, "firstRow");
					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(deliveryDocuments, "deliveryDocuments");
					click(deliveryDocuments, "deliveryDocuments");
					Thread.sleep(2000);

					click(printSingleRadioBtn, "printSingleRadioBtn");
					click(bookingSheetRadioBtn, "bookingSheetRadioBtn");
					enterText(documentCode, "B1", "documentCode");
					Thread.sleep(2000);

					click(saveButton, "saveButton");
					Thread.sleep(2000);
					click(refreshButton, "refreshButton");
					Thread.sleep(8000);

					// if(firstDocument.isDisplayed()){
					click(firstDocument, "firstDocument");

					String dirPath = System.getProperty("user.home")
							+ "\\Downloads";
					// String fileName =
					// functionallibraries.FunctionalLibrary.getLatestFilefromDir(dirPath).getName();

					Thread.sleep(2000);
					click(closeButton, "closeButton");
					Thread.sleep(2000);

					click(rowExitBtn, "rowExitBtn");
					moveToElement(attachmentsPDF, "attachmentsPDF");
					click(attachmentsPDF, "attachmentsPDF");
					Thread.sleep(3000);

					// String strFilepath = System.getProperty("user.home") +
					// "\\Downloads\\" + fileName;
					String strFilepath = null;
					enterText(urlNameField, strFilepath, "urlNameField");
					click(addButton, "addButton");
					Thread.sleep(2000);
					click(saveExitButton, "saveExitButton");
					Thread.sleep(2000);

					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(tmsStatus, "tmsStatus");
					click(tmsStatus, "tmsStatus");
					Thread.sleep(2000);
					moveToElement(bookedStatus, "bookedStatus");
					click(bookedStatus, "bookedStatus");

					Thread.sleep(2000);

					String statusCheck4 = statusfield.getText();
					if (statusCheck4.equalsIgnoreCase("50")) {
						// workWithShipmentAfterBooking();
						System.out.println("Booked");
					} else {
						System.out.println("Status update fail from 40 to 50");
						ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate 40 to 50",
								ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
					}

				} else {
					System.out.println("Status update fail from 35 to 40");
					ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate 35 to 40",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}

			} else {
				System.out.println("Status update fail from 30 to 35");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Failed to upate 35 to 40",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside workWithShipmentPageAfterRFQ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void workWithShipmentAfterBooking() {

	}

}
