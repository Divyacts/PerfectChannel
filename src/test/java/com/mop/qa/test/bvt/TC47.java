package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.POPEnquiryPage;
import com.mop.qa.pageobject.SOPEnquiryPage;
import com.mop.qa.pageobject.SaleBatchSubmissionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC47 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to perform Credit batching Seller SOP");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			SOPEnquiryPage sopEnquir = jdeHomePage.navigateToSOP();
			String flagforSalebatching = "creditSaleBatching";
			sopEnquir.verifyREcordsPresentForSale(flagforSalebatching);
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			POPEnquiryPage pop = jdeHomePage.navigateToPOP();
			pop.verifyRecordsforSaleinPOP();
			jdeHomePage.goToHomeScreen();
			Thread.sleep(1000);
 
			SaleBatchSubmissionPage saleBatch = jdeHomePage
					.navigateToCreditBatchingSellerSOP();
			saleBatch.submitCombineBtachingForSale();

			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");

			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			sopEnquir = jdeHomePage.navigateToSOP();
			sopEnquir.verifyREcordsPresentForSale(flagforSalebatching);
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			pop = jdeHomePage.navigateToPOP();
			pop.verifyRecordsforSaleinPOP();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
