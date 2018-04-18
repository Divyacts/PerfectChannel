package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.ARLedgerPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC56 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("IT - 052b- Create Deposit Refund");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			ARLedgerPage arLedger = jdeHomePage.navigateToARLedgerPage();
			arLedger.createDepositRefund(); 
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
