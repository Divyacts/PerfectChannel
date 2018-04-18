package com.mop.qa.test.P2P;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.OrderApprovalPage;
import com.mop.qa.pageobject.OrderInquiryChargePage;
import com.mop.qa.pageobject.PrinterSelectionPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import functionallibraries.FunctionalLibrary;

public class TC6 extends TestBase {


	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 013 - PO Approval and PO Print -PP03 - OP");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			OrderInquiryChargePage order = jdeHomePage.navigateTo3WayInquiry();
			order = order.searchPOOrder();
			String status = order.returnStatus();
			System.out.println("status" + status);
			PrinterSelectionPage print;
			String approval = rds.getValue("General_Data", currentTest, "Approve");
			String printer = rds.getValue("General_Data", currentTest, "Print");

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
						"C:\\Users\\235222\\Desktop\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");

				signOnPage = new SignOnPage(remoteDriver);
				Thread.sleep(2000);
				jdeHomePage = signOnPage.Approverlogin();
				Thread.sleep(5000);
				OrderApprovalPage appr = jdeHomePage
						.navigtingToPOApprovalPage();
				appr.approval();
				order.goToHomepage();
				System.out.println("before autiit");
				Runtime.getRuntime().exec(
						"C:\\Users\\235222\\Desktop\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");

				signOnPage = new SignOnPage(remoteDriver);
				jdeHomePage = signOnPage.login2nd();
				OrderInquiryChargePage orderpage = jdeHomePage
						.navigateTo3WayInquiry();
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
