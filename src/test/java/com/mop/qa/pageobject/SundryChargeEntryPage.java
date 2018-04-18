package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.Utilities.MPException;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class SundryChargeEntryPage extends PageBase {
	// UI Map object definitions

	protected SundryChargeEntryPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
	}

	@FindBy(xpath = "//input[@title='Buyer Seller Address']")
	private WebElement buyerSellerAddress;

	@FindBy(xpath = "//input[@title='Company']")
	private WebElement company;

	@FindBy(xpath = "//input[@title='Department']")
	private WebElement department;

	@FindBy(xpath = "//input[@title='Order Number']")
	private WebElement orderNumber;

	@FindBy(xpath = "//*[@id='HE0_99']/tbody/tr/td[2]/span/nobr")
	private WebElement sellerSO;

	@FindBy(xpath = "//*[@id='HE0_95']/tbody/tr/td[2]/span/nobr")
	private WebElement sopr;

	@FindBy(xpath = "//*[@id='HE0_96']/tbody/tr/td[2]/span/nobr")
	private WebElement soPo;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//span/button[text()='Create Charge']")
	private WebElement chargebtn;

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement search;

	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExitButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;
	
	TestBase test = new TestBase();

	public SundryChargeEntryPage createSundryCharge(String chargeType)
			throws  IOException, MPException {

		
		String compan = rds.getValue("General_Data", test.currentTest, "Company");
		String deptNum = rds.getValue("General_Data", test.currentTest, "Department");
		String accntNo = getJDEAppProperties("AccountNumber");

		try {
			remoteDriver.switchTo().frame(menuIframe);
			enterText(buyerSellerAddress, accntNo, "buyerSellerAddress");
			Thread.sleep(2000);
			
			enterText(company, compan, "company");

			Thread.sleep(2000);
			
			enterText(department, deptNum, "department");

			Thread.sleep(2000);
			
			click(search, "search");
			click(formExitButton, "formExitButton");

			Thread.sleep(3000);
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			if (chargeType.equalsIgnoreCase("SOPR")) {
				moveToElement(sopr, "sopr");
				click(sopr, "sopr");
				Thread.sleep(3000);
			} else if (chargeType.equalsIgnoreCase("SOPO")) {
				action.moveToElement(soPo).click().build().perform();
				moveToElement(soPo, "soPo");
				click(sopr, "sopr");
				Thread.sleep(3000);
			} else if (chargeType.equalsIgnoreCase("SO")) {
				moveToElement(sellerSO, "sellerSO");
				click(sellerSO,"sellerSO"); 
				Thread.sleep(3000);
			}

			moveToElement(sellerSO, "sellerSO");
			click(sellerSO,"sellerSO");  
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.PASS, "createSundryCharge successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println("batchReviewFromSeteport" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside batchReviewFromSeteport BatchReviewPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SundryChargeEntryPage(remoteDriver);
	}

	public PrinterSelectionPage sundryChargeCreation()
			throws  Exception {
		Thread.sleep(2000);
		System.out.println("inside sundryChargeCreation");
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("Ship To Number");
		list3.add("Department");
		list3.add("Sale Site");
		list3.add("Charge Item");
		list3.add("Quantity");
		list3.add("Unit Price");

		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		String strTodaysDate = dateFormat.format(currentDate);
		System.out.println(strTodaysDate);

		ArrayList<String> list4 = new ArrayList<String>();
		String shipToNumber = rds.getValue("General_Data", test.currentTest, "ShipToNumber");
		String deptNum = rds.getValue("General_Data", test.currentTest, "Department");
		String chargeItem = rds.getValue("General_Data", test.currentTest, "ChargeItem");
		String saleSit = rds.getValue("General_Data", test.currentTest, "SaleSite");


		list4.add(shipToNumber);
		list4.add(deptNum);
		list4.add(saleSit);
		list4.add(chargeItem);
		list4.add("1");
		list4.add("2000");

		for (int j = 0; j < list4.size(); j++) {
			enterValues(list3.get(j), 0, list4.get(j));
		}
		Thread.sleep(2000);
		click(chargebtn, "chargebtn");
		Thread.sleep(8000);
		Thread.sleep(5000);
		ExtentUtility.getTest().log(LogStatus.PASS, "sundryChargeCreation successfull",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return new PrinterSelectionPage(remoteDriver);

	}

	public void enterValues(String fieldName, int RowCount, String list1) {
		System.out.println(gridList.size());
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
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).click();
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).clear();
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).sendKeys(list1.trim());
	}

}