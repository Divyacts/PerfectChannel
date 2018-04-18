package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.TMSShipConfirmCatPage;
import com.mop.qa.pageobject.WorkWithShippmentPage;
import com.mop.qa.testbase.TestBase;


public class TC510 extends TestBase {
	@Test
	public void executeTest() {
		try {
			// input-->recieveOption,
			System.out.println("IT 510 Ship Confirm");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			TMSShipConfirmCatPage tmsShip = jdeHomePage.navigateToTMSShipConfirmPage();
			tmsShip.workWithTMSShipConfirmCat();
			jdeHomePage.goToHomeScreen();
			WorkWithShippmentPage workShipmentTMS = jdeHomePage.navigateToWorkWithShipment3();
			workShipmentTMS.workWithShipmentTMSConfirmCAT();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
