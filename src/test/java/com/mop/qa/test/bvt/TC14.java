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
import com.mop.qa.pageobject.SellerAgreementBeSpokePage;
import com.mop.qa.pageobject.SellerAgreementChargesPage;
import com.mop.qa.pageobject.SellerAgreementDetailsPage;
import com.mop.qa.pageobject.SellerAgreementPayment;
import com.mop.qa.pageobject.SellerAgreementSignatorisPage;
import com.mop.qa.pageobject.SellerAgreementStandardPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.TieredRatePage;
import com.mop.qa.testbase.TestBase;

import functionallibraries.FunctionalLibrary;

public class TC14 extends TestBase {


TestBase test = new TestBase();

	@Test
	public void executeTest() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("sellerAgreementobj.txt"));
			
			String execution = rds.getValue("SellerAgreement_Data", test.currentTest, "ExecutionCount");
			String agreementType = rds.getValue("General_Data", test.currentTest, "AgreementType");

			SellerAgrment sa = new SellerAgrment();
			sa.setCount(execution);
			String cnt = sa.getCount();
			int cont = Integer.parseInt(cnt);
			System.out.println("con" + cont);
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser(); 

			SellerAgreementStandardPage standard = jdeHomePage
					.naviWorkWithSellerAgreement(agreementType);
			ArrayList<String> Seller = new ArrayList<String>();
			for (int i = 0; i < cont; i++) {
				SellerAgreementDetailsPage details = standard
						.addNewSelAgrreement(i);
				details.createSellerAgrStand(objectOutputStream, sa, Seller);
				SellerAgreementChargesPage charges = details.selectCharge();
				details = charges.setChargeValue();
				SellerAgreementSignatorisPage sign = details
						.selectSignotories();
				details = sign.setSignotoryVal();
				SellerAgreementPayment payment = details.selectPayments();
				Thread.sleep(5000);
				details = payment.setPayment();
				SellerAgreementBeSpokePage beSpoke = details.selectBeSpoke();
				
				String beSpok = rds.getValue("SellerAgreement_Data", test.currentTest, "BeSpoke");

				if (beSpok.equalsIgnoreCase("O")) {
					beSpoke.setBeSpokeOverCommission();
				} else if (beSpok.equalsIgnoreCase("Z")) {
					beSpoke.setBeSpokeZeroCommison();
				} else if (beSpok.equalsIgnoreCase("E")) {
					TieredRatePage tiered = beSpoke.setValuesEnhancedhammer();
					tiered.entertierDetailsAndSave();
				}
			}
			objectOutputStream.writeObject(sa);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("objectOutputStream.sa"
					+ sa.getSellerAgreement());
			jdeHomePage.goToHomeScreen();
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		}

	}

	public void updateExcel(String sellerAg, String iter, String tcId) {
		String excelFilePath = "D:\\SellerData.xlsx";
		try {
			System.out.println("inside write");
			FileInputStream inputStream = new FileInputStream(new File(
					excelFilePath));
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
