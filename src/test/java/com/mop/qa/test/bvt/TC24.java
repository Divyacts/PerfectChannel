package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithAuctionResultsPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;


public class TC24 extends TestBase {


	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			

			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleHeader = jdeHomePage.naviWorkWithSaleHeader();
			WorkWithAuctionResultsPage auction = saleHeader.auctionResults();
			auction = auction.generateARG(); 
			auction.ViewJobStatusWorkWithAuctionResults();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
