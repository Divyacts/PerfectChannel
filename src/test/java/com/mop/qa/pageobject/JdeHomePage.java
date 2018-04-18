package com.mop.qa.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus; 

import io.appium.java_client.AppiumDriver;

public class JdeHomePage extends PageBase {
	// UI Map object definitions
	@FindBy(xpath = "//*[@id='drop_mainmenu']")
	private WebElement mainMenu;

	@FindBy(xpath = "//div[@id='drop_home']")
	private WebElement homeScreen;

	@FindBy(xpath = "//span[contains(text(),'Christie') and contains(text(),'London')]")
	private WebElement christiesLondon;

	@FindBy(xpath = "(//span[text()='CCSA'])[2]")
	private WebElement navigateCCSA;

	@FindBy(xpath = "(//span[contains(text(),'Stock Orders')])[2]")
	private WebElement stockOrders;

	@FindBy(xpath = "(//a[contains(text(),'Stock') and contains(text(),'Standard')])[2]")
	private WebElement standardStock;

	@FindBy(xpath = "(//a[contains(text(),'Sale')])[2]")
	private WebElement sale;

	@FindBy(xpath = "//*[@id='C0_22']")
	private WebElement itemId;

	@FindBy(xpath = "//*[@id='hc_Find']")
	private WebElement find;

