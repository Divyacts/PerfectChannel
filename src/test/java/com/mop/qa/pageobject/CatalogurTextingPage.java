package com.mop.qa.pageobject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class CatalogurTextingPage extends PageBase {
	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Item Number'])[2]")
	private WebElement itemNumber;

	@FindBy(xpath = "(//*[@title='Department'])[2]")
	private WebElement dept;

	@FindBy(xpath = "//input[@title='Item Number']")
	private WebElement itemNumberforInventory;

	@FindBy(xpath = "//*[@id='e1MFastpathForm']/a/img")
	private WebElement searchArrow;

	@FindBy(xpath = "//input[@title='Display Inventory Status']")
	private WebElement inventoryCheckBox;

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

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement cc;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='drop_mainmenu']")
	private WebElement mainMenu;

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
	private WebElement dateVal1;

	@FindBy(xpath = "//input[@title='AT 01 Val 2']")
	private WebElement dateVal2;

	@FindBy(xpath = "//input[@title='AT 01 Val 3']")
	private WebElement dateVal3;

	@FindBy(xpath = "//input[@title='AT 02 Val 1']")
	private WebElement orgin1;

	@FindBy(xpath = "//input[@title='AT 02 Val 2']")
	private WebElement orgin2;

	@FindBy(xpath = "//input[@title='AT 02 Val 3']")
	private WebElement orgin3;

	@FindBy(xpath = "//input[@title='AT 03 Val 1']")
	private WebElement artist1;

	@FindBy(xpath = "//input[@title='AT 03 Val 2']")
	private WebElement artist2;

	@FindBy(xpath = "//input[@title='AT 03 Val 3']")
	private WebElement artist3;

	@FindBy(xpath = "//input[@title='AT 04 Val 1']")
	private WebElement type;

	@FindBy(xpath = "//input[@title='AT 05 Val 1']")
	private WebElement object;

	@FindBy(xpath = "//input[@title='AT 06 Val 1']")
	private WebElement size;

	@FindBy(xpath = "//input[@title='Plus Value']")
	private WebElement plusVal;

	@FindBy(id = "modalIframe1")
	private WebElement modalIframe;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement iframeselect;

	@FindBy(xpath = "//input[@title='Pre Dimension Phrase']")
	private WebElement preDimPhase;

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

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement clickSave;

	@FindBy(xpath = "//button[@title='Ctrl+Alt+V']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[contains(text(),'Edit Catalogue Text')]")
	private WebElement editCatText;

	@FindBy(xpath = "//*[@id='C0_22']")
	private WebElement itemId;

	// *[@class='RCUXComboBox']

	/**
	 * Constructor to initialize the page
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 * @throws InterruptedException
	 */
	public CatalogurTextingPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	public void enterInventoryDimentionsforItem() {
		try {

			// driver.switchTo().frame(iframe);
			Thread.sleep(5000);
			System.out.println("docataloguing");
			// driver.switchTo().frame(iframe);

			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']")).click();
			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']"))
					.sendKeys("P57P41T");
			click(searchArrow, "searchArrow");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);

			FileInputStream ios = new FileInputStream(
					"d:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(2);
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
			listStrings10 = extractExcelContentByColumnIndex(9, sheet, ios);
			listStrings11 = extractExcelContentByColumnIndex(10, sheet, ios);
			listStrings12 = extractExcelContentByColumnIndex(11, sheet, ios);
			listStrings13 = extractExcelContentByColumnIndex(12, sheet, ios);
			listStrings14 = extractExcelContentByColumnIndex(13, sheet, ios);
			listStrings15 = extractExcelContentByColumnIndex(14, sheet, ios);
			listStrings16 = extractExcelContentByColumnIndex(15, sheet, ios);
			listStrings17 = extractExcelContentByColumnIndex(16, sheet, ios);
			listStrings18 = extractExcelContentByColumnIndex(17, sheet, ios);

			for (int i = 0; i <= listStrings1.size(); i++) {
				enterText(itemNumber, listStrings1.get(i), "itemNumber");


				Thread.sleep(3000);
				click(find, "find");
				Thread.sleep(3000);
				click(select, "select");
				Thread.sleep(3000);

				Select select = new Select(selectVal);
				select.selectByVisibleText("5-Dimensions");
				Thread.sleep(3000);

				preDimPhase.clear();
				preDimPhase.sendKeys(listStrings2.get(i));
				Thread.sleep(3000);

				height1.clear();
				height1.sendKeys(listStrings3.get(i));
				Thread.sleep(2000);

				width1.clear();
				width1.sendKeys(listStrings4.get(i));
				Thread.sleep(2000);

				depth1.clear();
				depth1.sendKeys(listStrings5.get(i));
				Thread.sleep(2000);

				dia1.clear();
				dia1.sendKeys(listStrings6.get(i));
				Thread.sleep(2000);

				UM1.clear();
				UM1.sendKeys(listStrings7.get(i));
				Thread.sleep(2000);
				

				enterText(postDimPhrase, listStrings8.get(i), "postDimPhrase");

				Thread.sleep(2000);

				/*
				 * altUM1.clear(); altUM1.sendKeys(listStrings9.get(i));
				 * Thread.sleep(2000);
				 */
				
				enterText(preWeightPhrase, listStrings15.get(i), "preWeightPhrase");

				Thread.sleep(2000);
				
				enterText(weight, listStrings16.get(i), "weight");

				Thread.sleep(2000);
				
				enterText(postWeightPhrase, listStrings18.get(i), "postWeightPhrase");

				Thread.sleep(2000);

				Thread.sleep(2000);
				click(save, "save");
				Thread.sleep(3000);

			}
		}

		catch (Exception ex) {
			System.out.println("Cataloging Navigating Work With Property" + ex);

		}
	}

	public void updatePlusValueFlag() throws IOException {
		try {
			// driver.switchTo().frame(iframe);
			Thread.sleep(5000);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			FileInputStream ios = new FileInputStream(
					"D:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(2);
			int rowS = sheet.getPhysicalNumberOfRows();
			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']")).click();
			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']"))
					.sendKeys("P57P41T");
			click(searchArrow, "searchArrow");

			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);

			ArrayList<String> listStrings2 = new ArrayList<String>();
			ArrayList<String> listStrings21 = new ArrayList<String>();

			listStrings2 = extractExcelContentByColumnIndex(1, sheet, ios);
			listStrings21 = extractExcelContentByColumnIndex(20, sheet, ios);

			for (int i = 0; i < listStrings1.size(); i++) 
			{
				enterText(itemId, listStrings1.get(i), "itemId");
				Thread.sleep(2000);
				click(find, "find");
				Thread.sleep(3000);
				click(select, "select");
				Thread.sleep(3000);
				selectOPtionByVisibleText(selectVal, "3-Item Details & Flags");
				Thread.sleep(3000);
				click(plusVal, "plusVal");
			}

		} catch (Exception ex) {
			System.out.println("Cataloging Navigating Work With Property" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Cataloging Work With Property pag",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
	}

	public void docataloging() throws IOException {
		try {
			// driver.switchTo().frame(iframe);
			Thread.sleep(5000);
			System.out.println("docataloguing");
			// driver.switchTo().frame(iframe);

			ArrayList<String> listStrings1 = new ArrayList<String>();
			FileInputStream ios = new FileInputStream(
					"D:\\catalogue_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowS = sheet.getPhysicalNumberOfRows();
			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']")).click();
			remoteDriver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']"))
					.sendKeys("P57P41T");
			click(searchArrow, "searchArrow");
			Thread.sleep(3000);
			remoteDriver.switchTo().frame(iframe);

			listStrings1 = extractExcelContentByColumnIndex(0, sheet, ios);

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

			// listStrings1 = extractExcelContentByColumnIndex(0, sheet,
			// ios);
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

			for (int i = 0; i < listStrings1.size(); i++) {
				enterText(itemId, listStrings1.get(i), "itemId");

				Thread.sleep(2000);
				click(find, "find");
				Thread.sleep(3000);
				click(select, "select");
				Thread.sleep(3000);
				// Enter Hilling text
				click(hilling, "hilling");
				Thread.sleep(3000); // toBEHilled.click();
				enterText(gneralText, listStrings2.get(i), "gneralText");
				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(3000);

				// Enter Photo text
				click(photo, "photo");
				Thread.sleep(3000);
				if (toBePhoto.isSelected()) {
					click(toBePhoto, "toBePhoto");
				}

				enterText(gneralText, listStrings3.get(i), "gneralText");
				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(3000);
				click(save, "save");
				Thread.sleep(3000);
				// save.click();
				Thread.sleep(3000);
			}
		} catch (Exception ex) {
			System.out.println("Cataloging Navigating Work With Property" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside Cataloging Work With Property page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

	} 

	public boolean switchWindow(String title) throws IOException {
		System.out.println("switch control to window");
		String currentWindow = remoteDriver.getWindowHandle();
		Set<String> availableWindows = remoteDriver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				if (remoteDriver.switchTo().window(windowId).getTitle()
						.equals(title)) {
					return true;
				} else {
					remoteDriver.switchTo().window(currentWindow);
				}
			}
		}

		return false;
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
								// System.out.println("CELL_TYPE_NUMERIC");
								columndata.add(cell.getNumericCellValue() + "");
								break;

							case Cell.CELL_TYPE_STRING:
								// System.out.println("CELL_TYPE_STRING");
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

	public ArrayList<ArrayList<String>> search(List<String> itemNumber)
			throws Exception {
		System.out.println("inside k itemNumber" + itemNumber);
		remoteDriver.switchTo().frame(iframe);
		ArrayList<String> barLsit = new ArrayList<String>();
		ArrayList<String> poSoForArr = new ArrayList<String>();
		ArrayList<ArrayList<String>> ArrayList2 = new ArrayList<ArrayList<String>>();
		String fieldName;
		List<WebElement> webEle4 = remoteDriver
				.findElements(By.className("JSGridHeaderCell"));
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
		rowValue = remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.getText();
		Thread.sleep(3000);
		System.out.println("rowValue" + rowValue);
		return rowValue;
	}

	public void getOrderNumberFromPdf() {

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

		String OrderValue = getORnumber(ORNoOtpt);
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
		functionallibraries.FunctionalLibrary.propertiesWrite("SVNumber",
				SVNumber);
		functionallibraries.FunctionalLibrary.propertiesWrite("OrderValue",
				OrderValue);
		// functionallibraries.FunctionalLibrary.propertiesWrite("OrderValue11",
		// OrderNumber);

		System.out.println("data has been inputted");

	}

	private String getORnumber(String ORNoOtpt) {
		String OrderNumber = null;
		if (ORNoOtpt.contains("OR")) {
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
				System.out.println(
						"Order number is " + ORNoArray[orLocation + 1]);
				OrderNumber = ORNoArray[orLocation + 1];
			}
		} else {
			System.out.println("No order number is present");
			OrderNumber = null;
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

}
