package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.InboundConsignmentPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class TC523 extends TestBase {

	@Test

	public void executeTest() { 
		try {
			// input--> orderNo,orderType
			System.out.println("IT - 523 - Site Transfer - Request shipping (Inbd)");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			InboundConsignmentPage workImport = jdeHomePage.navigateToInboundIntersiteTransfers();
			workImport.catRequestForInbound();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
