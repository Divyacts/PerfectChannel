package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

/**
 * SignOnPage class
 * 
 * @author Cognizant
 */
public class BiztalkPage extends PageBase {
	// UI Map object definitions

	@FindBy(xpath = "//*[@id='searchDisplay']")
	private WebElement searchDisplay;
	
	@FindBy(xpath = "//*[@id='_tbBusinessData1']")
	private WebElement saleNumebrField;
	
	@FindBy(xpath = "//*[@id='_btnSearch']")
	private WebElement btnSearch;
	
	@FindBy(id = "_gvMasterAudit")
	private List<WebElement> gridList;
	
	@FindBy(xpath = "//table[@id='_gvMasterAudit']/tbody/tr[2]/td/span/a")
	private WebElement busisnessProcess;
	
	@FindBy(xpath = "//*[@id='_gvMasterAudit]/tbody/tr[2]/td[2]/div[1]")
	private WebElement status;
	
	@FindBy(xpath = "//table[@id='_gvMasterAudit']/tbody/tr")
	private List<WebElement> rowsCnt;
	

	TestBase test = new TestBase();

	public BiztalkPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}
	
	public void enterBizTalkUrl() throws Exception {
		String url = getAppProperties("biztalkUrl"); 
		System.out.println("enterBizTalkUrl");
		enterUrl(url);
		System.out.println("after URL enterBizTalkUrl");
	}  

	public BiztalkPage checkProcessingText(String processName) throws Exception {
		try{
		click(searchDisplay, "searchDisplay"); 
		String saleNo = rds.getValue("LCT",test.currentTest, "SaleNumb");
		String result1 = saleNo.replaceAll("[-+.^:,E]", ""); 
		enterText(saleNumebrField, result1, "saleNumebrField");
		click(btnSearch, "btnSearch"); 
		//Thread.sleep(50000);
		int size = rowsCnt.size();
		System.out.println(size);
		for(int i=2;i<=size;i++){
			System.out.println("in for");
				String textVal = remoteDriver.findElement(By.xpath("//table[@id='_gvMasterAudit']/tbody/tr[" + i + "]/td/span/a")).getText();
				String status = remoteDriver.findElement(By.xpath("//*[@id='_gvMasterAudit']/tbody/tr["+ i + "]/td[2]/div[1]")).getText();
				System.out.println("textVal"+textVal);
				System.out.println("status"+status);
				if(textVal.trim().equalsIgnoreCase(processName.trim())){
					assertTrue(textVal.equalsIgnoreCase(processName), "Business process Tranmitted");
					assertTrue(status.equalsIgnoreCase("Completed"), "Business process status is compeleted");
					break;
			}
				
		}  
		}catch(Exception e){ 
			System.out.println("Exception"+e);
		}
		  
		return new BiztalkPage(remoteDriver);  	
	}
	
	public String getValues(String fieldName, int RowCount)
			throws InterruptedException {
		System.out.println(gridList.size());
		String colindexcolindexValue, rowValue;
		colindexcolindexValue = null;
		rowValue = null;
		for (int i = 0; i < gridList.size(); i++) {
			WebElement element = gridList.get(i);
			Actions actions = new Actions(remoteDriver);
			actions.moveToElement(element);
			actions.perform();
			if (element.getText().replace("\n", " ")
					.equalsIgnoreCase(fieldName)) {
				colindexcolindexValue = element.getAttribute("colindex");
				System.out.println(colindexcolindexValue);
				break;
			}
		}
		rowValue = remoteDriver
				.findElement(By.xpath(
						"//tr[@id='G0_1_R" + RowCount + "']/td[@colindex='"
								+ colindexcolindexValue + "']/div/input"))
				.getAttribute("value");

		System.out.println("rowValue" + rowValue);
		Thread.sleep(3000);
		return rowValue;
	}


}