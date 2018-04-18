package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OutboundSoldAuctionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;

public class TC19 extends TestBase { 

	@Test
	public void executeTest() {
		try {
			// input-->SBItemNumber,SBOrderType
			System.out.println("Test for OutboundSold Auction consignment");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithShippmentPage workOutbound = jdeHomePage.navigateToWorkWithShipment1();
			workOutbound.workWithShippmentOutbound();
			WorkWithPropertyPage workPropertyOutbound = jdeHomePage.naviWorkWithProperty();
			workPropertyOutbound.getInventoryStatusForOutbound();
			OutboundSoldAuctionPage outbound = jdeHomePage.navigateToOutboundSoldAuction();
			outbound.catRequestForOutbound();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
