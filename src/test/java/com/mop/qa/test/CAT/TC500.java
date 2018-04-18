package com.mop.qa.test.CAT;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.InboundConsignmentPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPaymentGroupPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC500 extends TestBase {

	private FunctionalLibrary functionalLibrary;

	@Test
	public void executeTest() {
		try {
			// input--> itemNo,orderNo
			System.out.println("500 - CAT Request Shipping Inbound");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("CAT"); 
			InboundConsignmentPage inbound = jdeHomePage
					.navigateToInboundConsignmentPage();
			inbound.catRequestForInbound();
			jdeHomePage.goToHomeScreen(); 

		} catch (

		Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
