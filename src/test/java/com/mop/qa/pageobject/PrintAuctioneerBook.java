package com.mop.qa.pageobject;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class PrintAuctioneerBook extends PageBase {

	protected PrintAuctioneerBook(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@title='Data Selection']")
	private WebElement dataSelectionchkbox;

	@FindBy(xpath = "//img[@id='hc0']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='Select2']")
	private WebElement checkBox2;

	@FindBy(xpath = "//*[@id='Select3']")
	private WebElement checkBox3;

	@FindBy(xpath = "//*[@id='hc952']")
	private WebElement delete;

	@FindBy(xpath = "//select[@id='LeftOperand1']")
	private WebElement saleNumber;

	@FindBy(xpath = "//select[@id='Comparison1']")
	private WebElement comparisonBox1;

	@FindBy(xpath = "//select[@id='RightOperand1']")
	private WebElement selectRightBox1;

	@FindBy(xpath = "//input[@id='LITtf']")
	private WebElement literalInputField;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='listRecRptsHeader']/div[2]/a")
	private WebElement refreshButton;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement jobField;

	@FindBy(xpath = "//*[@id='listRRpt_WSJ']/table/tbody/tr/td[2]")
	private WebElement viewJobStatus;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToDownload;

	@FindBy(xpath = "//input[@id='PO1T0']")
	private WebElement payDateField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[8]/div")
	private WebElement checkStatusAfterReport;
	
	@FindBy(xpath = "//*[@id='TE_FAST_PATH_BOX']")
	private WebElement checkReport;
	
	@FindBy(xpath = "//*[@id='HE0_121']/tbody/tr/td[2]/span/nobr")
	private WebElement submittedJobs;
	
	@FindBy(xpath = "//*[@id='HE0_93']/tbody/tr/td[2]/span/nobr")
	private WebElement advacned;
	
	@FindBy(xpath = "//input[@title='Data Source Name']")
	private WebElement dataSource;
	
	@FindBy(xpath = "//*[@id='e1MFastpathForm']/a/img")
	private WebElement fastPathGo;
	
	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectAll;
	
	
	
	
	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExit;
	
	

	public PrintAuctioneerBook printAuctionBook() throws IOException {
		try {
			System.out.println("printAuctionBook");
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(1000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(5000);
			click(checkBox2, "checkBox2");
			click(checkBox3, "checkBox3");
			click(delete, "delete");
			Thread.sleep(2000);
			
			selectOPtionByVisibleText(saleNumber, "Sale Number (F57PA11) (Y57PSALE) [BC]");

			Thread.sleep(3000);
			selectOPtionByVisibleText(comparisonBox1, "is equal to");

			Thread.sleep(3000);
			selectOPtionByVisibleText(selectRightBox1, "Literal");

			Thread.sleep(200);

			String sale = null;
			sale = getJDEAppProperties("SaleNumber");
			enterText(literalInputField, sale, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);
			Thread.sleep(8000);

			remoteDriver.switchTo().defaultContent();
			click(refreshButton, "refreshButton");
			Thread.sleep(8000);
			click(viewJobStatus,"viewJobStatus");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);

			Thread.sleep(3000);
			enterText(jobField, "R57PA018*", "jobField");

			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(linkToDownload, "linkToDownload");
			Thread.sleep(2000);
			String checkStatusReport = checkStatusAfterReport.getText();
			remoteDriver.switchTo().defaultContent();
			if (checkStatusReport.equalsIgnoreCase("D")) {
				System.out
					.println("Report Generated Succesfully Check for Status");
				ExtentUtility.getTest().log(LogStatus.PASS, "Report Generated Succesfully Check for Status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("printAuctionBook" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside printAuctionBook PrintAuctioneerBook page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new PrintAuctioneerBook(remoteDriver);
	}
	
	public PrintAuctioneerBook printAuctionBookLCT() throws IOException{
		try {
			System.out.println("printAuctionBook");
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(1000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(5000);
			click(checkBox2, "checkBox2");
			click(checkBox3, "checkBox3");
			click(delete, "delete");
			Thread.sleep(2000);
			selectOPtionByVisibleText(saleNumber, "Sale Number (F57PA11) (Y57PSALE) [BC]");

			Thread.sleep(3000);
			selectOPtionByVisibleText(comparisonBox1, "is equal to");

			Thread.sleep(3000);
			selectOPtionByVisibleText(selectRightBox1, "Literal");

			Thread.sleep(200);

			String sale = null;
			sale = getJDEAppProperties("SaleNumber");
			enterText(literalInputField, sale, "literalInputField");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(5000); 
			Thread.sleep(8000);
			remoteDriver.switchTo().defaultContent();
			click(refreshButton, "refreshButton");
			Thread.sleep(8000);
		} catch (Exception ex) {
			System.out.println("printAuctionBook" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside printAuctionBook PrintAuctioneerBook page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		
		
	}
		return new PrintAuctioneerBook(remoteDriver);
	}
	
	public void checkAuctioneerBook() throws Exception{
		try{
		enterText(checkReport,"bv","checkReport");
		click(fastPathGo, "fastPathGo");
		remoteDriver.switchTo().frame(iframe);
		click(formExit, "formExit");
		moveToElement(submittedJobs, "submittedJobs");
		click(submittedJobs, "submittedJobs");
		Thread.sleep(3000);
		click(formExit, "formExit");
		moveToElement(advacned, "advacned");
		click(advacned, "advacned");
		Thread.sleep(2000);
		enterText(dataSource, "NYJDAPP01P", "dataSource");
		click(searchButton, "searchButton");
		click(selectAll, "selectAll");
		click(selectButton, "selectButton");   
		
		Thread.sleep(2000);
		click(linkToDownload, "linkToDownload");
		Thread.sleep(2000);
		String checkStatusReport = checkStatusAfterReport.getText();
		remoteDriver.switchTo().defaultContent();
		if (checkStatusReport.equalsIgnoreCase("D")) {
			System.out
				.println("Report Generated Succesfully Check for Status");
			ExtentUtility.getTest().log(LogStatus.PASS, "Report Generated Succesfully Check for Status",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		Thread.sleep(2000);  
		}catch (Exception ex) {
			System.out.println("printAuctionBook" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside checkAuctioneerBook",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		
		
	}
		
	}
	

}
