package com.mop.qa.test.bvt;

import org.junit.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SettlementReportPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC27 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to Prepare for Settlement Report");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			SettlementReportPage settlementRept = jdeHomePage
					.navigateToPrepareForSettlementRpt();
			settlementRept.prepareSettlementReport();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
