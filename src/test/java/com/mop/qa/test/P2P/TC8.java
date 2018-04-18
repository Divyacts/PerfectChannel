package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OrderInquiryChargePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.VoucherLoggingPage;
import com.mop.qa.testbase.TestBase;


public class TC8 extends TestBase {

	@Test	
	public void executeTest() {
		try {
			System.out.println("IT - 018 - Log Invoice - PP08");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OrderInquiryChargePage orderInquiryCharge;
			orderInquiryCharge = jdeHomePage.navigateTo3WayInquiry();
			orderInquiryCharge.orderInquiry(); 
			orderInquiryCharge.goToHomepage();
			VoucherLoggingPage voucher = jdeHomePage
					.navigatingToVoucherLogging();
			Thread.sleep(3000);
			voucher.logInvoice();
			// voucherLogging.logInvoice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

}