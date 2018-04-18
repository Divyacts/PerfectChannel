package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC31 extends TestBase {

	private FunctionalLibrary functionalLibrary;
	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to perform Status Update");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleheader = jdeHomePage
					.naviWorkWithSaleHeader();
			saleheader.updateSaleStatus("10", "20");
			saleheader.updateSaleStatus("20", "30");
			saleheader.updateSaleStatus("30", "40");
			saleheader.updateCurrencyDate();
			saleheader.updateSaleStatus("40", "50");

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
