package com.mop.qa.pageobject;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mop.qa.testbase.PageBase;

public class SoldSinceSalePage extends PageBase {

	public SoldSinceSalePage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}
	// UI Map object definitions
	@FindBy(xpath = "//input[@title='Paddle Number']")
	private WebElement paddelNumber;

	@FindBy(xpath = "//input[@title='Offer Price']")
	private WebElement OfferPrice;

	@FindBy(xpath = "//button[contains(text(),'Enter Sold Since Sale Offer')]")
	private WebElement soldSinceSale;

	@FindBy(xpath = "//button[contains(text(),'Signed Documentation Received')]")
	private WebElement signedDoc;

	@FindBy(xpath = "//button[contains(text(),'Sold Since Sale Approved')]")
	private WebElement soldSinceSaleApp;

	@FindBy(xpath = "//input[@title='Buyer Letter Sent']")
	private WebElement buyerLetterSent;

	@FindBy(xpath = "//input[@title='Buyer Letter Received']")
	private WebElement buyerLetterRec;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//input[@title='Seller Letter Sent']")
	private WebElement sellerLetterSent;

	@FindBy(xpath = "//nobr[contains(text(),'Sold Since Sale')]")
	private WebElement soldSale;

	@FindBy(xpath = "//input[@title='Seller Letter Received']")
	private WebElement sellerLetterRec;

	@FindBy(xpath = "//button[@id='C0_13']")
	private WebElement exportButton;

	@FindBy(xpath = "(//input[@title='Shipment Number'])[1]")
	private WebElement shipmentNoField;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//button[contains(text(),'Lot')]")
	private WebElement maintainByLot;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yesInPop;

	Actions actions = new Actions(remoteDriver);

	public SoldSinceSalePage makeSoldSinceSale() {
		System.out.println("Inside makeSoldSinceSale Page");

		try {

			FileInputStream ios = new FileInputStream("d:\\Bidder_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(2);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(2, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(3, sheet, ios);
			System.out.println("listStrings1" + listStrings1.size());
			System.out.println("listStrings2" + listStrings2.size());
			System.out.println("listStrings3" + listStrings3.size());

			for (int k = 0; k <= listStrings1.size() - 1; k++) {

				if (listStrings1.get(k).equalsIgnoreCase("BI")) {
					enterText(paddelNumber, listStrings2.get(k), "paddelNumber");
					enterText(OfferPrice,listStrings3.get(k), "OfferPrice");

					click(buyerLetterSent, "buyerLetterSent");
					click(buyerLetterRec, "buyerLetterRec");
					Thread.sleep(500);
					click(sellerLetterSent, "sellerLetterSent");
					click(sellerLetterRec, "sellerLetterRec");
					click(soldSinceSale, "soldSinceSale");

					Thread.sleep(3000);
					click(save, "save");
					click(maintainByLot, "maintainByLot");
					Thread.sleep(2000);
					click(rowExit, "rowExit");
					moveToElement(soldSale, "soldSale");
					/*Actions action = new Actions(driver);
					action.moveToElement(soldSale).click();
					action.build().perform();*/
					Thread.sleep(3000);
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);

		}

		return new SoldSinceSalePage(remoteDriver);

	}

	public SoldSinceSalePage signedDocumentRecieved() {
		System.out.println("Inside signedDocumentRecieved");
		try {
			click(signedDoc, "signedDoc");
			click(save, "save");
			click(maintainByLot, "maintainByLot");
			Thread.sleep(2000);
			click(rowExit, "rowExit");
			moveToElement(soldSale, "soldSale");
			/*Actions action = new Actions(driver);
			action.moveToElement(soldSale).click();
			action.build().perform();*/
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);

		}

		return new SoldSinceSalePage(remoteDriver);

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

	public SoldSinceSalePage soldSinceSaleApproved() {
		System.out.println("Inside soldSinceSaleApproved");
		try {
			click(soldSinceSaleApp, "soldSinceSaleApp");
			Thread.sleep(10000);
			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"C:\\Users\\235222\\Desktop\\christies\\closePopUp.exe");
			Thread.sleep(2000);
			click(save, "save");

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		
		}

		return new SoldSinceSalePage(remoteDriver);

	}

	public void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(remoteDriver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = remoteDriver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// exception handling
		}
	}

	public WorkWithAuctionResultsPage returnSaleStatus() {
		System.out.println("Inside soldSinceSaleApproved");
		try {
			click(soldSinceSaleApp, "soldSinceSaleApp");
			Thread.sleep(2000);
			click(save, "save");

		} catch (Exception ex) {
			System.out.println("Exception" + ex);

		}

		return new WorkWithAuctionResultsPage(remoteDriver);

	}

}
