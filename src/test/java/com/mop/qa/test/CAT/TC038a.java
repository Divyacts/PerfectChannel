package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.BookArrivalPage;
import com.mop.qa.pageobject.InboundPropertyPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC038a extends TestBase {

	private FunctionalLibrary functionalLibrary;

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 038a - Site Transfer (Arrival) - IN14");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			InboundPropertyPage inbProp = jdeHomePage.navigateToInboundProp();
			String oJNumber = inbProp.printArrivalPickList();
			Runtime.getRuntime().exec(
					"C:\\Users\\235222\\Desktop\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");
			signOnPage = new SignOnPage(remoteDriver);
			signOnPage.loginAsValidUser();
			BookArrivalPage arrivePage = jdeHomePage
					.navigateToBookArrivalsSiteTransfer();
			arrivePage.arriveInventoryItem(oJNumber);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
