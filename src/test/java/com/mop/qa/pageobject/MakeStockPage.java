package com.mop.qa.pageobject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import supportlibraries.ScriptHelper;


import com.mop.qa.testbase.PageBase;

public class MakeStockPage extends PageBase {
	
	public MakeStockPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@title='New Vendor']")
	private WebElement newVendor;

	@FindBy(xpath = "//input[@title='Seller Agreement']")
	private WebElement sellerAgreement;

	@FindBy(xpath = "//input[@title='Stock Order']")
	private WebElement stockOrder;

	@FindBy(xpath = "//input[@title='Auction Result']")
	private WebElement auctionResult;

	@FindBy(xpath = "//input[@title='Create New Stock Order']")
	private WebElement createStock;

	@FindBy(xpath = "//input[@title='Keep Item in Sale']")
	private WebElement keepItemInSale;

	@FindBy(xpath = "//input[@title='Make Stock Currency']")
	private WebElement makeStockCurrency;

	@FindBy(xpath = "//input[@title='Sale Number']")
	private WebElement saleNumber;

	@FindBy(xpath = "//input[@title='Hammer/Compensation']")
	private WebElement hammerCompensation;

	@FindBy(xpath = "//input[@title='Make Stock Reason']")
	private WebElement makeStockReason;

	@FindBy(xpath = "//input[@title='Business Manager']")
	private WebElement businessMngr;

	@FindBy(xpath = "//button[contains(text(),'Submit for Approval')]")
	private WebElement submitApproval;

	@FindBy(xpath = "//button[contains(text(),'Approve Make Stock')]")
	private WebElement makeStockApprove;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "(//button[contains(text(),'Lot')])[1]")
	private WebElement lot;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//button[contains(text(),'Lot')]")
	private WebElement maintainByLot;

	@FindBy(xpath = "//nobr[contains(text(),'Make Stock')]")
	private WebElement makeStock;

	Actions actions = new Actions(remoteDriver);

	public WorkWithAuctionResultsPage makeStockForItem() {
		System.out.println("Inside makeStockForItem Page");

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
			enterText(auctionResult, "BI", "auctionResult");
			click(searchButton, "searchButton");
			Thread.sleep(3000);

			String row = rows.getText();
			ArrayList<String> list = new ArrayList<>();
			String[] values = row.split("-");
			for (String str : values) {
				list.add(str.trim());
				System.out.println("list" + list);
			}
			int rowCnt = Integer.parseInt(list.get(1));
			System.out.println("rowCnt" + rowCnt);

			for (int k = 0; k < rowCnt - 1; k++) {

				if (listStrings1.get(k).equalsIgnoreCase("BI")) {

					remoteDriver.findElement(
							By.xpath("//*[@id='G0_1_R" + k
									+ "']/td[1]/div/input")).click();
					Thread.sleep(1000);
					click(lot, "lot");
					Thread.sleep(3000);
					click(rowExit, "rowExit");
					moveToElement(makeStock, "makeStock");
					/*Actions action = new Actions(driver);
					action.moveToElement(makeStock).click();
					action.build().perform();*/
					Thread.sleep(3000);
					enterText(newVendor, listStrings2.get(k), "newVendor");

					Thread.sleep(2000);
					enterText(sellerAgreement, listStrings3.get(k), "sellerAgreement");

					Thread.sleep(1000);

					if (listStrings3.get(k).isEmpty()) {
						click(createStock, "createStock");
						Thread.sleep(2000);
					} else {
						enterText(stockOrder, listStrings3.get(k), "stockOrder");
					}

					if (listStrings3.get(k).isEmpty()) {
						click(keepItemInSale, "keepItemInSale");
						Thread.sleep(2000);
					} else {
						enterText(saleNumber, listStrings3.get(k), "saleNumber");
						Thread.sleep(2000);
					}
					enterText(hammerCompensation, listStrings3.get(k), "hammerCompensation");
					Thread.sleep(2000);

					enterText(makeStockCurrency, listStrings3.get(k), "makeStockCurrency");
	
					enterText(makeStockReason, listStrings3.get(k), "makeStockReason");

					enterText(businessMngr, listStrings3.get(k), "businessMngr");

					click(submitApproval,"submitApproval");

					Thread.sleep(3000);

				}
			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);

		}

		return new WorkWithAuctionResultsPage(remoteDriver);

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

}
