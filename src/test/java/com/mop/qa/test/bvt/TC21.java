package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;

public class TC21 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("Test to perform Bid Entry");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleheader = jdeHomePage.naviWorkWithSaleHeader();
			saleheader.performBidEntry();  
			//jdeHomePage.goToHomeScreen();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
