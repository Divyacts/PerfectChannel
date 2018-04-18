package com.mop.qa.test.bvt;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.APLedgerPage;
import com.mop.qa.pageobject.BatchReviewPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC26 extends TestBase {

	public StockOrder stock;

	@Test

	public void executeTest() {
		try {
			System.out.println("Test to Post Batch Pre step for Preparing Settlement Report");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			APLedgerPage apledger = jdeHomePage.navigateToApLedger();
			apledger = apledger.searchBatchNumberForSale();
			ArrayList<String> batchNumber = new ArrayList<String>();
			batchNumber = apledger.getBatchNumberForSale(batchNumber);
			jdeHomePage.goToHomeScreen(); 
			Thread.sleep(3000);

			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");
			
			
			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			BatchReviewPage batReview = jdeHomePage.navigateTobtchReview();
			batReview.batchReviewFromSeteport(batchNumber);
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);

			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");

			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			apledger = jdeHomePage.navigateToApLedger();
			apledger = apledger.searchBatchNumberForSale();
			String column = "P C";
			apledger.checkForPCStatusUpdate(column);
			apledger.updatePayStatusAndValidate();
			column = "Pay Stat";
			apledger.checkForPCStatusUpdate(column);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
