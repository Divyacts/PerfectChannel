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
import com.mop.qa.pageobject.PerfectChannelHomePage;
import com.mop.qa.pageobject.SellerAgreementDetailsPage;
import com.mop.qa.pageobject.SellerAgreementNonStandardPage;
import com.mop.qa.pageobject.SellerAgreementStandardPage;
import com.mop.qa.pageobject.SignOnPage;
import com.mop.qa.pageobject.TieredRatePage;
import com.mop.qa.testbase.TestBase;



public class TC13 extends TestBase {

	TestBase test = new TestBase();

	@Test
	public void executeTest() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("sellerAgreementobj.txt"));
			
			String execution = rds.getValue("SellerAgreement_Data", test.currentTest, "ExecutionCount");
			String ICEnabled = rds.getValue("SA_IC", test.currentTest, "ICEnabled");
			String agreementType = rds.getValue("General_Data", currentTest, "AgreementType");

			SellerAgrment sa = new SellerAgrment();
			sa.setCount(execution);
			String cnt = sa.getCount();
			int cont = Integer.parseInt(cnt);
			SignOnPage signOnPage = new SignOnPage(remoteDriver);
			JdeHomePage jdeHomePage = signOnPage.loginAsValidUser(); 

			SellerAgreementStandardPage standard = jdeHomePage
					.naviWorkWithSellerAgreement(agreementType);
			String lossLDL = rds.getValue("SellerAgreement_Data", currentTest, "LDL");

			ArrayList<String> Seller = new ArrayList<String>();
			for (int i = 0; i < cont; i++) {
				SellerAgreementDetailsPage details = standard
						.addNewSelAgrreement(i);
				details.createSellerAgrStand(objectOutputStream, sa, Seller);

				// SellerAgreementChargesPage charges = details.selectCharge();
				// details = charges.setChargeValue();
				// if (lossLDL.equalsIgnoreCase("C")) {
				// details.enterTableValues();
				// }
				// SellerAgreementSignatorisPage sign = details
				// .selectSignotories();
				// details = sign.setSignotoryVal();
				// SellerAgreementPayment payment = details.selectPayments();
				// Thread.sleep(5000);
				// details = payment.setPayment();
				if (ICEnabled.trim().equalsIgnoreCase("Y")) {
					System.out.println("setICJudistriction is set");
					details.setICJudistriction();
				}
				SellerAgreementNonStandardPage nonStd = details
						.selectNonStandard();
				
				String nonstdCmr = rds.getValue("SellerAgreement_Data", currentTest, "NonStdCMR");

				System.out.println("nonstdCmr" + nonstdCmr);
				if (nonstdCmr.equalsIgnoreCase("O")) {
					TieredRatePage tRatePage = nonStd.setValuesForNonStandard();
					tRatePage.entertierDetailsAndSave();
				} else if (nonstdCmr.equalsIgnoreCase("N")) {
					nonStd.setNonStdCommissionRate();
				} else if (nonstdCmr.equalsIgnoreCase("Z")) {
					nonStd.setNonStdCommissionRate();
				}

				standard = details.saveOnly();
				Thread.sleep(3000);
				// jdeHomePage = standard.close();
				objectOutputStream.writeObject(sa);

				objectOutputStream.flush();
				System.out.println("before autiit");
				Runtime.getRuntime().exec(
						"D:\\Data Backup\\DeskTopBackUp\\christies\\logout.exe");
				Thread.sleep(10000);
				System.out.println("after autiit");
				String sellerAg = sa.getSellerAgreement().get(i);

				System.out.println("sellerg Number" + sellerAg);
				
				String iter = rds.getValue("SellerAgreement_Data", currentTest, "Iteration");
				String tcId = rds.getValue("SellerAgreement_Data", currentTest, "TC_ID");
				updateExcel(sellerAg, iter, tcId);

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
