package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OutboundSoldAuctionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC514 extends TestBase {


	@Test

	public void executeTest() {
		try {
			System.out.println("514- Request Shipping (RTO)");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OutboundSoldAuctionPage workImport = jdeHomePage
					.navigateToOutboundRTO();
			workImport.catRequestForOutbound();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
