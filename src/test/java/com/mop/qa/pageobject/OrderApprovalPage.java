package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;


public class OrderApprovalPage extends PageBase {

	public OrderApprovalPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}

	// UI Map object definitions
	@FindBy(xpath = "(//*[@title='Branch/Plant'])[1]")
	private WebElement branch;

	@FindBy(xpath = "(//*[@title='Approver'])[1]")
	private WebElement approver;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//nobr[contains(text(),'Approval Review')]")
	private WebElement appReview;

	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExit;

	@FindBy(xpath = "//nobr[contains(text(),'Approve')]")
	private WebElement approve;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "(//*[@title='Order Number'])[1]")
	private WebElement orderNumber;
	
	TestBase test = new TestBase();

	public OrderApprovalPage approval() throws Exception {
		System.out.println("Inside PO approval page");
		remoteDriver.switchTo().frame(menuIframe);
		branch.clear();
		approver.clear();
		String approverID = rds.getValue("P2P", test.currentTest, "ApproverID");
		enterText(approver, approverID, "approver");
		approver.sendKeys(approverID);
		Thread.sleep(3000);
		String OrderNumber = functionallibraries.FunctionalLibrary
				.propertiesRead("PurchaseOrderNumber");
		orderNumber.sendKeys(OrderNumber);
		searchButton.click();
		Thread.sleep(3000);
		checkBox.click();
		rowExit.click();
		moveToElement(appReview, "appReview");
		/*Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(appReview).click().build().perform();*/
		Thread.sleep(5000);
		click(formExit, "formExit");
		Thread.sleep(3000);
		String status = "Approved";
		if (status.equalsIgnoreCase("Approved")) {
			moveToElement(approve, "approve");
			
			Thread.sleep(3000);
		}
		return new OrderApprovalPage(remoteDriver);
	}

}
