package com.mop.qa.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class TieredRatePage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]/div/input")
	private WebElement tyreType2;

	@FindBy(xpath = "//input[@title='Tier Type']")
	private WebElement tierType;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//*[@id='HE0_39']/tbody/tr/td[2]/span/nobr")
	private WebElement details;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[4]/div/input")
	private WebElement threshold;

	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement add;
	
	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement close;

	
	public TieredRatePage(RemoteWebDriver remoteDriver) { 
		super(remoteDriver);
	}

	TestBase test = new TestBase();
	
	public TieredRatePage entertierDetailsAndSave() {
		try {
			Thread.sleep(3000);
			System.out.println("inside entertierDetailsAndSave");
			
			String tierTpe = rds.getValue("SellerAgreement_Data", test.currentTest, "TierType");
			enterText(tierType, tierTpe, "TierType");
			enterText(tyreType2, tierTpe, "TierType2");
			click(rowExit, "RowExit");
			click(details, "Details");

			enterTableValues(0);
			
			click(saveButton, "Save");
			click(saveButton, "Save");
			click(saveButton, "Save");
			click(close, "close");
		} catch (Exception ex) {
			System.out.println("Exception inside entertierDetailsAndSave" + ex);
		}
		return new TieredRatePage(remoteDriver);
	}

	public void enterTableValues(int count) {
		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add("Threshold From");
			list.add("Rate");
			// list.add("Value");

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add("40");
			list1.add("3");
			// list1.add("40");

			rowCreation(count, list, list1);
			List<WebElement> webEle2 = remoteDriver.findElements(By
					.className("JSGridHeaderCell"));
			WebElement element = webEle2.get(0);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);

		} catch (Exception ex) {
			System.out.println("Exception"+ex);
		}
	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws InterruptedException {
		Thread.sleep(3000);
		for (int j = 0; j < list.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
		}

	}

	public void enterValues(String fieldName, int RowCount, String list1) {
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