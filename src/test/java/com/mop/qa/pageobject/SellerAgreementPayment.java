package com.mop.qa.pageobject;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import supportlibraries.DriverScript;
import supportlibraries.ScriptHelper;

/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class SellerAgreementPayment extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//*[@id='jdeGridData0_1']/tbody/tr")
	private List<WebElement> gridList;

	@FindBy(xpath = "//*[@id='C0_61']")
	private WebElement paytype;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[7]/div/select")
	private WebElement bankAccnt;

	@FindBy(xpath = "//input[@title='Payor Type']")
	private WebElement payerType;

	@FindBy(xpath = "//input[@title='Waive Foreign Bank Fees']")
	private WebElement forBankFees;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[5]/div/input")
	private WebElement saleSiteTab;

	public SellerAgreementPayment(RemoteWebDriver remoteDriver) { 
		super(remoteDriver);
	}

	TestBase test = new TestBase();
	

	public SellerAgreementDetailsPage setPayment() {
		System.out.println("inside setPayment");
		try {
			Thread.sleep(5000);
			String PayType = rds.getValue("SellerAgreement_Data", test.currentTest, "PayType");
			String saleSite = rds.getValue("SellerAgreement_Data", test.currentTest, "SaleSourceSite");

			String Paytype1 = ("Cheque");
			String Paytype2 = ("Complex");
			String Paytype3 = ("New Payment Instruction");
			String Paytype4 = ("Override");
			String Paytype5 = ("Rejected by COA");
			String Paytype6 = ("Site Primary");

			assertTrue(payerType.getAttribute("value").equalsIgnoreCase("A"),
					"Seller Agreement Account is dispalyed as A");
			assertTrue(forBankFees.isDisplayed(),
					"Wave Foreign Bank fess check box is dispalyed");
			WebElement ele = remoteDriver
					.findElement(By.xpath("//*[@id='G0_1_R0']/td[5]/div"));
			System.out.println("value ele" + ele.getAttribute("value").trim());
			assertTrue(
					ele.getAttribute("value").trim().equalsIgnoreCase(saleSite),
					"Sale site is defaulted to " + saleSite + "");

			Thread.sleep(3000);
			//Select se = new Select(paytype);
			if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype1.trim()))) {
				selectOPtionByIndex(paytype, 2);
				Thread.sleep(2000);
				click(save,"save");
				Thread.sleep(3000);
			}

			else if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype2.trim()))) {
				selectOPtionByIndex(paytype, 3);
				Thread.sleep(2000);
				click(save,"save");
				Thread.sleep(3000);
			} else if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype3.trim()))) {
				selectOPtionByIndex(paytype, 4);
				Thread.sleep(2000);
				click(save,"save");
				Thread.sleep(3000);
			} else if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype4.trim()))) {
				selectOPtionByIndex(paytype, 5);
				Thread.sleep(2000);
				selectOPtionByIndex(bankAccnt, 1);
				click(save,"save");
				Thread.sleep(3000);
			} else if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype5.trim()))) {
				selectOPtionByIndex(paytype, 6);
				Thread.sleep(2000);
				click(save,"save");
				Thread.sleep(3000);
			} else if (PayType != null
					&& (PayType.trim().equalsIgnoreCase(Paytype6.trim()))) {
				selectOPtionByIndex(paytype, 7);
				Thread.sleep(2000);
				click(save,"save");
				Thread.sleep(3000);
			}

		} catch (

		Exception ex)

		{
			System.out.println("Exception inside setPayment" + ex);
		}
		return new SellerAgreementDetailsPage(remoteDriver);
	}

}