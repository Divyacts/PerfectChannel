package com.mop.qa.pageobject;


import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.mop.qa.Utilities.StockOrder; 
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;


public class StockOrderDetailPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(xpath = "(//input[@title='Order Number1'])[1]")
	private WebElement orderNumber;

	@FindBy(xpath = "(//input[@title='Order Number'])[1]")
	private WebElement orderNumberFirstPage;

	@FindBy(xpath = "(//input[@title='Order Number'])[1]")
	private WebElement orderNumber1;

	@FindBy(xpath = "(//input[@title='Stock Order Type value'])[1]")
	private WebElement orderType;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//span/button[text()='Create Charge']")
	private WebElement chargebutton;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@title='Long Address Number_ALKY']")
	private WebElement accntNumber;

	@FindBy(xpath = "//input[@title='Seller AgreementER']")
	private WebElement sellerAgreement;

	@FindBy(xpath = "//input[@title='Source Site']")
	private WebElement sourceSite;

	@FindBy(xpath = "//input[@title='Vendor Status']")
	private WebElement vendorStatus;

	@FindBy(xpath = "(//input[@title='Source Site'])[1]")
	private WebElement sourceSiteFirstPage;

	@FindBy(xpath = "//input[@title='Sale Site']")
	private WebElement saleSite;

	@FindBy(xpath = "//input[@title='Branch/Plant1']")
	private WebElement consignmetnSite;

	@FindBy(xpath = "//input[@title='Expected Arrival SiteER']")
	private WebElement expArrSite;

	@FindBy(xpath = "//input[@title='Order Date']")
	private WebElement creationDate;

	@FindBy(xpath = "//input[@title='Department value']")
	private WebElement deptValue;

	@FindBy(xpath = "//*[@id='gtab0_1']")
	private WebElement select;

	public StockOrderDetailPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}
	
	TestBase test = new TestBase();

	public StockOrder createNewWine(StockOrder stock, String set,
			ObjectInputStream objectInputStream, ArrayList<String> barcono,
			ArrayList<String> itemsno, ArrayList<String> StockOrd,
			ArrayList<String> soPoNum, int i) throws InterruptedException {
		try {
			System.out.println("inside stockOrder");
			if (i == 0) {
				remoteDriver.switchTo().frame(menuIframe);
			}
			click(add,"Click Add button");
			Thread.sleep(5000);
			String acntNo = getJDEAppProperties("AccountNumber");
			enterText(accntNumber, acntNo, "Account number");
			Thread.sleep(2000);
			ArrayList<String> exe = new ArrayList<String>();
			String[] values = set.split(":");
			for (String str : values) {
				exe.add(str);
				System.out.println("combination" + exe);
			}
			String cnt = exe.get(1);
			int number = Integer.parseInt(cnt);
			System.out.println("number" + number);

			// maunal input commented

			/*
			 * SellerAgrment selAg = (SellerAgrment)
			 * objectInputStream.readObject();
			 * System.out.println("selAg.getSellerAgreement()" +
			 * selAg.getSellerAgreement()); String selleAgrNo =
			 * selAg.getSellerAgreement().get(number);
			 * System.out.println("selleAgrNo" + selleAgrNo);
			 * objectInputStream.close();
			 */

			Thread.sleep(2000);
			// manual input

			ArrayList<String> list = new ArrayList<String>();
			list.add("Estimate Currency");
			list.add("Description 1");
			list.add("Description 2");
			list.add("Proposed Sale");
			list.add("Item Intention");
			list.add("Estimate Low");
			list.add("Estimate High");
			list.add("Reserve Value");
			list.add("Reserve Status");
			// list.add("Illustration Size");

			// list.add("Actual Marketing Charge");
			// list.add("Tax on Lot");

			list.add("Total Nbr of Bottles");
			list.add("Expected Arrival Date");
			// list.add("Catalogue Wine Bottle Size");
			// list.add("Wine Bottle Size Description");
			// list.add("Wine Vintage type");
			// list.add("Wine Code");
			list.add("Expected Arrival Site");
			// list.add("Country of Origin");
			// list.add("Client's Reference");

			FileInputStream ios = new FileInputStream(
					"d:\\Seller_Stock_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(2);
			int rowS = sheet.getPhysicalNumberOfRows();
			System.out.println("sheet" + sheet.getSheetName());
			
			
			String sellerAgrNo = getJDEAppProperties("SellerAgreementNumber");
			enterText(sellerAgreement, sellerAgrNo, "Seller Agreement");
			Thread.sleep(2000);
			String saleSourceSite = getJDEAppProperties("SaleSourceSite");
			Thread.sleep(2000);
			enterText(sourceSite, saleSourceSite, "Source Site");
			Thread.sleep(2000);
			
			String saleSellingSite = getJDEAppProperties("SaleSellingSite");
			Thread.sleep(2000);
			enterText(saleSite, saleSellingSite, "Sale Site");
			Thread.sleep(2000);
			enterText(consignmetnSite,saleSellingSite,"Consignment Site");
			Thread.sleep(2000);
			// expArrSite.clear();
			// expArrSite.sendKeys(listStrings11.get(k - 1));
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(creationDate,strTodaysDate,"Creation Date");

			Thread.sleep(2000);
			String dept = rds.getValue("General_Data", test.currentTest, "Department");
			System.out.println("dept" + dept);
			Thread.sleep(2000);
			enterText(deptValue,dept,"Department Value");

			Thread.sleep(2000);
			click(accntNumber, "Account Number");
			selectOPtionByVisibleText(select, "Show All Columns");
			Thread.sleep(2000);
			String SaleNumber = getJDEAppProperties("SaleNumber");

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
			ArrayList<String> listStrings15 = new ArrayList<String>();
			ArrayList<String> listStrings16 = new ArrayList<String>();
			ArrayList<String> listStrings17 = new ArrayList<String>();
			ArrayList<String> listStrings18 = new ArrayList<String>();

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(3, sheet, ios);
			listStrings5 = extractExcelContentByColumnIndex(4, sheet, ios);
			listStrings6 = extractExcelContentByColumnIndex(5, sheet, ios);
			listStrings7 = extractExcelContentByColumnIndex(6, sheet, ios);
			listStrings8 = extractExcelContentByColumnIndex(7, sheet, ios);
			listStrings9 = extractExcelContentByColumnIndex(8, sheet, ios);

			List<WebElement> webEle2 = remoteDriver
					.findElements(By.className("JSGridHeaderCell"));
			System.out.println("listStrings1.size()" + listStrings1.size());
			System.out.println(listStrings1);
			
			String currency = rds.getValue("General_Data", test.currentTest, "Currency");
			String lotValue = null;
			for (int k = 1; k <= listStrings1.size(); k++) {
				System.out.println("cal k" + k);
				ArrayList<String> finalList = new ArrayList<String>();

				finalList.add(currency);
				finalList.add(listStrings1.get(k - 1));
				finalList.add(listStrings2.get(k - 1));
				finalList.add(SaleNumber);
				finalList.add(listStrings3.get(k - 1));
				finalList.add(listStrings4.get(k - 1));
				finalList.add(listStrings5.get(k - 1));
				finalList.add(listStrings6.get(k - 1));
				finalList.add(listStrings7.get(k - 1));
				finalList.add(listStrings8.get(k - 1));
				finalList.add(strTodaysDate);
				finalList.add(listStrings9.get(k - 1));

				// finalList.add(listStrings17.get(k - 1));
				// finalList.add(listStrings18.get(k));

				// finalList.add(listStrings10.get(k - 1));
				/*
				 * finalList.add(strTodaysDate);
				 * finalList.add(listStrings11.get(k));
				 * finalList.add(listStrings12.get(k));
				 * finalList.add(listStrings13.get(k));
				 * finalList.add(listStrings14.get(k));
				 * finalList.add(listStrings15.get(k));
				 * finalList.add(listStrings16.get(k));
				 */

				System.out.println("finalList" + finalList);
				rowCreation(k, list, finalList);
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				Thread.sleep(3000);
				// saveButton.click();
				/*
				 * JdeHomePage.callMeToWait(5000); element = webEle2.get(0);
				 * actions = new Actions(driver);
				 * actions.moveToElement(element); actions.perform();
				 * JdeHomePage.callMeToWait(5000);
				 */
				// getItemNumberRows(k);
				WebElement element3 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[6]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			}
			click(saveButton, "Save Button");
			Thread.sleep(50000);
			String stockOrderNumber = orderNumber.getAttribute("value");
			propertiesJdeWrite("stockOrderNumber", stockOrderNumber);
			System.out.println("stockOrderNumber" + stockOrderNumber);
			StockOrd.add(stockOrderNumber);
			stock.setStockOrder(StockOrd);
			stock.setItemNumbers(itemsno);
			stock.setBarcodes(barcono);
			stock.setPoSoNumber(soPoNum);
			// objectOutputStream.writeObject(stock);
			// objectOutputStream.flush();
			// objectOutputStream.close();
			System.out.println("itemsno" + itemsno);
			System.out.println("barcono" + barcono);
			System.out.println("stock" + stock.getStockOrder());
			System.out.println("stock" + stock.getItemNumbers());
			System.out.println("stock" + stock.getBarcodes());
			// JdeHomePage.callMeToWait(3000);
			// saveButton.click();
			click(saveButton, "saveButton");
			saveButton.click();
			Thread.sleep(50000);
			// saveButton.click();
			// JdeHomePage.callMeToWait(5000);
		} catch (Exception ex) {
			System.out.println("Inside createNewStockOrder" + ex);

		}
		return stock;

	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<ArrayList<String>> searchAndGetItemAndPOSO(String stNo) {
		ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
		try {
			System.out.println("searchAndGetItemAndPOSO");

			ArrayList<String> barCode = new ArrayList<String>();
			ArrayList<String> poSo = new ArrayList<String>();

			Thread.sleep(1000);
			remoteDriver.switchTo().frame(menuIframe);
			enterText(orderNumberFirstPage, stNo, "Order Number");
			sourceSiteFirstPage.clear();
			click(searchButton, "searchButton");
			Thread.sleep(1000);
			click(selectButton, "selectButton");
			Thread.sleep(3000);

			boolean nextButton = IsTestElementPresent();
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

			for (int i = 0; i < rowCnt - 1; i++) {
				String Val = getValues("Barcode", i);
				System.out.println("Val" + Val);
				barCode.add(Val);
				String Val2 = getValues("Related PO/SO No", i);
				System.out.println("Val2" + Val2);
				poSo.add(Val2);
				WebElement element3 = remoteDriver.findElement(
						By.xpath("//*[@id='G0_1_R" + i + "']/td[1]/div/input"));
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element3);
				actions.perform();
				actions.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			}
			finalList.add(barCode);
			finalList.add(poSo);
			// return finalList;

		} catch (Exception ex) {
			System.out.println("getBatchNumberForSale" + ex);
		}
		return finalList;

	}

	public StockOrder createNewPrivateSale(StockOrder stock, String set,
			ObjectInputStream objectInputStream, ArrayList<String> barcono,
			ArrayList<String> itemsno, ArrayList<String> StockOrd,
			ArrayList<String> soPoNum, int i) throws InterruptedException {
		try {
			System.out.println("inside stockOrder");

			if (i == 0) {
				remoteDriver.switchTo().frame(menuIframe);
			}
			add.click();
			Thread.sleep(5000);
			
			String acntNo = getJDEAppProperties("AccountNumber");
			enterText(accntNumber, acntNo, "accntNumber");
			Thread.sleep(2000);
			// commented for now
			/*
			 * ArrayList<String> exe = new ArrayList<String>(); String[] values
			 * = set.split(":"); for (String str : values) { exe.add(str);
			 * System.out.println("combination" + exe); } String cnt =
			 * exe.get(1); int number = Integer.parseInt(cnt);
			 * System.out.println("number" + number);
			 */

			// maunal input commented

			/*
			 * SellerAgrment selAg = (SellerAgrment)
			 * objectInputStream.readObject();
			 * System.out.println("selAg.getSellerAgreement()" +
			 * selAg.getSellerAgreement()); String selleAgrNo =
			 * selAg.getSellerAgreement().get(number);
			 * System.out.println("selleAgrNo" + selleAgrNo);
			 * objectInputStream.close();
			 */
			String sellerAgrNo = getJDEAppProperties("SellerAgreementNumber");
            enterText(sellerAgreement, sellerAgrNo, "sellerAgreement");
			Thread.sleep(2000);
			String saleSourceSite = getJDEAppProperties("SaleSourceSite");
			enterText(sourceSite, saleSourceSite, "sourceSite");
			String saleSellingSite = getJDEAppProperties("SaleSellingSite");
			enterText(saleSite, saleSellingSite, "saleSite");
			String ConsignmentSite = getJDEAppProperties("ConsignmentSite");
			enterText(consignmetnSite, ConsignmentSite, "consignmetnSite");

			// expArrSite.clear();
			// expArrSite.sendKeys(saleSellingSite);
			enterText(orderType, "P", "orderType");
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(creationDate, strTodaysDate, "creationDate");
			String dept = rds.getValue("General_Data", test.currentTest, "Department");

			enterText(deptValue, dept, "deptValue");
			
			click(accntNumber, "accntNumber");
			selectOPtionByVisibleText(select, "Show All Columns");

			String SaleNumber = getJDEAppProperties("SaleNumber");

			Thread.sleep(2000);
			// manual input

			ArrayList<String> list = new ArrayList<String>();
			list.add("Estimate Currency");
			list.add("Description 1");
			list.add("Description 2");
			list.add("Tax on Lot");
			list.add("Expected Arrival Site");
			// list.add("Country of Origin");
			list.add("Pre Sale Due Diligence Complete");
			list.add("Net To Seller");
			list.add("Insurance Value");
			list.add("Minimum Asking Amount");
			list.add("Expected Sale Year");
			list.add("Expected Sale Month");
			list.add("Artist Resale Right");
			list.add("Net to Seller Currency");
			// list.add("India Nat.Treasure");
			// list.add("Wild Plant or Animal");
			// list.add("Species Common Name");
			// list.add("Percentage Of ARR To Charge");

			FileInputStream ios = new FileInputStream(
					"d:\\Seller_Stock_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(4);
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

			List<WebElement> webEle2 = remoteDriver
					.findElements(By.className("JSGridHeaderCell"));
			System.out.println("listStrings1.size()" + listStrings1.size());
			System.out.println(listStrings1);
			String currency = getJDEAppProperties("Currency");

			for (int k = 1; k <= listStrings1.size(); k++) {
				System.out.println("cal k" + k);

				ArrayList<String> finalList = new ArrayList<String>();
				finalList.add(currency);
				finalList.add(listStrings1.get(k - 1));
				finalList.add(listStrings2.get(k - 1));
				// finalList.add(SaleNumber);
				finalList.add(listStrings3.get(k - 1));
				finalList.add(listStrings4.get(k - 1));
				finalList.add(listStrings5.get(k - 1));
				finalList.add(listStrings6.get(k - 1));
				finalList.add(listStrings7.get(k - 1));
				finalList.add(listStrings8.get(k - 1));
				finalList.add(listStrings9.get(k - 1));
				finalList.add(listStrings10.get(k - 1));
				finalList.add(listStrings11.get(k - 1));
				finalList.add(listStrings12.get(k - 1));

				System.out.println("finalList" + finalList);
				rowCreation(k, list, finalList);
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				Thread.sleep(3000);
				// saveButton.click();
				/*
				 * JdeHomePage.callMeToWait(5000); element = webEle2.get(0);
				 * actions = new Actions(driver);
				 * actions.moveToElement(element); actions.perform();
				 * JdeHomePage.callMeToWait(5000);
				 */
				// getItemNumberRows(k);
				WebElement element3 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[6]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			}
			click(saveButton, "saveButton");
			saveButton.click();
			Thread.sleep(10000);

			String stockOrderNumber = orderNumber.getAttribute("value");
	
			propertiesJdeWrite("StockOrderNumber",stockOrderNumber);

			System.out.println("stockOrderNumber" + stockOrderNumber);
			StockOrd.add(stockOrderNumber);
			stock.setStockOrder(StockOrd);
			stock.setItemNumbers(itemsno);
			stock.setBarcodes(barcono);
			stock.setPoSoNumber(soPoNum);
			// objectOutputStream.writeObject(stock);
			// objectOutputStream.flush();
			// objectOutputStream.close();
			System.out.println("itemsno" + itemsno);
			System.out.println("barcono" + barcono);
			System.out.println("stock" + stock.getStockOrder());
			System.out.println("stock" + stock.getItemNumbers());
			System.out.println("stock" + stock.getBarcodes());
			// JdeHomePage.callMeToWait(3000);
			// saveButton.click();
			click(saveButton, "saveButton");
			Thread.sleep(5000);
			// saveButton.click();
			// JdeHomePage.callMeToWait(5000);

		} catch (Exception ex) {
			System.out.println("Inside createNewStockOrder" + ex);

		}
		return stock;
	}

	public StockOrder createNewStockOrder(StockOrder stock, String set,
			ObjectInputStream objectInputStream, ArrayList<String> barcono,
			ArrayList<String> itemsno, ArrayList<String> StockOrd,
			ArrayList<String> soPoNum, int i) throws InterruptedException {
		try {
			System.out.println("inside stockOrder");
			if (i == 0) {
				remoteDriver.switchTo().frame(menuIframe);
			}
			click(add, "add");
			Thread.sleep(5000);

			String acntNo = getJDEAppProperties("AccountNumber");
            enterText(accntNumber, acntNo, "accntNumber");
			Thread.sleep(2000);
			/*
			 * ArrayList<String> exe = new ArrayList<String>(); String[] values
			 * = set.split(":"); for (String str : values) { exe.add(str);
			 * System.out.println("combination" + exe); } String cnt =
			 * exe.get(1); int number = Integer.parseInt(cnt);
			 * System.out.println("number" + number);
			 */

			// maunal input commented

			/*
			 * SellerAgrment selAg = (SellerAgrment)
			 * objectInputStream.readObject();
			 * System.out.println("selAg.getSellerAgreement()" +
			 * selAg.getSellerAgreement()); String selleAgrNo =
			 * selAg.getSellerAgreement().get(number);
			 * System.out.println("selleAgrNo" + selleAgrNo);
			 * objectInputStream.close();
			 */
			
			String sellerAgrNo = getJDEAppProperties("SellerAgreementNumber");
			enterText(sellerAgreement, sellerAgrNo, "sellerAgreement");
			String saleSourceSite = getJDEAppProperties("SaleSourceSite");
			enterText(sourceSite, saleSourceSite, "sourceSite");
			Thread.sleep(2000);
	
			String saleSellingSite = getJDEAppProperties("SaleSellingSite");
			String ConsignmentSite = getJDEAppProperties("ConsignmentSite");

			Thread.sleep(2000);
			enterText(saleSite, saleSellingSite, "saleSite");
			enterText(consignmetnSite, ConsignmentSite, "ConsignmentSite");

			// expArrSite.clear();
			// expArrSite.sendKeys(saleSellingSite);
			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
			String strTodaysDate = dateFormat.format(currentDate);
			Thread.sleep(2000);
			enterText(creationDate, strTodaysDate, "creationDate");
			String dept = rds.getValue("General_Data", test.currentTest, "Department");
			enterText(deptValue, dept, "deptValue");
			Thread.sleep(2000);
			click(accntNumber, "accntNumber");
			String sellerStat = rds.getValue("SellerAgreement_Data", test.currentTest, "SellerStatus");

			System.out.println(
					"vendorStatus" + vendorStatus.getAttribute("value"));

			assertTrue(
					vendorStatus.getAttribute("value")
							.equalsIgnoreCase(sellerStat),
					"Vendor status Displayed in stock order is same as that of the Seller Agreement");

			selectOPtionByVisibleText(select, "Show All Columns");
			String SaleNumber = getJDEAppProperties("SaleNumber");


			Thread.sleep(2000);
			// manual input

			ArrayList<String> list = new ArrayList<String>();
			list.add("Estimate Currency");
			list.add("Description 1");
			list.add("Description 2");
			list.add("Proposed Sale");
			list.add("Item Intention");
			list.add("Tax on Lot");
			list.add("Estimate Low");
			list.add("Estimate High");
			list.add("Reserve Value");
			list.add("Reserve Status");
			// list.add("Transit LDL");
			list.add("Illustration Size");
			list.add("Expected Arrival Date");
			list.add("Actual Marketing Charge");

			list.add("Expected Arrival Site");
			// list.add("Country of Origin");
			// list.add("Artist Resale Right");
			// list.add("Plus Value");
			// list.add("Client's Reference");
			// list.add("India Nat.Treasure");
			// list.add("Wild Plant or Animal");
			// list.add("Species Common Name");
			// list.add("Percentage Of ARR To Charge");

			FileInputStream ios = new FileInputStream(
					"d:\\Seller_Stock_data.xlsx");
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
			ArrayList<String> listStrings15 = new ArrayList<String>();
			ArrayList<String> listStrings16 = new ArrayList<String>();

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
			listStrings15 = extractExcelContentByColumnIndex(14, sheet, ios);
			listStrings16 = extractExcelContentByColumnIndex(15, sheet, ios);

			List<WebElement> webEle2 = remoteDriver
					.findElements(By.className("JSGridHeaderCell"));
			System.out.println("listStrings1.size()" + listStrings1.size());
			System.out.println(listStrings1);
			String currency = rds.getValue("General_Data", test.currentTest, "Currency");

			for (int k = 1; k <= listStrings1.size(); k++) {
				System.out.println("cal k" + k);

				ArrayList<String> finalList = new ArrayList<String>();
				finalList.add(currency);
				finalList.add(listStrings1.get(k - 1));
				finalList.add(listStrings2.get(k - 1));
				finalList.add(SaleNumber);
				finalList.add(listStrings3.get(k - 1));
				finalList.add(listStrings10.get(k - 1));
				finalList.add(listStrings4.get(k - 1));
				finalList.add(listStrings5.get(k - 1));
				finalList.add(listStrings6.get(k - 1));
				finalList.add(listStrings7.get(k - 1));
				finalList.add(listStrings8.get(k - 1));
				finalList.add(strTodaysDate);
				finalList.add(listStrings9.get(k - 1));
				finalList.add(listStrings11.get(k - 1));
				// finalList.add(listStrings12.get(k - 1));
				// finalList.add(listStrings13.get(k - 1));
				// finalList.add(listStrings14.get(k - 1));
				/*
				 * finalList.add(strTodaysDate);
				 * finalList.add(listStrings11.get(k));
				 * finalList.add(listStrings12.get(k));
				 * finalList.add(listStrings13.get(k));
				 * finalList.add(listStrings14.get(k));
				 * finalList.add(listStrings15.get(k));
				 * finalList.add(listStrings16.get(k));
				 */

				System.out.println("finalList" + finalList);
				rowCreation(k, list, finalList);
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				Thread.sleep(3000);
				// saveButton.click();
				/*
				 * JdeHomePage.callMeToWait(5000); element = webEle2.get(0);
				 * actions = new Actions(driver);
				 * actions.moveToElement(element); actions.perform();
				 * JdeHomePage.callMeToWait(5000);
				 */
				// getItemNumberRows(k);
				WebElement element3 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[6]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			}
			saveButton.click();

			Thread.sleep(100000);
			String stockOrderNumber = orderNumber.getAttribute("value");
			propertiesJdeWrite("StockOrderNumber", stockOrderNumber);

			System.out.println("stockOrderNumber" + stockOrderNumber);
			// JdeHomePage.callMeToWait(150000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);

			/*
			 * StockOrd.add(stockOrderNumber); stock.setStockOrder(StockOrd);
			 * stock.setItemNumbers(itemsno); stock.setBarcodes(barcono);
			 * stock.setPoSoNumber(soPoNum); //
			 * objectOutputStream.writeObject(stock); //
			 * objectOutputStream.flush(); // objectOutputStream.close();
			 * System.out.println("itemsno" + itemsno);
			 * System.out.println("barcono" + barcono);
			 * System.out.println("stock" + stock.getStockOrder());
			 * System.out.println("stock" + stock.getItemNumbers());
			 * System.out.println("stock" + stock.getBarcodes()); //
			 * JdeHomePage.callMeToWait(3000); // saveButton.click();
			 * saveButton.click(); JdeHomePage.callMeToWait(5000);
			 */
			// saveButton.click();
			// JdeHomePage.callMeToWait(5000);

		} catch (

		Exception ex) {
			System.out.println("Inside createNewStockOrder" + ex);

		}
		return stock;
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
		rowValue = remoteDriver
				.findElement(By.xpath(
						"//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
				.getAttribute("value");
		/*
		 * String rowValue1 = driver .findElement(By.xpath( "//tr[@id='G0_1_R" +
		 * RowCount + "']/td[@colindex='" + colindexcolindexValue +
		 * "']/div/input")) .getAttribute("value");
		 */
		System.out.println("rowValue" + rowValue);
		// System.out.println("rowValue1" + rowValue1);
		Thread.sleep(3000);
		return rowValue;
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

	public void enterValues(String fieldName, int RowCount, String list1) {
		try {
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
					System.out.println(
							"fieldName" + fieldName + colindexcolindexValue);
					// System.out.println(colindexcolindexValue);
					break;
				}
			}
			if ((colindexcolindexValue.equalsIgnoreCase("66")
					|| (colindexcolindexValue.equalsIgnoreCase("68"))
					|| (colindexcolindexValue.equalsIgnoreCase("69"))
					|| colindexcolindexValue.equalsIgnoreCase("81")
					|| colindexcolindexValue.equalsIgnoreCase("87")
					|| colindexcolindexValue.equalsIgnoreCase("116")
					|| colindexcolindexValue.equalsIgnoreCase("192")
					|| colindexcolindexValue.equalsIgnoreCase("208"))) {
				if (list1.contains("Y")) {
					System.out.println("inside checkbox" + list1);
					remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R"
							+ (RowCount - 1) + "']/td[@colindex='"
							+ colindexcolindexValue
							+ "']/div/input[@type='checkbox']")).click();
					Thread.sleep(2000);
				}

			} else if (list1.equalsIgnoreCase("No Lot")) {
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (RowCount - 1) + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.clear();
				Thread.sleep(2000);
				Thread.sleep(2000);
			} else if (list1.equalsIgnoreCase("No Size")) {
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (RowCount - 1) + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.sendKeys(" ");
			} else {
				remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (RowCount - 1) + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
						.clear();
				remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + (RowCount - 1)
						+ "']/td[@colindex='" + colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']"))
						.sendKeys(list1.trim());
				Thread.sleep(2000);
			}
		} catch (

		Exception ex)

		{
			System.out.println("enterValues in stockorderPage" + ex);

		}

	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) {
		WebElement element3 = remoteDriver.findElement(By
				.xpath("//*[@id='G0_1_R" + (count - 1) + "']/td[6]/div/input"));
		Actions actions1 = new Actions(remoteDriver);
		actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
		for (int j = 0; j < list.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
		}

	}

}