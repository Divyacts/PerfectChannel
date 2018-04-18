package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.FreightUpdateBillablesPage;
import com.mop.qa.pageobject.FreightUpdatePayablePage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC506 extends TestBase {


	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 506/511 - Freight Update -  Payable Freight");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("CAT");
			FreightUpdateBillablesPage freightUpdate = jdeHomePage
					.navigateToFreightUpdateBillablesPage();
			freightUpdate.workWithFreightUpdatePage();
			// jdeHomePage.goToHomeScreen();
			WorkWithShippmentPage workShipmentFreight = jdeHomePage
					.navigateToWorkWithShipment3();
			workShipmentFreight.workWithShipmentFreightUpdate();
			FreightUpdatePayablePage freightUpdatePayable = jdeHomePage
					.navigateToFreightUpdatePayablePage(); 
			freightUpdatePayable.workWithFreightUpdatePayablePage();
			WorkWithShippmentPage workShipmentFinal = jdeHomePage
					.navigateToWorkWithShipment3();
			workShipmentFinal.workWithShippmentFinalCheck();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
