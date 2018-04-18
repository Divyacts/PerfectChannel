package com.mop.qa.pageobject;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class SettlementReportPage extends PageBase {

	protected SettlementReportPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='Data Selection']")
	private WebElement dataSelectionchkbox;

	@FindBy(xpath = "//img[@id='hc0']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='PO10T0']")
	private WebElement companyText;

	@FindBy(xpath = "//*[@id='PO2T0']")
	private WebElement remittenceDate;

	@FindBy(xpath = "//*[@id='PO3T0']")
	private WebElement saleNum;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='listRecRptsHeader']/div[2]/a")
	private WebElement refreshButton;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement jobField;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToDownload;

	@FindBy(xpath = "//*[@id='listRRpt_WSJ']/table/tbody/tr/td[2]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[8]/div")
	private WebElement checkStatusAfterReport;
	
	TestBase test = new TestBase();

	public SettlementReportPage prepareSettlementReport() throws IOException {
		try {
			System.out.println("prepareSettlementReport");

			remoteDriver.switchTo().frame(iframe);

			Thread.sleep(2000);
			click(dataSelectionchkbox, "dataSelectionchkbox");
			click(submitButton, "submitButton");
			Thread.sleep(5000);
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			String companyCode = rds.getValue("General_Data", test.currentTest, "Company");
			Thread.sleep(2000);
			enterText(companyText, companyCode, "companyText");
			Thread.sleep(2000);

			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(remittenceDate, strTodaysDate, "remittenceDate");
			Thread.sleep(2000);
			String SaleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNum, SaleNum, "saleNum");
			click(selectButton, "selectButton");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			saveButton.click();
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();
			click(refreshButton, "refreshButton");
			Thread.sleep(8000);
			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);

			remoteDriver.switchTo().frame(iframe);
			enterText(jobField, "R5804002*", "jobField");
			click(searchButton, "searchButton");
			Thread.sleep(2000);
			click(linkToDownload, "linkToDownload");
			Thread.sleep(2000);
			String checkStatusReport = checkStatusAfterReport.getText();
			remoteDriver.switchTo().defaultContent();
			if (checkStatusReport.equalsIgnoreCase("D")) {
				System.out
						.println("Report Generated Succesfully Check for Status");
				ExtentUtility.getTest().log(LogStatus.PASS, "Report Status changed to D",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

		} catch (Exception ex) {
			System.out.println("prepareSettlementReport" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside prepareSettlementReport SettlementReportPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SettlementReportPage(remoteDriver);

	}

	/*
	 * public void getApLedgerTotal() {
	 * 
	 * String dirPath = "C:\\Users\\235222\\Downloads"; String fileName =
	 * getLatestFilefromDir(dirPath).getName(); System.out.println(fileName);
	 * String propertyFileName = "Data.properties";
	 * 
	 * String strFilepath = System.getProperty("user.home") + "\\Downloads\\" +
	 * fileName; int k = 0; String pdfOut; pdfOut = pageText(1, 1, strFilepath);
	 * 
	 * System.out.println(pdfOut);
	 * 
	 * String[] splitArray = pdfOut.split("\n"); String ORNoOtpt =
	 * splitArray[splitArray.length - 1]; String SVNoOtpt =
	 * splitArray[splitArray.length - 2];
	 * 
	 * String OrderValue = getORnumber(ORNoOtpt); String SVNumber =
	 * getSVnumber(SVNoOtpt); // Properties prop = new Properties(); //
	 * OutputStream output = null; // prop.setProperty("SVNumber",SVNumber); //
	 * prop.setProperty("OrderValue",OrderValue);
	 * 
	 * try { prop.store(new FileWriter("data.properties"), "Data Property"); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * functionallibraries.FunctionalLibrary.propertiesWrite("SVNumber",
	 * SVNumber);
	 * functionallibraries.FunctionalLibrary.propertiesWrite("OrderValue",
	 * OrderValue); //
	 * functionallibraries.FunctionalLibrary.propertiesWrite("OrderValue11", //
	 * OrderNumber);
	 * 
	 * System.out.println("data has been inputted");
	 * 
	 * }
	 */

	private static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

}
