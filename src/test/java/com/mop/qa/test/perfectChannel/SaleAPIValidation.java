package com.mop.qa.test.perfectChannel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mop.qa.pageobject.PerfectChannelHomePage;
import com.mop.qa.pageobject.PerfectChannelSaleEditPage;
import com.mop.qa.testbase.TestBase;

public class SaleAPIValidation extends TestBase {
	
	@Test
	public void executeTest() throws Exception {
		PerfectChannelHomePage perfectch = new PerfectChannelHomePage(remoteDriver);
		String user = rds.getValue("PerfectChannel", currentTest, "Username");
		String password = rds.getValue("PerfectChannel", currentTest, "Password"); 
		perfectch.enterUrl(); 
		Thread.sleep(2000);
		perfectch.login(user,password);
		PerfectChannelSaleEditPage edit = perfectch.saleAPIvalidations();
		edit.validateSaleAPIDetials(); 
	}
}  
