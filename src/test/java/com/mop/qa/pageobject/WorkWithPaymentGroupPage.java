package com.mop.qa.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import supportlibraries.ScriptHelper;

public class WorkWithPaymentGroupPage extends PageBase {

	public WorkWithPaymentGroupPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		// TODO Auto-generated constructor stub
	}

	// UI Map object definitions

	@FindBy(xpath = "//img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//input[@title='Pay Inst']")
	private WebElement payInstrmntField;

	@FindBy(xpath = "//input[@title='Originator']")
	private WebElement originatorField;

	@FindBy(xpath = "(//input[@title='Bank Account'])[1]")
	private WebElement bankAccntField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement rowSelect;

	@FindBy(id = "ROW_EXIT_BUTTON")
	private WebElement rowExitButton;

	@FindBy(xpath = "//*[@id='HE0_94']/tbody/tr/td[2]/span/nobr")
	private WebElement writeOption;

	@FindBy(xpath = "//*[@id='HE0_95']/tbody/tr/td[2]/span/nobr")
	private WebElement updateOption;

	@FindBy(xpath = "	(//a[@title='Refresh'])[2]")
	private WebElement refreshButton;

	@FindBy(xpath = "(//input[@title='Batch Number'])[1]")
	private WebElement batchNumberField;

	@FindBy(xpath = "//button[@id='C0_13']")
	private WebElement okButtonPopUp;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[6]")
	private WebElement checkStatusAfterPrint;

	@FindBy(xpath = "//*[@id='G0_11_R0']/td[1]/div")
	private WebElement rowAfterSelect;

	@FindBy(className = "JSGridHeaderCell")
	private List<WebElement> gridList;

	public void completePayment() throws Exception {
		System.out.println("Navigated to Work with Payment Groups");

		remoteDriver.switchTo().frame(iframe);


		bankAccntField.clear();
		Thread.sleep(2000);

		payInstrmntField.clear();
		Thread.sleep(2000);
		enterText(payInstrmntField, "C", "payInstrmntField");
		Thread.sleep(2000);
		enterText(originatorField, "INJRENJIN", "originatorField");
		click(searchButton, "searchButton");

		Thread.sleep(3000);

		if (rowSelect.isDisplayed()) {
			click(rowSelect, "rowSelect");
			click(rowExitButton, "rowExitButton");
			Thread.sleep(3000);
			Thread.sleep(2000);
			moveToElement(writeOption, "writeOption");
			Thread.sleep(3000);

			click(saveButton, "saveButton");
			Thread.sleep(5000);
			// saveButton.click();
			// Thread.sleep(2000);

			click(okButtonPopUp, "okButtonPopUp");
			System.out.println("Printer Selection Page");
			Thread.sleep(2000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);

			remoteDriver.switchTo().defaultContent();
			Thread.sleep(8000);
			remoteDriver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			Thread.sleep(20000);
			Thread.sleep(8000);
			System.out.println("after wait");
			click(refreshButton,"refreshButton");

			remoteDriver.switchTo().frame(iframe);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			String checkStatusPrint = checkStatusAfterPrint.getText();
			if (checkStatusPrint.equalsIgnoreCase("UPD")) {
				System.out.println("Status changed successfully");
				ExtentUtility.getTest().log(LogStatus.PASS, "Status changed from WRT to UPD",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				Thread.sleep(3000);
				click(rowSelect, "rowSelect");
				Thread.sleep(3000);
				click(rowExitButton, "rowExitButton");
				Thread.sleep(2000);
				moveToElement(updateOption, "updateOption");
				Thread.sleep(3000);
				click(saveButton, "saveButton");
				Thread.sleep(5000);
				// checkPayStatus();

			} else {

				System.out.println("Status changed failed");
			}

		}

	}

}
