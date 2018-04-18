package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC505 extends TestBase {

	@Test
	public void executeTest() {
		try {
			// input-->orderNo,orderType,netAmount
			System.out.println("505 - Shipping quotes to requestor and Add Charges");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("CAT");
			WorkWithShippmentPage workShipmentRequestor = jdeHomePage
					.navigateToWorkWithShipment1();
			workShipmentRequestor.printDocuments("A2"); 
			signOnPage.logout();
			jdeHomePage = signOnPage.loginAsValidUser("CAT");
			workShipmentRequestor = jdeHomePage.navigateToWorkWithShipment1();
			workShipmentRequestor.shippingQuotesToRequestor();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
