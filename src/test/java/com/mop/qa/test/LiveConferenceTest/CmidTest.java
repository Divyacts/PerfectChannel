package com.mop.qa.test.LiveConferenceTest;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.TransmitCatInfoPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;

public class CmidTest extends TestBase{
	
	@Test 
	public void executeTest() throws Exception {
	SignOnPage signOnPage = new SignOnPage(remoteDriver);
	signOnPage.enterEMUSUrl(); 
	JdeHomePage jdeHomePage = signOnPage.loginAsValidUser("LCT");
	TransmitCatInfoPage transmit = jdeHomePage.navigateToLTF();
	transmit.transmitCMID(); 
	}
}
