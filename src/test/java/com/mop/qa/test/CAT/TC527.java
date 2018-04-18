package com.mop.qa.test.CAT;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.ClientCollectionPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SOPManageExistingOrder;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;


public class TC527 extends TestBase {


	@Test
	
	public void executeTest() {
		try {
			// input-->CollectDecollect,saleSite,transactnType,lotNo
			System.out.println("IT 527 Generating Collection Order");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();

			// to get the next status //to get the charge item numbr
			SOPManageExistingOrder sopManageExisting = jdeHomePage.navigateToSOPpage();
			sopManageExisting.getNextStatus();

			// to perform opertions & take Pick number
			SOPManageExistingOrder sopManageExisting2 = jdeHomePage.navigateToSOPpage1();
			sopManageExisting2.workWithSOPpage();

			// to get barcode go to work with property with item number & scroll
			WorkWithPropertyPage workProperty = jdeHomePage.naviWorkWithProperty();
			workProperty.getBarcode(); 

			// go to inventory client collections
			ClientCollectionPage clientCollect = jdeHomePage.navigateToClientCollections();
			clientCollect.workWithClientCollection();

			// go to work with property & get inventory status
			WorkWithPropertyPage workProperty1 = jdeHomePage.naviWorkWithProperty1();
			workProperty1.getInventoryStatusForCollection();

			// going back to sop screen to check the status
			SOPManageExistingOrder sopManageExisting3 = jdeHomePage.navigateToSOPpage1();
			sopManageExisting3.getNextStatus();
			sopManageExisting3.validateStatus(); 

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
