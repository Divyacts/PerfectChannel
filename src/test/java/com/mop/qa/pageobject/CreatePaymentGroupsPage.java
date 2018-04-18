package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;


public class CreatePaymentGroupsPage extends PageBase {

	public CreatePaymentGroupsPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//img[@id='hc_close']")
	private WebElement closeButton;

	@FindBy(xpath = "//input[@title='Data Selection']")
	private WebElement dataSelectionchkbox;

	@FindBy(xpath = "//img[@id='hc0']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@id='LeftOperand8']")
	private WebElement selectLeftBox8;

	@FindBy(xpath = "//select[@id='Comparison8']")
	private WebElement comparisonBox8;

	@FindBy(xpath = "//select[@id='RightOperand8']")
	private WebElement selectRightBox8;

	@FindBy(xpath = "//select[@id='LeftOperand9']")
	private WebElement selectLeftBox9;

	@FindBy(xpath = "//select[@id='Comparison9']")
	private WebElement comparisonBox9;

	@FindBy(xpath = "//select[@id='RightOperand9']")
	private WebElement selectRightBox9;

	@FindBy(xpath = "//select[@id='LeftOperand10']")
	private WebElement selectLeftBox10;

	@FindBy(xpath = "//select[@id='Comparison10']")
	private WebElement comparisonBox10;

	@FindBy(xpath = "//select[@id='RightOperand10']")
	private WebElement selectRightBox10;

	@FindBy(xpath = "//select[@id='LeftOperand11']")
	private WebElement selectLeftBox11;

	@FindBy(xpath = "//select[@id='Comparison11']")
	private WebElement comparisonBox11;

	@FindBy(xpath = "//select[@id='RightOperand11']")
	private WebElement selectRightBox11;

	@FindBy(xpath = "//select[@id='LeftOperand12']")
	private WebElement selectLeftBox12;

	@FindBy(xpath = "//select[@id='Comparison12']")
	private WebElement comparisonBox12;

	@FindBy(xpath = "//select[@id='RightOperand12']")
	private WebElement selectRightBox12;

