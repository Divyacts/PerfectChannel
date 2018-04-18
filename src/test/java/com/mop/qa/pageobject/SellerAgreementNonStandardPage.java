package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class SellerAgreementNonStandardPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@title='Override Commission Rate']")
	private WebElement override;

	@FindBy(xpath = "//input[@title='Non Std Commission Rate']")
	private WebElement nStdcomrate;

	@FindBy(xpath = "//input[@title='Zero Commission']")
	private WebElement zeroCommision;

	@FindBy(xpath = "//button[contains(text(),'Override Commission Rates')]")
	private WebElement buttonOverride;

	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement add;

	@FindBy(xpath = "//*[@id='hc_Close']")
	private WebElement close;
	
	public SellerAgreementNonStandardPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	
	public SellerAgreementStandardPage setNonStdCommissionRate() {
		try {
			Thread.sleep(3000);
			enterText(nStdcomrate, "4", "Standard Com Rate");
			click(saveButton, "save Click");
			click(close, "Close Click");
		} catch (Exception ex) {
			System.out.println("Exception inside setNonStdCommissionRate" + ex);

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public SellerAgreementStandardPage setNonStdZeroCommison() {
		try {
			Thread.sleep(3000);
			click(zeroCommision, "zero Commission");
			click(saveButton, "Save Button");
			click(close, "Close");

		} catch (Exception ex) {
			System.out.println("Exception inside setNonStdZeroCommison" + ex);

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public TieredRatePage setValuesForNonStandard() {
		try {
			Thread.sleep(3000);
			System.out.println("inside setValuesForNonStandard");
			click(override, "override");
			click(buttonOverride, "buttonOverride");
		} catch (Exception ex) {
			System.out.println("Exception inside setValuesForNonStandard" + ex);

		}
		return new TieredRatePage(remoteDriver);
	}

}