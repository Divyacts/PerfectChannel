package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.PrinterSelectionPage;
import com.mop.qa.pageobject.SOPEnquiryPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.SundryChargeEntryPage;
import com.mop.qa.testbase.TestBase;


public class TC54 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("Test to perform LedgerManagement Sundry Charge Entry");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			SundryChargeEntryPage sundryChargePage = jdeHomePage
					.navigateToCreateSundryChargeEntry();
			String chargeType = rds.getValue("General_Data", currentTest, "ChargeType");
			sundryChargePage = sundryChargePage.createSundryCharge(chargeType);
			PrinterSelectionPage print = sundryChargePage
					.sundryChargeCreation();
			print.saveToPrint();
			jdeHomePage.goToHomeScreen();
			Thread.sleep(1000);
			SOPEnquiryPage sopPage = jdeHomePage.navigateToSOPEnquiry();
			sopPage.ViewJobStatus(chargeType);
			sopPage.verifySoNumber();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
