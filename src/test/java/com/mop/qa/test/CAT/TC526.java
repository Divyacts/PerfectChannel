package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC526 extends TestBase {

	@Test
	public void executeTest() {
		try {
			// input--> orderNo,orderType
			System.out.println("IT 527 Export Record Creation");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithShippmentPage workImport = jdeHomePage.navigateToWorkWithShipment1();
			workImport.exportRecordCreation();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
