package com.mop.qa.pageobject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;


public class WorkWithPropertyPage extends PageBase {
	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Item Number'])[2]")
	private WebElement itemNumber;

	@FindBy(xpath = "(//*[@title='Department'])[2]")
	private WebElement dept;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumberforInventory;

	@FindBy(xpath = "//input[@title='Pre Dimension Phrase']")
	private WebElement preDimPhase;

	@FindBy(xpath = "//input[@title='Display Inventory Status']")
	private WebElement inventoryCheckBox;

	@FindBy(xpath = "//input[@title='Pre Weight Phrase']")
	private WebElement preWeightPhrase;

	@FindBy(xpath = "//input[@title='Post Weight Phrase']")
	private WebElement postWeightPhrase;

	@FindBy(xpath = "//input[@title='Height']")
	private WebElement height1;

	@FindBy(xpath = "//input[@title='Weight']")
	private WebElement weight;

	@FindBy(xpath = "//input[@title='Width']")
	private WebElement width1;

	@FindBy(xpath = "//input[@title='Depth']")
	private WebElement depth1;

	@FindBy(xpath = "//input[@title='Diameter']")
	private WebElement dia1;

	@FindBy(xpath = "//input[@title='UM']")
	private WebElement UM1;

	@FindBy(xpath = "//input[@title='Alt UM']")
	private WebElement altUM1;

	@FindBy(xpath = "//input[@title='Post Dimension Phrase']")
	private WebElement postDimPhrase;

	@FindBy(xpath = "//*[@id='gtab0_1']")
	private WebElement dropDown;

	@FindBy(xpath = "(//*[@title='Sale Site'])[2]")
	private WebElement saleSite;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']") 
	private WebElement rowExit;
	
	@FindBy(xpath = "//*[@id='REPORT_EXIT_BUTTON']") 
	private WebElement reportExit;
	
	@FindBy(xpath = "//nobr[contains(text(),'Charges')]")
	private WebElement charges;

	@FindBy(xpath = "//*[@id='HE0_107']/tbody/tr/td[2]/span/nobr")
	private WebElement returnToOwner;

	@FindBy(xpath = "//table[@id='HE0_157']/tbody/tr/td[2]/span/nobr")
	private WebElement sopr;

	@FindBy(xpath = "//*[@id='HE0_156']/tbody/tr/td[2]/span/nobr")
	private WebElement soCharge;

	@FindBy(xpath = "//*[@id='HE0_158']/tbody/tr/td[2]/span/nobr")
	private WebElement sopo;
	

	@FindBy(xpath = "//*[@id='SubMenu_HE0_224']/span/nobr")
	private WebElement condtRpt;
	
	@FindBy(xpath = "//*[@id='HE0_230']/tbody/tr/td[2]/span/nobr")
	private WebElement condtOnly;
	
	
	@FindBy(xpath = "//div[contains(text(),'CCSA')]")
	private WebElement ccsa;

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement cc;

	@FindBy(xpath = "(//span[contains(text(),'Charges')])[2]")
	private WebElement selectCharges;