	@FindBy(xpath = "//*[@id='hc_Select']")
	private WebElement select;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='e1MFastpathForm']/a/img")
	private WebElement searchArrow;
	

	public JdeHomePage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public JdeHomePage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	
	TestBase test = new TestBase();
	

	public void goToHomeScreen() throws Exception {
		System.out.println("Going to home screen");
		remoteDriver.switchTo().defaultContent();
		click(homeScreen,"homeScreen");
	}
	 
	public InventoryPage navigateToInventoryPage() {
		try {
			System.out.println("inside navigateMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Inventory')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Temporary') and contains(text(),'Release')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Maintain') and contains(text(),'Outbound') and contains(text(),'Order')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inventory Page" + ex);

		}
		return new InventoryPage(remoteDriver);

	}
	
	public OrderReciptPage navigateToPORecipt() throws IOException {
		try {
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Order') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Order') and contains(text(),'Receipt')])[2]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Order') and contains(text(),'Receipt') and contains(text(),'OP')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToPORecipt Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate To Purchase Order Receipt" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigateToPORecipt ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} 
		return new OrderReciptPage(remoteDriver);
	}
	
	public BookArrivalPage navigateToBookArrivalsSiteTransfer() throws IOException {
		try {
			System.out.println("inside navigateToBookArrivalsSiteTransfer");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Inventory')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Scanner')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Book') and contains(text(),'Arrivals') and contains(text(),'Site')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to BookArrivalsSiteTRansfer Page"
							+ ex);

			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToBookArrivalsSiteTransfer Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new BookArrivalPage(remoteDriver);

	}
	
	public InboundPropertyPage navigateToInboundProp() throws IOException {
		try {
			System.out.println("inside navigateToInboundProp");

			String country = rds.getValue("General_Data", test.currentTest, "Country");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Inventory')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Inbound') and contains(text(),'Property')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToInboundProp Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inventory Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToInboundProp Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new InboundPropertyPage(remoteDriver);

	}
	
	public OutboundSoldAuctionPage navigateToOutboundSoldAuction() {
		try {
			System.out.println("inside navigateMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[5]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[3]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[4]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Outbound') and contains(text(),'Sold') and contains(text(),'Auction')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to OutboundSoldAuction Page"
							+ ex);
		}
		return new OutboundSoldAuctionPage(remoteDriver);
	}
	
	
	public BookArrivalPage navigateToArrivalOfItem() throws IOException {
		try {
			System.out.println("inside navigateToArrivalOfItem");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Inventory')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Scanner')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Book') and contains(text(),'Arrivals')])[6]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToArrivalOfItem Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Book Arrival" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception insideNavigate to Book Arrival",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new BookArrivalPage(remoteDriver);
	}
	

	
	
	
	public OutboundSoldAuctionPage navigateToOutBoundTempReleasePage() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			Thread.sleep(3000);
			System.out.println("Inbound");
			Thread.sleep(5000);
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Outbound') and contains(text(),'Temporary') and contains(text(),'Release')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigate To OutBound TempReleasePage Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inbound Consignment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Inbound Consignment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new OutboundSoldAuctionPage(remoteDriver);
	}
	
	public OutboundSoldAuctionPage navigateToOutboundIntersiteTransfers() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			Thread.sleep(3000);
			System.out.println("Inbound");
			Thread.sleep(5000);
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Outbound') and contains(text(),'Intersite') and contains(text(),'Transfer')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToOutboundIntersiteTransfers Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inbound Consignment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Inbound Consignment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new OutboundSoldAuctionPage(remoteDriver);
	}
	
	
	public OutboundSoldAuctionPage navigateToOutboundRTO() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			Thread.sleep(3000);
			System.out.println("Inbound");
			Thread.sleep(5000);
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Outbound') and contains(text(),'RTO') and contains(text(),'Recollections') and contains(text(),'party')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToOutboundRTO Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work With Shipment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToOutboundRTO Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new OutboundSoldAuctionPage(remoteDriver);
	}
	 
	public PurchaseOrderEntryPage navigtingToCreatePurOrderEntry() throws IOException {
		try {
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(4000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Entry')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			/*
			 * action.moveToElement( driver.findElement(By .xpath(
			 * "//td/div/div/div/table/tbody/tr/td[4]/table/tbody/tr/td/table/tbody/tr/td/a"
			 * ))).click() .build().perform();
			 */

			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'3') and contains(text(),'Way') and contains(text(),'Match')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.INFO, "navigtingToCreatePurOrderEntry Page Successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating To PO Order Entry" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigating To PO Order Entry",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new PurchaseOrderEntryPage(remoteDriver);

	}
	
	public InboundConsignmentPage navigateToInboundIntersiteTransfers() throws IOException {
		try {
			System.out.println("inside navigateMenu");

			Thread.sleep(3000);
			System.out.println("Inbound");
			Thread.sleep(5000);
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Inbound') and contains(text(),'Intersite') and contains(text(),'Transfers')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToInboundIntersiteTransfers Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inbound Consignment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Inbound Consignment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new InboundConsignmentPage(remoteDriver);
	}
	
	
	public WorkWithShippmentPage navigateToWorkWithShipment() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'Shipments')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToWorkWithShipment successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work With Shipment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToWorkWithShipment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithShippmentPage(remoteDriver);
	}
	
	public ClientCollectionPage navigateToClientCollections() {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Inventory')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Scanner')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Client') and contains(text(),'Collections')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Client Collections Page"
							+ ex);
		}
		return new ClientCollectionPage(remoteDriver);
	}

	public WorkWithSaleHeaderPage naviWorkWithSaleHeader1() throws Exception {
		try {
			System.out.println("inside naviWorkWithSaleHeader");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'With') and contains(text(),'Sale') and contains(text(),'Header')])[3]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Work with sale header successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Sale Header"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate Work with sale Header",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithSaleHeaderPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCreditBatchingAdHoc() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//a[contains(text(),'Ad-hoc')])[2]"))).click()
					.build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Batch Review",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Batch Review",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCLedgerBatchingCancelAndMake() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Ledger') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Cancel') and contains(text(),'Sales') and contains(text(),'Make')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToCLedgerBatchingCancelAndMake Succesfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Cancel and Make Stock"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Batch Review",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public ReciptingPage navigateToClientAccountingRecipt() throws IOException {
		try {
			System.out.println("inside navigateToClientAccountingRecipt");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000); 
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Receipting')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//a[contains(text(),'Receipting')])[3]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToClientAccountingRecipt successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to client accounting" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToClientAccountingRecipt",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new ReciptingPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCreditBatchingSellerSOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'SOP')])[6]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreditBatchingSellerSOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Seller SOP" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to batching Seller SOP",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToSettlementBatchingSellerSOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Settlement') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'SOP')])[6]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToSettlementBatchingSellerSOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Seller SOP" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to batching Seller SOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	} 
	
	public SaleBatchSubmissionPage navigateToSettlementBatchingPOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Settlement') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//a[contains(text(),'POP')])[9]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToSettlementBatchingPOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Seller SOP" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to batching Seller SOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SOPEnquiryPage navigateToSOPEnquiry() throws IOException {
		try {
			System.out.println("inside navigateToSOPEnquiry");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'CCSA')])[2]"))).click()
					.build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Charges')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'SOP') and contains(text(),'Enquiry')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToSOPEnquiry successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to SOP Inquiry Sale" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to SOP Inquiry Sale",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SOPEnquiryPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCLedgerBatchingSundryInvoice() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Ledger') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Sundry') and contains(text(),'Buyer') and contains(text(),'Invoice')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCLedgerBatchingSundryInvoice successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Sundry Invoice"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToCLedgerBatchingSundryInvoice",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SundryChargeEntryPage navigateToCreateSundryChargeEntry() throws IOException {
		try {
			System.out.println("inside navigateToSundryChargeEntry");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Ledger') and contains(text(),'Management')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Sundry') and contains(text(),'Charge') and contains(text(),'Entry')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreateSundryChargeEntry successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Sundry Invoice"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to batching Sundry Invoice",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SundryChargeEntryPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCLedgerBatchingSellerMakeStock() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Ledger') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'Make') and contains(text(),'Stock')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCLedgerBatchingSellerMakeStock successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Seller Make Stock"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to batching Seller Make Stock",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCLedgerBatchingSellerSOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Ledger') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'SOP')])[6]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCLedgerBatchingSellerSOP successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to batching Sundry Invoice"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception navigateToCLedgerBatchingSellerSOP",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	
	public WorkWithPropertyPage naviWorkWithProperty1() throws IOException {
		try {
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			
			Thread.sleep(4000);
			System.out.println("inside navigateWorkWithProperty");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'With') and contains(text(),'Property')])[3]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation naviWorkWithProperty successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with property" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception naviWorkWithProperty",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPropertyPage(remoteDriver);
	}
	
	public InboundConsignmentPage navigateToInboundConsignmentPage() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			Thread.sleep(3000);
			System.out.println("Inbound");
			Thread.sleep(5000);
			String country = rds.getValue("CAT", test.currentTest, "Country");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'CAT') and contains(text(),'Requests')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Inbound') and contains(text(),'Consignment') and contains(text(),'Stock') and contains(text(),'Orders')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToInboundConsignmentPage successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Inbound Consignment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Inbound Consignment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new InboundConsignmentPage(remoteDriver);
	}
	
	public AutonettingPage navigateToAutonetting() throws IOException {
		try {
			System.out.println("inside navigateToAutonetting");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Auto') and contains(text(),'Netting')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToAutonetting successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Auto Netting" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Auto Netting",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new AutonettingPage(remoteDriver);
	}
	 
	public SaleBatchSubmissionPage navigateToCreditBatchingPsotSaleFrieght() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Post') and contains(text(),'Sale') and contains(text(),'Freight')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreditBatchingPsotSaleFrieght successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Post Sale Freight" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Post Sale Freight",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public WorkWithShippmentPage navigateToWorkWithShipment3() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[6]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[5]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'Shipments')])[4]")))
					.click().build().perform();
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToWorkWithShipment3 successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work With Shipment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Work With Shipment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithShippmentPage(remoteDriver);
	}
	
	public FreightUpdateBillablesPage navigateToFreightUpdateBillablesPage() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);  
			String country = rds.getValue("CAT", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[3]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Payments')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Freight') and contains(text(),'Update')and contains(text(),'Billables') and contains(text(),'Express')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToFreightUpdateBillablesPage successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to FreightUpdateBillables Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to FreightUpdateBillables Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		
		}
		return new FreightUpdateBillablesPage(remoteDriver);

	}
	
	public SOPManageExistingOrder navigateToSOPpage() {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//a[contains(text(),'SOP')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);

		}

		catch (Exception ex) {
			System.out.println("Exception inside Navigate to SOP Page" + ex);
		}
		return new SOPManageExistingOrder(remoteDriver);
	}

	public SOPManageExistingOrder navigateToSOPpage1() {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[3]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//a[contains(text(),'SOP')])[4]")))
					.click().build().perform();
			Thread.sleep(2000);

		}

		catch (Exception ex) {
			System.out.println("Exception inside Navigate to SOP Page" + ex);
		}
		return new SOPManageExistingOrder(remoteDriver);
	}

	
	public FreightUpdatePayablePage navigateToFreightUpdatePayablePage() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[5]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[3]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Reports')])[4]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Freight') and contains(text(),'Update')and contains(text(),'payable') and contains(text(),'manual')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToFreightUpdatePayablePage successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to FreightUpdatePayables Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to FreightUpdatePayables Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new FreightUpdatePayablePage(remoteDriver);

	}
	
	public TMSShipConfirmCatPage navigateToTMSShipConfirmPage() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'GNV') and contains(text(),'Transport') and contains(text(),'Reports')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'TMS') and contains(text(),'Ship')and contains(text(),'Confirm') and contains(text(),'CAT') and contains(text(),'Shipments')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToTMSShipConfirmPage successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to TMSShipConfirm Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to TMSShipConfirm Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new TMSShipConfirmCatPage(remoteDriver);

	}
	
	public WorkWithShippmentPage navigateToWorkWithShipment2() {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("CAT", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[6]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[5]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'Shipments')])[4]")))
					.click().build().perform();
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work With Shipment Page"
							+ ex);
		}
		return new WorkWithShippmentPage(remoteDriver);
	}
	public WorkWithShippmentPage navigateToWorkWithShipment1() throws IOException {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("CAT", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Art') and contains(text(),'Transport') and contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'Shipments')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToWorkWithShipment1 successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work With Shipment Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Work With Shipment Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithShippmentPage(remoteDriver);
	}
	public SaleBatchSubmissionPage navigateToCreditBatchingReInvoiceInvoice() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000); 
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Re') and contains(text(),'Invoicing') and contains(text(),'Invoice')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreditBatchingReInvoiceInvoice successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Re Invoicing Invoice" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Re Invoicing Invoice",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCreditBatchingReInvoiceCrdt() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Re') and contains(text(),'Invoicing') and contains(text(),'Credit')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreditBatching ReInvoiceCrdt successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Re Invoicing Credit" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Re Invoicing Credit",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot())); 
		}
		return new SaleBatchSubmissionPage(remoteDriver); 
	}
	
	public ARLedgerPage navigateToARLedgerPage() {
		try {
			System.out.println("inside navigateMenu");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[3]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'AR') and contains(text(),'Ledger')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
		}

		catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to ARLedgerPage Page" + ex);
		}
		return new ARLedgerPage(remoteDriver);

	}
	
	
	public WorkWithPrivateSalePage1 naviToPrivateSaleDealEntry() throws IOException {
		try {
			System.out.println("inside naviToPrivateSaleDealEntry");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Private') and contains(text(),'Sales')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Private') and contains(text(),'Sale') and contains(text(),'Deal')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to naviToPrivateSaleDealEntry Successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with private Sale Deal Entry"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in to naviToPrivateSaleDealEntry",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPrivateSalePage1(remoteDriver);
	}
	
	public SellerAgreementStandardPage naviWorkWithSellerAgreement(
			String agreementType) {
		try {
			System.out.println("inside naviWorkWithSellerAgreement");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			click(mainMenu,"mainMenu");

			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Seller') and contains(text(),'Agreement')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'Agreements') and contains(text(),'"
							+ agreementType + "')])[2]")))
					.click().build().perform();

		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Seller Agreement"
							+ ex);
		}
		return new SellerAgreementStandardPage(remoteDriver);
	}
	
	public SellerAgreementStandardPage goTOSellerAgreementLCT(
			String agreementType) {
		try {
			System.out.println("inside naviWorkWithSellerAgreement");
			String country = rds.getValue("LCT", test.currentTest, "Country");
			click(mainMenu,"mainMenu");

			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Seller') and contains(text(),'Agreement')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'Agreements') and contains(text(),'"
							+ agreementType + "')])[2]")))
					.click().build().perform();

		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Seller Agreement"
							+ ex);
		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	public WorkWithSaleHeaderPage naviWorkWithSaleHeader()  throws Exception {
		try {
			System.out.println("inside naviWorkWithSaleHeader");
			click(mainMenu,"mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'With') and contains(text(),'Sale') and contains(text(),'Header')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Work with sale header successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Sale Header"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate Work with sale Header",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithSaleHeaderPage(remoteDriver);
	}
	
	public StockOrderDetailPage navigateToStockOrderPage() throws IOException { 
		try {
			System.out.println("inside navigateToStockOrderPage");

			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			// /OrderType = "Wine";
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			String OrderType = rds.getValue("General_Data", test.currentTest, "OrderType");

			Thread.sleep(3000);
			Thread.sleep(3000);
			// String country=dataTable.getData("General_Data","Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Stock Orders')])[2]")))
					.click().build().perform();
			if (OrderType.equalsIgnoreCase("Wine")) {
				action.moveToElement(remoteDriver.findElement(By
						.xpath("(//a[contains(text(),'Stock') and contains(text(),'Order') and contains(text(),'"
								+ OrderType + "')])[3]")))
						.click().build().perform();
			}
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Stock') and contains(text(),'Order') and contains(text(),'"
							+ OrderType + "')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to stock order page successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside navigation to Stock order Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to stock order page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new StockOrderDetailPage(remoteDriver);
	}
	
	
	public CatalogurTextingPage docatalogingTest() throws IOException {
		try {
			System.out.println("do docatalogingTest");
			remoteDriver.switchTo().defaultContent();
			Thread.sleep(3000);
			/*
			 * driver.findElement(By.cssSelector(
			 * "input[id = 'TE_FAST_PATH_BOX']")).click();
			 * driver.findElement(By.cssSelector("input[id='TE_FAST_PATH_BOX']")
			 * ).sendKeys("P57P41T");
			 * 
			 * ArrayList<String> listStrings1 = new ArrayList<String>();
			 * FileInputStream ios = new
			 * FileInputStream("d:\\catalogue_data.xlsx"); XSSFWorkbook workbook
			 * = new XSSFWorkbook(ios); XSSFSheet sheet =
			 * workbook.getSheetAt(1); int rowS =
			 * sheet.getPhysicalNumberOfRows();
			 * driver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']")).click
			 * (); driver.findElement(By.xpath("//*[@id='TE_FAST_PATH_BOX']")).
			 * sendKeys("P57P41T"); searchArrow.click(); Thread.sleep(3000);
			 * driver.switchTo().frame(iframe); listStrings1 =
			 * extractExcelContentByColumnIndex(0, sheet, ios); itemId.clear();
			 * itemId.sendKeys("SN00552102/001"); Thread.sleep(2000);
			 * find.click(); Thread.sleep(2000); select.click();
			 */
			Thread.sleep(3000);
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to docatalogingTest successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println(
					"Exception inside navigation to Stock order Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to docatalogingTest Exception",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new CatalogurTextingPage(remoteDriver);
	}
	
	public TransmitCatInfoPage navigateToLTF() throws IOException {
		try {
			
			String country = rds.getValue("LCT", test.currentTest, "Country");
			Thread.sleep(4000);
			System.out.println("inside navigateToLTF");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Pre Sale')])[2]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Transmit Catalogue Information')])[2]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Transmit Catalogue Information')])[2]"))) 
					.click().build().perform();
			Thread.sleep(3000);ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Lot Finder maintenance successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Lot Finder maintenance with property" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation to Lot Finder maintenance",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new TransmitCatInfoPage(remoteDriver);
	}
	 
	public WorkWithPropertyPage naviWorkWithProperty() throws IOException {
		try {
			
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(4000);
			System.out.println("inside navigateWorkWithProperty");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'With') and contains(text(),'Property')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to wrk with property page successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with property" + ex);

			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation to with property page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPropertyPage(remoteDriver);
	} 
	public WorkWithPropertyPage naviWorkWithPropertyLCT() throws IOException {
		try {
			String country = rds.getValue("LCT", test.currentTest, "Country");
			Thread.sleep(4000);
			System.out.println("inside naviWorkWithPropertyLCT");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(
					remoteDriver.findElement(By.xpath("(//span[text()='CCSA'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Work') and contains(text(),'With') and contains(text(),'Property')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to wrk with property page successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with property" + ex);

			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation to with property page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new WorkWithPropertyPage(remoteDriver);
	} 

	public WorkWithPropertyPage naviWorkWithPropertyIE() throws IOException {
		try {
			
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(4000);
			System.out.println("inside navigateWorkWithProperty");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(
					remoteDriver.findElement(By.cssSelector("#node56404"))).click()
					.build().perform();
			Thread.sleep(5000);
			action.moveToElement(
					remoteDriver.findElement(By.cssSelector("#node56562"))).click()
					.build().perform();
			Thread.sleep(5000);
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to wrk with property page successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with property" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation to with property page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithPropertyPage(remoteDriver);
	}
	
	public GenerateChargeOrderRequisiton navigtingToGenerateChargeOrder() throws IOException {
		try {
			System.out.println("inside navigtingToGenerateChargeOrder");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);

			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Quotes') and contains(text(),'Requisitions')])[2]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Charge') and contains(text(),'Order')and contains(text(),'Requisition')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to generate Charge order successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating To Generate Charge Order"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in Navigation to generate Charge order",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} 

		return new GenerateChargeOrderRequisiton(remoteDriver);

	}
	
	public PrintAuctioneerBook navigateToPrintAuctinBook(String sheetName) throws IOException {
		try {
			System.out.println("inside navigateToPrintAuctinBook");
			click(mainMenu, "mainMenu");
			String country = rds.getValue(sheetName, test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[text()='Auction Management'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[text()='Daily Operations'])[2]"))).click()
					.build().perform();
			Thread.sleep(5000); 
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//span[text()='Auction'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//div[@tasklabel='Print Auctioneers Book'])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.INFO, "navigateToPrintAuctinBook",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Sale Header"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside navigateToPrintAuctinBook",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new PrintAuctioneerBook(remoteDriver);
	}
	
	
	public OrderInquiryChargePage navigtingToOrderInquiryCharge() throws IOException {
		try {
			System.out.println("inside navigtingToOrderInquiryCharge");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(7000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Order') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			Thread.sleep(8000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Order') and contains(text(),'Inquiry') and contains(text(),'Charge') and contains(text(),'Orders')])[2]")))
					.click().build().perform();
			/*
			 * action.moveToElement( driver.findElement(By.xpath(
			 * "//a[contains(text(),'Charge') and contains(text(),'Inquiry')]//following::a[4]"
			 * ))) .click().build().perform();
			 */
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Order Inquiry successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigting To Order Inquiry Charge" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in Navigation to Order Inquiry ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}

		return new OrderInquiryChargePage(remoteDriver);
	}
	
	public OrderApprovalPage navigtingToPOApprovalPage() throws IOException {
		try {
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(4000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Order') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			/*
			 * action.moveToElement( driver.findElement(By .xpath(
			 * "//td/div/div/div/table/tbody/tr/td[4]/table/tbody/tr/td/table/tbody/tr/td/a"
			 * ))).click() .build().perform();
			 */

			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Orders') and contains(text(),'Awaiting') and contains(text(),'Approval')])[2]")))
					.click().build().perform();

			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to PO Approval Page successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigating To PO Approval" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigate to PO Approval Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} 
		return new OrderApprovalPage(remoteDriver);

	}
	
	public OrderReciptPage navigateToPurchaseOrderRecipt() throws IOException {
		try {
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Order') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Order') and contains(text(),'Receipt')])[2]")))
					.click().build().perform();
			Thread.sleep(6000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Order') and contains(text(),'Receipt') and contains(text(),'OW')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to Order Recipt successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate To Purchase Order Receipt" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception Order Recipt",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new OrderReciptPage(remoteDriver);
	}
	
	public SaleBatchSubmissionPage navigateToCreditBatchingSale() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Invoicing') and contains(text(),'Batching')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Credit') and contains(text(),'Batching')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//a[contains(text(),'Sale')])[25]"))).click()
					.build().perform();
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Batch Review",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new SaleBatchSubmissionPage(remoteDriver);
	}
	
	public OrderInquiryChargePage navigateTo3WayInquiry() throws IOException {
		try {
			System.out.println("inside navigtingToOrderInquiryCharge");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(7000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Order') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			Thread.sleep(8000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Order') and contains(text(),'Inquiry') and contains(text(),'3') and contains(text(),'Match')])[2]")))
					.click().build().perform();
			/*
			 * action.moveToElement( driver.findElement(By.xpath(
			 * "//a[contains(text(),'Charge') and contains(text(),'Inquiry')]//following::a[4]"
			 * ))) .click().build().perform();
			 */
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to 3 Way Inquiry Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigting To Order Inquiry Charge" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation to 3 Way Inquiry",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		return new OrderInquiryChargePage(remoteDriver);
	}
	
	public SOPEnquiryPage navigateToSOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//a[contains(text(),'SOP')])[3]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to 3 SOP Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation SOP",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SOPEnquiryPage(remoteDriver);
	}
	
	public APLedgerPage navigateToApLedger() throws IOException {
		try {
			System.out.println("inside navigateTobtchReview");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'AP') and contains(text(),'Ledger')])[2]")))
					.click().build().perform();
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation APLedger",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new APLedgerPage(remoteDriver);
	}
	
	public POPEnquiryPage navigateToPOP() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000); 
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Account') and contains(text(),'Enquiries')])[4]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver
					.findElement(By.xpath("(//a[contains(text(),'POP')])[4]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to 3 POP Successfull",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation POP",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new POPEnquiryPage(remoteDriver);
	}
	
	public SellerAgreementStandardPage naviWorkWithSellerAgreementPrivateSale() throws IOException {
		try {
			System.out.println("inside naviWorkWithSellerAgreement");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Private') and contains(text(),'Sale')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Daily') and contains(text(),'Operations')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Seller') and contains(text(),'Agreements') and contains(text(),'Private')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation to naviWorkWithSellerAgreementPrivateSale",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Working with Seller Agreement"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception Navigation to naviWorkWithSellerAgreementPrivateSale",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SellerAgreementStandardPage(remoteDriver);
	}

	
	public SettlementReportPage navigateToPrepareForSettlementRpt() throws IOException {
		try {
			System.out.println("inside navigateToBatching");
			click(mainMenu, "mainMenu");
			mainMenu.click();
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Payment') and contains(text(),'Processing')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Prepare') and contains(text(),'Settlement') and contains(text(),'Report')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToPrepareForSettlementRpt",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToPrepareForSettlementRpt",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new SettlementReportPage(remoteDriver);
	}
	
	public VoucherLoggingPage navigatingToVoucherLogging() throws IOException {
		try {
			Thread.sleep(1000);
			System.out.println("inside navigatingToVoucherLogging");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Vouchers')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Voucher') and contains(text(),'Logging')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation ToVoucherLogging",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating to Voucher Logging Supplier Ledger Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigating to Voucher Logging Supplier Ledger Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new VoucherLoggingPage(remoteDriver);

	}
	
	public VoucherMatchPage navigatingToMatchLoggedVoucherPage() throws IOException {
		try {
			System.out.println("inside navigatingToMatchLoggedVoucherPage");

			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000); 
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(4000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Vouchers')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Match') and contains(text(),'Voucher') and contains(text(),'3')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation ToMatchLoggedVoucherPage",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating to Match Logged Voucher Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigating to Match Logged Voucher Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new VoucherMatchPage(remoteDriver);

	}
	
	public VoucherLoggingSupplierLedgerPage navigatingToVoucherLogging1() throws IOException {
		try {
			System.out.println("inside navigatingToVoucherLogging1");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(4000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Vouchers')])[2]")))
					.click().build().perform();
			Thread.sleep(4000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Voucher') and contains(text(),'Logging')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation ToVoucherLogging1",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating to Voucher Logging Supplier Ledger Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigating to Voucher Logging Supplier Ledger Page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		return new VoucherLoggingSupplierLedgerPage(remoteDriver);

	}
	 
	public BatchReviewPage navigateTobtchReview() throws IOException {
		try {
			System.out.println("inside navigateTobtchReview");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(3000);
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Client') and contains(text(),'Accounting')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(
					By.xpath("(//span[contains(text(),'Receipting')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Batch') and contains(text(),'Review')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateTobtchReview",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out
					.println("Exception inside Navigate to Batch Review" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Batch Review",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new BatchReviewPage(remoteDriver);
	}
	
	public CreatePaymentGroupsPage navigateToCreatePayment() throws IOException {
		try {
			System.out.println("inside navigateToCreatePayment");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Payments')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Automatic') and contains(text(),'Payments')])[4]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'US') and contains(text(),'AP') and contains(text(),'Checks')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			/*
			 * action.moveToElement( driver.findElement(By .xpath(
			 * "(//span[contains(text(),'Create') and contains(text(),'Payment') and contains(text(),'Groups')])[2]"
			 * ))) .click().build().perform(); Thread.sleep(5000);
			 * action.moveToElement( driver.findElement(By .xpath(
			 * "(//a[contains(text(),'UK') and contains(text(),'Cheque') and contains(text(),'Co101')])[2]"
			 * ))) .click().build().perform();
			 */
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToCreatePayment",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Create Payment Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception inside Navigate to Create Payment Pag",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new CreatePaymentGroupsPage(remoteDriver);
	}
	
	public VoucherLoggingPage navigatingToVoucherLogging2() throws IOException {
		try {
			Thread.sleep(1000);
			System.out.println("inside navigatingToVoucherLogging");
			click(mainMenu, "mainMenu");
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Actions action = new Actions(remoteDriver);
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Vouchers')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'Voucher') and contains(text(),'Logging')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigatingToVoucherLogging2",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigating to Voucher Logging Supplier Ledger Page"
							+ ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception in navigation navigatingToVoucherLogging2",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}

		return new VoucherLoggingPage(remoteDriver);

	}
	
	public WorkWithPaymentGroupPage navigateToWorkWithPayment() throws IOException {
		try {
			System.out.println("inside navigateToWorkWithPayment");
			click(mainMenu, "mainMenu");
			Actions action = new Actions(remoteDriver);
			String country = rds.getValue("General_Data", test.currentTest, "Country");
			Thread.sleep(1000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("//span[contains(text(),'Christie') and contains(text(),'"
							+ country + "')]")))
					.click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Purchase') and contains(text(),'Pay')])[2]")))
					.click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Accounts') and contains(text(),'Payable') and contains(text(),'Payments')])[3]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//span[contains(text(),'Work') and contains(text(),'Payment') and contains(text(),'Groups')])[2]")))
					.click().build().perform();
			Thread.sleep(5000);
			action.moveToElement(remoteDriver.findElement(By
					.xpath("(//a[contains(text(),'UK') and contains(text(),'Groups') and contains(text(),'Co101')])[2]")))
					.click().build().perform();
			ExtentUtility.getTest().log(LogStatus.INFO, "Navigation navigateToWorkWithPayment",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception ex) {
			System.out.println(
					"Exception inside Navigate to Work with Payment Page" + ex);
			ExtentUtility.getTest().log(LogStatus.INFO, "Exception Navigation navigateToWorkWithPayment",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		return new WorkWithPaymentGroupPage(remoteDriver);

	}

}