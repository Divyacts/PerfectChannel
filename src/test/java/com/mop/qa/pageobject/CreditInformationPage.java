package com.mop.qa.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

import io.appium.java_client.AppiumDriver;


public class CreditInformationPage extends PageBase {


	public CreditInformationPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public CreditInformationPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}


	// UI Map object definitions
	@FindBy(xpath = "//*[@id='hc_Add']")
	private WebElement addSale;

	@FindBy(xpath = "(//input[@title='Credit Sale Coordinator'])[1]")
	private WebElement creditCor;

	@FindBy(xpath = "(//input[@title='Settlement Sale Coordinator'])[1]")
	private WebElement saleCor;

	@FindBy(xpath = "(//input[@title='Sale Credit Threshold'])[1]")
	private WebElement threshold;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;
	
	TestBase test = new TestBase();

	public PrinterSelectionPage saleTraFinal() {
		try {
			// driver.switchTo().frame(iframe);
			// postSaleTransfer.sendKeys(output);
			Thread.sleep(3000);
			
			String salecord = rds.getValue("General_Data", test.currentTest, "SaleCord");
			creditCor.clear();
			creditCor.sendKeys(salecord.trim());
			Thread.sleep(2000);
			String settlecord = rds.getValue("General_Data", test.currentTest, "SettlementCord");
			Thread.sleep(2000);
			saleCor.clear();
			saleCor.sendKeys(settlecord.trim());
			Thread.sleep(2000);
			String Threshold = rds.getValue("General_Data", test.currentTest, "Threshold");
			threshold.clear();
			threshold.sendKeys(Threshold.trim());
			save.click();
			Thread.sleep(3000);

		} catch (Exception ex) {
			System.out.println("saleTransfer" + ex);
			/*report.updateTestLog(
					"Exception",
					"Exception inside CreditInformationPage 6th screenValue page",
					Status.FAIL);*/
		}
		return new PrinterSelectionPage(remoteDriver);
	}

}
