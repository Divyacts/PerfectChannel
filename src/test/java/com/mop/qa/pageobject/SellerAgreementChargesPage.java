package com.mop.qa.pageobject;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.MPException;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import io.appium.java_client.AppiumDriver;
import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class SellerAgreementChargesPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//*[@id='jdeGridData0_1']/tbody/tr")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//input[@title='Transit To LDL']")
	private WebElement transitToLDL;

	@FindBy(xpath = "//input[@title='Transit From LDL']")
	private WebElement transitFromLDL;


	public SellerAgreementChargesPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public SellerAgreementChargesPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	
	TestBase test = new TestBase();

	public SellerAgreementDetailsPage setChargeValue() {
		System.out.println("inside setChargeValue");
		try {

			String chrgeType = selectCharge();
			selectChargeType(chrgeType);
			Thread.sleep(1000);
			click(save, "Save Element");
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("Exception inside setChargeValue" + ex);
		}
		return new SellerAgreementDetailsPage(remoteDriver); 
	}

	public String selectCharge() throws Exception {
		
		String Charges = rds.getValue("SellerAgreement_Data", test.currentTest, "Charges");
		String TransitToLDL = rds.getValue("SellerAgreement_Data", test.currentTest, "TransitToLDL");
		String TransitFromLDL = rds.getValue("SellerAgreement_Data", test.currentTest, "TransitFromLDL");

		try {
			assertTrue(transitToLDL.isDisplayed(),
					"Transit to LDL check box is dispalyed");
			assertTrue(transitFromLDL.isDisplayed(),
					"Transit from LDL check box is dispalyed");
			Thread.sleep(3000);
			if (TransitToLDL.trim().equalsIgnoreCase("N")) {
				transitToLDL.click();
			} else if (TransitFromLDL.trim().equalsIgnoreCase("N")) {
				transitFromLDL.click();
			}

			System.out.println("slectCharge" + Charges);
			System.out.println(" abosorbinggg " + "//input[@title='"
					+ Charges.trim() + "']");
			assertTrue(remoteDriver
					.findElement(By
							.xpath("//input[@title='" + Charges.trim() + "']"))
					.isDisplayed(), "Transit to LDL check box is dispalyed");
			remoteDriver.findElement(
					By.xpath("//input[@title='" + Charges.trim() + "']"))
					.click();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Exception inside selectCharge method" + ex);
		}

		return Charges;
	}

	public void enterValues(String fieldName, int RowCount, String list1)
			throws InterruptedException {
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
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		System.out.println("before entering");
		System.out.println("RowCount" + RowCount);
		if ((colindexcolindexValue.equalsIgnoreCase("2")
				|| (colindexcolindexValue.equalsIgnoreCase("6"))
				|| (colindexcolindexValue.equalsIgnoreCase("8"))
				|| colindexcolindexValue.equalsIgnoreCase("9"))) {
			if (list1.contains("Y")) {

				remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + (RowCount)
						+ "']/td[@colindex='" + colindexcolindexValue
						+ "']/div/input[@type='checkbox']")).click();
				Thread.sleep(2000);

			}

		} else if (!list1.contains("NA")) {
			remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
					+ "']/td[@colindex='" + colindexcolindexValue
					+ "']/div/input[@class='JSTextfield']")).click();
			remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
					+ "']/td[@colindex='" + colindexcolindexValue
					+ "']/div/input[@class='JSTextfield']"))
					.sendKeys(list1.trim());
			Thread.sleep(3000);

		}

	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) {
		System.out.println("in rowCreation" + count);
		try {
			for (int j = 0; j < list1.size(); j++) {
				enterValues(list.get(j), count, list1.get(j));
			}
		} catch (InterruptedException e) {
			System.out.println(
					"Exception inside rowCreation for charges method" + e);
		}
	}

	public void selectChargeType(String chrges) {
		try {
			Thread.sleep(3000);
			
			String ChargeType = rds.getValue("SellerAgreement_Data", test.currentTest, "ChargeType");
			String capp = rds.getValue("SellerAgreement_Data", test.currentTest, "Capped");
			String cappVal = rds.getValue("SellerAgreement_Data", test.currentTest, "Capped Value");
			String cappCur = rds.getValue("SellerAgreement_Data", test.currentTest, "Capped Currency");
			
			String perLot = rds.getValue("SellerAgreement_Data", test.currentTest, "Per Lot or Consignment");
			String Split = rds.getValue("SellerAgreement_Data", test.currentTest, "Split");
			String absorb = rds.getValue("SellerAgreement_Data", test.currentTest, "% Christies Absorb");
			String christies = rds.getValue("SellerAgreement_Data", test.currentTest, "Christies");

			String seller =rds.getValue("SellerAgreement_Data", test.currentTest, "Seller");

			ArrayList<String> list = new ArrayList<String>();
			list.add("Capped");
			list.add("Capped Value");
			list.add("Capped Currency");
			list.add("Per Lot or Consignment");
			list.add("Split");
			list.add("% Christies Absorb");
			list.add("Christies");
			list.add("Seller");

			ArrayList<String> list2 = new ArrayList<String>();
			list2.add(capp);
			list2.add(cappVal);
			list2.add(cappCur);
			list2.add(perLot);
			list2.add(Split);
			list2.add(absorb);
			list2.add(christies);
			list2.add(seller);

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add("Framing & Mounting");
			list1.add("Marketing");
			list1.add("Packing & Shipping from Client");
			list1.add("Restoration");
			list1.add("Testing & Analysis");
			list1.add("Unsold Storage");
			list1.add("Unsold Pack & Ship to Client");
			list1.add("Expertise");

			if (chrges.trim().equalsIgnoreCase("Absorbing Some Costs")
					|| chrges.trim().equalsIgnoreCase("Sharing Costs")) {
				System.out.println("inside if");
				Thread.sleep(1000);
				for (int j = 0; j < gridList.size(); j++) {
					System.out.println("ChargeType" + ChargeType);
					System.out.println("list1.get(j)" + list1.get(j));
					if (ChargeType.trim().equalsIgnoreCase(list1.get(j))) {
						System.out.println("isnide if");
						remoteDriver.findElement(By
								.xpath("//*[@id='G0_1_R" + j + "']/td[3]/div"))
								.click();
						Thread.sleep(1000);
						System.out.println("J value" + j);
						rowCreation(j, list, list2);
					}

				}

			} else {
				System.out.println("inside else");
				for (int j = 0; j < gridList.size(); j++) {
					System.out.println("ChargeType" + ChargeType);
					System.out.println("list1.get(j)" + list1.get(j));
					if (ChargeType.trim().equalsIgnoreCase(list1.get(j))) {
						System.out.println("isnide if");
						remoteDriver.findElement(By
								.xpath("//*[@id='G0_1_R" + j + "']/td[3]/div"))
								.click();
						Thread.sleep(1000);

					}

				}
			}

		} catch (Exception ex) {
			System.out.println("Exception inside selectChargeType method" + ex);
		}
	}
}