package com.mop.qa.test.LiveConferenceTest;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.BiztalkPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.TransmitCatInfoPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;

public class BizTalkVerificationTest extends TestBase{
	
	@Test 
	public void executeTest() throws Exception {
	BiztalkPage biztalk = new BiztalkPage(remoteDriver);
	biztalk.enterBizTalkUrl();   
	System.out.println("after biztalk url"); 
	String processMess = rds.getValue("LCT",currentTest, "ProcessignMessage");
	biztalk.checkProcessingText(processMess);
	}
}
