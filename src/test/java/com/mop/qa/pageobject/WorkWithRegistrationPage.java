package com.mop.qa.pageobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class WorkWithRegistrationPage extends PageBase {

	protected WorkWithRegistrationPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addSale;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//input[@title='Paddle Number']")
	private WebElement paddleNum;

	@FindBy(xpath = "//input[@title='Enter Bids']")
	private WebElement check;

	@FindBy(xpath = "//input[@title='Print Registration']")
	private WebElement print;

	@FindBy(xpath = "//input[@title='Client Address Number mn']")
	private WebElement clientAccntNo;

	@FindBy(xpath = "//input[@title='Intended Bidding Amount']")
	private WebElement biddingAmt;

	@FindBy(xpath = "//input[@title='Bidder Type']")
	private WebElement bidderType;

	@FindBy(xpath = "//input[@title='Select all fetched records']")
	private WebElement selectAll;

	@FindBy(xpath = "//input[@title='Override_Reason_Code']")
	private WebElement override;

	@FindBy(xpath = "//button[contains(text(),'Update And Save')]")
	private WebElement updateSave;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "//*[@id='C0_139']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExitButton;

	@FindBy(xpath = "//nobr[contains(text(),'Paddle Rev and Edit')]")
	private WebElement paddleReview;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement alert;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='C0_222']")
	private WebElement selectShipAddress;

	@FindBy(xpath = "//*[@id='C0_223']")
	private WebElement selectMailAddress;
	
	TestBase test = new TestBase();

	/*
	 * public WorkWithRegistrationPage addBidders(){ try{ addSale.click();
	 * Thread.sleep(2000); String bideType =
	 * dataTable.getData("Bidder_Registration_data", "BidderType");
	 * Thread.sleep(2000); String type = bideType.replace(" ", ""); type =
	 * type.trim(); Thread.sleep(2000); bidderType.sendKeys(type.trim()); String
	 * paddleno = generatePIN(); paddleNum.sendKeys(paddleno);
	 * Thread.sleep(1000); String accntNum =
	 * dataTable.getData("Bidder_Registration_data", "AccountNumber");
	 * Thread.sleep(1000); clientAccntNo.sendKeys(accntNum);
	 * //bidderType.sendKeys(bideType.trim()); String amt =
	 * dataTable.getData("Bidder_Registration_data", "BindingAmt");
	 * biddingAmt.sendKeys(amt); save.click(); Thread.sleep(5000); save.click();
	 * Thread.sleep(3000); } catch(Exception ex){
	 * System.out.println("addBidders" + ex); report.updateTestLog("Exception",
	 * "Exception inside addBidders in WorkWithRegistrationPage page",
	 * Status.FAIL); }
	 * 
	 * return new WorkWithRegistrationPage(scriptHelper);
	 * 
	 * }
	 */

	public WorkWithRegistrationPage addBidders() throws IOException {
		try {
			FileInputStream ios = new FileInputStream(
					"D:\\Data Backup\\Bidder_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(0);
			// int rowCount = sheet.getPhysicalNumberOfRows();
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			ArrayList<String> listStrings4 = new ArrayList<String>();

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(3, sheet, ios);

			String acntNo;
			String bidderTy;
			String bidAmt;
			String paddleno;
			ArrayList<String> paddle = new ArrayList<String>();
			for (int i = 1; i <= listStrings2.size(); i++) {
				acntNo = listStrings1.get(i - 1);
				bidderTy = listStrings2.get(i - 1);
				paddleno = listStrings4.get(i - 1);
				click(addSale, "addSale"); 
				Thread.sleep(2000);
				// String paddleno = generatePIN();
				// Thread.sleep(2000);
				System.out.println("acntNo" + acntNo);
				String paddleResult = paddleno.replaceAll("([0-9])\\.0+([^0-9]|$)",
						"$1$2");
				enterText(paddleNum, paddleResult, "paddleNum");
				// paddle.add(paddleno);
				Thread.sleep(2000);
 
				String result = acntNo.replaceAll("([0-9])\\.0+([^0-9]|$)",
						"$1$2");
				System.out.println("stifn s " + result);

				/*
				 * String result = acntNo.replaceAll("[-+.^:,E,]", "");
				 * System.out.println("result" + result);
				 */

				/*
				 * Pattern pattern = Pattern.compile("(\\d{4})"); Matcher
				 * matcher = pattern.matcher(result); String Val1 = ""; if
				 * (matcher.find()) { System.out.println(matcher.group(0)); Val1
				 * = matcher.group(0); System.out.println("Val1" + Val1); }
				 */
				enterText(clientAccntNo, result, "clientAccntNo");
				Thread.sleep(2000);
				String type = bidderTy.replace(" ", "");
				Thread.sleep(2000);
				type = type.replaceAll("\\s+", "");
				type = type.trim();
				Thread.sleep(2000);
				enterText(bidderType, type.trim(), "bidderType");
				Thread.sleep(2000);
				if (type.equalsIgnoreCase("A") || type.equalsIgnoreCase("T")
						|| type.equalsIgnoreCase("O")
						|| type.equalsIgnoreCase("L")) {
					Thread.sleep(2000);
					click(check, "check");
					Thread.sleep(2000);
					click(print, "print");
					print.click();
					Thread.sleep(2000);
				}
				listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
				// bidAmt = listStrings3.get(i - 1);
				// biddingAmt.clear();
				// biddingAmt.sendKeys(bidAmt);
				Thread.sleep(2000);
				
				selectOPtionByIndex(selectMailAddress, 1);

				Thread.sleep(1000);
				selectOPtionByIndex(selectShipAddress, 1);

				click(save, "save");
				boolean alert = isAlertPresent();
				if (alert) {
					click(save, "save");
					Thread.sleep(3000);
				}
				Thread.sleep(2000);
				ExtentUtility.getTest().log(LogStatus.PASS, "Added Bidders for sale in WorkWithRegistrationPage page",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
				click(save, "save");
				Thread.sleep(3000);
				updateSheet(paddleno, i);
			}
			

		} catch (Exception ex) {
			System.out.println("addBidders" + ex);
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside addBidders in WorkWithRegistrationPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 

		}
		return new WorkWithRegistrationPage(remoteDriver);
	}

	public boolean isAlertPresent() {
		try {
			remoteDriver.findElement(By.xpath("//*[@id='E0_1']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void updateSheet(String paddle, int i) {
		try {
			System.out.println("in update");
			FileInputStream fsIP = new FileInputStream("d:\\Bidder_data.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fsIP);
			XSSFSheet worksheet = wb.getSheetAt(0);
			Cell cell = null; // declare a Cell object
			XSSFRow sheetrow = worksheet.getRow(i);
			cell = worksheet.getRow(i).getCell(3);
			if (cell == null) {
				cell = sheetrow.createCell(3);
			}
			cell.setCellValue(paddle);
			System.out.println("in rowCount" + sheetrow.getCell(3));
			fsIP.close();
			FileOutputStream output_file = new FileOutputStream(
					"d:\\Bidder_data.xlsx");
			wb.write(output_file); // write changes
			output_file.close();
		} catch (Exception e) {
			e.printStackTrace();
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
								columndata.add(cell.getNumericCellValue() + "");
								break;
							case Cell.CELL_TYPE_STRING:
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

	
	
	public WorkWithRegistrationPage updateRegistrationStatus() throws IOException {
		try {
			System.out.println("in updateRegistrationStatus");
			formExitButton.click();
			Thread.sleep(2000);
			moveToElement(paddleReview, "paddleReview");
			click(find, "find");
			Thread.sleep(3000);
			Thread.sleep(5000);
			click(selectAll, "selectAll");
			String ovrrCode = rds.getValue("General_Data", test.currentTest, "OverrideReasonCode");
			enterText(override, ovrrCode, "override");
			Thread.sleep(1000);
			String regStat = rds.getValue("General_Data", test.currentTest, "RegStatus");
			selectOPtionByVisibleText(select, regStat);
			Thread.sleep(1000);
			click(updateSave, "updateSave");
			Thread.sleep(5000);
			click(find, "find");
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.PASS, "Registration status has been updated as per data sheet",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			/*
			 * String row = rows.getText(); ArrayList<String> list = new
			 * ArrayList<>(); String[] values = row.split("-"); for (String str
			 * : values) { list.add(str.trim());
			 * System.out.println("list"+list); } int rowCnt =
			 * Integer.parseInt(list.get(1));
			 * System.out.println("rowCnt"+rowCnt); String FieldName =
			 * "Registration Status"; String regStatCde =
			 * dataTable.getData("General_Data", "RegStatusCode"); for(int
			 * i=0;i<rowCnt;i++){ String status = getValues(FieldName,i);
			 * if(status.equalsIgnoreCase(regStatCde)){ report.updateTestLog(
			 * "Registration Status",
			 * "Registration status has been updated as per data sheet",
			 * Status.PASS); }else{ report.updateTestLog("Registration Status",
			 * "Registration status has been updated failed", Status.FAIL); } }
			 */
		} catch (Exception ex) {
			System.out.println("updateRegistrationStatus" + ex);
			ExtentUtility.getTest().log(LogStatus.PASS, "Exception inside updateRegistrationStatus in WorkWithRegistrationPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

		return new WorkWithRegistrationPage(remoteDriver);

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
			System.out.println("element" + element.getAttribute("value"));
			actions.perform();
			if (element.getText().replace("\n", " ").contains(fieldName)) {
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

	public String generatePIN() {
		int x = (int) (Math.random() * 9);
		x = x + 1;
		String randomPIN = (x + "") + (((int) (Math.random() * 1000)) + "");
		return randomPIN;
	}

}
