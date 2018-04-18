package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithAuctionResultsPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;


public class TC23 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test for Auction Results and Status Update from 60 to 65");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleHeader = jdeHomePage
					.naviWorkWithSaleHeader();
			WorkWithAuctionResultsPage auction = saleHeader.auctionResults();
			auction.enterAuctioNResults(); 
			jdeHomePage.goToHomeScreen();
			WorkWithSaleHeaderPage sale = jdeHomePage.naviWorkWithSaleHeader1();
			sale.updateSaleStatus("60", "65");
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
