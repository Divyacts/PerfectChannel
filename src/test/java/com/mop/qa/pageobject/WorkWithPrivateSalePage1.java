package com.mop.qa.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.relevantcodes.extentreports.LogStatus;

public class WorkWithPrivateSalePage1 extends PageBase {

	protected WorkWithPrivateSalePage1(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addDealEntry;

	@FindBy(xpath = "(//input[@title='Item Number'])[1]")
	private WebElement itemNumber;

	@FindBy(xpath = "(//input[@title='Item'])[1]")
	private WebElement itemInSearch;

	@FindBy(xpath = "(//input[@title='Buyer Number'])[1]")
	private WebElement buyerNumber;

	@FindBy(xpath = "(//input[@title='Buyer Price'])[1]")
	private WebElement buyerPrice;

	@FindBy(xpath = "(//input[@title='Currency Code'])[1]")
	private WebElement currencyCode;

	@FindBy(xpath = "//button[text()='Add Offer']")
	private WebElement addOfferButton;

	@FindBy(xpath = "//button[text()='Post Sale Gen']")
	private WebElement postSaleGen;

	@FindBy(xpath = "//button[text()='Approve']")
	private WebElement approveButton;

	@FindBy(xpath = "//button[text()='Generate Buyer Charges']")
	private WebElement generateBuyerCharges;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectAllCheckBox;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='C0_55']")
	private WebElement mailingAddr;

