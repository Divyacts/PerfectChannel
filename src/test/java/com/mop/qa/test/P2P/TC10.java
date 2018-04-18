package com.mop.qa.test.P2P;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mop.qa.pageobject.BatchReviewPage;
import com.mop.qa.pageobject.CreatePaymentGroupsPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.VoucherLoggingPage;
import com.mop.qa.pageobject.VoucherLoggingSupplierLedgerPage;
import com.mop.qa.pageobject.WorkWithPaymentGroupPage;
import com.mop.qa.testbase.TestBase;

public class TC10 extends TestBase {


	@Test

	public void executeTest() {
		try {
			System.out.println("IT - 020b - Auto Payment (Cheque) - PP10");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			VoucherLoggingSupplierLedgerPage voucherLog = jdeHomePage.navigatingToVoucherLogging1(); 
			voucherLog = voucherLog.statusChangePrerequisite();
			voucherLog.goToHomepage();
			BatchReviewPage batReview = jdeHomePage.navigateTobtchReview();
			batReview.batchReview();
			jdeHomePage.goToHomeScreen();
			CreatePaymentGroupsPage createPayment = jdeHomePage
					.navigateToCreatePayment(); 
			createPayment.autoPayment();
			System.out.println("after autoPayment");
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);

			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");

			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			VoucherLoggingPage log = jdeHomePage.navigatingToVoucherLogging2();
			log.checkPayStatus();
			System.out.println("after autoPayment");
			jdeHomePage.goToHomeScreen(); 
			WorkWithPaymentGroupPage workWithPayment = jdeHomePage
					.navigateToWorkWithPayment();
			workWithPayment.completePayment();
			System.out.println("after completePayment");
			jdeHomePage.goToHomeScreen();
			log = jdeHomePage.navigatingToVoucherLogging();
			log.checkPayStatus();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}
	}


}
