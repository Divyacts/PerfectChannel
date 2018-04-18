package com.mop.qa.pageobject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;


public class PrinterSelectionPage extends PageBase {
	
	public PrinterSelectionPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public PrinterSelectionPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement save;

	/*public WorkWithPropertyPage saveCharge() throws InterruptedException {
		save.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		return new WorkWithPropertyPage(scriptHelper);
	}*/
 
	public WorkWithSaleHeaderPage saveToPrint() throws Exception {
		Thread.sleep(3000);
		click(save, "save");
		Thread.sleep(3000);
		remoteDriver.switchTo().defaultContent();
		return new WorkWithSaleHeaderPage(remoteDriver);
	}

	public OrderInquiryChargePage savefrmOrder() throws Exception {
		click(save, "save");
		Thread.sleep(3000);
		remoteDriver.switchTo().defaultContent();
		return new OrderInquiryChargePage(remoteDriver);
	}

}
