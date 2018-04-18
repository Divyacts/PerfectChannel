package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithRegistrationPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;


public class TC20 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("Test to perform Bidder registration and Sale status update to 50 and 60");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleheader = jdeHomePage
					.naviWorkWithSaleHeader();
			WorkWithRegistrationPage register = saleheader
					.performBidderRegistration();
			register.addBidders();  
			register.updateRegistrationStatus();
			jdeHomePage.goToHomeScreen();
			WorkWithSaleHeaderPage sale = jdeHomePage.naviWorkWithSaleHeader1();
			sale.updateSaleStatus("50", "60"); 
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
