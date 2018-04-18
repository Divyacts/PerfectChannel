package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.SoldSinceSalePage;
import com.mop.qa.pageobject.WorkWithAuctionResultsPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;

public class TC35 extends TestBase {


	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 083 - Sold Since Sale  - CCSA22"); 
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage salePage = jdeHomePage
					.naviWorkWithSaleHeader();
			WorkWithAuctionResultsPage results = salePage.auctionResults();
			SoldSinceSalePage soldPage = results.soldSinceSale();
			soldPage.makeSoldSinceSale();
			soldPage.signedDocumentRecieved();
			soldPage.soldSinceSaleApproved();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
