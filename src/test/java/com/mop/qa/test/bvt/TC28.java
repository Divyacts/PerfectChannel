package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SettlementReportPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPaymentGroupPage;
import com.mop.qa.testbase.TestBase;

public class TC28 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to Create Payment Groups");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithPaymentGroupPage payment = jdeHomePage.navigateToWorkWithPayment();
			payment.completePayment();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
