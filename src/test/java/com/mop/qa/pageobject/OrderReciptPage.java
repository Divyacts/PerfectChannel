package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;


/**
 * FlightConfirmationPage class
 * 
 * @author Cognizant
 */
public class OrderReciptPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "(//input[@title='Order Number'])[1]")
	private WebElement orderNumber;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//span/button[text()='Create Charge']")
	private WebElement chargebutton;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='C0_37']")
	private WebElement branchPlant;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(id = "//*[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div/input")
	private WebElement RecCnt;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement warning;

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public OrderReciptPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	public OrderReciptPage2 orderRecipt() throws InterruptedException, IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			branchPlant.clear();
			orderNumber.clear();
			String orderNo = getJDEAppProperties("PurchaseOrderNumber");
            enterText(orderNumber, orderNo, "orderNumber");
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			click(checkBox, "checkBox");
			click(selectButton, "selectButton");
			Thread.sleep(8000);
			ExtentUtility.getTest().log(LogStatus.PASS, "Order Recipt successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println("Inside Order Recipt" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception in Order Recipt successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new OrderReciptPage2(remoteDriver);
	}

	public void reciptCheck() throws IOException {
		if (checkBox.isDisplayed()) {
			ExtentUtility.getTest().log(LogStatus.PASS, "CheckBox is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

}
