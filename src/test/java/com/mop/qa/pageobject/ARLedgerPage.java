package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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


public class ARLedgerPage extends PageBase {

	protected ARLedgerPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@id='hc_Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement numberOfRows;

	@FindBy(xpath = "//input[@title='LongAddressNumber']")
	private WebElement addressNumberField;

	@FindBy(xpath = "(//input[@title='Sale Number'])[1]")
	private WebElement saleNumberField;

	@FindBy(xpath = "(//input[@title='Document Type'])[1]")
	private WebElement docType;

	@FindBy(xpath = "(//input[@title='Customer'])[1]")
	private WebElement customerAccnt;

	@FindBy(xpath = "//input[@title='Company']")
	private WebElement company;

	@FindBy(xpath = "//input[@title='Invoice Date']")
	private WebElement invoiceDate;

	@FindBy(xpath = "//input[@title='G/L Date']")
	private WebElement glDate;

	@FindBy(xpath = "//input[@title='Currency']")
	private WebElement currency;

	@FindBy(xpath = "//button[@id='C0_638']")
	private WebElement batchesBtn;

	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement hcAdd;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement batchesFirstRow;

	@FindBy(xpath = "//img[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExitBtn;

	@FindBy(xpath = "//*[@id='HE0_123']/tbody/tr/td[2]/span/nobr")
	private WebElement postByBatch;

	@FindBy(xpath = "//*[@id='SubMenu_HE0_732']/span/nobr")
	private WebElement christiesLink;

	@FindBy(xpath = "//input[@title='Dispute Marker - Cashiers']")
	private WebElement disputeMarkerCash;

	@FindBy(xpath = "//input[@title='Cashier Marker Updated']")
	private WebElement cashMarkUpd;

	@FindBy(xpath = "//input[@title='Credit Marker Updated']")
	private WebElement creditMarkUpd;

	@FindBy(xpath = "//input[@title='Dispute Marker - Credit']")
	private WebElement disputeMarkerCredit;

	@FindBy(xpath = "//*[@id='HE0_664']/tbody/tr/td[2]/span/nobr")
	private WebElement dicputeMarketUpd;

	@FindBy(xpath = "//*[@id='HE0_84']/tbody/tr/td[2]/span/nobr")
	private WebElement GLDistribution;

	@FindBy(xpath = "//td[contains(text(),'View Job Status')]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement submittedJobs;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToPrint;

	@FindBy(xpath = "(//input[@title='Lot Number'])")
	private WebElement lotNumberField;

	@FindBy(xpath = "(//input[@title='Transaction Description'])")
	private WebElement transactionDesc;
	
	TestBase test = new TestBase();

	public void workWithARLedgerPage() throws IOException {
		System.out.println("Inside WorkWithSOPpage getNextStatusDecollection");

		try {

			remoteDriver.switchTo().frame(iframe);

			Actions actions = new Actions(remoteDriver);
			String addressNo = getCollectDeColelctProperties("AddressNo");
			enterText(addressNumberField, addressNo, "addressNumberField");
			Thread.sleep(2000);
			
			String saleNo = getCollectDeColelctProperties("SaleNo");
			enterText(saleNumberField, saleNo, "saleNumberField");

			String lotNo = getCollectDeColelctProperties("LotNumber");
			enterText(lotNumberField, lotNo, "lotNumberField");
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			String noOfRows = numberOfRows.getText();
			noOfRows = noOfRows.trim();
			String rowArray[] = noOfRows.split(" - ");
			String rowRequired = rowArray[1];

			Integer rows = Integer.parseInt(rowRequired);
			rows = rows - 1;
			rowRequired = rows.toString();

			String fieldName = "P C";

			int count = 0;

			String batchNumber;

			for (int i = 0; i < rows; i++) {
				String status = getValues(fieldName, i);
				if (status.equalsIgnoreCase("D")) {
					count++;

				} else {

					WebElement webEle2 = remoteDriver
							.findElement(By.xpath("//*[@id='selectAll0_1']"));
					actions.moveToElement(webEle2);
					actions.perform();
					System.out.println("Move to first coluimn");

					Thread.sleep(2000);

					WebElement element = remoteDriver.findElement(By.xpath(
							"//*[@id='G0_1_R" + i + "']/td[1]/div/input"));
					element.click();

					Thread.sleep(2000);

					String Val = getValues("Batch Number", i);
					System.out.println("Val" + Val);
					if (!Val.equals("")) {
						batchNumber = Val;
					}
					click(batchesBtn, "batchesBtn");
					Thread.sleep(3000);
					
					
					click(batchesFirstRow, "batchesFirstRow");
					Thread.sleep(2000);
					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(postByBatch, "postByBatch");
					click(postByBatch, "postByBatch");

					Thread.sleep(4000);
					click(saveButton, "elementName");
					Thread.sleep(4000);

					remoteDriver.switchTo().defaultContent();
					click(viewJobStatus, "viewJobStatus");
					Thread.sleep(3000);
					remoteDriver.switchTo().frame(iframe);
					click(submittedJobs, "submittedJobs");
					Thread.sleep(2000);
					enterText(submittedJobs, "R09801*", "submittedJobs");
					Thread.sleep(2000);
					click(searchButton, "searchButton");
					Thread.sleep(3000);
					click(linkToPrint, "linkToPrint");
					Thread.sleep(3000);
					click(closeButton, "closeButton");
					Thread.sleep(2000);
					click(closeButton, "closeButton");
					Thread.sleep(2000);
					click(searchButton, "searchButton");
					Thread.sleep(3000);

					String status1 = getValues("P C", i);
					if (status1.equalsIgnoreCase("D")) {
						count++;
					}

				}

			}

			int value = rows;
			if (count == value) {
				System.out.println("All ledgers have PC status as D");
				ExtentUtility.getTest().log(LogStatus.PASS, "All ledgers have PC status as D",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("All ledgers do not have PC status as D");
				ExtentUtility.getTest().log(LogStatus.PASS, "All ledgers do not have PC status as D",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
			click(closeButton,"closeButton");
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside workWithSOPpage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void applyCashierTaxrefund() throws IOException {
		System.out.println("Inside applyCashierTaxrefund");

		try {
			Thread.sleep(2000);
			remoteDriver.switchTo().frame(iframe);
			click(hcAdd,"hcAdd");
			Thread.sleep(2000);
			String docTye = getCollectDeColelctProperties("DocumentType");
			String addressNo = getCollectDeColelctProperties("AddressNo");
			String comp =  rds.getValue("General_Data", test.currentTest, "Company");
			String curency =  rds.getValue("General_Data", test.currentTest, "Currency");
			enterText(docType, docTye, "docType");

			Thread.sleep(2000);
			enterText(customerAccnt, addressNo, "customerAccnt");

			Thread.sleep(2000);
			enterText(company, comp, "company");
			Thread.sleep(2000);
			enterText(currency, curency, "currency");
			Thread.sleep(2000);
			Thread.sleep(2000);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 1); // Adding 1 day
			String output = sdf.format(c.getTime());
			System.out.println("output" + output);
			enterText(invoiceDate, output, "invoiceDate");
			Thread.sleep(2000);
			enterText(glDate, output, "glDate");
			Thread.sleep(2000);
			enterTableValues(0);
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside AR Ledger Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void createDepositRefund() throws IOException {
		System.out.println("Inside createDepositRefund");

		try {
			Thread.sleep(2000);
			remoteDriver.switchTo().frame(iframe);
			click(hcAdd, "hcAdd");
			Thread.sleep(2000);
			String addressNo = getCollectDeColelctProperties("AddressNo");
			String comp =  rds.getValue("General_Data", test.currentTest, "Company");
			String curency =  rds.getValue("General_Data", test.currentTest, "Currency");
			
			enterText(customerAccnt, addressNo, "customerAccnt");

			Thread.sleep(2000);
			enterText(company, comp, "company");

			Thread.sleep(2000);
			enterText(currency, curency, "currency");
			Thread.sleep(2000);
			Thread.sleep(2000);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 1); // Adding 1 day
			String output = sdf.format(c.getTime());
			System.out.println("output" + output);
			enterText(invoiceDate, output, "invoiceDate");

			Thread.sleep(2000);
			enterText(glDate, output, "glDate");
			Thread.sleep(2000);
			enterTableValues(0);
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside AR Ledger Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void applyDisputeMarker() throws IOException {
		System.out.println("Inside applyDisputeMarker");

		try {

			remoteDriver.switchTo().frame(iframe);

			Actions actions = new Actions(remoteDriver);
			String addressNo = getCollectDeColelctProperties("AddressNo");
			enterText(addressNumberField, addressNo, "addressNumberField");
			Thread.sleep(2000);
			String saleNo = getCollectDeColelctProperties("SaleNo");
			enterText(saleNumberField, saleNo, "saleNumberField");
			Thread.sleep(2000);
			String lotNo = getCollectDeColelctProperties("SaleNo");
			
			enterText(lotNumberField, lotNo, "lotNumberField");
			enterText(transactionDesc, "HAM", "transactionDesc");
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			String noOfRows = numberOfRows.getText();
			noOfRows = noOfRows.trim();
			String rowArray[] = noOfRows.split(" - ");
			String rowRequired = rowArray[1];

			Integer rows = Integer.parseInt(rowRequired);
			rows = rows - 1;
			rowRequired = rows.toString();

			String fieldName = "Lot Number";
			String fieldName1 = "Transaction Description";

			for (int i = 0; i < rows; i++) {
				String lotVal = getValues(fieldName, i);
				String transDesc = getValues(fieldName1, i);
				if (lotVal.equalsIgnoreCase(lotNo)
						&& transDesc.equalsIgnoreCase("HAM")) {

					WebElement webEle2 = remoteDriver
							.findElement(By.xpath("//*[@id='selectAll0_1']"));
					actions.moveToElement(webEle2);
					actions.perform();
					System.out.println("Move to first coluimn");

					Thread.sleep(2000);

					WebElement element = remoteDriver.findElement(By.xpath(
							"//*[@id='G0_1_R" + i + "']/td[1]/div/input"));
					element.click();

					Thread.sleep(2000);
					click(rowExitBtn, "rowExitBtn");
					Thread.sleep(2000);
					moveToElement(christiesLink, "christiesLink");
					click(christiesLink, "christiesLink");
					Thread.sleep(2000);
					moveToElement(dicputeMarketUpd, "dicputeMarketUpd");
					click(dicputeMarketUpd, "dicputeMarketUpd");
					Thread.sleep(4000);
					String DispuiteMarkercashier = getCollectDeColelctProperties("DispuiteMarkercashier");
					String DisputeMarherCredit = getCollectDeColelctProperties("DisputeMarherCredit");


					if (DispuiteMarkercashier.length() > 0) {
						enterText(disputeMarkerCash, DispuiteMarkercashier, "disputeMarkerCash");
						click(cashMarkUpd, "cashMarkUpd");
						Thread.sleep(2000);
					} else {
						enterText(disputeMarkerCredit, DisputeMarherCredit, "disputeMarkerCredit");
						click(creditMarkUpd, "creditMarkUpd");
						Thread.sleep(2000);
					}
					click(saveButton, "saveButton");
					Thread.sleep(4000);

				}

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

	public void enterTableValues(int count) throws IOException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add("Sale Number");
			list.add("Lot Number");
			list.add("Gross Amount");
			list.add("Remark");
			// list.add("Tax Area");
			// list.add("Tax Expl");
			list.add("Transaction Description");

			ArrayList<String> list1 = new ArrayList<String>();
			
			String saleNumber = getCollectDeColelctProperties("SaleNo");
			String lotNo = getCollectDeColelctProperties("SaleNo");
			String grossAmt = getCollectDeColelctProperties("Grossamt");
			String remark = getCollectDeColelctProperties("Remark");
			String taxAr = getCollectDeColelctProperties("TaxArea");
			
			String taxExpl = getCollectDeColelctProperties("TaxExpl");
	
			String transDescri = getCollectDeColelctProperties("TransDesc");

			list1.add(saleNumber);
			list1.add(lotNo);
			list1.add(grossAmt);
			list1.add(remark);
			// list1.add(taxAr);
			// list1.add(taxExpl);
			list1.add(transDescri);

			rowCreation(count, list, list1);
			List<WebElement> webEle2 = remoteDriver
					.findElements(By.className("JSGridHeaderCell"));
			WebElement element = webEle2.get(0);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);

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
		List<WebElement> webEle2 = remoteDriver
				.findElements(By.className("JSGridHeaderCell"));
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
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).click();
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).clear();
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).sendKeys(list1.trim());
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
