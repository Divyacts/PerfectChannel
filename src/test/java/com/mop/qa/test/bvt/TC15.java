package com.mop.qa.test.bvt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.StockOrderDetailPage;
import com.mop.qa.testbase.TestBase; 


public class TC15 extends TestBase {

	TestBase test = new TestBase();
	
	@Test
	public void executeTest() {
		try {
			Thread.sleep(3000);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("stockOrderobj.txt"));
			ArrayList<String> combination = new ArrayList<String>();
			String[] valFinal = null;
			StockOrder stock = new StockOrder();
			
			/*String execution = rds.getValue("Stock_Order_Data", test.currentTest, "ExecutionCount");
			stock.setCount(execution);
			String cnt = stock.getCount();
			int cont = Integer.parseInt(cnt);*/
			// manual setup
			int cont = 1; 
			String saStockCombination = rds.getValue("Stock_Order_Data", test.currentTest, "Combination");
			String orderType = rds.getValue("General_Data", test.currentTest, "OrderType");
			
			String[] values = saStockCombination.split(",");
			for (String str : values) {
				combination.add(str);
				System.out.println("combination" + combination); 
			}
			System.out.println("cont" + cont);
			ArrayList<String> itemsno = new ArrayList<String>();
			ArrayList<String> barcono = new ArrayList<String>();
			ArrayList<String> soPoNumber = new ArrayList<String>();
			ArrayList<String> StockOrd = new ArrayList<String>();
			
			
			
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			StockOrderDetailPage stockPage = jdeHomePage
					.navigateToStockOrderPage();  
			for (int i = 0; i < cont; i++) {
				System.out.println("inside loop" + i);
				String set = combination.get(i); 
				System.out.println("set" + set);
				ObjectInputStream objectInputStream = new ObjectInputStream(
						new FileInputStream("sellerAgreementobj.txt"));
				if (orderType.equalsIgnoreCase("Standard")) {
					stock = stockPage.createNewStockOrder(stock, set,
							objectInputStream, itemsno, barcono, StockOrd,
							soPoNumber, i);
					System.out.println("stock" + stock);
				} else if (orderType.equalsIgnoreCase("Wine")) {
					stock = stockPage.createNewWine(stock, set,
							objectInputStream, barcono, itemsno, StockOrd,
							soPoNumber, i);
				} else if (orderType.equalsIgnoreCase("Private")) {
					stock = stockPage.createNewPrivateSale(stock, set,
							objectInputStream, barcono, itemsno, StockOrd,
							soPoNumber, i);
				}

				System.out.println(
						"stock.getStockOrder()" + stock.getStockOrder());
				System.out.println(
						"stock.getItemNumbers()" + stock.getItemNumbers());
				System.out
						.println("stock.getBarcodes()()" + stock.getBarcodes());
			}
			objectOutputStream.writeObject(stock);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("after write object");
			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000); 
			// functionalLibrary.signOut();
			/*
			 * Actions action = new Actions(driver);
			 * action.moveToElement(driver.findElement(By.xpath(
			 * "//a[contains(text(),'Sign Out')]"))).click();
			 * Thread.sleep(3000); action.build().perform(); Thread.sleep(3000);
			 * driver.switchTo().alert().accept(); Thread.sleep(3000);
			 */
			// stockPage.listelemtns();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
