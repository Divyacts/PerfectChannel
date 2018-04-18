package com.mop.qa.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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


import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import io.appium.java_client.AppiumDriver;

public class WorkWithAuctionResultsPage extends PageBase {

	public WorkWithAuctionResultsPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	TestBase test = new TestBase();
	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addSale;

	@FindBy(xpath = "//button[contains(text(),'Enter Results')]")
	private WebElement enterResults;

	@FindBy(xpath = "(//button[contains(text(),'Lot')])[1]")
	private WebElement lot;

	@FindBy(xpath = "(//button[contains(text(),'Sale')])[2]")
	private WebElement saleButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "(//*[@title='Seller Agreement'])[2]")
	private WebElement sellerAgreement;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//td[contains(text(),'View Job Status')]")
	private WebElement viewJobStatus;

	@FindBy(xpath = "//nobr[contains(text(),'Sold Since Sale')]")
	private WebElement soldSinceSale;

	@FindBy(xpath = "//nobr[contains(text(),'Underbidders')]")
	private WebElement underbidders;

	@FindBy(xpath = "//nobr[contains(text(),'Make Stock')]")
	private WebElement makeStock;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yesButton;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//input[@title='Job']")
	private WebElement submittedJobs;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement select;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/a")
	private WebElement linkToPrint;

	@FindBy(xpath = "//*[@id='listRecRptsHeader']/div[2]/a")
	private WebElement refreshButton;

	@FindBy(xpath = "//input[@title='New Vendor']")
	private WebElement newVendor;

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

	@FindBy(xpath = "(//input[@title='Sale Number'])[2]")
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

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement rows;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//button[contains(text(),'Lot')]")
	private WebElement maintainByLot;

	@FindBy(xpath = "//button[contains(text(),'Sale')]")
	private WebElement maintainBySale;

	@FindBy(xpath = "//button[contains(text(),'Refresh')]")
	private WebElement refresh;

	@FindBy(xpath = "//input[@title='Make Stock G/L Category']")
	private WebElement glCategory;

	public WorkWithAuctionResultsPage enterAuctioNResults() {
		try {
			System.out.println("enterAuctioNResults");
			click(enterResults, "enterResults");
			Thread.sleep(3000);
			ArrayList<String> list = new ArrayList<String>();
			list.add("Auction Result");
			list.add("Knock Down Amt");
			list.add("Paddle Number");

			FileInputStream ios = new FileInputStream("d:\\Bidder_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(2);
			int rowS = sheet.getPhysicalNumberOfRows();
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);
			System.out.println("listStrings1" + listStrings1.size());
			System.out.println("listStrings2" + listStrings2.size());
			System.out.println("listStrings3" + listStrings3.size());

			for (int k = 0; k <= listStrings1.size() - 1; k++) {
				System.out.println(k);
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(listStrings1.get(k));
				list1.add(listStrings2.get(k));
				list1.add(listStrings3.get(k));
				System.out.println("list1" + list1);
				rowCreation(k, list, list1);
				List<WebElement> webEle2 = remoteDriver.findElements(By
						.className("JSGridHeaderCell"));
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				WebElement element3 = remoteDriver.findElement(By
						.xpath("//*[@id='G0_1_R" + (k) + "']/td[5]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
				Thread.sleep(3000);

			}
			click(save, "save");
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("enterAuctioNResults" + ex);

		}
		return new WorkWithAuctionResultsPage(remoteDriver);

	}

	public void enterUnderbids() {

		try {
			System.out.println("enterUnderbids");
			click(maintainBySale, "maintainBySale");
			Thread.sleep(3000);

			FileInputStream ios = new FileInputStream("d:\\Bidder_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(3);
			int rowS = sheet.getPhysicalNumberOfRows();
			ArrayList<String> listStrings1 = new ArrayList<String>();
			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings3 = new ArrayList<String>();
			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(2, sheet, ios);

			for (int k = 0; k <= listStrings1.size() - 1; k++) {

				String fieldName2 = "Paddle Number";
				String paddleNumber = enterUnderBidsForPaddle(fieldName2, k);
				System.out.println("istStrings1.get(k)" + listStrings1.get(k));

				String result1 = listStrings1.get(k).replaceAll("\\.0*$", "");

				System.out.println("result1" + result1);

				// if (paddleNumber.equalsIgnoreCase(result1)) {
				remoteDriver.findElement(
						By.xpath("//tr[@id='G0_1_R" + k + "']/td[1]/div/input"))
						.click();
				Thread.sleep(2000);
				click(rowExit, "rowExit");
				moveToElement(underbidders, "underbidders");
				Thread.sleep(2000);

				ArrayList<String> list = new ArrayList<String>();
				list.add("Paddle Number");
				list.add("Bid Amount");
				list.add("Bid Type");

				System.out.println(k);
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(result1);
				list1.add(listStrings2.get(k));
				list1.add(listStrings3.get(k));
				System.out.println("list1" + list1);
				rowCreation(k, list, list1);
				List<WebElement> webEle2 = remoteDriver.findElements(By
						.className("JSGridHeaderCell"));
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
				actions.perform();
				WebElement element3 = remoteDriver.findElement(By
						.xpath("//*[@id='G0_1_R" + (k) + "']/td[5]/div/input"));
				Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(3000);
				// } else {
				// System.out.println("inm else");

				// }
				// continue;

			}


		} catch (Exception ex) {
			System.out.println("UnderBids" + ex);


		}

	}

	public String enterUnderBidsForPaddle(String fieldName, int RowCount) {
		System.out.println("enterUnderBidsForPaddle" + gridList.size());
		String colindexcolindexValue, rowValue;
		colindexcolindexValue = null;
		rowValue = null;

		List<WebElement> webEle2 = remoteDriver.findElements(By
				.className("JSGridHeaderCell"));
		System.out.println("No of elements" + webEle2.size());

		for (int i = 0; i < gridList.size(); i++) {

			WebElement element = gridList.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			System.out.println("element.getText()" + element.getText());
			System.out.println("fieldName" + fieldName);
			System.out.println("element."
					+ element.getText().replace("\n", " "));
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		System.out.println("RowCount" + RowCount);
		rowValue = remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue + "']/div/input"))
				.getAttribute("value");
		System.out.println("rowValue" + rowValue);
		return rowValue;

		
		
	}
	
	
	public SoldSinceSalePage soldSinceSale() {

		try {
			System.out.println("soldSinceSale");
			remoteDriver.findElement(By.xpath("//*[@id='G0_1_R2']/td[1]/div/input"))
					.click();
			Thread.sleep(1000);
			click(lot, "lot");
			Thread.sleep(3000);
			click(rowExit, "rowExit");
			moveToElement(soldSinceSale, "soldSinceSale");
			/*Actions action = new Actions(driver);
			action.moveToElement(soldSinceSale).click();
			action.build().perform();*/
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("soldSinceSale" + ex);


		}
		return new SoldSinceSalePage(remoteDriver);

	}

	public void makeStockForItem() {
		System.out.println("Inside makeStockForItem Page");

		try {

			FileInputStream ios = new FileInputStream("d:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(1);

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

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);
			listStrings2 = extractExcelContentByColumnIndex(5, sheet, ios);
			listStrings3 = extractExcelContentByColumnIndex(6, sheet, ios);
			listStrings4 = extractExcelContentByColumnIndex(7, sheet, ios);
			listStrings5 = extractExcelContentByColumnIndex(8, sheet, ios);
			listStrings6 = extractExcelContentByColumnIndex(9, sheet, ios);
			listStrings7 = extractExcelContentByColumnIndex(10, sheet, ios);
			listStrings8 = extractExcelContentByColumnIndex(11, sheet, ios);
			listStrings9 = extractExcelContentByColumnIndex(12, sheet, ios);
			listStrings10 = extractExcelContentByColumnIndex(13, sheet, ios);
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

			for (int k = 0; k <= rowCnt; k++) {
				Thread.sleep(3000);

				remoteDriver.findElement(
						By.xpath("//*[@id='G0_1_R" + k + "']/td[1]/div/input"))
						.click();
				Thread.sleep(5000);
				click(lot, "lot");
				Thread.sleep(3000);
				click(rowExit, "rowExit");
				Thread.sleep(3000);
				moveToElement(makeStock, "makeStock");
				/*Actions action = new Actions(driver);
				action.moveToElement(makeStock).click();
				action.build().perform();*/
				Thread.sleep(3000);

				enterText(newVendor, listStrings2.get(k), "newVendor");
				enterText(sellerAgreement, listStrings3.get(k), "sellerAgreement");

				Thread.sleep(2000);

				if (listStrings8.get(k).equalsIgnoreCase("N")) {
					System.out.println("inside ");
					click(createStock, "createStock");
					Thread.sleep(2000);
				} else {
					enterText(stockOrder, listStrings8.get(k), "stockOrder");

				}

				if (listStrings4.get(k).equalsIgnoreCase("N")
						&& keepItemInSale.isEnabled()) {
					click(keepItemInSale, "keepItemInSale");
					Thread.sleep(2000);
				} else {
					enterText(saleNumber, listStrings4.get(k), "saleNumber");
					Thread.sleep(2000);
				}

				enterText(hammerCompensation, listStrings5.get(k), "hammerCompensation");
				Thread.sleep(2000);

				enterText(makeStockCurrency, listStrings9.get(k), "makeStockCurrency");
				Thread.sleep(2000);
				
				
				enterText(makeStockReason, listStrings6.get(k), "makeStockReason");
				Thread.sleep(2000);

				String manager = new BigDecimal(listStrings7.get(k))
						.toPlainString();

				enterText(businessMngr,manager, "businessMngr");
				Thread.sleep(2000);
				
				enterText(glCategory,listStrings10.get(k), "glCategory");

				Thread.sleep(2000);
				click(submitApproval, "submitApproval");

				Thread.sleep(4000);
				click(rowExit, "rowExit");

				Thread.sleep(3000);
				moveToElement(makeStock, "makeStock");
				/*action = new Actions(driver);
				action.moveToElement(makeStock).click();
				action.build().perform();*/
				Thread.sleep(3000);
				click(makeStockApprove, "makeStockApprove");

				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(2000);
				click(refresh, "refresh");
				click(refresh, "refresh");

				click(refresh, "refresh");

			}

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
			
		}

	}

	public MakeStockPage makeStock() {

		try {
			System.out.println("soldSinceSale");

			remoteDriver.findElement(By.xpath("//*[@id='G0_1_R2']/td[1]/div/input"))
					.click();
			Thread.sleep(1000);
			click(lot, "lot");
			Thread.sleep(3000);
			click(rowExit, "rowExit");
			moveToElement(makeStock, "makeStock");
			/*Actions action = new Actions(driver);
			action.moveToElement(makeStock).click();
			action.build().perform();*/
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("makeStock" + ex);


		}
		return new MakeStockPage(remoteDriver);

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

	public GenerateChargeOrderRequisiton ViewJobStatusWorkWithAuctionResults() {
		try {
			System.out.println("ViewJobStatus navigateWorkWithAuctionResults");
			Thread.sleep(5000);
			click(refreshButton, "refreshButton");

			viewJobStatus.click();
			Thread.sleep(3000);
			moveToElement(submittedJobs, "submittedJobs");
			/*Actions actions = new Actions(driver);
			actions.moveToElement(submittedJobs).click();*/
			remoteDriver.switchTo().frame(iframe);
			click(submittedJobs, "submittedJobs");
			Thread.sleep(2000);
			enterText(submittedJobs, "R57P091*", "submittedJobs");

			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(linkToPrint, "linkToPrint");
			moveFile();
			Thread.sleep(5000);
			click(closeButton, "closeButton");
			// Thread.sleep(3000);
			// closeButton.click();
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("ViewJobStatus Navigating Work With Property"
					+ ex);

		}
		return new GenerateChargeOrderRequisiton(remoteDriver);
	}

	public void moveFile() {
		InputStream inStream = null;
		OutputStream outStream = null;
		String dirPath = "C:\\Users\\235222\\Downloads";
		String fileName = getLatestFilefromDir(dirPath).getName();
		String strFilepath = System.getProperty("user.home") + "\\Downloads\\"
				+ fileName;
		System.out.println(fileName);

		try {
			System.out.println("strFilepath" + strFilepath);
			File afile = new File(strFilepath);
			File bfile = new File("C:\\SALE\\ARGGeneration.pdf");
			System.out.println("bfile" + bfile);
			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			System.out.println("before while");
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public WorkWithAuctionResultsPage generateARG() {
		try {
			System.out.println("generateARG");
			click(saleButton, "saleButton");
			Thread.sleep(5000);
			click(yesButton,"yesButton");
			Thread.sleep(2000);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println("generateARG" + ex);
		}
		return new WorkWithAuctionResultsPage(remoteDriver);
	}

	public void enterValues(String fieldName, int RowCount, String list1) {
		try {
			System.out.println("in enterValues");
			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));
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
			if (!list1.isEmpty()) {
				remoteDriver.findElement(
						By.xpath("//*[@id='G0_1_R" + RowCount
								+ "']/td[@colindex='" + colindexcolindexValue
								+ "']/div/input")).click();
				remoteDriver.findElement(
						By.xpath("//*[@id='G0_1_R" + RowCount
								+ "']/td[@colindex='" + colindexcolindexValue
								+ "']/div/input")).clear();
				list1 = list1.replace(" ", "");
				Thread.sleep(2000);
				list1 = list1.replaceAll("\\s+", "").trim();
				System.out.println("list1" + list1);

				list1 = list1.trim();
				remoteDriver.findElement(
						By.xpath("//*[@id='G0_1_R" + RowCount
								+ "']/td[@colindex='" + colindexcolindexValue
								+ "']/div/input")).sendKeys(list1.trim());
				Thread.sleep(1000);
				WebElement element3 = remoteDriver.findElement(By
						.xpath("//*[@id='G0_1_R" + RowCount
								+ "']/td[@colindex='" + colindexcolindexValue
								+ "']/div/input"));
			}
		} catch (Exception ex) {
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

}