	@FindBy(xpath = "(//a[contains(text(),'SOP Enquiry')])[2]")
	private WebElement sopEnquiry;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='drop_mainmenu']")
	private WebElement mainMenu;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement checkBoxSelectAll;

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

	@FindBy(xpath = "(//input[@title='Department'])[1]")
	private WebElement departmentField;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//button[contains(text(),'Hilling')]")
	private WebElement hilling;

	@FindBy(xpath = "//button[contains(text(),'Photo')]")
	private WebElement photo;

	@FindBy(xpath = "//input[@title='To Be Hilled']")
	private WebElement toBEHilled;

	@FindBy(xpath = "//input[@title='To Be Photographed']")
	private WebElement toBePhoto;

	@FindBy(xpath = "//input[@title='Category Description']")
	private WebElement categoryDesc;

	// input[@title='Category Description']

	@FindBy(xpath = "//textarea[@title='General Text']")
	private WebElement gneralText;

	@FindBy(xpath = "//*[@class='RCUXComboBox']")
	private WebElement selectVal;

	@FindBy(xpath = "//input[@title='AT 06 Val 1']")
	private WebElement material;

	@FindBy(xpath = "//input[@title='AT 01 Val 1']")
	private WebElement dateVal;

	@FindBy(xpath = "//input[@title='AT 02 Val 1']")
	private WebElement style;

	@FindBy(xpath = "//input[@title='AT 03 Val 1']")
	private WebElement origin;

	@FindBy(xpath = "//input[@title='AT 04 Val 1']")
	private WebElement artist;

	@FindBy(xpath = "//input[@title='AT 05 Val 1']")
	private WebElement design;

	@FindBy(xpath = "//input[@title='AT 07 Val 1']")
	private WebElement type;

	@FindBy(xpath = "//input[@title='Sale Site']")
	private WebElement SaleSite;

	@FindBy(xpath = "//input[@title='AT 08 Val 1']")
	private WebElement object;

	@FindBy(xpath = "//button[@title='Ctrl+Alt+V']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[contains(text(),'Edit Catalogue Text')]")
	private WebElement editCatText;

	@FindBy(xpath = "//input[@title='Return Date']")
	private WebElement dateVal1;

	@FindBy(xpath = "//input[@title='Return Reason']")
	private WebElement returReason;

	@FindBy(xpath = "//input[@title='Return Notes']")
	private WebElement returnNotes;

	@FindBy(xpath = "//button[contains(text(),'Return To Owner')]")
	private WebElement retrunOwner;

	@FindBy(xpath = "//img[@name='hc_OK']")
	private WebElement saveButton1;
	
	@FindBy(xpath = "//*[@id='listRecRptsHeader']/div[2]/a")
	private WebElement refreshButton;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement jobField;
	
	@FindBy(xpath = "//*[@id='G0_1_R0']/td[8]/div")
	private WebElement checkStatusAfterReport;

	TestBase test = new TestBase();

	public WorkWithPropertyPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		
	}
	
	public void generateConditionReport() throws InterruptedException, IOException{
		System.out.println("generateConditionReport navigateWorkWithProperty");
		try{
		remoteDriver.switchTo().frame(iframe);
		String itemNumb = rds.getValue("LCT", test.currentTest, "ItemNumber");	
		enterText(itemNumber, itemNumb, "itemNumber");
		click(find, "find");
		Thread.sleep(2000);
		click(reportExit, "reportExit");
		Thread.sleep(1000);
		moveToElement(returnToOwner, "returnToOwner");
		moveToElement(condtRpt, "condtRpt");
		moveToElement(condtOnly, "condtOnly"); 
		Thread.sleep(1000);
		click(saveButton1, "saveButton1");
		
		remoteDriver.switchTo().defaultContent();
		click(refreshButton, "refreshButton");
		Thread.sleep(8000);
		click(viewJobStatus, "viewJobStatus");
		Thread.sleep(3000);
		
		remoteDriver.switchTo().frame(iframe);
		enterText(jobField, "*R57PA36*", "jobField");
		click(searchButton, "searchButton");
		Thread.sleep(3000); 
		remoteDriver.switchTo().defaultContent();
		if (checkStatusAfterReport.getText().equalsIgnoreCase("D")) {
			assertTrue(checkStatusAfterReport.getText().equalsIgnoreCase("D"), "ConditionReport Report Generated");
			System.out
					.println("Report Generated Succesfully Check for Status");
			ExtentUtility.getTest().log(LogStatus.PASS, "Report Generated Succesfully Check for Status",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		
		} catch (Exception ex) {
			System.out.println("Navigate to navigateWorkWithProperty" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in generating ConditionReport",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}  
		
	}

	public void retrunToOwner() {
		try {
			System.out.println("retrunToOwner navigateWorkWithProperty");
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			FileInputStream ios = new FileInputStream("D:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(0);

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			System.out.println("listStrings1" + listStrings1);

			for (int i = 0; i < listStrings1.size(); i++) {
				enterText(saleSite, "*", "saleSite");
				Thread.sleep(2000);
				Actions action = new Actions(remoteDriver);
				action.sendKeys(Keys.TAB).build().perform();
				enterText(departmentField, "*", "departmentField");
				Thread.sleep(2000);
				enterText(itemNumber, listStrings1.get(i), "itemNumber");
				click(find, "find");
				click(checkBoxSelectAll, "checkBoxSelectAll");
				Thread.sleep(3000);
				click(rowExit, "rowExit");
				Thread.sleep(1000);
				moveToElement(returnToOwner, "returnToOwner");
				Thread.sleep(1000);

				Date currentDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
				String strTodaysDate = dateFormat.format(currentDate);
				Thread.sleep(2000);
				enterText(dateVal1, strTodaysDate, "dateVal1");
				Thread.sleep(2000);
				String retrunReason = rds.getValue("SellerAgreement_Data", test.currentTest, "RetrunReason"); 

				System.out.println("retrunReason" + retrunReason);
				enterText(returReason, retrunReason, "returReason");

				Thread.sleep(2000);
				String retrunNotes = rds.getValue("General_Data", test.currentTest, "RetrunNotes"); 
				System.out.println("retrunNotes" + retrunNotes);
				enterText(returnNotes, retrunNotes, "returnNotes");
				Thread.sleep(2000);
				enterText(saleSite, "CKS", "saleSite");
				Thread.sleep(2000);
				click(retrunOwner, "retrunOwner");
				Thread.sleep(1000);

				System.out.println("before autiit");
				Runtime.getRuntime()
						.exec("C:\\Users\\235222\\Desktop\\christies\\closePopUp.exe");

			}

		} catch (Exception ex) {
			System.out.println("Navigate to navigateWorkWithProperty" + ex);
		}
	}
	
	public void checkPageLoad(){
		try {
			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);
			elementIsDisplayed(itemNumber, "itemNumber");
		}catch (Exception ex) {
			System.out.println("getBarcode Navigating Work With Property" + ex);

		} 
	}

	public void getBarcode() {
		try {
			System.out.println("getBarcode navigateWorkWithProperty");


			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// dataTable.getData("General_Data","ChargeItemNo");
			String itemNo  = getJDEAppProperties("ChargeItemNo");

			departmentField.clear();
			Thread.sleep(2000);
			saleSite.clear();
			Thread.sleep(2000);
			enterText(itemNumber, itemNo, "itemNumber");
			click(searchButton, "searchButton");


			String barcodeValue = getValues("Barcode", 0);
			// dataTable.putData("General_Data", "Barcode", barcodeValue);
			propertiesJdeWrite("Barcode", barcodeValue);
			click(closeButton,"closeButton");
			Thread.sleep(3000);
			remoteDriver.switchTo().defaultContent();

			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("getBarcode Navigating Work With Property" + ex);

		}
	}

	public void checkInventoryStatus() {
		try {
			System.out.println("checkinverntoyStatus navigateWorkWithProperty");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// dataTable.getData("General_Data","ChargeItemNo");
			String itemNo  = getJDEAppProperties("ChargeItemNo");
			String itemNo1  = getJDEAppProperties("ItemNumber");

			departmentField.clear();
			Thread.sleep(2000);
			saleSite.clear();
			Thread.sleep(2000);
			enterText(itemNumber, itemNo1, "itemNumber");
			click(inventoryCheckBox, "inventoryCheckBox");
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			String fieldName = "Inventory Status";
			String inventoryStatusValue = getValues(fieldName, 0);
			System.out.println(inventoryStatusValue);

			if (inventoryStatusValue.equalsIgnoreCase("600")) {
				System.out.println("Site Transfer successful");
				ExtentUtility.getTest().log(LogStatus.PASS, " Inventory Status update to " + inventoryStatusValue + " successful",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Inventory Status update failed");
				ExtentUtility.getTest().log(LogStatus.FAIL, " Inventory Status update to " + inventoryStatusValue + " failed",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

			// dataTable.putData("General_Data", "InventoryStatus",
			// inventoryStatusValue);
			click(closeButton, "closeButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatusForSite Transfer Navigating Work With Property"
							+ ex);

		}
	}

	public void getInventoryStatusForCollection() {
		try {
			System.out
					.println("getInventoryStatusForCollection navigateWorkWithProperty");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// dataTable.getData("General_Data","ChargeItemNo");
			String itemNo = getJDEAppProperties("ChargeItemNo");

			departmentField.clear();
			Thread.sleep(2000);
			saleSite.clear();
			Thread.sleep(2000);
			
			enterText(itemNumber, itemNo, "itemNumber");

			inventoryCheckBox.click();
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			String fieldName = "Inventory Status";
			String inventoryStatusValue = getValues(fieldName, 0);
			System.out.println(inventoryStatusValue);

			if (inventoryStatusValue.equalsIgnoreCase("700")) {
				System.out.println("Inventory Status update successful");
				ExtentUtility.getTest().log(LogStatus.PASS, " Inventory Status update to " + inventoryStatusValue + " successful",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Inventory Status update failed");
				ExtentUtility.getTest().log(LogStatus.FAIL, " Inventory Status update to " + inventoryStatusValue + " failed",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

			// dataTable.putData("General_Data", "InventoryStatus",
			// inventoryStatusValue);
			propertiesJdeWrite("InventoryStatus",inventoryStatusValue);

			click(closeButton, "closeButton");

			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatusForCollection Navigating Work With Property"
							+ ex);

		}
	}

	public void getInventoryStatusForDeCollection() {
		try {
			System.out
					.println("getInventoryStatusForDeCollection navigateWorkWithProperty");


			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// dataTable.getData("General_Data","ChargeItemNo");
			String itemNo = getJDEAppProperties("ChargeItemNo");

			departmentField.clear();
			Thread.sleep(2000);
			saleSite.clear();
			Thread.sleep(2000);
			enterText(itemNumber, itemNo, "itemNumber");

			click(inventoryCheckBox, "inventoryCheckBox");
			click(searchButton, "searchButton");

			Thread.sleep(3000);

			String fieldName = "Inventory Status";
			String inventoryStatusValue = getValues(fieldName, 0);
			System.out.println(inventoryStatusValue);

			if (inventoryStatusValue.equalsIgnoreCase("300")) {
				System.out.println("Inventory Status update successful");
				ExtentUtility.getTest().log(LogStatus.PASS, " Inventory Status update to " + inventoryStatusValue + " successful",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				System.out.println("Inventory Status update failed");
				ExtentUtility.getTest().log(LogStatus.FAIL, " Inventory Status update to " + inventoryStatusValue + " failed",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}

			// dataTable.putData("General_Data", "InventoryStatus",
			// inventoryStatusValue);
			propertiesJdeWrite(inventoryStatusValue, "InventoryStatus");
			click(closeButton, "closeButton");
			Thread.sleep(2000);

			remoteDriver.switchTo().defaultContent();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatusForDeCollection Navigating Work With Property"
							+ ex);

		}
	}

	public void getInventoryStatusForOutbound() {
		try {
			System.out
					.println("getInventoryStatusForOutbound navigateWorkWithProperty");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);
			String ItemNumber = getJDEAppProperties("ItemNumber");

			enterText(itemNumberforInventory, ItemNumber, "itemNumberforInventory");
			departmentField.clear();
			inventoryCheckBox.click();
			saleSite.clear();
			click(find, "find");
			Thread.sleep(4000);

			String fieldName = "Inventory Status";
			String inventoryStatusValue = getValues(fieldName, 0);

			System.out.println(inventoryStatusValue);

			Thread.sleep(3000);

			if ((inventoryStatusValue.equalsIgnoreCase("200"))
					|| (inventoryStatusValue.equalsIgnoreCase("250"))) {
				propertiesJdeWrite("SBInventoryStatus", inventoryStatusValue); 
				
				System.out.println("Outbound has arrived or located");
			} else {
				System.out
						.println("Inventory status is not matching for Outbound");
			}
			click(closeButton, "closeButton");
			remoteDriver.switchTo().defaultContent();
			System.out.println("close button is pressed");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatus Navigating Work With Property"
							+ ex);

		}
	}

	public WorkWithChargeDetailPage createChargeFromProperty(String chargeType)
			throws InterruptedException {
		try {
			Thread.sleep(5000);

			remoteDriver.switchTo().frame(iframe);
			itemNumber.clear();
			String itemNo = rds.getValue("P2P", test.currentTest, "ItemNumber");
            enterText(itemNumber, itemNo, "itemNumber");
			dept.clear();
			saleSite.clear();
			click(find, "find");
			Thread.sleep(5000);
			click(checkBox, "checkBox");
			click(rowExit, "rowExit");
			Thread.sleep(3000);
			moveToElement(charges, "charges");
			Thread.sleep(3000);
			if (chargeType.equalsIgnoreCase("SOPR")) {
				moveToElement(sopr, "sopr");
				click(sopr, "sopr");
				Thread.sleep(5000);
			} else if (chargeType.equalsIgnoreCase("SOPO")) {
				moveToElement(sopo, "sopo");
				click(sopo,"sopo");
				Thread.sleep(3000);
			} else if (chargeType.equalsIgnoreCase("SO")) {
				moveToElement(soCharge, "soCharge");
				click(soCharge, "soCharge");
				Thread.sleep(3000); 
			}
			System.out.println("Creating charge from property");
		} catch (Exception ex) {
			System.out.println("Navigate to WorkWithChargeDetailPage" + ex);

		}
		return new WorkWithChargeDetailPage(remoteDriver);
	}

	public SOPEnquiryPage verifySOCreation() throws Exception {
		// driver.switchTo().frame(iframe);
		remoteDriver.switchTo().defaultContent();
		Thread.sleep(5000);
		// cc.click();
		/*
		 * mainMenu.click(); Actions action = new Actions(driver);
		 * Thread.sleep(3000); action.moveToElement(
		 * driver.findElement(By.xpath(
		 * "//span[contains(text(),'Christie') and contains(text(),'London')]"
		 * ))) .click().build().perform();
		 * action.moveToElement(driver.findElement
		 * (By.xpath("(//span[text()='CCSA'])[2]"))).click().build().perform();
		 * Thread.sleep(5000);
		 */
		click(ccsa, "ccsa");
		moveToElement(selectCharges, "selectCharges");
		click(selectCharges, "selectCharges");
		moveToElement(sopEnquiry, "sopEnquiry");
		click(sopEnquiry, "sopEnquiry");  
		Thread.sleep(3000);
		return new SOPEnquiryPage(remoteDriver);
	}

	public void docataloging() {
		try {

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(5000);
			System.out.println("docataloguing");
			// driver.switchTo().frame(iframe);

			FileInputStream ios = new FileInputStream("d:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowS = sheet.getPhysicalNumberOfRows();
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			ArrayList<String> listStrings4 = new ArrayList<String>();
			ArrayList<String> listStrings5 = new ArrayList<String>();
			ArrayList<String> listStrings6 = new ArrayList<String>();
			ArrayList<String> listStrings7 = new ArrayList<String>();
			ArrayList<String> listStrings8 = new ArrayList<String>();
			ArrayList<String> listStrings9 = new ArrayList<String>();
			ArrayList<String> listStrings10 = new ArrayList<String>();
			ArrayList<String> listStrings11 = new ArrayList<String>();
			ArrayList<String> listStrings12 = new ArrayList<String>();
			ArrayList<String> listStrings13 = new ArrayList<String>();
			ArrayList<String> listStrings14 = new ArrayList<String>();

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(3, sheet, ios);
			listStrings5 = extractExcelContentByColumnIndex(4, sheet, ios);
			listStrings6 = extractExcelContentByColumnIndex(5, sheet, ios);
			listStrings7 = extractExcelContentByColumnIndex(6, sheet, ios);
			listStrings8 = extractExcelContentByColumnIndex(7, sheet, ios);
			listStrings9 = extractExcelContentByColumnIndex(8, sheet, ios);
			listStrings10 = extractExcelContentByColumnIndex(9, sheet, ios);
			listStrings11 = extractExcelContentByColumnIndex(10, sheet, ios);
			listStrings12 = extractExcelContentByColumnIndex(11, sheet, ios);
			listStrings13 = extractExcelContentByColumnIndex(12, sheet, ios);
			listStrings14 = extractExcelContentByColumnIndex(13, sheet, ios);

			for (int i = 0; i <= listStrings1.size() - 1; i++) {
				enterText(itemNumber, listStrings1.get(i), "itemNumber");

				dept.clear();
				saleSite.clear();
				click(find, "find");
				Thread.sleep(5000);
				click(checkBox, "checkBox");
				click(select, "select");
				Thread.sleep(3000);

				// Enter Hilling text
				click(hilling, "hilling");
				Thread.sleep(3000);
				click(toBEHilled, "toBEHilled");
				enterText(gneralText, listStrings2.get(i), "gneralText");
				click(save, "save");
				Thread.sleep(3000);

				// Enter Photo text
				click(photo, "photo");
				Thread.sleep(3000);
				if (toBePhoto.isSelected()) {
					click(toBePhoto, "toBePhoto");

				}
				enterText(gneralText, listStrings3.get(i), "gneralText");
				click(save, "save");
				Thread.sleep(3000);

				// Chart of Art Text
				selectOPtionByVisibleText(selectVal, listStrings4.get(i));
				Thread.sleep(3000);
				
				enterText(categoryDesc, listStrings6.get(i), "categoryDesc");
				click(saveButton, "saveButton");
				Thread.sleep(3000);
				
				enterText(dateVal, listStrings7.get(i), "dateVal");

				Thread.sleep(2000);
				enterText(style, listStrings8.get(i), "style");
	
				Thread.sleep(2000);
				
				enterText(origin, listStrings9.get(i), "origin");

				Thread.sleep(2000);
				
				enterText(artist, listStrings10.get(i), "artist");
				enterText(design, listStrings11.get(i), "design");

				enterText(material, listStrings12.get(i), "material");

				Thread.sleep(2000);
				enterText(type, listStrings13.get(i), "type");

				Thread.sleep(2000);
				enterText(object, listStrings14.get(i), "object");

				Thread.sleep(2000);
				click(saveButton, "saveButton");
				Thread.sleep(3000);

				/*
				 * select=new Select(selectVal); String
				 * tabVal2=dataTable.getData("Catalogue_Data","SelectTabVal2");
				 * select.selectByVisibleText(tabVal2); Thread.sleep(1000);
				 * editCatText.click(); Thread.sleep(1000);
				 */
				Thread.sleep(3000);
			}
		} catch (Exception ex) {
			System.out.println("Cataloging Navigating Work With Property" + ex);

		}

	}

	public ArrayList<String> extractExcelContentByColumnIndex(int columnIndex,
			Sheet sheet, FileInputStream ios) {
		ArrayList<String> columndata = null;
		try {
			int rowCount = sheet.getPhysicalNumberOfRows();
			Iterator<Row> rowIterator = sheet.iterator();
			columndata = new ArrayList<>();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (row.getRowNum() > 0) { // To filter column headings
						if (cell.getColumnIndex() == columnIndex) {// To match
																	// column
																	// index
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								System.out.println("CELL_TYPE_NUMERIC");
								columndata.add(cell.getNumericCellValue() + "");
								break;

							case Cell.CELL_TYPE_STRING:
								System.out.println("CELL_TYPE_STRING");
								columndata.add(cell.getStringCellValue());
								break;
							}
						}
					}
				}
			}
			System.out.println(columndata);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return columndata;
	}

	public void saleRoomNotice() {

	}

	public GenerateChargeOrderRequisiton ViewJobStatusWorkWithProperty(
			String chargeType) throws IOException {
		try {
			System.out.println("ViewJobStatus navigateWorkWithProperty");
			click(viewJobStatus, "viewJobStatus");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe); 
			moveToElement(submittedJobs, "submittedJobs");
			click(submittedJobs, "submittedJobs"); 
			
			//click(submittedJobs, "submittedJobs");
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
			closeButton.click();
			// Thread.sleep(3000); 
			// closeButton.click();
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("ViewJobStatus Navigating Work With Property"
					+ ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "ViewJobStatusWorkWithProperty",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new GenerateChargeOrderRequisiton(remoteDriver);
	}

	public void getInventoryStatus(List<String> itemNumber) {
		try {
			System.out.println("getInventoryStatus navigateWorkWithProperty");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// String
			// itemNumber=functionallibraries.FunctionalLibrary.propertiesRead("ItemNumber");
			for (int i = 0; i < itemNumber.size(); i++) {
				enterText(itemNumberforInventory, itemNumber.get(i), "itemNumberforInventory");

				departmentField.clear();
				Thread.sleep(2000);
				if (!inventoryCheckBox.isSelected()) {
					click(inventoryCheckBox, "inventoryCheckBox");
				}
				Thread.sleep(2000);
				click(find, "find");
				Thread.sleep(4000);

				String fieldName = "Inventory Status";
				String inventoryStatusValue = getValues(fieldName, 0);

				System.out.println(inventoryStatusValue);

				Thread.sleep(3000);
				
				String invenArr = rds.getValue("General_Data", test.currentTest, "InventoryArrived");
				String invenMoved = rds.getValue("General_Data", test.currentTest, "InventoryMoved");


				if (inventoryStatusValue.equalsIgnoreCase(invenArr)) {
					ExtentUtility.getTest().log(LogStatus.PASS, "The item has been successfully Arrived",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} else if (inventoryStatusValue.equalsIgnoreCase(invenMoved)) {
					ExtentUtility.getTest().log(LogStatus.PASS, "The item has been successfully Moved",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} else {
					ExtentUtility.getTest().log(LogStatus.FAIL, "Issue in The item has been Arrival/Movement",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
				click(closeButton, "closeButton");
				remoteDriver.switchTo().defaultContent();
				System.out.println("close button is pressed");
				Thread.sleep(3000);
			}
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatus Navigating Work With Property"
							+ ex);
		}

	}

	public void getInvenStat(List<String> itemNumber) {
		try {
			System.out.println("getInvenStat navigateWorkWithProperty");

			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			// String
			// itemNumber=functionallibraries.FunctionalLibrary.propertiesRead("ItemNumber");
			for (int i = 2; i < itemNumber.size(); i++) {
				enterText(itemNumberforInventory, itemNumber.get(i), "itemNumberforInventory");
				departmentField.clear();
				Thread.sleep(2000);
				if (!inventoryCheckBox.isSelected()) {
					click(inventoryCheckBox, "inventoryCheckBox");
				}
				Thread.sleep(2000);
				click(find, "find");
				Thread.sleep(4000);

				String fieldName = "Inventory Status";
				String inventoryStatusValue = getValues(fieldName, 0);
				System.out.println(inventoryStatusValue);

				Thread.sleep(3000);
				
				String invenArr = rds.getValue("General_Data", test.currentTest, "InventoryArrived");
				String invenMoved = rds.getValue("General_Data", test.currentTest, "InventoryMoved");

				if (inventoryStatusValue.equalsIgnoreCase(invenArr)) {
					ExtentUtility.getTest().log(LogStatus.PASS, "The item has been successfully Arrived",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} else if (inventoryStatusValue.equalsIgnoreCase(invenMoved)) {
					ExtentUtility.getTest().log(LogStatus.PASS, "The item has been successfully Moved",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				
				} else {
					ExtentUtility.getTest().log(LogStatus.FAIL, "Issue in The item has been Arrival/Movement",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
				}
				// /closeButton.click();
			}
		}

		catch (Exception ex) {
			System.out
					.println("getInventoryStatus Navigating Work With Property"
							+ ex);
		}
	}

	public ArrayList<ArrayList<String>> search(List<String> itemNumber)
			throws Exception {
		System.out.println("inside k itemNumber" + itemNumber);
		remoteDriver.switchTo().frame(iframe);
		selectOPtionByVisibleText(dropDown, "Show All Columns");

		Thread.sleep(3000);
		ArrayList<String> barLsit = new ArrayList<String>();
		ArrayList<String> poSoForArr = new ArrayList<String>();
		ArrayList<ArrayList<String>> ArrayList2 = new ArrayList<ArrayList<String>>();
		String fieldName;
		List<WebElement> webEle4 = remoteDriver.findElements(By
				.className("JSGridHeaderCell"));
		// change value of i back to 0
		for (int i = 0; i < itemNumber.size(); i++) {
			System.out.println("itemNumber" + itemNumber.get(i));
			Thread.sleep(2000);
			
			enterText(itemNumberforInventory, itemNumber.get(i), "itemNumberforInventory");
			departmentField.clear();
			saleSite.clear();
			click(find, "find");
			Thread.sleep(1000);
			fieldName = "Barcode";
			String barcode = getValues(fieldName, 0);
			barLsit.add(barcode);
			System.out.println("barLsit" + barLsit);

			fieldName = "Related PO/SO No";
			String PoSo = getValues(fieldName, 0);
			poSoForArr.add(PoSo);
			System.out.println("poSoForArr" + poSoForArr);

			ArrayList2.add(barLsit);
			ArrayList2.add(poSoForArr);
			WebElement element = webEle4.get(0);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
		}
		return ArrayList2;
	}

	public String getBarcode(String itemNumber) throws InterruptedException {
		Thread.sleep(4000);
		String fieldName = "Barcode";
		String barcode = getValues(fieldName, 0);
		System.out.println("barcode");
		return barcode;
	}

	public void getInventoryStatus() {
		try {
			System.out.println("getInventoryStatus navigateWorkWithProperty");


			remoteDriver.switchTo().frame(iframe);
			Thread.sleep(2000);

			String itemNumber = getJDEAppProperties("ItemNumber");

			// String itemNumber = dataTable.getData("General_Data",
			// "ItemNumber");
			enterText(itemNumberforInventory, itemNumber, "itemNumberforInventory");


			departmentField.clear();
			click(inventoryCheckBox, "inventoryCheckBox");

			SaleSite.clear();
			click(find, "find");
			Thread.sleep(3000);

			String fieldName = "Inventory Status";
			String inventoryStatusValue = getValues(fieldName, 0);

			System.out.println(inventoryStatusValue);

			Thread.sleep(3000);
			propertiesJdeWrite("InventoryStatus", inventoryStatusValue);
			click(closeButton, "closeButton");

			remoteDriver.switchTo().defaultContent();
			System.out.println("close button is pressed");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("getInventoryStatus Navigating Work With Property"
							+ ex);

		}

	}

	public String getValues(String fieldName, int RowCount)
			throws InterruptedException {
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
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div")).getText();
		Thread.sleep(3000);
		System.out.println("rowValue" + rowValue);
		return rowValue;
	}

	public void getOrderNumberFromPdf(String chargeType) {

		String dirPath = "C:\\Users\\235222\\Downloads";
		String fileName = getLatestFilefromDir(dirPath).getName();
		System.out.println(fileName);
		String propertyFileName = "Data.properties";

		String strFilepath = System.getProperty("user.home") + "\\Downloads\\"
				+ fileName;
		int k = 0;
		String pdfOut;
		pdfOut = pageText(1, 1, strFilepath);

		System.out.println(pdfOut);

		String[] splitArray = pdfOut.split("\n");
		String ORNoOtpt = splitArray[splitArray.length - 1];
		String SVNoOtpt = splitArray[splitArray.length - 2];

		String OrderValue = getOROWnumber(ORNoOtpt, chargeType);
		String SVNumber = getSVnumber(SVNoOtpt);
		// Properties prop = new Properties();
		// OutputStream output = null;
		// prop.setProperty("SVNumber",SVNumber);
		// prop.setProperty("OrderValue",OrderValue);
		/*
		 * try { prop.store(new FileWriter("data.properties"), "Data Property");
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		propertiesJdeWrite("SVNumber", SVNumber);
		propertiesJdeWrite("OrderValue", OrderValue);

		// functionallibraries.FunctionalLibrary.propertiesWrite("OrderValue11",
		// OrderNumber);

		System.out.println("data has been inputted");

	}

	private String getOROWnumber(String ORNoOtpt, String chargeType) {
		String OrderNumber = null;
		if (ORNoOtpt.contains("OW") && chargeType.equalsIgnoreCase("SOPO")) {
			String[] ORNoArray = ORNoOtpt.split(" ");

			// System.out.println(ORNoArray.length);
			// System.out.println(ORNoArray[2]);

			int orLocation = 0;
			for (int i = 0; i < ORNoArray.length; i++) {
				if (ORNoArray[i].equalsIgnoreCase("OW")) {
					orLocation = i;
				}
			}

			if (orLocation > 0) {
				System.out.println("Order number is "
						+ ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}
		} else if (ORNoOtpt.contains("OR")
				&& chargeType.equalsIgnoreCase("SOPR")) {
			String[] ORNoArray = ORNoOtpt.split(" ");

			// System.out.println(ORNoArray.length);
			// System.out.println(ORNoArray[2]);

			int orLocation = 0;
			for (int i = 0; i < ORNoArray.length; i++) {
				if (ORNoArray[i].equalsIgnoreCase("OR")) {
					orLocation = i;
				}
			}

			if (orLocation > 0) {
				System.out.println("Order number is "
						+ ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}

			else {
				System.out.println("No order number is present");
				OrderNumber = null;
			}
		}
		return OrderNumber;
	}

	private String getSVnumber(String SVNoOtpt) {
		String SVNumber = null;
		if (SVNoOtpt.contains("SV")) {
			String[] SVNoArray = SVNoOtpt.split(" ");
			// System.out.println(SVNoArray.length);
			// System.out.println(SVNoArray[2]);

			int svLocation = 0;
			for (int i = 0; i < SVNoArray.length; i++) {
				if (SVNoArray[i].equalsIgnoreCase("SV")) {
					svLocation = i;
				}
			}

			if (svLocation > 0) {
				System.out.println("SV number is " + SVNoArray[svLocation + 1]);
				SVNumber = SVNoArray[svLocation + 1];
			}
		} else {
			System.out.println("No SV number is present");
			SVNumber = null;
		}
		return SVNumber;
	}

	public static String pageText(int startPage, int endPage, String strFilepath) {
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
			System.out
					.println("Exception Occured while reading the value from document"
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

}