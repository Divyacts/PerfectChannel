package com.mop.qa.test.bvt;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mop.qa.Utilities.StockOrder;
import com.mop.qa.pageobject.BookArrivalPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.StockOrderDetailPage;
import com.mop.qa.pageobject.WorkWithPropertyPage;
import com.mop.qa.testbase.TestBase;



public class TC024 extends TestBase {

	public StockOrder stock;

	@Test
	public void executeTest() {
		try {
			System.out.println("IT - 024 - Property Arrival - IN2");
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			StockOrderDetailPage stock = jdeHomePage.navigateToStockOrderPage();
			ArrayList<ArrayList<String>> barPoSoList = new ArrayList<ArrayList<String>>();
			ArrayList<String> poSoForArrival = new ArrayList<String>();
			ArrayList<String> barcodesForStock = new ArrayList<String>();

			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("stockOrderobj.txt"));
			StockOrder stockor = (StockOrder) objectInputStream.readObject();
			ArrayList<String> itemNum = stockor.getItemNumbers();
			ArrayList<String> sNo = stockor.getStockOrder();
			ArrayList<String> sopoNumbers = stockor.getStockOrder();
			System.out.println("itemNum" + itemNum);
			System.out.println("sNo" + sNo);
			System.out.println("sopoNumbers" + sopoNumbers);

			// core logic
			for (int i = 0; i < sNo.size(); i++) {

				HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
				// ArrayList<String> barcodesForStock1 = new
				// ArrayList<String>();
				List<String> values = new ArrayList<String>();
				List<String> item = new ArrayList<String>();
				String stNo = sNo.get(i);
				System.out.println("stNo" + stNo);
				for (int j = 0; j < itemNum.size(); j++) {
					if (itemNum.get(j).contains(stNo)) {
						values.add(itemNum.get(j));
						hm.put(stNo, values);
						System.out.println("hm" + hm);
						item = hm.get(stNo);
						System.out.println("last item" + item);
					}
				}
				System.out.println("item size" + item.size());
				barPoSoList = stock.searchAndGetItemAndPOSO(stNo);
				barcodesForStock = barPoSoList.get(0);
				poSoForArrival = barPoSoList.get(1);
				System.out.println("after write object");
				jdeHomePage.goToHomeScreen();
				BookArrivalPage arrivalPage = jdeHomePage.navigateToArrivalOfItem();
				arrivalPage = arrivalPage.arriveItem(barcodesForStock, poSoForArrival, stNo);
				jdeHomePage.goToHomeScreen();
				Thread.sleep(3000);
				
				System.out.println("before autiit");
				Runtime.getRuntime().exec(
						"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");

				signOnPage = new SignOnPage(remoteDriver);
				jdeHomePage = signOnPage.loginAsValidUser(); 
				jdeHomePage.naviWorkWithProperty();
				Thread.sleep(5000);
			}
			/*
			 * objectOutputStream.writeObject(stockor);
			 * System.out.println("stockorbarcodes" +
			 * stockor.getFinalBarcodes());
			 */

			jdeHomePage.goToHomeScreen();
			Thread.sleep(3000);
			
			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");
			
			signOnPage = new SignOnPage(remoteDriver);
			jdeHomePage = signOnPage.loginAsValidUser();
			WorkWithPropertyPage wrkWithProp = jdeHomePage.naviWorkWithProperty();
			System.out.println("itemNum" + itemNum);
			wrkWithProp.getInvenStat(itemNum);

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}


}
