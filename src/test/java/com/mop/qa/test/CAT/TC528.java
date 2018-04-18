package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC528 extends TestBase {

	@Test

	public void executeTest() {
		try {
			// input--> orderNo,orderType
			System.out.println("IT - 528 - Proof of Delivery");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithShippmentPage workShip = jdeHomePage
					.navigateToWorkWithShipment();
			workShip.confirmProofOfDelivery();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
