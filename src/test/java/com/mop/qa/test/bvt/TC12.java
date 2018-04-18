package com.mop.qa.test.bvt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.mop.qa.Utilities.SellerAgrment;
import com.mop.qa.pageobject.JdeHomePage;
import com.mop.qa.pageobject.SellerAgreementChargesPage;
import com.mop.qa.pageobject.SellerAgreementDetailsPage;
import com.mop.qa.pageobject.SellerAgreementPayment;
import com.mop.qa.pageobject.SellerAgreementSignatorisPage;
import com.mop.qa.pageobject.SellerAgreementStandardPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.testbase.TestBase;

public class TC12 extends TestBase {

	@Test
	public void executeTest() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("sellerAgreementobj.txt"));

			String ICEnabled = rds.getValue("SA_IC", currentTest, "ICEnabled"); 
			String user = rds.getValue("General_Data", currentTest, "Username");
			String password = rds.getValue("General_Data", currentTest, "Password");  
			
			String agreementType = rds.getValue("General_Data", currentTest, "AgreementType");
			String lossLDL = rds.getValue("SellerAgreement_Data", currentTest, "LDL"); 

			SellerAgrment sa = new SellerAgrment(); 

			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			signOnPage.enterUrl();
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser();
			
			
			SellerAgreementStandardPage standard = jdeHomePage
					.naviWorkWithSellerAgreement(agreementType);
			ArrayList<String> Seller = new ArrayList<String>();
			for (int i = 0; i < 1; i++) {
				SellerAgreementDetailsPage details = standard
						.addNewSelAgrreement(i);
				sa = details.createSellerAgrStand(objectOutputStream, sa,
						Seller);
				if (lossLDL.equalsIgnoreCase("C")) {
					details.enterTableValues();
				}
				SellerAgreementChargesPage charges = details.selectCharge();
				details = charges.setChargeValue();

				SellerAgreementSignatorisPage sign = details
						.selectSignotories();
				details = sign.setSignotoryVal();
				SellerAgreementPayment payment = details.selectPayments();
				Thread.sleep(5000); 
				details = payment.setPayment();

				if (ICEnabled.trim().equalsIgnoreCase("Y")) {
					System.out.println("setICJudistriction is set");
					details.setICJudistriction();
				}

				standard = details.saveOnly();
				Thread.sleep(3000); 
				objectOutputStream.writeObject(sa);

				objectOutputStream.flush();
				jdeHomePage.goToHomeScreen();
				Thread.sleep(3000);
				signOnPage.logout(); 
				String sellerAg = sa.getSellerAgreement().get(i);
				System.out.println("sellerg Number" + sellerAg);
			}
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

	public void updateExcel(String sellerAg, String iter, String tcId) {
		String excelFilePath = "D:\\SellerData.xlsx";
		try {
			System.out.println("inside write");
			FileInputStream inputStream = new FileInputStream(
					new File(excelFilePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet worksheet = workbook.getSheetAt(0);
			System.out.println("inside write");
			int rowNum = worksheet.getLastRowNum() + 1;
			System.out.println("inside rowNum");
			Row row = worksheet.createRow(rowNum);
			Cell cell = row.createCell(0);
			cell.setCellValue(tcId);
			cell = row.createCell(1);
			cell.setCellValue(iter);
			cell = row.createCell(2);
			cell.setCellValue(sellerAg);
			System.out.println("inside rowNum");
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();
			System.out.println("after wr write");

		} catch (IOException | EncryptedDocumentException ex) {
			ex.printStackTrace();
		}
	}


}
