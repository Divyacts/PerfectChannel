package com.mop.qa.test.LiveConferenceTest;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class PDAsiaLinkAccessTest extends TestBase{
	
	@Test 
	public void executeTest() throws Exception {
	SignOnPage signOnPage = new SignOnPage(remoteDriver);
	signOnPage.enterAsiaUrl(); 
	signOnPage.loginAsValidUser();
	signOnPage.checkHomePageLoad(); 
	}
}
