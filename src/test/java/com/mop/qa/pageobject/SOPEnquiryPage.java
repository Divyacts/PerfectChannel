package com.mop.qa.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class SOPEnquiryPage extends PageBase {

	protected SOPEnquiryPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Order Number'])[2]")
	private WebElement orderNumber;

	@FindBy(xpath = "(//*[@title='Sale Site'])[2]")
	private WebElement saleSite;

	@FindBy(xpath = "(//*[@title='Sale Number'])[2]")
	private WebElement saleNumber;

	@FindBy(xpath = "(//*[@title='Transaction Type'])")
	private WebElement transactionType;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='G0_41_R0']/td[1]/div/input")
	private WebElement firstRow;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "(//*[@title='Lot Number'])[2]")
	private WebElement lotNumber;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//td[contains(text(),'View Job Status')]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement submittedJobs;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToPrint;

	// *[@id='G0_41_R" +RowCount+"']/td[1]/div/input

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	public SOPEnquiryPage verifySoNumber() throws  IOException {
		try {
			
			String svNumber = getJDEAppProperties("SVNumber");

			remoteDriver.switchTo().frame(iframe);
			enterText(orderNumber, svNumber, "orderNumber");
			String saleSit = getJDEAppProperties("SaleSellingSite");
			Thread.sleep(3000);
			//enterText(saleSite, saleSit, "saleSite");
			Thread.sleep(3000); 
			click(find, "find"); 
			Thread.sleep(3000);
			if (firstRow.isDisplayed()) {
				ExtentUtility.getTest().log(LogStatus.PASS, "First Row is  dispalyed",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
		} catch (Exception ex) {
			System.out.println("verifySoNumber SOP Enquiry" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "No Rows dispalyed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SOPEnquiryPage(remoteDriver);  
	}

	public GenerateChargeOrderRequisiton ViewJobStatus(String chargeType) throws IOException {
		try {
			System.out.println("ViewJobStatus navigateWorkWithProperty");
			Thread.sleep(3000);
			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);
			moveToElement(submittedJobs, "submittedJobs");
			remoteDriver.switchTo().frame(iframe);
			click(submittedJobs, "submittedJobs");
			Thread.sleep(2000);
			enterText(submittedJobs, "R5842001*", "submittedJobs");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(linkToPrint, "linkToPrint");
			Thread.sleep(5000);
			getOrderNumberFromPdf(chargeType);
			Thread.sleep(2000);
			click(closeButton, "closeButton");
			// Thread.sleep(3000);
			// closeButton.click();
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println(
					"ViewJobStatus GenerateChargeOrderRequisiton" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Generare Charg",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new GenerateChargeOrderRequisiton(remoteDriver);
	}

	public void getOrderNumberFromPdf(String chargeType) {

		String dirPath = "C:\\Users\\235222\\Downloads";
		String fileName = getLatestFilefromDir(dirPath).getName();
		System.out.println(fileName);
		String propertyFileName = "data.properties";

		String strFilepath = System.getProperty("user.home") + "\\Downloads\\"
				+ fileName;
		int k = 0;
		String pdfOut;
		pdfOut = pageText(1, 1, strFilepath);

		System.out.println(pdfOut);

		String[] splitArray = pdfOut.split("\n");
		String ORNoOtpt = splitArray[splitArray.length - 1];
		String SCCNoOtpt = splitArray[splitArray.length - 2];
		System.out.println("ORNoOtpt" + ORNoOtpt);
		System.out.println("SCCNoOtpt" + SCCNoOtpt);

		if (chargeType.equalsIgnoreCase("SO")) {
			String SCNumber = getSCnumber(ORNoOtpt);
			propertiesJdeWrite("SCNumber", SCNumber);
		}

		if (chargeType.equalsIgnoreCase("SOPO")) {
			String OrderValue = getOROWnumber(ORNoOtpt, chargeType);
			String SCNumber = getSCnumber(SCCNoOtpt);
			propertiesJdeWrite("SCNumber", SCNumber);
			propertiesJdeWrite("OrderValueSC", OrderValue);
		}

		if (chargeType.equalsIgnoreCase("SOPR")) {
			String OrderValue = getOROWnumber(ORNoOtpt, chargeType);
			String SCNumber = getSCnumber(SCCNoOtpt);
			propertiesJdeWrite("SCNumber", SCNumber);
			propertiesJdeWrite("OrderValueSC", OrderValue);

		}

		System.out.println("data has been inputted");

	}

	private String getOROWnumber(String ORNoOtpt, String chargeType) {
		String OrderNumber = null;
		if (ORNoOtpt.contains("SC") && chargeType.equalsIgnoreCase("SOPO")) {
			String[] ORNoArray = ORNoOtpt.split(" ");

			System.out.println(ORNoArray.length);
			System.out.println(ORNoArray[2]);

			int orLocation = 0;
			for (int i = 0; i < ORNoArray.length; i++) {
				if (ORNoArray[i].equalsIgnoreCase("SC")) {
					orLocation = i;
				}
			}

			if (orLocation > 0) {
				System.out.println(
						"Order number is " + ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}
		} else if (ORNoOtpt.contains("SC")
				&& chargeType.equalsIgnoreCase("SOPR")) {
			String[] ORNoArray = ORNoOtpt.split(" ");

			// System.out.println(ORNoArray.length);
			// System.out.println(ORNoArray[2]);

			int orLocation = 0;
			for (int i = 0; i < ORNoArray.length; i++) {
				if (ORNoArray[i].equalsIgnoreCase("SC")) {
					orLocation = i;
				}
			}

			if (orLocation > 0) {
				System.out.println(
						"Order number is " + ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}

			else {
				System.out.println("No order number is present");
				OrderNumber = null;
			}
		} else if (ORNoOtpt.contains("SC")
				&& chargeType.equalsIgnoreCase("SO")) {
			String[] ORNoArray = ORNoOtpt.split(" ");
			System.out.println("inside SO");
			// System.out.println(ORNoArray.length);
			// System.out.println(ORNoArray[2]);

			int orLocation = 0;
			for (int i = 0; i < ORNoArray.length; i++) {
				if (ORNoArray[i].equalsIgnoreCase("SC")) {
					orLocation = i;
				}
			}

			if (orLocation > 0) {
				System.out.println(
						"Order number is " + ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}

			else {
				System.out.println("No order number is present");
				OrderNumber = null;
			}
		}
		return OrderNumber;
	}

	private String getSCnumber(String ORNoOtpt) {
		String SCNumber = null;
		if (ORNoOtpt.contains("SC")) {
			String[] SVNoArray = ORNoOtpt.split(" ");
			System.out.println(SVNoArray.length);
			System.out.println(SVNoArray[2]);

			int svLocation = 0;
			for (int i = 0; i < SVNoArray.length; i++) {
				if (SVNoArray[i].equalsIgnoreCase("SC")) {
					svLocation = i;
				}
			}

			if (svLocation > 0) {
				System.out.println("SC number is " + SVNoArray[svLocation + 1]);
				SCNumber = SVNoArray[svLocation + 1];
			}
		} else {
			System.out.println("No SC number is present");
			SCNumber = " ";
		}
		return SCNumber;
	}

	public static String pageText(int startPage, int endPage,
			String strFilepath) {
		String strPageText = "";
		try {
			File file = new File(strFilepath);
			PDDocument document = null;
			document = PDDocument.load(file);
			PDFTextStripper reader = new PDFTextStripper();
			reader.setStartPage(startPage);
			reader.setEndPage(endPage);
			strPageText = reader.getText(document);
		} catch (Exception e) {
			System.out.println(
					"Exception Occured while reading the value from document"
							+ e.getMessage());
		}
		return strPageText;
	}

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

	public SOPEnquiryPage verifyREcordsPresentForSale(String flag)
			throws InterruptedException {
		try {

			remoteDriver.switchTo().frame(iframe);
			saleSite.clear();
			/*
			 * String saleSit =
			 * functionallibraries.FunctionalLibrary.propertiesRead(
			 * "SaleSellingSite"); saleSite.sendKeys(saleSit);
			 */
			String saleNum = getJDEAppProperties("SaleNumber");
			String LotNumForAdhocBatching = getJDEAppProperties("LotNumForAdhocBatching");
			String SaleSource = getJDEAppProperties("SaleSourceSite");


			if (flag.equalsIgnoreCase("creditSaleBatching")) {
				enterText(saleNumber, saleNum, "saleNumber");
				enterText(transactionType, "HAM", "transactionType");

			}

			else if (flag.equalsIgnoreCase("creditAdHocBatching")) {
				enterText(saleNumber, saleNum, "saleNumber");
				Thread.sleep(1000);
				enterText(saleSite, SaleSource, "saleSite");
				Thread.sleep(1000);
				enterText(lotNumber, LotNumForAdhocBatching, "lotNumber");
				Thread.sleep(1000);
				enterText(transactionType, "HAM", "transactionType"); 
			}

			else if (flag.equalsIgnoreCase("creditSSSBatching")) {
				enterText(saleNumber, saleNum, "saleNumber");
				Thread.sleep(1000);
				enterText(saleSite, SaleSource, "saleSite");

				Thread.sleep(1000);
				enterText(lotNumber, LotNumForAdhocBatching, "lotNumber");

				Thread.sleep(1000);
				enterText(transactionType, "HAM", "transactionType");
			}

			Thread.sleep(3000);
			click(find, "find");
			Thread.sleep(3000);
			String fieldName2 = "Next Status";
			boolean nextButton = IsTestElementPresent();
			if (nextButton) {
				click(lastArrow, "lastArrow");
			}
			Thread.sleep(5000);

			String Val = getValues(fieldName2, 0);

			Thread.sleep(2000);

			if (Val.equalsIgnoreCase("580")) {
				ExtentUtility.getTest().log(LogStatus.PASS, " ARG Has been Generated Successfully ARG Has been Generated Successfully",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else if (Val.equalsIgnoreCase("999")) {
				System.out.println("inside 999");
				ExtentUtility.getTest().log(LogStatus.PASS, " Sale Batch Submission in SOP - 999 Batch has been Submitted and status changed to 999",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			} else {
				ExtentUtility.getTest().log(LogStatus.FAIL, " Sale Batch Submission in SOP not in expected status",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
		} catch (

		Exception ex) {
			System.out.println("verifyREcordsPresentForSale" + ex);

		}
		return new SOPEnquiryPage(remoteDriver);
	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
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
		rowValue = remoteDriver.findElement(By.xpath("//tr[@id='G0_41_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.getText();
		return rowValue;
	}

}
