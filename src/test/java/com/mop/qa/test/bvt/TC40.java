package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.ARLedgerPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC40 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("IT - 150 - Apply Dispute Marker Post Batching (AR Ledger) - CA");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			ARLedgerPage arLedger = jdeHomePage.navigateToARLedgerPage();
			arLedger.applyDisputeMarker();
		} catch (Exception ex) {
			System.out.println("Exception" + ex); 
		}

	}

}
