package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC504 extends TestBase {

	@Test

	public void executeTest() {
		try {
			// input-->orderType,orderNo,carrierNo
			System.out.println("504 - Requesting Inbound Shipping Quotes");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("CAT");
			WorkWithShippmentPage workShipmentSupplier = jdeHomePage
					.navigateToWorkWithShipment1();
			workShipmentSupplier.printDocuments("A1");
			signOnPage.logout();
			jdeHomePage = signOnPage.loginAsValidUser("CAT");
			workShipmentSupplier = jdeHomePage.navigateToWorkWithShipment1();
			workShipmentSupplier.shippingQutoesToSuppliers(); 
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		} 

	}

}
