package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.PrinterSelectionPage;
import com.mop.qa.pageobject.SOPEnquiryPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithChargeDetailPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;

import com.mop.qa.testbase.TestBase;

public class TC1 extends TestBase {


	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 010 - Create Charges");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithPropertyPage worWithprp = jdeHomePage.naviWorkWithProperty(); 
			String chargeType = rds.getValue("P2P", currentTest, "ChargeType");
			WorkWithChargeDetailPage charge = worWithprp
					.createChargeFromProperty(chargeType);
			PrinterSelectionPage print = charge.selectCharge();
			Thread.sleep(5000);
			print.saveToPrint();

			// String country=dataTable.getData("General_Data","Country");
			SOPEnquiryPage sopPage = worWithprp.verifySOCreation();
			worWithprp.ViewJobStatusWorkWithProperty(chargeType);
			worWithprp.verifySOCreation();
			sopPage.verifySoNumber();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
