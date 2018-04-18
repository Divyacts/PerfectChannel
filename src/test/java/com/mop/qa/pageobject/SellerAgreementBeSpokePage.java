package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.MPException;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class SellerAgreementBeSpokePage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@title='Override Commission']")
	private WebElement override;

	@FindBy(xpath = "//input[@title='Non Std Commission Rate']")
	private WebElement nStdcomrate;

	@FindBy(xpath = "//input[@title='Bespoke Zero Commission']")
	private WebElement zeroCommision;

	@FindBy(xpath = "//input[@title='Enhanced Hammer']")
	private WebElement enhancedhammer;

	@FindBy(xpath = "//input[@title='Guarantee Amount']")
	private WebElement gaurenteeAmt;

	@FindBy(xpath = "//input[@title='Guarantee']")
	private WebElement gaurentee;

	@FindBy(xpath = "//input[@title='Third Party Guarantee']")
	private WebElement thirdPartyGaurentee;

	@FindBy(xpath = "//input[@title='Guarantee Payment Days']")
	private WebElement paymentDays;

	@FindBy(xpath = "//input[@title='Holiday Threshold']")
	private WebElement holidayThresh;

	@FindBy(xpath = "//input[@title='Upside To Seller']")
	private WebElement upsideToSeller;

	@FindBy(xpath = "//input[@title='Guarantee Currency Code']")
	private WebElement currencyCode;

	@FindBy(xpath = "//input[@title='Seller Exchange Rate']")
	private WebElement sellerExcahngeRate;

	@FindBy(xpath = "//input[@title='Guarantee For Multiple Items']")
	private WebElement gaurenteeForMultiple;

	@FindBy(xpath = "//button[contains(text(),'Enhanced Hammer Commission')]")
	private WebElement enhancedhammerCommission;

	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement close;

	@FindBy(xpath = "//input[@title='Early Payment']")
	private WebElement earlyPayment;

	@FindBy(xpath = "//input[@title='1st Early Payment Days']")
	private WebElement firststEarlyPayDays;

	@FindBy(xpath = "//input[@title='1st Early Payment Amount']")
	private WebElement firstEarlyPayAmt;

	@FindBy(xpath = "//input[@title='2nd Early Payment Days']")
	private WebElement secondEarlyPayAmt;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//nobr[contains(text(),'Legal Notes')]")
	private WebElement legalNotes;

	public SellerAgreementBeSpokePage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	TestBase test = new TestBase();

	public SellerAgreementStandardPage setBeSpokeOverCommission() {
		try {
			Thread.sleep(3000);
			enterText(override, "4", "override");
			click(saveButton, "saveButton");

			String earlyPayflag = rds.getValue("SA_IC", test.currentTest, "earlyPayflag");
			if (earlyPayflag.equalsIgnoreCase("Y")) {
				setEarlypayment();
			}
			click(close, "close");

		} catch (Exception ex) {
			System.out
					.println("Exception inside setBeSpokeOverCommission" + ex);

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public SellerAgreementStandardPage setBeSpokeZeroCommison() {
		try {
			Thread.sleep(3000);
			click(zeroCommision, "zeroCommision");
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			String earlyPayflag = rds.getValue("SA_IC", test.currentTest, "earlyPayflag");

			if (earlyPayflag.equalsIgnoreCase("Y")) {
				setEarlypayment();
			}
			click(close, "close");

		} catch (Exception ex) {
			System.out.println("Exception inside setBeSpokeZeroCommison" + ex);

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public SellerAgreementStandardPage setEarlypayment() {
		try {
			String firstPayDay = rds.getValue("SA_IC", test.currentTest, "firstPayDay");
			String firstPayAmt = rds.getValue("SA_IC", test.currentTest, "firstPayAmt");
			String secondpayDay = rds.getValue("SA_IC", test.currentTest, "secondpayDay");
			Thread.sleep(2000);
			click(earlyPayment, "earlyPayment");
			enterText(firststEarlyPayDays, firstPayDay, "firststEarlyPayDays");
			enterText(firstEarlyPayAmt, firstPayAmt, "firstEarlyPayAmt");
			enterText(secondEarlyPayAmt, secondpayDay, "secondEarlyPayAmt");
			/*
			 * rowExit.click(); Thread.sleep(2000); Actions action = new
			 * Actions(driver); action.moveToElement(legalNotes).click();
			 * action.build().perform(); Thread.sleep(3000);
			 */


		} catch (Exception ex) {
			System.out.println("Exception inside setEarlypayment" + ex);

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public void setgaurenteeValues() throws Exception {
		
		String gaurAmt = rds.getValue("SA_IC", test.currentTest, "gaurenteeAmt");
		String threshHold = rds.getValue("SA_IC", test.currentTest, "Hthreshold");
		String upSideSeller = rds.getValue("SA_IC", test.currentTest, "upsideSeller");
		String gCurrency = rds.getValue("SA_IC", test.currentTest, "gCurrency");
		String selExRate = rds.getValue("SA_IC", test.currentTest, "sellerExRate");
		
		click(gaurentee, "gaurentee");

		if (!gaurAmt.isEmpty()) {
			enterText(gaurenteeAmt, gaurAmt, "gaurenteeAmt");
		}
		if (!threshHold.isEmpty()) {
			enterText(holidayThresh, threshHold, "holidayThresh");

		}
		if (!upSideSeller.isEmpty()) {
			enterText(upsideToSeller, upSideSeller, "upsideToSeller");

		}
		if (!gCurrency.isEmpty()) {
			enterText(currencyCode, gCurrency, "currencyCode");

		}

		if (!selExRate.isEmpty()) {
			enterText(sellerExcahngeRate, selExRate, "sellerExcahngeRate");

		}

	}

	public TieredRatePage setValuesEnhancedhammer() {
		try {
			Thread.sleep(3000);
			System.out.println("inside setValuesForNonStandard");
		   click(enhancedhammer, "enhancedhammer");
		   click(enhancedhammerCommission, "enhancedhammerCommission");

		} catch (Exception ex) {
			System.out.println("Exception inside setValuesEnhancedhammer" + ex);

		}
		return new TieredRatePage(remoteDriver);
	}

}