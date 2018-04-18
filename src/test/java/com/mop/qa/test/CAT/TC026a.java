package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.InventoryPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC026a extends TestBase {


	@Test
	public void executeTest() {
		try {
			// input--> orderNo,orderType
			System.out.println("IT - 026a - Temporary Release (Create Outbound Order) - IN10");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			InventoryPage inventoryPage = jdeHomePage.navigateToInventoryPage();
			inventoryPage.tempRelCreateOutBoundOrder();
			Runtime.getRuntime().exec(
					"C:\\Users\\235222\\Desktop\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");
			signOnPage = new SignOnPage(remoteDriver);
			signOnPage.loginAsValidUser();
			inventoryPage = jdeHomePage.navigateToInventoryPage();
			inventoryPage.printPickList();

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
