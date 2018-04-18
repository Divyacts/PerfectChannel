package com.mop.qa.test.bvt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


import org.testng.annotations.Test;

import com.mop.qa.Utilities.DateObject;
import com.mop.qa.pageobject.CreditInformationPage;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.PostSaleTransferPage;
import com.mop.qa.pageobject.PrinterSelectionPage;
import com.mop.qa.pageobject.SaleSessionViewingPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.WorkWithSaleHeaderPage;
import com.mop.qa.testbase.TestBase;

 
  
public class TC11 extends TestBase {

	@Test 
	public void executeTest() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("date.txt"));
			 
			DateObject date = new DateObject();   

			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl(); 
			
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			
			WorkWithSaleHeaderPage saleheader = jdeHomePage.naviWorkWithSaleHeader(); 
			
			SaleSessionViewingPage viewpage = new SaleSessionViewingPage(remoteDriver); 
			date = saleheader.createSale(objectOutputStream, date); 
			String saleTyp = rds.getValue("General_Data", currentTest, "SaleType");
			if(saleTyp.equalsIgnoreCase("Online")){
				viewpage.enterecomData();
			}else{
				viewpage.enter3ScreenVal(); 	
			}
			
			PostSaleTransferPage saleTransfer = viewpage.enter4ScreenVal(date);
			
			CreditInformationPage crdtInfo = saleTransfer.saleTransfer(date);
			PrinterSelectionPage print = crdtInfo.saleTraFinal();
			saleheader = print.saveToPrint();	 
			
			String saleNum = saleheader.isSaleCreated();  
			
 
			System.out.println("before autiit");
			Runtime.getRuntime().exec(
					"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
			Thread.sleep(10000);
			System.out.println("after autiit");

		} catch (Exception ex) {
			System.out.println("Exception" + ex);

	}

	}

}
