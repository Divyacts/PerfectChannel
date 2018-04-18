package com.mop.qa.test.LiveConferenceTest;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;

public class ApplicationCheckTestAsia extends TestBase{
	
	@Test 
	public void executeTest() throws Exception {
	SignOnPage signOnPage = new SignOnPage(remoteDriver);
	signOnPage.enterAsiaUrl();  
	JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();  
	WorkWithPropertyPage wrkwithprop = jdeHomePage.naviWorkWithPropertyLCT();
	wrkwithprop.checkPageLoad();
	}
}
