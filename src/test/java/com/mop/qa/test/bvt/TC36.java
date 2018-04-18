package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;


public class TC36 extends TestBase {


	@Test

	public void executeTest() {
		try {
			System.out.println("IT - 082a - Return To Owner (RTO) - CCSA21");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithPropertyPage propertyPage = jdeHomePage
					.naviWorkWithProperty();
			propertyPage.retrunToOwner(); 
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
