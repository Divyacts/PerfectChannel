package com.mop.qa.test.LiveConferenceTest;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class PDEMUSLinkAccessTest extends TestBase{
	
	@Test 
	public void executeTest() throws Exception {
	SignOnPage signOnPage = new SignOnPage(remoteDriver);
	signOnPage.enterEMUSUrl(); 
	signOnPage.loginAsValidUser();
	signOnPage.checkHomePageLoad(); 
	}
}
