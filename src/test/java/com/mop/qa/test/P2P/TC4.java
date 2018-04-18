package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.PurchaseOrderEntryPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC4 extends TestBase {

	private FunctionalLibrary functionalLibrary;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to create Purchase Order Entry");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			PurchaseOrderEntryPage purchase = jdeHomePage
					.navigtingToCreatePurOrderEntry();
			purchase.createPurOrderEntry();
			purchase.verifyPurchaseORdeCreated();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
