package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.POPEnquiryPage;
import com.mop.qa.pageobject.SOPEnquiryPage;
import com.mop.qa.pageobject.SaleBatchSubmissionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;


public class TC25 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("IT - 092 - Batch Day 17 - Post Sale Actions - CA57 Update sale Status from 65 to 70");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			SOPEnquiryPage sopEnquir = jdeHomePage.navigateToSOP();
			String flagForSale = "creditSaleBatching";
			sopEnquir.verifyREcordsPresentForSale(flagForSale);
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			POPEnquiryPage pop = jdeHomePage.navigateToPOP();
			pop.verifyRecordsforSaleinPOP();
			jdeHomePage.goToHomeScreen();
			Thread.sleep(1000); 

			SaleBatchSubmissionPage saleBatch = jdeHomePage
					.navigateToCreditBatchingSale();
			saleBatch.submitCombineBtachingForSale();
			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			sopEnquir = jdeHomePage.navigateToSOP();
			sopEnquir.verifyREcordsPresentForSale(flagForSale);
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			pop = jdeHomePage.navigateToPOP();
			pop.verifyRecordsforSaleinPOP();

			jdeHomePage.goToHomeScreen();
			WorkWithSaleHeaderPage sale = jdeHomePage.naviWorkWithSaleHeader1();
			sale.updateSaleStatus("65", "70");

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
