package com.mop.qa.pageobject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.DateObject;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import io.appium.java_client.AppiumDriver;



public class PostSaleTransferPage extends PageBase {
	

	public PostSaleTransferPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public PostSaleTransferPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	


	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addSale;

	@FindBy(xpath = "(//input[@title='Sold - Post Sale Transfer'])[1]")
	private WebElement soldpostSaleTransfer;

	@FindBy(xpath = "(//input[@title='Bi - Post Sale Transfer'])[1]")
	private WebElement biPostTransfer;

	@FindBy(xpath = "(//input[@title='Sold - Non - Post Sale Transfer'])[1]")
	private WebElement nonPostTransfer;

	@FindBy(xpath = "(//input[@title='BI - Non - Post Sale Transfer'])[1]")
	private WebElement nonBIPostTransfer;

	@FindBy(xpath = "(//input[@title='Post Sale Transfer Location'])[1]")
	private WebElement postSaleTransfer;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	public CreditInformationPage saleTransfer(DateObject date)
			throws InterruptedException {
		try {
			TestBase test = new TestBase();
			// driver.switchTo().frame(iframe);
			Thread.sleep(3000);
			System.out.println(date);
			String output = date.getDateVal(); // Start date
			System.out.println("output" + output);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(output));
			c.add(Calendar.DATE, 2);
			output = sdf.format(c.getTime());
			soldpostSaleTransfer.clear();
			Thread.sleep(3000);
			// soldpostSaleTransfer.sendKeys(output);
			System.out.println("soldpostSaleTransfer" + output);

			String output4 = date.getDateVal(); // Start date
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c3 = Calendar.getInstance();
			c3.setTime(sdf3.parse(output4));
			c3.add(Calendar.DATE, 2);
			output4 = sdf3.format(c3.getTime());
			Thread.sleep(3000);
			biPostTransfer.clear();
			// biPostTransfer.sendKeys(output4);
			System.out.println("biPostTransfer" + output4);
			Thread.sleep(3000);

			String output2 = date.getDateVal(); // Start date
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.setTime(sdf1.parse(output2));
			c1.add(Calendar.DATE, 3);
			output2 = sdf1.format(c1.getTime());
			Thread.sleep(3000);
			nonPostTransfer.clear();
			// nonPostTransfer.sendKeys(output2);
			System.out.println("nonPostTransfer" + output2);
			Thread.sleep(3000);

			String output3 = date.getDateVal(); // Start date
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c2 = Calendar.getInstance();
			c2.setTime(sdf2.parse(output3));
			c2.add(Calendar.DATE, 3);
			output3 = sdf2.format(c2.getTime());
			Thread.sleep(3000);
			nonBIPostTransfer.clear();
			// nonBIPostTransfer.sendKeys(output3);
			System.out.println("nonBIPostTransfer" + output3);
			Thread.sleep(1000);
			
			String TransferLoc = rds.getValue("General_Data", test.currentTest, "TransferLoc");

			Thread.sleep(3000);
			// postSaleTransfer.sendKeys(TransferLoc);
			Thread.sleep(3000);

			save.click();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("enter3ScreenVal" + ex);
			/*report.updateTestLog("Exception",
					"Exception inside PostSaleTransferPage 5th screenValue page",
					Status.FAIL);*/
		}
		return new CreditInformationPage(remoteDriver);
	}

}
