package com.mop.qa.test.bvt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.SellerAgrment;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SellerAgreementChargesPage;
import com.mop.qa.pageobject.SellerAgreementDetailsPage;
import com.mop.qa.pageobject.SellerAgreementPayment;
import com.mop.qa.pageobject.SellerAgreementSignatorisPage;
import com.mop.qa.pageobject.SellerAgreementStandardPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC33 extends TestBase {


	@Test

	public void executeTest() {
		try {
			System.out.println("Test to create Seller Aggrement Private Sale");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("sellerAgreementobj.txt"));
			SellerAgrment sa = new SellerAgrment();
			// SellerAgrment sa = wrapper.getSellerAgrObj();
			
			/*String execution = dataTable.getData("SellerAgreement_Data",
					"ExecutionCount");
			System.out.println();
			SellerAgrment sa = new SellerAgrment();
			sa.setCount(execution);
			String cnt = sa.getCount();
			int cont = Integer.parseInt(cnt);
			System.out.println("con" + cont);  */
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			SellerAgreementStandardPage standard = jdeHomePage
					.naviWorkWithSellerAgreementPrivateSale();
			ArrayList<String> Seller = new ArrayList<String>();
			for (int i = 0; i < 1; i++) {
				SellerAgreementDetailsPage details = standard
						.addNewSelAgrreement(i);
				sa = details.createSellerAgrStand(objectOutputStream, sa,
						Seller);
				SellerAgreementChargesPage charges = details.selectCharge();
				details = charges.setChargeValue();
				SellerAgreementSignatorisPage sign = details
						.selectSignotories();
				details = sign.setSignotoryVal();
				SellerAgreementPayment payment = details.selectPayments();
				Thread.sleep(5000);
				details = payment.setPayment();
				standard = details.saveOnly();
				Thread.sleep(3000);
				// jdeHomePage = standard.close();
			}
			objectOutputStream.writeObject(sa);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out
					.println("objectOutputStream.sa" + sa.getSellerAgreement());
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			// functionalLibrary.signOut();
			/*
			 * Actions action = new Actions(driver);
			 * action.moveToElement(driver.findElement(By.xpath(
			 * "//a[contains(text(),'Sign Out')]"))).click();
			 * Thread.sleep(4000); action.build().perform(); Thread.sleep(3000);
			 * driver.switchTo().alert().accept(); Thread.sleep(3000);
			 */
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