	@FindBy(xpath = "//*[@id='C0_51']")
	private WebElement shipToAddr;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//td[@class='JSSelectHeader']")
	private WebElement checkBoxHeader;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='G0_24_20_R0']/td[3]/div/a")
	private WebElement selectFirstRadio;

	public WorkWithPrivateSalePage1 addDealEntry() throws IOException {
		try {

			remoteDriver.switchTo().frame(iframe);

			Thread.sleep(1000);

			FileInputStream ios = new FileInputStream("d:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(1);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			ArrayList<String> listStrings4 = new ArrayList<String>();

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(3, sheet, ios);

			for (int k = 1; k <= listStrings1.size(); k++) {

				System.out.println("listStrings1" + listStrings1);
				System.out.println("listStrings2" + listStrings2);
				System.out.println("listStrings3" + listStrings3);
				System.out.println("listStrings4" + listStrings4);

				/*
				 * itemInSearch.clear();
				 * itemInSearch.sendKeys(listStrings1.get(k - 1)); find.click();
				 * Thread.sleep(4000); selectAllCheckBox.click();
				 * select.click();
				 */
				click(addDealEntry, "addDealEntry");
				Thread.sleep(2000);
				enterText(itemNumber, listStrings1.get(k - 1), "itemNumber");


				Thread.sleep(2000);
				Actions action = new Actions(remoteDriver);
				action.sendKeys(Keys.TAB).build().perform();

				Thread.sleep(2000);
				click(addOfferButton, "addOfferButton");
				Thread.sleep(4000);
				
				

				buyerNumber.clear();
				String acntNo = listStrings2.get(k - 1);
				String result = acntNo.replaceAll("[-+.^:,E]", "");
				enterText(buyerNumber, result, "buyerNumber");
				System.out.println("result" + result);
				Thread.sleep(3000);
				click(buyerPrice, "buyerPrice");
				Thread.sleep(1000);

				selectOPtionByIndex(mailingAddr,1);
				Thread.sleep(2000);
				
				selectOPtionByIndex(shipToAddr,1);

				Thread.sleep(2000);

				buyerPrice.clear();
				String buyerPr = listStrings3.get(k - 1);
				String result1 = buyerPr.replaceAll("[-+.^:,E]", "");
				System.out.println("result1" + result1);
				enterText(buyerPrice, result1, "buyerPrice");
				Thread.sleep(1000);
				
				enterText(currencyCode, listStrings4.get(k - 1), "currencyCode");


				Thread.sleep(1000);
				
				click(generateBuyerCharges, "generateBuyerCharges");
				Thread.sleep(5000);
				click(save, "save");
				Thread.sleep(2000);
				click(approveButton, "approveButton");
				Thread.sleep(4000);

				String status = returnStatus();
				if (status.equalsIgnoreCase("40")) {
					ExtentUtility.getTest().log(LogStatus.PASS, "Successfully Approved deal Entry",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
				click(save, "save");
				Thread.sleep(2000);

			}

			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Add Deal Type" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Add Deal Type page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPrivateSalePage1(remoteDriver);
	}

	public WorkWithPrivateSalePage1 addFreight() throws IOException {

		try {

			remoteDriver.switchTo().frame(iframe);

			FileInputStream ios = new FileInputStream("d:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(1);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add("Item Number");
			list1.add("Unit Price");

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(4, sheet, ios);

			for (int i = 1; i <= listStrings2.size(); i++) {
				enterText(itemInSearch, listStrings1.get(i - 1), "itemInSearch");

				Thread.sleep(1000);
				click(find, "find");
				Thread.sleep(4000);
				click(selectAllCheckBox, "selectAllCheckBox");
				Thread.sleep(1000);
				click(select, "select");
				Thread.sleep(4000);
				click(selectFirstRadio, "selectFirstRadio");
				Thread.sleep(2000);

				for (int j = 1; j <= listStrings2.size(); j++) {
					System.out.println("j" + j);
					list2.add("FBC");
					list2.add(listStrings2.get(j - 1));
					System.out.println("listStrings2.get(j)"
							+ listStrings2.get(j - 1));
					rowCreation(2, list1, list2);
					// enterValues(list1.get(j - 1), 2, list2.get(j - 1));
				}
				click(save, "save");
				Thread.sleep(3000);
				click(postSaleGen, "postSaleGen");

				Thread.sleep(3000);
				String statusFreight = returnStatus();
				if (statusFreight.equalsIgnoreCase("60")) {
					ExtentUtility.getTest().log(LogStatus.PASS, "Successfully added freight to deal Entry",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

				}
				click(save, "save");
				Thread.sleep(3000);
				Thread.sleep(2000);
			}
		}

		catch (Exception ex) {
			System.out.println("performBidEntry" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in adding freight to deal Entry",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPrivateSalePage1(remoteDriver);

	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws IOException {
		for (int j = 0; j < list.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
		}

	}

	public void enterValues(String fieldName, int RowCount, String list2) throws IOException {
		try {
			System.out.println("gridList.size()" + gridList.size());
			String colindexcolindexValue;
			colindexcolindexValue = null;
			for (int i = 0; i < gridList.size(); i++) {
				// System.out.println( webEle2.get(i).getText());

				WebElement element = gridList.get(i);
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
			remoteDriver.findElement(
					By.xpath("//tr[@id='G0_46_20_R" + RowCount
							+ "']/td[@colindex='" + colindexcolindexValue
							+ "']/div/input[@class='JSTextfield']")).click();
			remoteDriver.findElement(
					By.xpath("//tr[@id='G0_46_20_R" + RowCount
							+ "']/td[@colindex='" + colindexcolindexValue
							+ "']/div/input[@class='JSTextfield']")).clear();
			remoteDriver.findElement(
					By.xpath("//tr[@id='G0_46_20_R" + RowCount
							+ "']/td[@colindex='" + colindexcolindexValue
							+ "']/div/input[@class='JSTextfield']")).sendKeys(
					list2.trim());
		} catch (Exception e) {
			System.out.println("Table entry" + e);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in enter values",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	}

	public String returnStatus() throws InterruptedException {
		String status1 = null;
		Actions actions = null;
		List<WebElement> webEle2 = remoteDriver.findElements(By
				.className("JSGridHeaderCell"));

		System.out.println(webEle2.size());
		String colindexcolindexValue;
		colindexcolindexValue = null;
		for (int i = 0; i < webEle2.size(); i++) {
			WebElement element = webEle2.get(i);
			actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			System.out.println("element" + element.getText());
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase("Offer Status")) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		status1 = remoteDriver.findElement(
				By.xpath("//tr[@id='G0_46_20_R0']/td[" + colindexcolindexValue
						+ "]/div")).getText();
		System.out.println("status1" + status1);
		Thread.sleep(5000);
		actions = new Actions(remoteDriver);
		actions.moveToElement(checkBoxHeader).build().perform();
		// actions.perform();
		Thread.sleep(5000);
		remoteDriver.switchTo().defaultContent();
		return status1;

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
