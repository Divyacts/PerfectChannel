package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import supportlibraries.ScriptHelper;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class VoucherMatchPage extends PageBase {

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement warning;

	@FindBy(xpath = "//input[@title='Invoice Number']")
	private WebElement invoiceNoField;

	@FindBy(id = "ROW_EXIT_BUTTON")
	private WebElement rowExitButton;

	@FindBy(xpath = "//*[@id='HE0_44']//nobr[contains(text(),'Redistribute')]")
	private WebElement redistributePO;

	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExitButton;

	@FindBy(xpath = "//*[@id='HE0_614']//nobr[contains(text(),'Receipts')]")
	private WebElement receiptsToMatch;

	@FindBy(xpath = "//input[@title='DOCO..OrderNumber']")
	private WebElement orderNumberField;

	@FindBy(xpath = "//input[@id='C0_202']")
	private WebElement supplierNumberField;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(xpath = "//input[@title='REMA..Remaining Amount']")
	private WebElement remainingAmount;

	protected VoucherMatchPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	public void match3WayVoucher() throws InterruptedException {
		try {
			System.out.println("Inside 3 way Voucher Match Screen");

			remoteDriver.switchTo().frame(iframe);


			invoiceNoField.clear();
			String invoice = getJDEAppProperties("InvoiceNumber");
			enterText(invoiceNoField, invoice, "invoiceNoField");
			Thread.sleep(2000);
			click(searchButton,"searchButton");
			Thread.sleep(7000);
			click(rowExitButton,"rowExitButton");
			Thread.sleep(2000);
			moveToElement(rowExitButton, "rowExitButton");
			Thread.sleep(2000);
			click(formExitButton, "formExitButton");
			moveToElement(receiptsToMatch, "receiptsToMatch");
			Thread.sleep(2000);
			orderNumberField.clear();
			Thread.sleep(2000);
			String orderNum = getJDEAppProperties("PurchaseOrderNumber");
			enterText(orderNumberField, orderNum, "orderNumberField");
			Thread.sleep(2000);
			supplierNumberField.clear();
			String supplier = getJDEAppProperties("SupplierNumber");
			enterText(supplierNumberField, supplier, "supplierNumberField");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(firstRow, "firstRow");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			/*
			 * try { driver.findElement(By.xpath("//*[@id='E0_1']"));
			 * saveButton.click(); Thread.sleep(3000); }catch
			 * (NoSuchElementException e) {
			 * System.out.println("No Warning Proceed"); }
			 */
			Thread.sleep(2000);
			String remainingAmt = remainingAmount.getAttribute("value");
			System.out.println("remainingAmt" + remainingAmt);

			if (remainingAmt.equalsIgnoreCase("")) {
				System.out.println("Voucher is  matched");
				ExtentUtility.getTest().log(LogStatus.PASS, "Voucher is  matched",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Voucher is not matched");
				ExtentUtility.getTest().log(LogStatus.FAIL, "Voucher is not matched",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			Thread.sleep(2000);
			click(saveButton, "saveButton"); 
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println(" Inside 3 way Voucher Match Screen" + ex);

		}
	}

}
