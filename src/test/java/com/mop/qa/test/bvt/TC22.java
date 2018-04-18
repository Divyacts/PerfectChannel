package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.PrintAuctioneerBook;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;


public class TC22 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to Print Autioneers Results");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			PrintAuctioneerBook auctionBook = jdeHomePage.navigateToPrintAuctinBook("General_Data");
			auctionBook.printAuctionBook();
			jdeHomePage.goToHomeScreen();    
			/*
			 * Thread.sleep(3000); Actions action = new Actions(driver);
			 * action.moveToElement(driver.findElement(By.xpath(
			 * "//a[contains(text(),'Sign Out')]"))).click();
			 * Thread.sleep(3000); action.build().perform(); Thread.sleep(3000);
			 * driver.switchTo().alert().accept(); Thread.sleep(3000);
			 * signOnPage = new SignOnPage(scriptHelper); jdeHomePage =
			 * signOnPage.loginAsValidUser(); WorkWithSaleHeaderPage sale =
			 * jdeHomePage.naviWorkWithSaleHeader(); sale.updateSaleStatus("50",
			 * "60");
			 */
			// jdeHomePage.goToHomeScreen();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
