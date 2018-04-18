package com.mop.qa.pageobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class VoucherLoggingPage extends PageBase {

	protected VoucherLoggingPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Add']")
	private WebElement addButton;

	@FindBy(xpath = "//input[@title='Company']")
	private WebElement companyField;

	@FindBy(xpath = "//input[@title='Supplier Number']")
	private WebElement supplierNoField;

	@FindBy(xpath = "//input[@title='Invoice Number']")
	private WebElement invoiceNoField;

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
	
	TestBase test =  new TestBase();

	public VoucherMatchPage logInvoice() { 
		try {
			System.out.println("Inside VoucherScreen");

			String supplierNumber = null, price = null, invoiceNo = null, currency = null;

			remoteDriver.switchTo().frame(iframe);
			click(addButton, "addButton");
			Thread.sleep(3000);
			String companyID = rds.getValue("General_Data", test.currentTest, "Company");
			enterText(companyField, companyID, "companyField");
			supplierNumber = getJDEAppProperties("SupplierNumber");

			price = getJDEAppProperties("Price");

			String invoice = generatePIN();
			// invoiceNo=dataTable.getData("General_Data","InvoiceNumber");
			propertiesJdeWrite("InvoiceNumber", invoice);
			
			currency = rds.getValue("General_Data", test.currentTest, "Currency");
			propertiesJdeWrite("Currency", currency);
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);

			Thread.sleep(5000);
			enterText(invoiceNoField, invoice, "invoiceNoField");
			enterText(supplierNoField, invoice, "supplierNumber");

			Thread.sleep(5000);
			enterText(invoiceDateField, strTodaysDate, "invoiceDateField");

			Thread.sleep(5000);
			enterText(invoiceDateField, strTodaysDate, "invoiceDateField");
			Thread.sleep(5000);
			enterText(glDateField, strTodaysDate, "glDateField");
			enterText(currencyField, currency, "currencyField");
			Thread.sleep(5000);
			enterText(priceField, price, "priceField");
			Thread.sleep(5000);
			click(priceField, "priceField");
			click(approverField, "approverField");
			Thread.sleep(3000);
			click(invoiceNoField, "invoiceNoField");
			Thread.sleep(3000);
			click(grossAmnt, "grossAmnt");
			enterText(grossAmnt, "2000", "grossAmnt");
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			/*
			 * try { driver.findElement(By.xpath("//*[@id='E0_1']"));
			 * saveButton.click(); Thread.sleep(3000); }catch
			 * (NoSuchElementException e) { System.out.println(
			 * "No Warning Proceed"); }
			 */
			Thread.sleep(3000);

			System.out
					.println("navigated to voucher logging - journal entry prompt");

			click(saveButton, "saveButton");
			Thread.sleep(5000);
			System.out.println("after save 11");
			/*
			 * try { driver.findElement(By.xpath("//*[@id='E0_1']"));
			 * saveButton.click(); Thread.sleep(3000); }catch
			 * (NoSuchElementException e) { System.out.println(
			 * "No Warning Proceed"); }
			 */
			click(saveButton, "saveButton");
			Thread.sleep(5000);
			String batchNumber = batchNoField.getAttribute("value");
			System.out.println(batchNumber);
			propertiesJdeWrite("BatchNumber", batchNumber);
			String prevDoc = prevDocField.getAttribute("value");
			propertiesJdeWrite("PrevDocumnt", prevDoc);
			Thread.sleep(3000);
			System.out.println("batchNumber" + batchNumber);
			System.out.println("prevDoc" + prevDoc);
			click(cancelButton, "cancelButton");
			Thread.sleep(4000);
			click(closeButton, "closeButton");
			Thread.sleep(4000);
			remoteDriver.switchTo().defaultContent();

		}

		catch (Exception ex) {
			System.out.println(" Inside Voucher Screen Page" + ex);
		}
		return new VoucherMatchPage(remoteDriver);

	}

	public VoucherLoggingPage checkPayStatus() throws InterruptedException {
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

		}
		return new VoucherLoggingPage(remoteDriver);

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
