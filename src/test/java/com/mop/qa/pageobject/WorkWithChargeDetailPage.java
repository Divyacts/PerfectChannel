package com.mop.qa.pageobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mop.qa.testbase.PageBase;

public class WorkWithChargeDetailPage extends PageBase {

	// UI Map object definitions
	@FindBy(xpath = "//span/button[text()='Create Charge']")
	private WebElement chargebtn;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;


	protected WorkWithChargeDetailPage(RemoteWebDriver remoteWebDriver)
			throws InterruptedException {
		super(remoteWebDriver);

	}

	public PrinterSelectionPage selectCharge() throws Exception {
		Thread.sleep(2000);
		System.out.println("inside selectCharge");
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("Charge Item");
		list3.add("Quantity");
		list3.add("Unit Price");
		list3.add("Supplier Number");
		list3.add("PO Request Date");

		Date currentDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		String strTodaysDate = dateFormat.format(currentDate);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 1);
		strTodaysDate = dateFormat.format(c.getTime());
		System.out.println("output" + strTodaysDate); 
		System.out.println(strTodaysDate);

		ArrayList<String> list4 = new ArrayList<String>();
		list4.add("RES");
		list4.add("1");
		list4.add("2000");
		// list4.add("90006720");
		list4.add("90001006");
		list4.add(strTodaysDate); 

		for (int j = 0; j < list4.size(); j++) {
			enterValues(list3.get(j), 0, list4.get(j));
		}
		Thread.sleep(2000);
		click(chargebtn, "chargebtn");  
		Thread.sleep(8000);
		Thread.sleep(5000);

		System.out.println("Printer Selection Page:-" + remoteDriver.getTitle());
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
