package com.mop.qa.test.bvt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.StockOrderDetailPage;
import com.mop.qa.testbase.TestBase;



public class TC30 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("Test to populate PO So Number for arrival of Item");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("stockOrderobj.txt"));
			StockOrder stock = new StockOrder();
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			StockOrderDetailPage stockPage = jdeHomePage.navigateToStockOrderPage();
			// ArrayList<String> codes = stockPage.populateObjectPOSO();
			/*
			 * stock.setPoSoNumber(codes);
			 * objectOutputStream.writeObject(stock);
			 * objectOutputStream.flush(); objectOutputStream.close();
			 */
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

}
