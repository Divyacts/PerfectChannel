package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OrderApprovalPage;
import com.mop.qa.pageobject.OrderInquiryChargePage;
import com.mop.qa.pageobject.PrinterSelectionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC5 extends TestBase {


	@Test
	public void executeTest() {
		try { 
			System.out.println("IT - 015a - PO Amendment - PP05"); 
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OrderInquiryChargePage order = jdeHomePage
					.navigtingToOrderInquiryCharge();
			// order.searchAndAmend();
			order.goToHomepage();
			System.out.println("before autiit"); 
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");
			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.login2nd();
			order = jdeHomePage.navigtingToOrderInquiryCharge();
			order = order.searchPOOrder();
			String status = order.returnStatus();
			System.out.println("status" + status);
			PrinterSelectionPage print;
			String approval = rds.getValue("P2P",currentTest, "Approve");
			String printer = rds.getValue("P2P",currentTest, "Print");

			System.out.println("..." + approval);
			System.out.println("..." + printer);

			if (status.equalsIgnoreCase(printer)) {
				System.out.println("in iff");
				print = order.printPoOrder();
				print.savefrmOrder();

			}
			if (status.equalsIgnoreCase(approval)) {
				System.out.println("in else");
				order.goToHomepage();
				System.out.println("before autiit");
				Runtime.getRuntime().exec(
						"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");
				// driver.switchTo().pa().accept();
				Thread.sleep(3000);

				signOnPage = new SignOnPage(remoteDriver);
				jdeHomePage = signOnPage.Approverlogin(); 
				Thread.sleep(5000);
				OrderApprovalPage appr = jdeHomePage
						.navigtingToPOApprovalPage(); 
				appr.approval();
				order.goToHomepage();
				System.out.println("before autiit");
				Runtime.getRuntime().exec(
						"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");

				signOnPage = new SignOnPage(remoteDriver);
				jdeHomePage = signOnPage.login2nd();
				OrderInquiryChargePage orderpage = jdeHomePage
						.navigtingToOrderInquiryCharge();
				orderpage = orderpage.searchPOOrder();
				String statusPr = order.returnStatus();
				System.out.println("statusPr" + statusPr);
				PrinterSelectionPage print1;
				if (statusPr.equalsIgnoreCase(printer)) {
					System.out.println("in 2nd iffff");
					print1 = order.printPoOrder();
					print1.saveToPrint();
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
