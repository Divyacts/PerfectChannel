package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class BatchReviewPage extends PageBase {
	// UI Map object definitions

	@FindBy(xpath = "//input[@title='User ID']")
	private WebElement userId;

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//*[@id='drop_home']")
	private WebElement homeButton;

	@FindBy(id = "hc_Find")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//*[@id='ROW_EXIT_BUTTON']")
	private WebElement rowExit;

	@FindBy(xpath = "//img[@id='hc_OK']")
	private WebElement savebutton;

	@FindBy(xpath = "//input[@title='Batch Number']")
	private WebElement batchNumber;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//*[@id='HE0_123']/tbody/tr/td[2]/span/nobr")
	private WebElement batchPost;

	@FindBy(xpath = "//input[@title='All Batches']")
	private WebElement postAll;

	@FindBy(xpath = "(//*[@id='jdehtmlGridDown'])[2]")
	private WebElement lastArrow;

	@FindBy(xpath = "//*[@id='G0_1_R0']")
	private WebElement firstRow;

	@FindBy(xpath = "//*[@id='G0_1_R3']")
	private WebElement thirdRow;

	@FindBy(xpath = "//input[@title='Batch Status']")
	private WebElement batchStatus;

	@FindBy(xpath = "//div[@id='jdeGridBack0_1']")
	private WebElement gridTop;

	@FindBy(xpath = "(//input[@title='Batch Type'])[2]")
	private WebElement batchType;

	public BatchReviewPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);


	}
	TestBase test =  new TestBase();

	public JdeHomePage goToHomepage() throws Exception {
		remoteDriver.switchTo().defaultContent();
		click(homeButton, "homeButton");
		Thread.sleep(2000);
		return new JdeHomePage(remoteDriver);
	}

	public BatchReviewPage batchReviewFromSeteport(ArrayList<String> batchNumb) throws IOException {
		try {
			remoteDriver.switchTo().frame(menuIframe);
			for (int i = 0; i < batchNumb.size(); i++) {
				System.out.println("batchNumb.get(i)" + batchNumb.get(i));
				if (batchNumb.get(i) != " ") {
					enterText(batchNumber, batchNumb.get(i), "batchNumber");
					click(postAll, "postAll");
					Thread.sleep(3000);
					click(searchButton, "searchButton");
					Thread.sleep(3000);
					click(selectAll, "selectAll");
					click(rowExit, "rowExit");
					Thread.sleep(2000);
					click(batchPost, "batchPost");
					Thread.sleep(5000);
					click(savebutton, "savebutton");
					Thread.sleep(4000);
				}
			}

		} catch (Exception ex) {
			System.out.println("batchReviewFromSeteport" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception inside batchReviewFromSeteport BatchReviewPage page",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		}
		return new BatchReviewPage(remoteDriver);

	}

	public BatchReviewPage batchReview() throws Exception {

		String batchNo = getJDEAppProperties("BatchNumber");
		String userforBatch = rds.getValue("General_Data", test.currentTest, "ApprUser");

		remoteDriver.switchTo().frame(menuIframe);
		enterText(batchNumber, batchNo, "batchNumber");
		enterText(userId, userforBatch, "userId");
		click(searchButton, "searchButton");
		Thread.sleep(3000);
		click(selectAll, "selectAll");
		click(rowExit, "rowExit");
		click(batchPost, "batchPost");
		Thread.sleep(2000);
		click(savebutton, "savebutton");
		Thread.sleep(4000);
		click(selectButton, "selectButton");
		Thread.sleep(3000);
		click(closeButton, "closeButton");
		Thread.sleep(3000);
		click(closeButton, "closeButton");
		Thread.sleep(3000);
		remoteDriver.switchTo().defaultContent();
		return new BatchReviewPage(remoteDriver);
	}

	public BatchReviewPage postByBatch() throws Exception {

		remoteDriver.switchTo().frame(menuIframe);
		ArrayList<String> batcSting = new ArrayList<String>();
		batcSting.add("IB");
		batcSting.add("AE");
		batcSting.add("VB");
		batcSting.add("RB");
		batcSting.add("V");

		for (int i = 0; i < batcSting.size(); i++) {
			enterText(userId, "IN*", "userId");
			enterText(batchStatus, "A", "batchStatus");
			enterText(batchType, batcSting.get(i), "batchType");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(3000);
			if (firstRow()) {
				System.out.println("in if");
				Thread.sleep(3000);
				boolean nextButton = IsTestElementPresent();
				if (nextButton) {
					click(lastArrow, "lastArrow");
				}
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) remoteDriver;
				js.executeScript("arguments[0].scrollTop = 0;", gridTop);
				Thread.sleep(1000);
				// while (firstRow.isDisplayed() || thirdRow.isDisplayed()) {
				// System.out.println("inside while");
				Thread.sleep(3000);
				click(selectAll, "selectAll");
				click(rowExit, "rowExit");
				Thread.sleep(2000);
				click(batchPost, "batchPost");
				Thread.sleep(10000);
				boolean save = IsSavePresent();
				if (save) {
					while (save) {
						click(savebutton, "savebutton");
						Thread.sleep(3000);
					}
				}
				Thread.sleep(5000);
				// searchButton.click();
				// Thread.sleep(4000);
				// }
			}
		}

		/*
		 * boolean error = IsErrorDisplayed(); if (error) {
		 * searchButton.click(); }
		 */
		remoteDriver.switchTo().defaultContent();
		return new BatchReviewPage(remoteDriver);

	}

	public boolean IsTestElementPresent() {
		try {
			remoteDriver.findElement(By.xpath("(//*[@id='jdehtmlGridDown'])[2]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean firstRow() {
		try {
			remoteDriver.findElement(By.xpath("//*[@id='G0_1_R0']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean IsSavePresent() {
		try {
			System.out.println("inside IsSavePresent");
			remoteDriver.findElement(By.xpath("//*[@id='hc_OK']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}