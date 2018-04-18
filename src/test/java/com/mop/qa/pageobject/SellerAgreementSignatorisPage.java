package com.mop.qa.pageobject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.Utilities.MPException;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper; 

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class SellerAgreementSignatorisPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//*[@id='C0_34']")
	private WebElement sigType;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='rownumber_gridheader']")
	private WebElement numberOfRows;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;


	public SellerAgreementSignatorisPage(RemoteWebDriver remoteDriver) { 
		super(remoteDriver);
	}

	TestBase test = new TestBase();
	


	public void checkTableContent() throws Exception {
		System.out.println("inside checkTableContent");

		String noOfRows = numberOfRows.getText();
		noOfRows = noOfRows.trim();
		String rowArray[] = noOfRows.split(" - ");
		String rowRequired = rowArray[1];

		Integer rows = Integer.parseInt(rowRequired);
		rows = rows - 1;
		rowRequired = rows.toString();

		String fieldName = "Type Of Name Description";

		int count = 0;

		String batchNumber;
		
		String SigType = rds.getValue("SellerAgreement_Data", test.currentTest, "SigType");


		ArrayList<String> agentList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("Name of Owner");

		ArrayList<String> companyList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("Title of Signatory");
		agentList.add("Company Name");

		ArrayList<String> estateList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("As Executor/PR of the late");

		ArrayList<String> partnerList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("Name of Partnership");

		ArrayList<String> attorneyList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("Attorney for");

		ArrayList<String> trustList = new ArrayList<>();
		agentList.add("Name of Signatory");
		agentList.add("Name of Trust");

		System.out.println("rows" + rows);

		for (int i = 0; i < rows - 1; i++) {
			System.out.println("i valueee" + i);
			if (SigType.equalsIgnoreCase("Agent")) {
				System.out.println("in Agent");
				String coldata = getValues(fieldName, i);
				System.out.println("coldata" + coldata);
				assertTrue(agentList.contains(coldata),
						"Agent table details are present in the JDE UI "
								+ coldata + "");

			}
			if (SigType.equalsIgnoreCase("Company")) {
				String coldata = getValues(fieldName, i);
				assertTrue(companyList.contains(coldata),
						"Company table details are present in the JDE UI "
								+ coldata + "");

			}
			if (SigType.equalsIgnoreCase("Estate")) {
				String coldata = getValues(fieldName, i);
				assertTrue(estateList.contains(coldata),
						"Estate table details are present in the JDE UI "
								+ coldata + "");

			}

			if (SigType.equalsIgnoreCase("Individual")) {
				String coldata = getValues(fieldName, i);
				assertTrue(agentList.contains(coldata),
						"Individual table details are present in the JDE UI "
								+ coldata + "");

			}

			if (SigType.equalsIgnoreCase("Partenrship")) {
				String coldata = getValues(fieldName, i);
				assertTrue(partnerList.contains(coldata),
						"Partenrship table details are present in the JDE UI "
								+ coldata + "");

			}

			if (SigType.equalsIgnoreCase("Power of Attorney")) {
				String coldata = getValues(fieldName, i);
				assertTrue(attorneyList.contains(coldata),
						"Power of Attorney table details are present in the JDE UI "
								+ coldata + "");

			}

			if (SigType.equalsIgnoreCase("Trust")) {
				String coldata = getValues(fieldName, i);
				assertTrue(trustList.contains(coldata),
						"Trust table details are present in the JDE UI "
								+ coldata + "");

			}
 
		}

	}

	public String getValues(String fieldName, int RowCount) {
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
		System.out.println("rowValue" + rowValue);
		return rowValue;

	}

	public SellerAgreementDetailsPage setSignotoryVal() {
		System.out.println("inside setSignotoryVal");
		try {
			
			String SigType = rds.getValue("SellerAgreement_Data", test.currentTest, "SigType");


			if (SigType.trim().equalsIgnoreCase("Agent")) {
				System.out.println("isndie agent");
				selectOPtionByIndex(sigType, 1);
				Thread.sleep(3000);
				enterTableValues(2);
			}

			else if (SigType.trim().equalsIgnoreCase("Company")) {
				selectOPtionByIndex(sigType, 2);
				Thread.sleep(3000);
				enterTableValues(3);
			} else if (SigType.trim().equalsIgnoreCase("Estate")) {
				selectOPtionByIndex(sigType, 3);
				Thread.sleep(3000);
				enterTableValues(2);
			} else if (SigType.trim().equalsIgnoreCase("Individual")) {
				selectOPtionByIndex(sigType, 4);
				Thread.sleep(3000);
				enterTableValues(1);
			} else if (SigType.trim().equalsIgnoreCase("Partnership")) {
				selectOPtionByIndex(sigType, 5);
				Thread.sleep(3000);
				enterTableValues(2);
			} else if (SigType.trim().equalsIgnoreCase("Power of Attorney")) {
				selectOPtionByIndex(sigType, 6);
				Thread.sleep(3000);
				enterTableValues(2);
			} else if (SigType.trim().equalsIgnoreCase("Trust")) {
				selectOPtionByIndex(sigType, 7);
				Thread.sleep(3000);
				enterTableValues(2);
			}
			Thread.sleep(500);
			checkTableContent();
			Thread.sleep(2000);
			click(saveButton,"saveButton");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Exception inside Set Signature Value" + ex);

		}
		return new SellerAgreementDetailsPage(remoteDriver);
	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws InterruptedException {
		System.out.println("inside row");
		Thread.sleep(3000);
		for (int j = 0; j < list.size(); j++) {
			enterValues(list.get(j), count, list1.get(j));
		}
	}

	public void enterTableValues(int count) throws IOException {
		try {

			String multipleSite = rds.getValue("SellerAgreement_Data", test.currentTest, "MultipleSite");

			List<WebElement> webEle2 = remoteDriver
					.findElements(By.className("JSGridHeaderCell"));
			if (multipleSite.equalsIgnoreCase("Y")) {
				System.out.println("inside multipleSite");

				ArrayList<String> list = new ArrayList<String>();
				list.add("Signatory Type");
				// list.add("Sequence Number");
				list.add("Type Of Name");
				list.add("Co");
				
				String companyCode1 = rds.getValue("SellerAgreement_Data", test.currentTest, "CompanyCode1");

				String companyCode2 = rds.getValue("SellerAgreement_Data", test.currentTest, "CompanyCode2");

				String companyCode3 = rds.getValue("SellerAgreement_Data", test.currentTest, "CompanyCode3");

				String TypeOfName = rds.getValue("SellerAgreement_Data", test.currentTest, "TypeOfName");

				String SigTypeCode = rds.getValue("SellerAgreement_Data", test.currentTest, "SigTypeCode");

				/*
				 * String Sequence1 = dataTable.getData("SellerAgreement_Data",
				 * "Sequence1"); String Sequence2 =
				 * dataTable.getData("SellerAgreement_Data", "Sequence2");
				 * String Sequence3 = dataTable.getData("SellerAgreement_Data",
				 * "Sequence3");
				 */

				/*
				 * ArrayList<String> sequenceCode = new ArrayList<String>();
				 * sequenceCode.add(Sequence1); sequenceCode.add(Sequence2);
				 * sequenceCode.add(Sequence3);
				 */

				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(companyCode1);
				if (!companyCode2.isEmpty()) {
					list1.add(companyCode2);
				}
				if (!companyCode3.isEmpty()) {
					list1.add(companyCode3);
				}

				int cnt = 0;
				System.out.println("list1.size()" + list1.size());
				for (int i = 0; i < list1.size(); i++) {
					System.out.println("for loop" + i);
					ArrayList<String> finalList = new ArrayList<String>();
					finalList.add(SigTypeCode);
					// finalList.add(sequenceCode.get(i));
					finalList.add(TypeOfName);
					finalList.add(list1.get(i));
					System.out.println("create row printing i" + finalList);
					cnt = count + i;
					System.out.println("cnt" + cnt);
					rowCreation(cnt, list, finalList);
					List<WebElement> webElemHeader = remoteDriver
							.findElements(By.className("JSGridHeaderCell"));
					WebElement element = webElemHeader.get(0);
					Actions actions = new Actions(remoteDriver);
					actions.moveToElement(element);
					actions.perform();
					Thread.sleep(3000);

					WebElement element3 = remoteDriver
							.findElement(By.xpath("//*[@id='G0_1_R"
									+ (count + i) + "']/td[2]/div/input"));
					Actions actions1 = new Actions(remoteDriver);
					actions1.sendKeys(element3, Keys.ARROW_DOWN).build()
							.perform();
					Thread.sleep(1000);

				}

			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add("Co");
				String companyCode = rds.getValue("General_Data", test.currentTest, "Company");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(companyCode);

				rowCreation(count, list, list1);
				List<WebElement> webEle3 = remoteDriver
						.findElements(By.className("JSGridHeaderCell"));
				WebElement element = webEle2.get(0);
				Actions actions = new Actions(remoteDriver);
				actions.moveToElement(element);
			}

		} catch (Exception ex) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " enterTableValues in Signatories",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void enterValues(String fieldName, int RowCount, String list1)
			throws InterruptedException {
		List<WebElement> webEle2 = remoteDriver
				.findElements(By.className("JSGridHeaderCell"));
		System.out.println("inside enter val" + webEle2.size());
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
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).clear();
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue
				+ "']/div/input[@class='JSTextfield']")).sendKeys(list1.trim());
		Thread.sleep(3000);
	}
}