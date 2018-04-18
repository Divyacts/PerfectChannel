package com.mop.qa.pageobject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;


import com.mop.qa.Utilities.DateObject;
import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;


public class WorkWithSaleHeaderPage extends PageBase {

	public WorkWithSaleHeaderPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public WorkWithSaleHeaderPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}


	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addSale;

	@FindBy(xpath = "//input[@title='Sale Site']") 
	private WebElement saleSite;

	@FindBy(xpath = "//input[@title='Sale Number']")
	private WebElement saleNumber;

	@FindBy(xpath = "//input[@title='Department']")
	private WebElement depart;

	@FindBy(xpath = "//input[@title='Title']")
	private WebElement title;

	@FindBy(xpath = "//input[@title='Sale Date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@title='To']")
	private WebElement endDate;

	@FindBy(xpath = "//input[@title='Main Sale Contact']")
	private WebElement saleCon;

	@FindBy(xpath = "//input[@title='Post Sale Contact']")
	private WebElement postSaleCon;

	@FindBy(xpath = "(//input[@title='Currency Information'])[2]")
	private WebElement currencyDate;

	@FindBy(xpath = "//input[@title='Auctioneer']")
	private WebElement acutioneer;

	@FindBy(xpath = "//input[@title='Sale Type']")
	private WebElement saleType;

	@FindBy(xpath = "//input[@title='Update To Sale Status']")
	private WebElement saleStat;

	@FindBy(xpath = "//input[@title='Sale Category']")
	private WebElement saleCat;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//*[@id='va0_21']")
	private WebElement img;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement close;

	@FindBy(xpath = "//input[@title='Business  Unit']")
	private WebElement bu;

	@FindBy(xpath = "//input[@title='Detail Entry']")
	private WebElement detailEntry;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(id = "modalIframe1")
	private WebElement iframe2;

	@FindBy(xpath = "//nobr[contains(text(),'Lotting Up')]")
	private WebElement lottingUp;

	@FindBy(xpath = "//nobr[contains(text(),'Registrations')]")
	private WebElement resgistration;

	@FindBy(xpath = "//nobr[contains(text(),'Bid Entry')]")
	private WebElement bidEntry;

	@FindBy(xpath = "//nobr[contains(text(),'Property Checklist')]")
	private WebElement proprCheckList;

	@FindBy(xpath = "//nobr[contains(text(),'Auction Results')]")
	private WebElement auctionResults;

	@FindBy(xpath = "//nobr[contains(text(),'Status Update')]")
	private WebElement statUpdate;

	@FindBy(xpath = "//nobr[contains(text(),'Currency Information')]")
	private WebElement currencyInfo;

	@FindBy(xpath = "//button[contains(text(),'Maintain')]")
	private WebElement maitainButton;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[1]")
	private WebElement firstArrow;
	// *[@id="jdehtmlGridDown"][1]

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div/input")
	private WebElement firstRow;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement alert;

	@FindBy(xpath = "//div[@id='jdeGridBack0_1']")
	private WebElement gridTop;

	@FindBy(xpath = "//input[@title='To Be Photographed']")
	private WebElement tobePhoto;

	@FindBy(xpath = "//input[@title='Props List Checked']")
	private WebElement proprCheck;

	@FindBy(xpath = "//input[@title='Catalogue Text Complete']")
	private WebElement catalogComplete;

	@FindBy(xpath = "(//button[contains(text(),'Update All')])[2]")
	private WebElement update2Button;

	@FindBy(xpath = "(//button[contains(text(),'Update All')])[3]")
	private WebElement update3Button;

	@FindBy(xpath = "(//button[contains(text(),'Update All')])[4]")
	private WebElement update4Button;
	
	@FindBy(xpath = "//input[@title='Online Sale']")
	private WebElement onlineSale;  
	
	@FindBy(xpath = "//*[@title='Online Sale (Alt+3)']")
	private WebElement onlineSaleTab;  
	
	@FindBy(xpath = "//input[@title='Start Time (HH:MM)']")
	private WebElement startTime;  
	
	@FindBy(xpath = "//input[@title='Lot Interval (HH:MM:SS)']")
	private WebElement lotInterval; 
	
	@FindBy(xpath = "//input[@title='Bid Increment Set Name']")
	private WebElement bidIncrement; 
 
	TestBase test = new TestBase();
	
	public DateObject createSale(ObjectOutputStream objectoutput,
			DateObject date) throws InterruptedException {
		String output = null;
		String output1 = null;
		try {
			Thread.sleep(5000);
			
			String saleSit = rds.getValue("General_Data", test.currentTest, "SaleSite");
			remoteDriver.switchTo().frame(iframe);
			addSale.click();
			//String currentTest= ctx.getCurrentXmlTest().getParameter("testname");
			//System.out.println(currentTest+ "is Running");
			
			String dept = rds.getValue("General_Data", test.currentTest, "Department");

			//System.out.println("saleSit" + saleSit);
			saleSite.clear();
			Thread.sleep(3000);
			saleSite.sendKeys(saleSit);
			Thread.sleep(5000);
			depart.clear();
			depart.sendKeys(dept);
			Thread.sleep(1000);
			
			String titl = rds.getValue("General_Data", test.currentTest, "Title");
			Thread.sleep(2000);
			//System.out.println("titl" + titl);
			title.clear();
			title.sendKeys(titl);
			Thread.sleep(2000);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 1); // Adding 1 day
			output = sdf.format(c.getTime());
			System.out.println("output" + output);
			Thread.sleep(2000);
			startDate.clear();
			startDate.sendKeys(output);
			Thread.sleep(2000);
			
			String contactSale = rds.getValue("General_Data", test.currentTest, "MainSaleContact");
			System.out.println("contactSale"+contactSale); 
			Thread.sleep(2000);
			saleCon.clear();
			saleCon.sendKeys(contactSale);
			
			String postContactSale = rds.getValue("General_Data", test.currentTest, "MainSaleContact");
			Thread.sleep(2000);
			postSaleCon.clear();
			postSaleCon.sendKeys(postContactSale);
			Thread.sleep(2000);
			acutioneer.clear();
			acutioneer.sendKeys(postContactSale);
			
			String saleCate = rds.getValue("General_Data", test.currentTest, "SaleCategory");
			Thread.sleep(1000);

			String cat = saleCate.replace(" ", "");
			cat = cat.trim();
			cat = cat.replaceAll("\\s+", "").trim();
			Thread.sleep(2000);
			saleCat.clear();
			saleCat.sendKeys(cat.trim());
			Thread.sleep(2000);
		
			String saleTyp = rds.getValue("General_Data", test.currentTest, "SaleType");
			saleType.sendKeys(saleTyp.trim());
			Thread.sleep(2000);
 
			Thread.sleep(2000);
			String saleNumb = saleNumber.getAttribute("value");
			System.out.println("saleNumb" + saleNumb);
			
			propertiesWrite("SaleNumber",saleNumb);   
			
			//dataTable.putData("General_Data", "SaleNumber", saleNumb);

			SimpleDateFormat sd1f = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.setTime(new Date()); // Now use today date.
			c1.add(Calendar.DATE, 1); // Adding 1 day
			output1 = sd1f.format(c1.getTime());
			Thread.sleep(2000);
			System.out.println("output1" + output1);
			Thread.sleep(2000);
			endDate.clear();
			endDate.sendKeys(output1);
			date.setDateVal(output);
			System.out.println("date" + date.getDateVal());
			objectoutput.writeObject(date);
			objectoutput.flush();
			objectoutput.close();
			returnObjectDate(date);

			if(saleTyp.trim().equalsIgnoreCase("Online")){ 
				ecomSale();  
			}
			 
			save.click();
			Thread.sleep(3000);
			save.click();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Create Sale firt Page" + ex);

		}
		return date;
	}
	
	
	public void performBidEntry() throws IOException {
		try {

			remoteDriver.switchTo().frame(iframe);
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			Thread.sleep(3000);
			click(rowExit, "rowExit");
			Actions action = new Actions(remoteDriver);
			action.moveToElement(bidEntry).click();
			action.build().perform();
			Thread.sleep(3000);
			click(addSale, "addSale");
			Thread.sleep(2000);
			click(detailEntry, "detailEntry");
			Thread.sleep(1000);

			ArrayList<String> list = new ArrayList<String>();
			list.add("Paddle Number");
			list.add("Lot Number");
			list.add("Bid Amount");
			list.add("Cur Cod");
			list.add("Bid Type");

			FileInputStream ios = new FileInputStream("d:\\Bidder_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(1);
			int rowS = sheet.getPhysicalNumberOfRows();
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			ArrayList<String> listStrings4 = new ArrayList<String>();
			ArrayList<String> listStrings5 = new ArrayList<String>();
			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(3, sheet, ios);
			// sheet = workbook.getSheetAt(0);
			listStrings5 = extractExcelContentByColumnIndex(4, sheet, ios);
			System.out.println("listStrings1" + listStrings1.size());
			System.out.println("listStrings2" + listStrings2.size());
			System.out.println("listStrings3" + listStrings3.size());
			System.out.println("listStrings4" + listStrings4.size());
			System.out.println("listStrings5" + listStrings5.size());

			for (int k = 0; k <= listStrings1.size() - 1; k++) {
				System.out.println(k);
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(listStrings5.get(k));
				list1.add(listStrings1.get(k));
				list1.add(listStrings2.get(k));
				list1.add(listStrings3.get(k));
				list1.add(listStrings4.get(k));
				System.out.println("list1" + list1);
				rowCreation(k, list, list1);
				List<WebElement> webEle2 = remoteDriver
						.findElements(By.className("JSGridHeaderCell"));
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				WebElement element3 = remoteDriver.findElement(By
						.xpath("//*[@id='G0_1_R" + (k) + "']/td[4]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
				Thread.sleep(3000);
			}

			if (isAlertPresent()) {
				click(save, "save");
				Thread.sleep(2000);
				click(save, "save");
				Thread.sleep(5000); 
			} else {
				click(save, "save");
				Thread.sleep(5000);
			}
			click(find, "find");
			Thread.sleep(5000);

			String row = rows.getText();
			ArrayList<String> newList = new ArrayList<>();
			String[] values = row.split("-");
			for (String str : values) {
				newList.add(str.trim());
				System.out.println("newList" + newList);
			}
			int rowCnt = Integer.parseInt(newList.get(1));
			System.out.println("rowCnt" + rowCnt);
			if (listStrings1.size() == rowCnt) {
				ExtentUtility.getTest().log(LogStatus.PASS, "Bid entry has been added Successfully for all the paddles",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} else {
				ExtentUtility.getTest().log(LogStatus.FAIL, "Bid entry has not been added for all the paddles",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			}
		} catch (Exception ex) {
			System.out.println("performBidEntry" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside performBidEntry WorkWithSaleHeaderPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}
	
	public WorkWithRegistrationPage performBidderRegistration()
			throws InterruptedException, IOException {
		try {

			remoteDriver.switchTo().frame(iframe);
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			Thread.sleep(3000);
			click(rowExit, "rowExit");
			Actions action = new Actions(remoteDriver);
			action.moveToElement(resgistration).click();
			action.build().perform();
			ExtentUtility.getTest().log(LogStatus.PASS, "performBidderRegistration",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			Thread.sleep(5000);
		} catch (Exception ex) {
			System.out.println("performLottingForSale" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "performBidderRegistration",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithRegistrationPage(remoteDriver);
	}
	

	public WorkWithAuctionResultsPage auctionResults() {
		try {

			remoteDriver.switchTo().frame(iframe);
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			Thread.sleep(3000);
			click(rowExit, "rowExit");
			moveToElement(auctionResults, "auctionResults");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("performBidEntry" + ex);

		}
		return new WorkWithAuctionResultsPage(remoteDriver);
	}

	
	
	public void ecomSale() throws Exception{
		click(onlineSale, "Online Sale CheckBox");
		click(onlineSaleTab, "Online Sale Tab"); 
		String saleStartTime = rds.getValue("General_Data", test.currentTest, "ESaleStartTime");
		String saleLotInterval = rds.getValue("General_Data", test.currentTest, "LotInterval");
		String bidIncr = rds.getValue("General_Data", test.currentTest, "BidIncrement");
		enterText(startTime, saleStartTime, "Start Time");
		enterText(lotInterval, saleLotInterval, "Lot Interval");
		enterText(bidIncrement, bidIncr, "Bid Increment");
	}  

	public DateObject returnObjectDate(DateObject date) {
		return date;
	}

	public void enterValues(String fieldName, int RowCount, String list1) {
		try {
			System.out.println("in enterValues");
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
			if (list1.equalsIgnoreCase("No Suffix")
					|| list1.contentEquals("TEL")) {
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.clear();

				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.sendKeys(" ");
			} else {
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.clear();
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.sendKeys(list1.toLowerCase());
			}
			Thread.sleep(1000);
			WebElement element3 = remoteDriver.findElement(
					By.xpath("//*[@id='G0_1_R" + RowCount + "']/td[@colindex='"
							+ colindexcolindexValue + "']/div/input"));
		} catch (

		Exception ex) {
			System.out.println("enterValues" + ex);

		}
	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) {
		System.out.println("in rowCreation" + count);
		for (int j = 0; j < list1.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
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

	public void propertyCheckList() throws InterruptedException {
		try {
			remoteDriver.switchTo().frame(iframe);
			
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			click(rowExit, "rowExit");
			click(proprCheckList, "proprCheckList");
			click(find, "find");
			click(tobePhoto, "tobePhoto");
			click(update2Button, "update2Button");
			click(tobePhoto, "tobePhoto");
			click(update2Button, "update2Button");
			click(proprCheck, "proprCheck");
			click(update3Button, "update3Button");
			click(catalogComplete, "catalogComplete");
			click(update4Button, "update4Button");
			click(save, "save");
			Thread.sleep(3000);
			
		} catch (Exception ex) {
			System.out.println("perform propertyCheckList" + ex);
			/*report.updateTestLog("Exception",
					"Exception inside propertyCheckList page", Status.FAIL);*/
		}
	}

	public void updateSaleStatus(String current, String updateTo)
			throws InterruptedException, IOException {
		try {
			String saleStatus;
			if (current.equalsIgnoreCase("10") || current.equalsIgnoreCase("50")
					|| current.equalsIgnoreCase("60")
					|| current.equalsIgnoreCase("65")) {
				remoteDriver.switchTo().frame(iframe);
			}
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			click(rowExit, "rowExit");
			moveToElement(statUpdate, "statUpdate");
			click(statUpdate, "statUpdate");
			Thread.sleep(5000);
			String fieldName1 = "Sale Status";
			saleStatus = getValues(fieldName1, 0);
			if (saleStatus.equalsIgnoreCase(current)) {
				enterText(saleStat, updateTo, "saleStat"); 
				Thread.sleep(2000);
			}
			click(select, "select");
			click(find, "find");
			click(close, "close");
 
			Thread.sleep(2000);
			saleStatus = getValues(fieldName1, 0);
			if (saleStatus.equalsIgnoreCase(updateTo)) {
				
				ExtentUtility.getTest().log(LogStatus.PASS, 
						"Sale status has been successfully update from "
								+ current + " to " + updateTo + "",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	
			}
		} catch (Exception ex) {
			System.out.println("perform updateSaleStatus" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Sale status has been successfully update from "
							+ current + " to " + updateTo + "",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 

		}
	}

	public void updateCurrencyDate() throws InterruptedException, IOException {
		try {
			String saleNum = getJDEAppProperties("SaleNumber");
			// driver.switchTo().frame(iframe);
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			click(rowExit, "rowExit");
			moveToElement(currencyInfo, "currencyInfo");
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(3000);
			enterText(currencyDate, strTodaysDate, "currencyDate");

			Thread.sleep(1000);
			click(save, "save");

			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.PASS, "Updating currency date sucessful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
		}

		catch (Exception ex) {
			System.out.println("perform updateCurrencyDate" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in Updating currency date",
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
		rowValue = remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.getText();
		return rowValue;
	}

	
	public String isSaleCreated() throws InterruptedException, IOException {
		String sale = null;
		try {
			remoteDriver.switchTo().frame(iframe);
			String saleNum = getJDEAppProperties("SaleNumber"); 
			enterText(saleNumber, saleNum, "SaleNumber");
			click(find,"find");
			Thread.sleep(3000); 
			sale = getValues("Sale Number", 0);
			ExtentUtility.getTest().log(LogStatus.PASS, "Sale is created",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("isSaleCreated" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in sale creation",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
		}
		return sale; 
	}

	public String FilesListFromFolder() {
		String fname = null;
		File file = new File("D:\\QC_ScreenShot");
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(f.getName());
			if (f.getName().contains("TC11")) {
				fname = f.getName();
			}

		}
		return fname;
	}

	public void performLottingForSale() throws InterruptedException, IOException {
		try {

			remoteDriver.switchTo().frame(iframe);
			String saleNum = getJDEAppProperties("SaleNumber");
			enterText(saleNumber, saleNum, "saleNumber");
			click(find, "find");
			click(rowExit, "rowExit");
			moveToElement(lottingUp, "lottingUp");

			Thread.sleep(5000);
			click(maitainButton, "maitainButton");
			Thread.sleep(5000);
			boolean nextButton = IsTestElementPresent();
			System.out.println("nextButton" + nextButton);
			if (nextButton) {
				click(lastArrow, "lastArrow");

			}
			Thread.sleep(5000);
			String row = rows.getText();
			ArrayList<String> list = new ArrayList<>();
			String[] values = row.split("-");
			for (String str : values) {
				list.add(str.trim());
				System.out.println("list" + list);
			}
			int rowCnt = Integer.parseInt(list.get(1));
			System.out.println("rowCnt" + rowCnt);

			JavascriptExecutor js = (JavascriptExecutor) remoteDriver;
			js.executeScript("arguments[0].scrollTop = 0;", gridTop);
			Thread.sleep(1000);

			ArrayList<String> header = new ArrayList<String>();
			header.add("Lot Number");
			header.add("Lot Suffix");

			FileInputStream ios = new FileInputStream(
					"d:\\Seller_Stock_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(3);
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			for (int k = 1; k <= listStrings1.size(); k++) {
				System.out.println("cal k" + k);
				ArrayList<String> finalList = new ArrayList<String>();

				finalList.add(listStrings1.get(k - 1));
				finalList.add(listStrings2.get(k - 1));

				System.out.println("finalList" + finalList);
				rowCreation(k - 1, header, finalList);
				Thread.sleep(3000);
				WebElement element3 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[3]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			}

			/*
			 * for (int i = 0; i < rowCnt; i++) { int val = (i + 100) + 1;
			 * String value = Integer.toString(val); System.out.println("value"
			 * + value); WebElement e2 =
			 * driver.findElement(By.xpath("//*[@id='G0_1_R" + i +
			 * "']/td[3]/div")); Actions actions1 = new Actions(driver);
			 * actions1.moveToElement(e2).click(); actions1.build().perform();
			 * Thread.sleep(2000); WebElement e3 =
			 * driver.findElement(By.xpath("//*[@id='G0_1_R" + i +
			 * "']/td[3]/div/input")); e3.clear(); e3.sendKeys(value); Actions
			 * actions12 = new Actions(driver); actions12.sendKeys(e3,
			 * Keys.ARROW_DOWN).build().perform(); }
			 */
			click(save, "save");

			Thread.sleep(4000);

		}

		catch (Exception ex) {
			System.out.println("performLottingForSale" + ex);

		}

	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			remoteDriver.findElement(By.xpath("//*[@id='E0_1']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
