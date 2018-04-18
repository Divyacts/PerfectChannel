package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;


public class TC19 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithSaleHeaderPage saleheader = jdeHomePage.naviWorkWithSaleHeader();
			saleheader.performLottingForSale();
			jdeHomePage.goToHomeScreen();
			/* 
			 * Thread.sleep(3000); Actions action = new Actions(driver);
			 * action.moveToElement(driver.findElement(By.xpath(
			 * "//a[contains(text(),'Sign Out')]"))).click();
			 * Thread.sleep(5000); action.build().perform(); Thread.sleep(5000);
			 * driver.switchTo().alert().accept(); Thread.sleep(3000);
			 * signOnPage = new SignOnPage(scriptHelper); jdeHomePage =
			 * signOnPage.loginAsValidUser(); WorkWithSaleHeaderPage sale =
			 * jdeHomePage.naviWorkWithSaleHeader(); sale.updateSaleStatus("10",
			 * "20");
			 */
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}



}
