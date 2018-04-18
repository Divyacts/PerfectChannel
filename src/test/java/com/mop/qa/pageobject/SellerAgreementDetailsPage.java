package com.mop.qa.pageobject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.Utilities.SellerAgrment;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;


public class SellerAgreementDetailsPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "(//input[@title='Address Number'])[1]")
	private WebElement addressNum;

	@FindBy(xpath = "//input[@title='Date Signed']")
	private WebElement dateSigned;

	@FindBy(xpath = "(//input[@title='Seller Agreement'])[1]")
	private WebElement sellerAgreementNumber;

	@FindBy(xpath = "(//input[@title='Deal Type'])[1]")
	private WebElement dealType;

	@FindBy(xpath = "//input[@title='Source Site']")
	private WebElement sourceSite;

	@FindBy(xpath = "//*[@id='C0_583']")
	private WebElement consignedBy;

	@FindBy(xpath = "//button[contains(text(),'Charges')]")
	private WebElement chargesButton;

	@FindBy(xpath = "//button[contains(text(),'Signatories')]")
	private WebElement signatoriesButton;

	@FindBy(xpath = "//button[contains(text(),'Payment Instructions')]")
	private WebElement paymentButton;

	@FindBy(xpath = "//*[@id='C0_34']")
	private WebElement sigType;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//button[@title = 'Ctrl+Alt+O']")
	private WebElement okButton;

	@FindBy(xpath = "//a[@title='Non Standard (Alt+2)']")
	private WebElement nonStandard;

	@FindBy(xpath = "//a[@title='Bespoke (Alt+3)']")
	private WebElement bespoke;

	@FindBy(xpath = "//input[@title='Rate Type']")
	private WebElement rateType;

	@FindBy(xpath = "//input[@title='VPhone Number']")
	private WebElement vPhoneNum;

	@FindBy(xpath = "//input[@title='CTL']")
	private WebElement ctl;

	@FindBy(xpath = "//input[@title='KYC Status']")
	private WebElement kycStatus;

	@FindBy(xpath = "//input[@title='VCountry']")
	private WebElement vCountry;

	@FindBy(xpath = "//input[@title='Client Language']")
	private WebElement clientLang;

	@FindBy(xpath = "//input[@title='Account Type']")
	private WebElement accntType;

	@FindBy(xpath = "//input[@title='Seller Agreement Approver']")
	private WebElement sellerApprover;

	@FindBy(xpath = "//input[@title='Legal Approver']")
	private WebElement legalApprover;

	@FindBy(xpath = "//input[@title='IC Payee Account']")
	private WebElement icPayee;

	@FindBy(xpath = "//input[@title='Annual']")
	private WebElement annual;

	@FindBy(xpath = "//input[@title='Online Sale']")
	private WebElement onlineSale;

	@FindBy(xpath = "//input[@title='Legal Notes']")
	private WebElement legalNots;

	@FindBy(xpath = "//input[@title='Seller Agreement']")
	private WebElement sellerAgreement;

	@FindBy(xpath = "//input[@title='Performance Comm Waiver']")
	private WebElement perfComWavier;

	@FindBy(xpath = "//input[@title='NY Interiors']")
	private WebElement nyInteriors;

	@FindBy(xpath = "//input[@title='Apply BI Fees']")
	private WebElement biFees;

	@FindBy(xpath = "//input[@title='Performance Comm']")
	private WebElement perfCom;

	@FindBy(xpath = "//input[@title='Introductory Commission']")
	private WebElement icCheck;

	@FindBy(xpath = "//input[@title='IC Approved']")
	private WebElement icApproved;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//input[@title='Loss Damage Liability']")
	private WebElement lossDL;

	@FindBy(xpath = "//input[@title='Seller Status']")
	private WebElement sellerStatus;

	public SellerAgreementDetailsPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public SellerAgreementDetailsPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	TestBase test = new TestBase();

	public SellerAgreementStandardPage setICJudistriction() {
		try {
			Thread.sleep(2000);
			click(icCheck, "IC Checkbox");
			String ICAccnt = rds.getValue("SA_IC", test.currentTest, "ICAccnt");
			enterText(icPayee, ICAccnt, "IC PAyee Account");
			Thread.sleep(2000);
			click(icApproved, "ICApproved Checkbox");
			String icDealType = rds.getValue("SA_IC", test.currentTest, "ICDealtype");
			if (!icDealType.isEmpty()) {

			}

			enterVal("IC Jurisdriction", 0);

		} catch (Exception ex) {
			System.out.println("Inside selectNonStandard" + ex);
		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public void enterVal(String fieldName, int RowCount) {
		String colindexcolindexValue;
		colindexcolindexValue = null;
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
		remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
				+ "']/td[@colindex='" + colindexcolindexValue + "']/div"))
				.click();

	}

	public String isAgreementCreated() throws InterruptedException {
		String sellerAgr = null;
		try {
			String saleNum = getJDEAppProperties("SellerAgreement");
			sellerAgreement.clear();
			sellerAgreement.sendKeys(saleNum);
			click(find, "Search");
			Thread.sleep(3000);
			sellerAgr = getValues("Seller Agreement", 0);
		} catch (Exception ex) {
			System.out.println("isAgreementCreated" + ex);
		}
		return sellerAgr;
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
		return rowValue;
	}

	public SellerAgrment createSellerAgrStand(
			ObjectOutputStream objectOutputStream, SellerAgrment sAgrement,
			ArrayList<String> Seller) {
		System.out.println("inside createSellerAgrStand");
		try { 
			Thread.sleep(5);
			
			 
			String AccountNumber = rds.getValue("SellerAgreement_Data", test.currentTest, "AccountNumber");
			String SaleSourceSite = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSourceSite");
			
			System.out.println("AccountNumber"+AccountNumber);
			String sellerAgNumb = getAttributeValue(sellerAgreementNumber, "value");
			propertiesJdeWrite("SellerAgreementNumber", sellerAgNumb);
			
			addressNum.clear();
			enterText(addressNum, AccountNumber, "AddressNumber");
			sourceSite.clear();
			enterText(sourceSite, SaleSourceSite, "Source Site");
			Thread.sleep(2000);
			
			String sellerStat = rds.getValue("SellerAgreement_Data", test.currentTest, "SellerStatus");

			if (!sellerStat.isEmpty()) {
				enterText(sellerStatus, sellerStat, "Seller Status");
			} 

			Date currentDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String strTodaysDate = dateFormat.format(currentDate); 
			
			String privateSale = rds.getValue("General_Data", test.currentTest, "PRivateSale");

			if (privateSale.equalsIgnoreCase("Y")) {
				enterText(dateSigned, strTodaysDate, "Date");
				
			}
			
			String approverName = rds.getValue("SellerAgreement_Data", test.currentTest, "ApproverName");
			System.out.println("approverName"+approverName);

			if (!approverName.isEmpty()) {
				enterText(sellerApprover, approverName, "Approver name");

			}
			
			String lApprover = rds.getValue("SellerAgreement_Data", test.currentTest, "LegalApprover");
			System.out.println("lApprover"+lApprover);

			if (!lApprover.isEmpty()) {
				enterText(legalApprover, lApprover, "LegalApprover name");
			}

			
			String vcntry = rds.getValue("SellerAgreement_Data", test.currentTest, "vCountry");

			if (!vcntry.isEmpty()) {
				assertTrue(
						vCountry.getAttribute("value").equalsIgnoreCase(vcntry),
						"Country code in JDE is dispalyed as present in COS for the specified account");
			}
			
			String clientla = rds.getValue("SellerAgreement_Data", test.currentTest, "cleintLanguage");

			if (!clientla.isEmpty()) {
				assertTrue(
						clientLang.getAttribute("value")
								.equalsIgnoreCase(clientla),
						"ClientLanguage in JDE is dispalyed as present in COS for the specified account");
			}

			String rateTyp = rds.getValue("SellerAgreement_Data", test.currentTest, "RateType");
			
			if (!rateTyp.isEmpty()) {
				enterText(rateType, rateTyp, "Rate Type");
			}

			
			String Annual = rds.getValue("SellerAgreement_Data", test.currentTest, "Annual");

			if (!Annual.isEmpty() && Annual.trim().equalsIgnoreCase("Y")) {
				click(annual, "Annual");

			}
			
			String biFe = rds.getValue("SellerAgreement_Data", test.currentTest, "Annual");
			if (!biFe.isEmpty() && biFe.trim().equalsIgnoreCase("Y")) {
				click(biFees, "Bi Fee");
				biFees.click();
			}

			
			String OnlineSale = rds.getValue("SellerAgreement_Data", test.currentTest, "OnlineSale");

			if (!OnlineSale.isEmpty()
					&& OnlineSale.trim().equalsIgnoreCase("Y")) {
				click(onlineSale, "Online sale");

			}

			
			String PerCommWave = rds.getValue("SellerAgreement_Data", test.currentTest, "PerCommWave");

			if (!PerCommWave.isEmpty()
					&& PerCommWave.trim().equalsIgnoreCase("Y")) {
				click(perfComWavier, "Perf Commission");
				perfComWavier.click();
			}
			
			String PerComm = rds.getValue("SellerAgreement_Data", test.currentTest, "PerComm");

			if (!PerComm.isEmpty()) {
				String perVAl = perfCom.getAttribute("value");
				assertTrue(perVAl.equalsIgnoreCase("2"),
						"Performance Commission value is defaulted to 2");
				enterText(perfCom, PerComm, "Performance Commission");
			}

			String lossLDL = rds.getValue("SellerAgreement_Data", test.currentTest, "LDL");
			if (!lossLDL.isEmpty()) {
				enterText(lossDL, lossLDL, "LossLDL");
			}

			String NyInteriors = rds.getValue("SellerAgreement_Data", test.currentTest, "NyInteriors");
			if (!NyInteriors.isEmpty()
					&& NyInteriors.trim().equalsIgnoreCase("Y")) {
				click(nyInteriors, "NY Interiors");
			}

			String legalNotes = rds.getValue("SellerAgreement_Data", test.currentTest, "legalNotes");
			if (!legalNotes.isEmpty()
					&& legalNotes.trim().equalsIgnoreCase("Y")) {
				click(legalNots, "Legal Notes");
			}

			// commenting for now
			/*
			 * if (!SaleSourceSite.equalsIgnoreCase("NYC")) { Select se = new
			 * Select(consignedBy); se.selectByIndex(1); Thread.sleep(3000); }
			 */
			
			String dealtpe = rds.getValue("SellerAgreement_Data", test.currentTest, "DealType");
			System.out.println("dealtpe" + dealtpe);
			Thread.sleep(3000);
			enterText(dealType, dealtpe, "DelaType"); 
			Thread.sleep(3000);
			enterMultipleSites();
			Thread.sleep(3000);
			Seller.add(sellerAgNumb);
			sAgrement.setSellerAgreement(Seller);
			/*
			 * System.out.println("sAgrement list object" +
			 * sAgrement.getSellerAgreement().size()); System.out.println(
			 * "sAgrement list object" + sAgrement.getSellerAgreement().get(0));
			 * objectOutputStream.writeObject(sAgrement);
			 */
			// objectOutputStream.flush();
			// objectOutputStream.close();
		} catch (Exception ex) {
			System.out.println("Inside createSeller Agreement Standard" + ex);

		}
		return sAgrement;
	}

	public void validateSellerHeaderPageFields() {

	}

	public SellerAgreementChargesPage selectCharge() {
		try {
			Thread.sleep(2000);
			click(chargesButton, "chargesButton");

		} catch (Exception ex) {
			System.out.println("Inside selectCharge" + ex);
		}
		return new SellerAgreementChargesPage(remoteDriver);
	}

	public SellerAgreementNonStandardPage selectNonStandard() {
		try {
			Thread.sleep(2000);
			click(nonStandard, "nonStandard");
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Inside selectNonStandard" + ex);
		}
		return new SellerAgreementNonStandardPage(remoteDriver);
	}

	public SellerAgreementBeSpokePage selectBeSpoke() {
		try {
			Thread.sleep(2000);
			click(bespoke, "bespoke");
			bespoke.click();
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("Inside selectBeSpoke" + ex);
		}
		return new SellerAgreementBeSpokePage(remoteDriver);
	}

	public SellerAgreementStandardPage saveOnly() {
		try {
			Thread.sleep(2000);
			click(save, "save");
			boolean elementisPresent = IsTestElementPresent();
			System.out.println("elementisPresent" + elementisPresent);
			if (elementisPresent) {
				click(save, "save"); 
			}
			Thread.sleep(5000);

		} catch (Exception ex) {
			System.out.println("Inside saveOnly" + ex);
		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("//*[@id='E0_1']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public SellerAgreementPayment selectPayments() {
		try {
			click(paymentButton,"Payment");
			Thread.sleep(3000);
			click(okButton,"ok Button");
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Inside selectPayments" + ex);
		}
		return new SellerAgreementPayment(remoteDriver);
	}

	public SellerAgreementSignatorisPage selectSignotories() {
		try {
			Thread.sleep(2000);
			click(signatoriesButton,"Signatories Button");

		} catch (Exception ex) {
			System.out.println("Inside selectSignotories" + ex);
		}
		return new SellerAgreementSignatorisPage(remoteDriver);
	}

	public void rowCreation(int count, ArrayList<String> list,
			ArrayList<String> list1) throws Exception {
		System.out.println("in rowCreation" + count);
		try {
			for (int j = 0; j < list1.size(); j++) {

				enterValues(list.get(j), count, list1.get(j));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Inside selectSignotories" + e);
		}
	}

	public void enterMultipleSites() {
		try {
			System.out.println("inside enterTableValues");

			ArrayList<String> list = new ArrayList<String>();
			list.add("Selling Site");
			/*
			 * String SaleSourceSite = functionallibraries.FunctionalLibrary
			 * .propertiesRead("SaleSourceSite");
			 */
			String SaleSellingSite1 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite1");
			String SaleSellingSite2 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite2");
			String SaleSellingSite3 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite3");
			

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add(SaleSellingSite1);
			if (!SaleSellingSite2.isEmpty()) {
				list1.add(SaleSellingSite2);
			}
			if (!SaleSellingSite3.isEmpty()) {
				list1.add(SaleSellingSite3);
			}
			// ArrayList<String> finalList = new ArrayList<String>();

			System.out.println("list1.size()" + list1.size());
			for (int k = 1; k <= list1.size(); k++) {
				System.out.println("cal k" + k);
				ArrayList<String> finalList1 = new ArrayList<String>();

				finalList1.add(list1.get(k - 1));

				System.out.println("finalList" + finalList1);

				rowCreation(k - 1, list, finalList1);
				Thread.sleep(3000);
				WebElement element3 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[3]/div/input"));
				moveToElement(element3, "ArrowDown");
				/*Actions actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();*/
				Thread.sleep(2000);
			}
		} catch (Exception ex) {
			System.out.println("Exception"+ex); 
		}
	}

	public void enterTableValues() throws IOException {
		try {
			System.out.println("inside enterTableValues");
			WebElement element = remoteDriver.findElement(
					By.xpath("//*[@id='G0_1_R0']/td[1]/div/input"));
			Actions actions3 = new Actions(remoteDriver);
			actions3.moveToElement(element);
			Thread.sleep(2000);
			element.click();
			Thread.sleep(1000);
			ArrayList<String> list = new ArrayList<String>();
			WebElement element3 = remoteDriver.findElement(
					By.xpath("//*[@id='G0_1_R0']/td[3]/div/input"));
			Actions actions1 = new Actions(remoteDriver);
			actions1.sendKeys(element3, Keys.ARROW_DOWN).build().perform();
			Thread.sleep(2000);
			list.add("Selling Site");
			list.add("LDL Override");
			list.add("Christie's LDL Override Rate");
			list.add("Transit LDL Override");
			list.add("Transit LDL Override Rate");
			list.add("Fragile LDL Override");
			list.add("Fragile LDL Override Rate");
			
			
			String lossLDL = rds.getValue("SellerAgreement_Data", test.currentTest, "LDL");

			/*
			 * String SaleSourceSite = functionallibraries.FunctionalLibrary
			 * .propertiesRead("SaleSourceSite");
			 */
			String SaleSourceSilte1 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite1");
			String SaleSourceSilte2 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite2");
			String SaleSourceSilte3 = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSellingSite3");
			String LDLOverride = rds.getValue("SA_IC", test.currentTest, "LDLOverride");
			String LDLOverrideRate = rds.getValue("SA_IC", test.currentTest, "LDLOverrideRate");
			String TransitOverride = rds.getValue("SA_IC", test.currentTest, "TransitOverride");
			String TransitOverrideRate = rds.getValue("SA_IC", test.currentTest, "TransitOverrideRate");
			String fragileOverride = rds.getValue("SA_IC", test.currentTest, "fragileOverride");
			String fragileOverrideRate = rds.getValue("SA_IC", test.currentTest, "fragileOverrideRate");
			

			ArrayList<String> list1 = new ArrayList<String>();
			list1.add(SaleSourceSilte1);
			if (!SaleSourceSilte2.isEmpty()) {
				list1.add(SaleSourceSilte2);
			}
			if (!SaleSourceSilte3.isEmpty()) {
				list1.add(SaleSourceSilte3);
			}
			// ArrayList<String> finalList = new ArrayList<String>();

			System.out.println("list1.size()" + list1.size());
			for (int k = 1; k <= list1.size(); k++) {
				System.out.println("cal k" + k);
				ArrayList<String> finalList1 = new ArrayList<String>();
				finalList1.add(list1.get(k - 1));
				finalList1.add(LDLOverride);
				finalList1.add(LDLOverrideRate);
				finalList1.add(TransitOverride);
				finalList1.add(TransitOverrideRate);
				finalList1.add(fragileOverride);
				finalList1.add(fragileOverrideRate);

				System.out.println("finalList" + finalList1);
				Actions action = new Actions(remoteDriver);
				action.sendKeys(Keys.PAGE_DOWN).perform();
				Thread.sleep(2000);
				rowCreation(k - 1, list, finalList1);
				Thread.sleep(3000);
				WebElement element31 = remoteDriver.findElement(By.xpath(
						"//*[@id='G0_1_R" + (k - 1) + "']/td[3]/div/input"));
				actions1 = new Actions(remoteDriver);
				actions1.sendKeys(element31, Keys.ARROW_DOWN).build().perform();
			}
		} catch (Exception ex) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "enterTableValues  Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void enterValues(String fieldName, int RowCount, String list1)
			throws Exception {
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
				break;
			}
		}

		if ((colindexcolindexValue.equalsIgnoreCase("6")
				|| (colindexcolindexValue.equalsIgnoreCase("9"))
				|| (colindexcolindexValue.equalsIgnoreCase("12")))) {
			if (list1.contains("Y")) {
				System.out.println("inside checkbox" + list1);
				WebElement element = remoteDriver
						.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
								+ "']/td[@colindex='" + colindexcolindexValue
								+ "']/div/input[@type='checkbox']"));
				Thread.sleep(2000);
				click(element, "CheckBox");
			}

		} else { 
			System.out.println("in else");
			remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
					+ "']/td[@colindex='" + colindexcolindexValue
					+ "']/div/input[@class='JSTextfield']")).clear();

			remoteDriver.findElement(By.xpath("//tr[@id='G0_1_R" + RowCount
					+ "']/td[@colindex='" + colindexcolindexValue
					+ "']/div/input[@class='JSTextfield']"))
					.sendKeys(list1.trim());
			Thread.sleep(3000);
			// driver.findElement(By.xpjath("//*[@id='G0_1_R0']/td[4]/div/input"))
			// .click();i
			Thread.sleep(3000);
		}
	}
}