package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OrderReciptPage;
import com.mop.qa.pageobject.OrderReciptPage2;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class TC7 extends TestBase {


	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 017a - PO Receipt - PP07");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OrderReciptPage recipt = jdeHomePage
					.navigateToPurchaseOrderRecipt();
			OrderReciptPage2 recipt2 = recipt.orderRecipt();
			Thread.sleep(3000);
			recipt = recipt2.orderRecipt();
			recipt.reciptCheck(); 
		} catch (Exception ex) {
			System.out.println("Exception" + ex); 
		}

	}

}
