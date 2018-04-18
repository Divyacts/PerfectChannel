package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.GenerateChargeOrderRequisiton;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class TC2 extends TestBase {

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 011 - PO Requisition Generation for Vendor Charges - PP01");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			// WorkWithPropertyPage worWithprp =
			// jdeHomePage.naviWorkWithProperty();
			// jdeHomePage.goToHomeScreen();
			// GenerateChargeOrderRequisiton generateCharge =
			// worWithprp.ViewJobStatusWorkWithProperty();
			// jdeHomePage.goToHomeScreen();
			GenerateChargeOrderRequisiton generateCharge = jdeHomePage
					.navigtingToGenerateChargeOrder();
			generateCharge.generatingChargeOrderRequisition(); 
			jdeHomePage.goToHomeScreen();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}
	}

}