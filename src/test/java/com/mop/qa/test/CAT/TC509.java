package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC509 extends TestBase{
	
	@Test 
	public void executeTest() {
		try {
			System.out.println("IT 509 Book Shipment");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithShippmentPage bookShippment=jdeHomePage.navigateToWorkWithShipment1();
			bookShippment.bookingShippment();
		} 
		catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