	@FindBy(xpath = "//input[@id='LITtf']")
	private WebElement literalInputField;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='listRecRptsHeader']/div[2]/a")
	private WebElement refreshButton;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement jobField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToDownload;

	@FindBy(xpath = "//input[@id='PO1T0']")
	private WebElement payDateField;

	/*
	 * //td[contains(text(),'Create Payment Control Groups')]
	 */
	@FindBy(xpath = "//*[@id='listRRpt_WSJ']/table/tbody/tr/td[2]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[8]/div")
	private WebElement checkStatusAfterReport;

	public void createPaymentForSettlement() throws IOException {
		System.out.println("Auto Payment");

		try {
			remoteDriver.switchTo().frame(iframe);

			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(5000);
			
			selectOPtionByVisibleText(selectLeftBox11, "Business Unit (F0411) (MCU) [BC]"); 
			Thread.sleep(3000);
			
			selectOPtionByVisibleText(comparisonBox11, "is equal to"); 
			Thread.sleep(3000);
			
			selectOPtionByVisibleText(selectRightBox11, "Literal"); 
			Thread.sleep(3000);
			
			String SaleNum = getJDEAppProperties("SaleNumber");
			enterText(literalInputField, SaleNum, "literalInputField");
			click(selectButton, "selectButton"); 
			Thread.sleep(2000);
			
			
			selectOPtionByVisibleText(selectLeftBox12,"Address Number (F0411) (AN8) [BC]");

			Thread.sleep(3000);
			
			selectOPtionByVisibleText(comparisonBox12,"is equal to");
			Thread.sleep(3000);
			
			selectOPtionByVisibleText(selectRightBox12,"Literal");
			Thread.sleep(3000);

			String accntNumber = getJDEAppProperties("AccountNumber");
			enterText(literalInputField, accntNumber, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);

			System.out.println("Navigated to processing options screen");
			enterText(payDateField, strTodaysDate, "payDateField");

			click(selectButton, "selectButton");
			Thread.sleep(2000);

			click(saveButton, "saveButton");
			Thread.sleep(4000);
			Thread.sleep(8000);

			remoteDriver.switchTo().defaultContent();

			click(refreshButton, "refreshButton");
			Thread.sleep(8000);

			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);

			remoteDriver.switchTo().frame(iframe);
			enterText(jobField, "R58457*", "jobField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);

			// linkToDownload.click();
			Thread.sleep(2000);
			String checkStatusReport = checkStatusAfterReport.getText();
			remoteDriver.switchTo().defaultContent();
			if (checkStatusReport.equalsIgnoreCase("D")) {
				System.out
						.println("Report Generated Succesfully Check for Status");
				ExtentUtility.getTest().log(LogStatus.PASS, "Report Generated Succesfully Check for Status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside createPaymentForSettlement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void createPaymentGNVHGKCKSPAR() throws IOException {
		System.out.println("Auto Payment");

		try {
			remoteDriver.switchTo().frame(iframe);

			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(5000);
			
			selectOPtionByVisibleText(selectLeftBox10, "Business Unit (F0411) (MCU) [BC]");

			Thread.sleep(3000);
			
			selectOPtionByVisibleText(comparisonBox11, "is equal to");

			Thread.sleep(3000);
			
			selectOPtionByVisibleText(selectRightBox10, "Literal");

			Thread.sleep(3000);
			
			String SaleNum = getJDEAppProperties("SaleNumber");
			enterText(literalInputField, SaleNum, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			
			selectOPtionByVisibleText(selectLeftBox11, "Address Number (F0411) (AN8) [BC]");

			Thread.sleep(3000);
			
			selectOPtionByVisibleText(comparisonBox11, "is equal to");

			Thread.sleep(3000);
			selectOPtionByVisibleText(selectRightBox11, "Literal");

			Thread.sleep(3000);
			String accntNumber = getJDEAppProperties("AccountNumber");
			enterText(literalInputField, accntNumber, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);

			System.out.println("Navigated to processing options screen");

			enterText(payDateField, strTodaysDate, "payDateField");

			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(4000);
			Thread.sleep(8000);

			remoteDriver.switchTo().defaultContent();

			click(refreshButton, "refreshButton");
			Thread.sleep(8000);

			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);

			remoteDriver.switchTo().frame(iframe);
			enterText(jobField, "R58457*", "jobField");
			click(searchButton, "searchButton");

			Thread.sleep(2000);

			// linkToDownload.click();
			Thread.sleep(2000);
			String checkStatusReport = checkStatusAfterReport.getText();
			remoteDriver.switchTo().defaultContent();
			if (checkStatusReport.equalsIgnoreCase("D")) {
				System.out
						.println("Report Generated Succesfully Check for Status");
				ExtentUtility.getTest().log(LogStatus.PASS, "Report Generated Succesfully Check for Status to D",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Status update failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void autoPayment() throws Exception {
		System.out.println("Auto Payment");

		remoteDriver.switchTo().frame(iframe);

		Thread.sleep(2000);
		click(dataSelectionchkbox, "dataSelectionchkbox");
		click(submitButton, "submitButton");
		Thread.sleep(5000);

		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		String strTodaysDate = dateFormat.format(currentDate);
		
		selectOPtionByVisibleText(selectLeftBox9, "Address Number (F0101) (AN8) [BC]");

		Thread.sleep(3000);
		
		selectOPtionByVisibleText(comparisonBox9, "is equal to");

		Thread.sleep(3000);
		
		selectOPtionByVisibleText(selectRightBox9, "Literal");

		Thread.sleep(3000);

		String supplierNo = getJDEAppProperties("SupplierNumber");
		enterText(literalInputField, supplierNo, "literalInputField");
		click(selectButton, "selectButton");
		Thread.sleep(2000);
		
		selectOPtionByVisibleText(selectLeftBox10, "Document (Voucher, Invoice, etc.) (F0411) (DOC) [BC]");

		Thread.sleep(3000);
		
		selectOPtionByVisibleText(comparisonBox10, "is equal to");

		Thread.sleep(3000);
		
		selectOPtionByVisibleText(selectRightBox10, "Literal");

		Thread.sleep(3000);

		String documentNo = null;
		documentNo =  getJDEAppProperties("PrevDocumnt");
		enterText(literalInputField, documentNo, "literalInputField");
		click(selectButton, "selectButton");
		Thread.sleep(2000);

		/*
		 * Select select6, select7, select8; select6 = new
		 * Select(selectLeftBox8); select6.selectByVisibleText(
		 * "A/R - A/P - Cash Rcpts/Inv Reg Code (F0411) (RP3) [BC]");
		 * Thread.sleep(3000);
		 * 
		 * select7 = new Select(comparisonBox8);
		 * select7.selectByVisibleText("is equal to"); Thread.sleep(3000);
		 * 
		 * select8 = new Select(selectRightBox8);
		 * select8.selectByVisibleText("Literal"); Thread.sleep(3000);
		 * 
		 * String regCode = dataTable.getData("General_Data","RegCode");
		 * literalInputField.sendKeys(regCode); selectButton.click();
		 * Thread.sleep(2000);
		 */
		click(selectButton, "selectButton");
		Thread.sleep(2000);

		System.out.println("Navigated to processing options screen");

		enterText(payDateField, strTodaysDate, "payDateField");
		click(selectButton, "selectButton");

		Thread.sleep(2000);
		click(saveButton, "saveButton");
		Thread.sleep(4000);
		Thread.sleep(8000);

		remoteDriver.switchTo().defaultContent();
		click(refreshButton, "refreshButton");
		Thread.sleep(8000);
		click(viewJobStatus, "viewJobStatus");
		Thread.sleep(3000);

		remoteDriver.switchTo().frame(iframe);
		enterText(jobField, "R04570*", "jobField");
		click(searchButton, "searchButton");

		Thread.sleep(2000);
  
		// linkToDownload.click();
		Thread.sleep(2000);
		String checkStatusReport = checkStatusAfterReport.getText();
		remoteDriver.switchTo().defaultContent();
		if (checkStatusReport.equalsIgnoreCase("D")) {
			System.out.println("Report Generated Succesfully Check for Status");
			ExtentUtility.getTest().log(LogStatus.INFO, "Report Generated Succesfully Check for Status to D",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

}
