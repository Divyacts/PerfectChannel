package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.ARLedgerPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class TC55 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 555 - Cashier Tax Refund - CSC");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			ARLedgerPage arLedger = jdeHomePage.navigateToARLedgerPage();
			arLedger.applyCashierTaxrefund();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
