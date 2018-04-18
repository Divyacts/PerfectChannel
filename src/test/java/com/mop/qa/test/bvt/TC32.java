package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.AutonettingPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC32 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 072 - Perform Autonetting - CA16");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			AutonettingPage autoNet = jdeHomePage.navigateToAutonetting();
			autoNet.triggerAutoNetting();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
