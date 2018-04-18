package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPrivateSalePage1;
import com.mop.qa.testbase.TestBase;


public class TC34 extends TestBase {

	@Test

	public void executeTest() {
		try {
			System.out.println("Test to create Private Sale Deal Entry");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithPrivateSalePage1 dealPage = jdeHomePage
					.naviToPrivateSaleDealEntry();
			dealPage.addDealEntry();

			// dealPage.addFreight();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
