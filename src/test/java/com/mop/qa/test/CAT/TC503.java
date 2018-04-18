package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;

public class TC503 extends TestBase {

	@Test
	public void executeTest() {
		try {
			// input--> orderNo,orderType
			System.out.println("IT 503 Import Record Creation");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("CAT");
			WorkWithShippmentPage workImport = jdeHomePage.navigateToWorkWithShipment1();
			workImport.importRecordCreation();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
