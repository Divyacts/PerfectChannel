package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.VoucherMatchPage;
import com.mop.qa.testbase.TestBase;


public class TC9 extends TestBase {

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 019 - Voucher Match - PP09");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			VoucherMatchPage voucherMatch = jdeHomePage
					.navigatingToMatchLoggedVoucherPage();
			voucherMatch.match3WayVoucher();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
