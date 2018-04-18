package com.mop.qa.pageobject;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.DateObject;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import io.appium.java_client.AppiumDriver;

public class SaleSessionViewingPage extends PageBase {

	public SaleSessionViewingPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public SaleSessionViewingPage(AppiumDriver appiumDriver) {
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

	@FindBy(xpath = "//input[@title='Sale Type']")
	private WebElement saleType;

	@FindBy(xpath = "//input[@title='Sale Category']")
	private WebElement saleCat;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	
	TestBase test = new TestBase();
	
	public SaleSessionViewingPage enter3ScreenVal() throws InterruptedException {
		try {
			// driver.switchTo().frame(iframe);
			ArrayList<String> list3 = new ArrayList<String>();
			list3.add("Time Start");
			list3.add("Time End");
			list3.add("Lot Range From");
			list3.add("Lot Range To");

			ArrayList<String> list4 = new ArrayList<String>();
			list4.add("11");
			list4.add("17");
			list4.add("1");
			list4.add("9999");

			for (int j = 0; j < list4.size(); j++) {
				enterValues(list3.get(j), 0, list4.get(j));
			}

			save.click();
			Thread.sleep(4000);

		} catch (Exception ex) {
			System.out.println("enter3ScreenVal" + ex);
			/*report.updateTestLog(
					"Exception",
					"Exception inside SaleSessionViewingPage 3rd screenValue page",
					Status.FAIL);*/
		}
		return new SaleSessionViewingPage(remoteDriver);
	}
	
	public SaleSessionViewingPage enterecomData() throws InterruptedException {
		try {
			// driver.switchTo().frame(iframe);
			ArrayList<String> list3 = new ArrayList<String>();
			list3.add("Session Number");
			list3.add("Time Start");
			list3.add("Time End");
			list3.add("Lot Range From");
			list3.add("Lot Range To");
			
		
			String sessionStartTime = rds.getValue("General_Data", test.currentTest, "SessionSatrtDate");
			String lotStartTime = rds.getValue("General_Data", test.currentTest, "LotTimeStart");
			String lotTimeEnd = rds.getValue("General_Data", test.currentTest, "LotTimeEnd");
			String lotStart = rds.getValue("General_Data", test.currentTest, "LotRangeStart");
			String lotEnd = rds.getValue("General_Data", test.currentTest, "LotRangeEnd");

			ArrayList<String> list4 = new ArrayList<String>();
			list4.add(sessionStartTime);
			list4.add(lotStartTime);
			list4.add(lotTimeEnd);
			list4.add(lotStart);
			list4.add(lotEnd);  

			for (int j = 0; j < list4.size(); j++) {
				enterValues(list3.get(j), 0, list4.get(j));
			}
 
			click(save,"Click Save in Session screen");
			Thread.sleep(4000); 

		} catch (Exception ex) {
			System.out.println("enter3ScreenVal" + ex);
			/*report.updateTestLog(
					"Exception",
					"Exception inside SaleSessionViewingPage 3rd screenValue page",
					Status.FAIL);*/
		}
		return new SaleSessionViewingPage(remoteDriver);
	}

	public PostSaleTransferPage enter4ScreenVal(DateObject date)
			throws InterruptedException {
		try {
			// driver.switchTo().frame(iframe);
			Thread.sleep(3000);
			ArrayList<String> lists = new ArrayList<String>();
			lists.add("Viewing No");
			lists.add("Date");
			lists.add("Time Start");
			lists.add("Time End");
			lists.add("Location");
			lists.add("Viewing Notes");

			String pin = generatePIN();
			/*
			 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 * Calendar c = Calendar.getInstance(); c.setTime(new Date()); //
			 * Now use today date. c.add(Calendar.DATE, 1); // Adding 1 day
			 * String output = sdf.format(c.getTime());
			 */
			String output = date.getDateVal();
			ArrayList<String> lists1 = new ArrayList<String>();
			lists1.add(pin);
			lists1.add(output);
			lists1.add("11");
			lists1.add("17");
			lists1.add("test");
			lists1.add("test");

			for (int j = 0; j < lists1.size(); j++) {
				enterValues(lists.get(j), 0, lists1.get(j));
			}
			Thread.sleep(3000);
			save.click();
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("enter4ScreenVal" + ex);
			

		}
		return new PostSaleTransferPage(remoteDriver);
	}
	
	

	public String generatePIN() {
		int x = (int) (Math.random() * 9);
		x = x + 1;
		String randomPIN = (x + "") + (((int) (Math.random() * 1000)) + "");
		return randomPIN;
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
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).click();
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).clear();
		remoteDriver.findElement(
				By.xpath("//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
						+ colindexcolindexValue
						+ "']/div/input[@class='JSTextfield']")).sendKeys(
				list1.trim());
	}

}
