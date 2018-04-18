package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OutboundSoldAuctionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC521 extends TestBase {


	@Test
	public void executeTest() {
		try {
			// input--> orderNo,orderType
			System.out.println("IT - 521 -Site Transfer - Request shipping (Outbd)");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OutboundSoldAuctionPage workImport = jdeHomePage.navigateToOutboundIntersiteTransfers();
			workImport.catRequestForOutbound();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}