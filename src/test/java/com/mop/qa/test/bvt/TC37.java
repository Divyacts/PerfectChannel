package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.CatalogurTextingPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC37 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 502 - Capture inventory dimensions");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			// WorkWithPropertyPage wrkProp =  
			// jdeHomePage.naviWorkWithProperty();
			CatalogurTextingPage catalogue = jdeHomePage.docatalogingTest();
			catalogue.enterInventoryDimentionsforItem(); 
			// catalogue.docataloging();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
